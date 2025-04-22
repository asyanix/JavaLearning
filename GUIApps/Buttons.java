import java.awt.*;
import javax.swing.*;

public class Buttons {
    public static void main(String[] args) {   

        
        JFrame frame = new JFrame("Кнопочки");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);

        frame.setLayout(new BorderLayout());

        frame.add(new JButton("Кнопка 1"), BorderLayout.NORTH);
        frame.add(new JButton("Кнопка 2"), BorderLayout.SOUTH);
        frame.add(new JButton("Кнопка 3"), BorderLayout.WEST);
        frame.add(new JButton("Кнопка 4"), BorderLayout.EAST);
        frame.add(new JButton("Кнопка 5"), BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
