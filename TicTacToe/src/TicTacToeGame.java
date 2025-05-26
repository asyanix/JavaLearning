public class TicTacToeGame {

    public static void main(String[] args) throws InterruptedException {
        Game game = new Game();

        Thread player1 = new PlayerThread("X", game);
        Thread player2 = new PlayerThread("O", game);

        player1.start();
        player2.start();

        // Главный поток ждет завершения player1 и player2
        // Метод join() приостанавливает выполнение текущего потока 
        player1.join();
        player2.join();

        System.out.println("Игра завершена.");
        System.out.println("Победитель: " + game.getWinner());
    }
}