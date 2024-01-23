public class Main {
    public static void main(String[] args) {
        GamePrinter game = new GamePrinter();
        game.setLanguage();
        game.printTutorial();

        PlayerDataHandler player1 = new PlayerDataHandler();
        PlayerDataHandler player2 = new PlayerDataHandler();

        player1.grabPlayerName(1);
        player2.grabPlayerName(2);
    }
}