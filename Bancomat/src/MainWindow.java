import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MainWindow extends JFrame {
    private Bancomat bancomat;

    public MainWindow(Bancomat bancomat) {
        super("Банкомат");
        this.bancomat = bancomat;

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(5, 1, 10, 10));

        JButton balanceButton = new JButton("Посмотреть баланс");
        JButton depositButton = new JButton("Пополнить счет");
        JButton withdrawButton = new JButton("Снять деньги");
        JButton interestButton = new JButton("Рассчитать проценты");
        JButton exitButton = new JButton("Выход");

        add(balanceButton);
        add(depositButton);
        add(withdrawButton);
        add(interestButton);
        add(exitButton);

        balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double balance = bancomat.checkBalance();
                double interest = bancomat.getDepositInterest();
                JOptionPane.showMessageDialog(MainWindow.this, "Ваш баланс: " + balance + " руб.\nПроцент по депозиту: " + interest);
            }
        });
        
        depositButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(MainWindow.this, "Введите сумму для пополнения:");
                try {
                    double amount = Double.parseDouble(input);
                    if (amount > 0) {
                        bancomat.deposit(amount);
                        JOptionPane.showMessageDialog(MainWindow.this, "Счет пополнен.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Неверный ввод.");
                }
            }
        });
        
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog(MainWindow.this, "Введите сумму для снятия:");
                try {
                    double amount = Double.parseDouble(input);
                    if (bancomat.withdraw(amount)) {
                        JOptionPane.showMessageDialog(MainWindow.this, "Деньги сняты.");
                    } else {
                        JOptionPane.showMessageDialog(MainWindow.this, "Недостаточно средств.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(MainWindow.this, "Неверный ввод.");
                }
            }
        });
        
        interestButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double interest = bancomat.calculateInterest();
                JOptionPane.showMessageDialog(MainWindow.this, "Проценты по депозиту: " + interest + " руб.");
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bancomat.close();
                System.exit(0);
            }
        });
        
        setVisible(true);
    }
}
