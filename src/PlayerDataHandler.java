import java.util.Scanner;

public class PlayerDataHandler {
    int score;
    String name;
    public void grabPlayerName(int player){
        Scanner input = new Scanner(System.in);
        System.out.print("\n");
        switch(player){
            case 1:
                GamePrinter.printCorrectLanguage("Player1", true);
                break;
            case 2:
                GamePrinter.printCorrectLanguage("Player2", true);
                break;
        }
        this.name = input.nextLine();
        GamePrinter.printCorrectLanguage("Name", false);
        System.out.print(player + ":" + this.name + "\n");
        GamePrinter.printCorrectLanguage("XO", false);
        switch(player){
            case 1:
                System.out.print("X\n");
                break;
            case 2:
                System.out.print("O\n");
                break;
        }
    }
}
