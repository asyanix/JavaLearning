
public class Account {
    private String number;
    private String pinCode;
    private double balance;
    private double depositInterest;

    public Account(String number, String pinCode, double balance, double depositInterest) {
        this.number = number;
        this.pinCode = pinCode;
        this.balance = balance;
        this.depositInterest = depositInterest;
    }

    public String getNumber() {
        return number;
    }

    public String getPinCode() {
        return pinCode;
    }

    public double getBalance() {
        return balance;
    }

    public double getDepositInterest() {
        return depositInterest;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        } else {
            return false; 
        }
    }

    public double calculateInterest() {
        return balance * (depositInterest / 100.0);
    }

    @Override
    public String toString() {
        return "Счет №" + number + "\nБаланс: " + balance + " руб.\nПроцент по депозиту: " + depositInterest + "%";
    }
}

