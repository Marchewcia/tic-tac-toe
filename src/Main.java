public class Main {
    public static void main(String[] args) {
        GamePrinter game = new GamePrinter();
        game.setLanguage();
        game.printTutorial();
        game.grabData();
        game.startGame();
    }
}