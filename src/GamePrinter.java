import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class GamePrinter {
    static String language;
    static String[][] layout = {
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
    String[][] currentLayout;
    static int inputInt;
    static int currentTurn = 1;
    static String currentCharacter = "X";

    static boolean gameWon = false;

    public void startGame(String name1, int score1, String name2, int score2) {
        this.currentLayout = layout;
        while(gameWon == false){
            switch(currentTurn){
                case 1:
                    currentTurn = 2;
                    System.out.println("Ruch gracza " + name1);
                    break;
                case 2:
                    currentTurn = 1;
                    System.out.println("Ruch gracza " + name2);
                    break;
            }
            try{
                Scanner input = new Scanner(System.in);
                inputInt = Integer.parseInt(input.nextLine());
                if (inputInt > 9 || inputInt < 1){
                    System.out.println("Zbyt duża lub zbyt mała liczba, spróbuj ponownie.");
                    this.startGame(name1, score1, name2, score2);
                }
                inputHandler(name1, score1, name2, score2);
            }
            catch(NumberFormatException e){
                System.out.println("Niepoprawny znak, spróbuj ponownie.");
                this.startGame(name1, score1, name2, score2);
            }
            for (int i=0; i<6; i+=2){
                if ((this.currentLayout[i][0] == this.currentLayout[i][2] && this.currentLayout[i][0] == this.currentLayout[i][4]) && (this.currentLayout[i][0] != " " && this.currentLayout[i][2] != " " && this.currentLayout[i][4] != " ")) {
                    gameWon = true;
                    break;
                }
            }
        }
    }

    public void inputHandler(String name1, int score1, String name2, int score2){
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
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[0][0] = currentCharacter ;
                break;
            case 2:
                if (this.currentLayout[0][2] == "O" || this.currentLayout[0][2] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[0][2] = currentCharacter ;
                break;
            case 3:
                if (this.currentLayout[0][4] == "O" || this.currentLayout[0][4] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[0][4] = currentCharacter ;
                break;
            case 4:
                if (this.currentLayout[2][0] == "O" || this.currentLayout[2][0] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[2][0] = currentCharacter ;
                break;
            case 5:
                if (this.currentLayout[2][2] == "O" || this.currentLayout[2][2] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[2][2] = currentCharacter ;
                break;
            case 6:
                if (this.currentLayout[2][4] == "O" || this.currentLayout[2][4] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[2][4] = currentCharacter ;
                break;
            case 7:
                if (this.currentLayout[4][0] == "O" || this.currentLayout[4][0] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[4][0] = currentCharacter ;
                break;
            case 8:
                if (this.currentLayout[4][2] == "O" || this.currentLayout[4][2] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[4][2] = currentCharacter ;
                break;
            case 9:
                if (this.currentLayout[4][4] == "O" || this.currentLayout[4][4] == "X"){
                    System.out.println("To pole jest już zajęte");
                    this.startGame(name1, score1, name2, score2);
                }
                this.currentLayout[4][4] = currentCharacter ;
                break;
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