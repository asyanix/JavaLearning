
import java.sql.*;

public class Bancomat {
    private static final String DB_URL = "jdbc:sqlite:bancomat.db";

    private Connection conn;
    private Account currentAccount;

    public Bancomat() {
        try {
            Class.forName("org.sqlite.JDBC");

            conn = DriverManager.getConnection("jdbc:sqlite:bancomat.db");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean login(String number, String pinCode) {
        String query = "SELECT * FROM Accounts WHERE number = ? AND pin_code = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, number);
            stmt.setString(2, pinCode);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                currentAccount = new Account(
                    rs.getString("number"),
                    rs.getString("pin_code"),
                    rs.getDouble("balance"),
                    rs.getDouble("deposit_interest")
                );
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public boolean withdraw(double amount) {
        if (currentAccount != null && currentAccount.withdraw(amount)) {
            return updateBalance();
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (currentAccount != null) {
            currentAccount.deposit(amount);
            return updateBalance();
        }
        return false;
    }

    public double calculateInterest() {
        if (currentAccount != null) {
            return currentAccount.calculateInterest();
        }
        return 0.0;
    }

    public double checkBalance() {
        if (currentAccount != null) {
            return currentAccount.getBalance();
        }
        return 0.0;
    }

    public double getDepositInterest() {
        if (currentAccount != null) {
            return currentAccount.getDepositInterest();
        }
        return 0.0;
    }

    private boolean updateBalance() {
        String update = "UPDATE Accounts SET balance = ? WHERE number = ?";
        try (PreparedStatement stmt = conn.prepareStatement(update)) {
            stmt.setDouble(1, currentAccount.getBalance());
            stmt.setString(2, currentAccount.getNumber());
            int affectedRows = stmt.executeUpdate();
            return affectedRows == 1;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void close() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
