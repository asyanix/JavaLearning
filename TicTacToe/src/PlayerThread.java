class PlayerThread extends Thread {
    private final String symbol;
    private final Game game;

    public PlayerThread(String symbol, Game game) {
        this.symbol = symbol;
        this.game = game;
    }

    @Override
    public void run() {
        while (game.getWinner().equals("Ничья")) {
            boolean moved = game.makeMove(symbol);
            if (!moved) break;

            try {
                Thread.sleep(500); 
                Thread.yield();             // передаем управление другому потоку
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Поток " + symbol + " окончил!");
    }
}
