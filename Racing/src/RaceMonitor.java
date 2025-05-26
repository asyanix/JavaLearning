public class RaceMonitor {
    private boolean winnerDeclared = false;
    private String winnerName = null;

    public synchronized boolean isWinnerDeclared() {
        return winnerDeclared;
    }

    public synchronized void setWinnerDeclared(boolean value) {
        this.winnerDeclared = value;
    }

    public synchronized void setWinnerName(String name) {
        this.winnerName = name;
    }

    public synchronized String getWinnerName() {
        return winnerName;
    }
}
