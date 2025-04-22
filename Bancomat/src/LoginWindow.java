import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginWindow extends JFrame {
    private JTextField accountNumberField;
    private JPasswordField pinField;
    private Bancomat bancomat;

    public LoginWindow() {
        super("Вход в банкомат");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(300, 200);
        setLocationRelativeTo(null); 

        accountNumberField = new JTextField();
        pinField = new JPasswordField();

        JButton loginButton = new JButton("Войти");

        setLayout(new GridLayout(3, 2, 5, 5));
        add(new JLabel("Номер счета (12 цифр):"));
        add(accountNumberField);
        add(new JLabel("PIN-код (4 цифры):"));
        add(pinField);
        add(new JLabel(""));
        add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String number = accountNumberField.getText().trim();
                String pin = new String(pinField.getPassword()).trim();
        
                if (number.length() != 12 || pin.length() != 4) {
                    JOptionPane.showMessageDialog(LoginWindow.this, "Введите корректные данные.");
                    return;
                }
        
                try {
                    bancomat = new Bancomat();
                    if (bancomat.login(number, pin)) {
                        new MainWindow(bancomat); 
                        dispose(); 
                    } else {
                        JOptionPane.showMessageDialog(LoginWindow.this, "Неверный номер счета или PIN-код.");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(LoginWindow.this, "Ошибка подключения к базе данных.");
                }
            }
        });
        

        setVisible(true);
    }
}
