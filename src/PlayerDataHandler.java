import java.util.Scanner;

public class PlayerDataHandler {
    int score;
    String name;

    public void grabPlayerName(int player){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nazwę " + player + " gracza.");
        this.name = input.nextLine();
    }
}
