import javax.swing.*; 

public class main {
    public static void main(String[] args) { 
        JFrame f = new JFrame();
        JLabel lab = new JLabel("Я метка 1");      //создать новый элемент "метка" 
        f.setSize(300, 200); 
        f.setLocation(500, 200);                    //задает расположение окна 
        f.add(lab);                                     //присоединить "метку" к окну
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        f.setVisible(true);
    }
}
