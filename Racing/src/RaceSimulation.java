import java.awt.*;
import javax.swing.*;

public class RaceSimulation extends JFrame {
    private JProgressBar racer1, racer2, racer3;
    private JButton startButton;

    public RaceSimulation() {
        setTitle("Гонки - Лабораторная 6");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 250);
        setLocationRelativeTo(null);

        racer1 = createProgressBar();
        racer2 = createProgressBar();
        racer3 = createProgressBar();

        startButton = new JButton("Старт");
        startButton.addActionListener(e -> {
            startButton.setEnabled(false);

            RaceMonitor monitor = new RaceMonitor();

            RacerThread t1 = new RacerThread(racer1, "Участник 1", monitor);
            RacerThread t2 = new RacerThread(racer2, "Участник 2", monitor);
            RacerThread t3 = new RacerThread(racer3, "Участник 3", monitor);

            t1.start();
            t2.start();
            t3.start();

            // Создаем управляющий поток
            new Thread(() -> {
                synchronized (monitor) {        // захватывает объект monitor
                    try {
                        while (!monitor.isWinnerDeclared()) {
                            monitor.wait();     // освобождает monitor и ждёт, пока поток гонщика вызовет notify()
                        }
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                // Победитель найден, обновляем GUI
                SwingUtilities.invokeLater(() -> {
                    JOptionPane.showMessageDialog(null, monitor.getWinnerName() + " победил!");
                    startButton.setEnabled(true);
                });
            }).start();
        });

        setLayout(new GridLayout(4, 1, 10, 10));
        add(racer1);
        add(racer2);
        add(racer3);
        add(startButton);

        setVisible(true);
    }

    private JProgressBar createProgressBar() {
        JProgressBar bar = new JProgressBar(0, 100);
        bar.setStringPainted(true);
        bar.setPreferredSize(new Dimension(350, 30));
        return bar;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RaceSimulation::new);
    }
}
