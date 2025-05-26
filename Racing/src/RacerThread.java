import javax.swing.*;

public class RacerThread extends Thread {
    private final JProgressBar progressBar;
    private final String name;
    private final RaceMonitor monitor;

    public RacerThread(JProgressBar bar, String name, RaceMonitor monitor) {
        this.progressBar = bar;
        this.name = name;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        System.out.println(name + " стартовал!");

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep((long) (Math.random() * 100)); // рандомная скорость гонщинка
            } catch (InterruptedException e) {
                return;
            }

            progressBar.setValue(i); 

            if (i == 100) {
                synchronized (monitor) {                    // в случае победы поток захватывает объект
                    if (!monitor.isWinnerDeclared()) {
                        monitor.setWinnerDeclared(true);
                        System.out.println(name + " победил!");

                        monitor.setWinnerName(name);
                        monitor.notify();                   // будим управляющий поток
                    }
                }
            }
        }

        System.out.println(name + " закончил гонку.");
    }
}
