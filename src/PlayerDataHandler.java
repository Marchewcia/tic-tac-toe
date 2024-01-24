import java.util.Scanner;

public class PlayerDataHandler {
    int score;
    String name;
    public void grabPlayerName(int player){
        Scanner input = new Scanner(System.in);
        System.out.println("Podaj nazwę " + player + " gracza.");
        this.name = input.nextLine();
        System.out.println("Nazwa " + player + " gracza: " + this.name + ". Ten gracz będzie grał jako X/O\n");
    }
}
