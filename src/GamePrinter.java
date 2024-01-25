import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GamePrinter {
    static String language;
    final static String[][] layout = {
            {" ", "|", " ", "|", " "},
            {"-", "-", "-", "-", "-"},
            {" ", "|", " ", "|", " "},
            {"-", "-", "-", "-", "-"},
            {" ", "|", " ", "|", " "}
    };
    static String[][] filledLayout = {
            {"1", "|", "2", "|", "3"},
            {"-", "-", "-", "-", "-"},
            {"4", "|", "5", "|", "6"},
            {"-", "-", "-", "-", "-"},
            {"7", "|", "8", "|", "9"}
    };
    String[][] currentLayout = {
            {" ", "|", " ", "|", " "},
            {"-", "-", "-", "-", "-"},
            {" ", "|", " ", "|", " "},
            {"-", "-", "-", "-", "-"},
            {" ", "|", " ", "|", " "}
    };
    static int inputInt;
    static int currentTurn = 1;
    static String currentCharacter = "X";
    static boolean firstTime = true;
    static boolean gameWon = false;

    PlayerDataHandler player1 = new PlayerDataHandler();
    PlayerDataHandler player2 = new PlayerDataHandler();

    public void grabData(){
        this.player1.grabPlayerName(1);
        this.player2.grabPlayerName(2);
    }
    public void startGame() {
        if (firstTime == true){
            for (int i = 0; i < layout.length; ++i) {
                for (int j = 0; j < layout[i].length; ++j) {
                    this.currentLayout[i][j] = layout[i][j];
                }
            }
            currentTurn = 1;
            firstTime = false ;
        }
        while(gameWon == false){
            for (int i = 0; i < this.currentLayout.length; ++i) {
                for (int j = 0; j < this.currentLayout[i].length; ++j) {
                    System.out.print(this.currentLayout[i][j]);
                }
                System.out.print("\n");
            }
            switch(currentTurn){
                case 1:
                    System.out.println("Ruch gracza " + this.player1.name);
                    break;
                case 2:
                    System.out.println("Ruch gracza " + this.player2.name);
                    break;
            }
            try{
                Scanner input = new Scanner(System.in);
                inputInt = Integer.parseInt(input.nextLine());
                if (inputInt > 9 || inputInt < 1){
                    System.out.println("Zbyt duża lub zbyt mała liczba, spróbuj ponownie.");
                    this.startGame();
                }
                inputHandler();
            }
            catch(NumberFormatException e){
                System.out.println("Niepoprawny znak, spróbuj ponownie.");
                this.startGame();
            }
            for (int i = 0; i < 6; i += 2){
                if ((this.currentLayout[i][0] == this.currentLayout[i][2] && this.currentLayout[i][0] == this.currentLayout[i][4]) && (this.currentLayout[i][0] != " " && this.currentLayout[i][2] != " " && this.currentLayout[i][4] != " ")) {
                    gameWon = true;
                }
            }
            for (int i = 0; i < 6; i += 2){
                if((this.currentLayout[0][i] == this.currentLayout[2][i] && this.currentLayout[0][i] == this.currentLayout[4][i]) && (this.currentLayout[0][i] != " " && this.currentLayout[2][i] != " " && this.currentLayout[4][i] != " ")){
                    gameWon = true;
                }
            }
            if((this.currentLayout[0][0] == this.currentLayout[2][2] && this.currentLayout[0][0] == this.currentLayout[4][4]) && (this.currentLayout[0][0] != " " && this.currentLayout[2][2] != " " && this.currentLayout[4][4] != " ")){
                gameWon = true;
            }
            if((this.currentLayout[0][4] == this.currentLayout[2][2] && this.currentLayout[0][4] == this.currentLayout[4][0]) && (this.currentLayout[0][4] != " " && this.currentLayout[2][2] != " " && this.currentLayout[4][0] != " ")){
                gameWon = true;
            }
        }
        if (currentTurn == 1){
            System.out.println("Gracz " + this.player1.name + " wygrał/a.");
            this.player1.score += 1;
        }
        else if (currentTurn == 2){
            System.out.println("Gracz " + this.player2.name + " wygrał/a.");
            this.player2.score += 1;
        }
        System.out.println("Wynik graczy:\n" + this.player1.name + ": " + this.player1.score + "\n" + this.player2.name + ": " + this.player2.score);
        gameWon = false ;
        firstTime = true ;
        this.startGame();
    }

    public void inputHandler(){
        if(currentTurn == 1){
            currentCharacter = "X";
        }
        else{
            currentCharacter = "O";
        }
        switch (inputInt){
            case 1:
                if (this.currentLayout[0][0] == "O" || this.currentLayout[0][0] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[0][0] = currentCharacter ;
                break;
            case 2:
                if (this.currentLayout[0][2] == "O" || this.currentLayout[0][2] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[0][2] = currentCharacter ;
                break;
            case 3:
                if (this.currentLayout[0][4] == "O" || this.currentLayout[0][4] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[0][4] = currentCharacter ;
                break;
            case 4:
                if (this.currentLayout[2][0] == "O" || this.currentLayout[2][0] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[2][0] = currentCharacter ;
                break;
            case 5:
                if (this.currentLayout[2][2] == "O" || this.currentLayout[2][2] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[2][2] = currentCharacter ;
                break;
            case 6:
                if (this.currentLayout[2][4] == "O" || this.currentLayout[2][4] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[2][4] = currentCharacter ;
                break;
            case 7:
                if (this.currentLayout[4][0] == "O" || this.currentLayout[4][0] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[4][0] = currentCharacter ;
                break;
            case 8:
                if (this.currentLayout[4][2] == "O" || this.currentLayout[4][2] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[4][2] = currentCharacter ;
                break;
            case 9:
                if (this.currentLayout[4][4] == "O" || this.currentLayout[4][4] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame();
                }
                this.currentLayout[4][4] = currentCharacter ;
                break;
        }
        if (currentTurn == 1){
            currentTurn = 2;
        }
        else if (currentTurn == 2){
            currentTurn = 1;
        }
    }

    public void setLanguage() {
        System.out.println("Choose your language: Polish or English. \nWybierz swój język: Polish (polski) czy English (angielski).\nPlease type exactly how it is written in this instruction. \nProszę aby wpisać dokładnie jak w tej instrukcji.");
        Scanner input = new Scanner(System.in);
        GamePrinter.language = input.nextLine();
        System.out.print("\n");
    }

    public void printTutorial() {
        System.out.println("Tutorial do gry w kółko i krzyżyk \nTak wygląda pusta plansza:\n");
        for (int i = 0; i < GamePrinter.layout.length; ++i) {
            for (int j = 0; j < GamePrinter.layout[i].length; ++j) {
                System.out.print(GamePrinter.layout[i][j]);
            }
            System.out.print("\n");
        }
        System.out.println("\nTak są oznaczone pola na których można postawić kółko lub krzyżyk:\n");
        for (int i = 0; i < GamePrinter.filledLayout.length; ++i) {
            for (int j = 0; j < GamePrinter.filledLayout[i].length; ++j) {
                System.out.print(GamePrinter.filledLayout[i][j]);
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void printCorrectLanguage(String name) {
        try {
            File file = new File(name + "_" + GamePrinter.language + ".txt");
            Scanner reading = new Scanner(file);
            while (reading.hasNextLine()) {
                System.out.println(reading.nextLine());
            }
            reading.close();
        } catch (FileNotFoundException e) {
            System.out.println("file_error");
        }
    }
}