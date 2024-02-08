import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
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
        if (firstTime){
            System.out.print("\n");
            System.arraycopy(layout, 0, this.currentLayout, 0, layout.length);
            currentTurn = 1;
            firstTime = false ;
        }
        while(!gameWon){
            for (int i = 0; i < this.currentLayout.length; ++i) {
                for (int j = 0; j < this.currentLayout[i].length; ++j) {
                    System.out.print(this.currentLayout[i][j]);
                }
                System.out.print("\n");
            }
            switch(currentTurn){
                case 1:
                    printCorrectLanguage("round", false);
                    System.out.print(this.player1.name + "\n");
                    break;
                case 2:
                    printCorrectLanguage("round", false);
                    System.out.print(this.player2.name + "\n");
                    break;
            }
            try{
                Scanner input = new Scanner(System.in);
                inputInt = Integer.parseInt(input.nextLine());
                if (inputInt > 9 || inputInt < 1){
                    printCorrectLanguage("tooManyOrTooLittleNumber", false);
                    System.out.print("\n");
                    this.startGame();
                }
                inputHandler();
            }
            catch(NumberFormatException e){
                printCorrectLanguage("incorrectKey", false);
                System.out.print("\n");
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
            if(this.currentLayout[0][0] != " " && this.currentLayout[0][2] != " " && this.currentLayout[0][4] != " " && this.currentLayout[2][0] != " " && this.currentLayout[2][2] != " " && this.currentLayout[2][4] != " " && this.currentLayout[4][0] != " " && this.currentLayout[4][2] != " " && this.currentLayout[4][4] != " " && this.currentLayout[0][4] != " "){
                System.out.println("Remis");
                firstTime = true ;
                this.startGame();
            }
        }
        System.out.print("\n");
        if (currentTurn == 2){
            System.out.print("\n" + this.player1.name);
            this.player1.score += 1;
        }
        else if (currentTurn == 1){
            System.out.print("\n" + this.player2.name);
            this.player2.score += 1;
        }
        printCorrectLanguage("Won", true);
        System.out.print(this.player1.name + ": " + this.player1.score + "\n" + this.player2.name + ": " + this.player2.score + "\n");
        gameWon = false ;
        firstTime = true ;
        printCorrectLanguage("Next", true);
        gameContinue();
    }

    private void gameContinue(){
        Scanner input = new Scanner(System.in);
        String input1 = input.nextLine();
        if (Objects.equals(input1, "T")){
            this.startGame();
        }
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
                if (this.currentLayout[0][0] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[0][0] = currentCharacter ;
                break;
            case 2:
                if (this.currentLayout[0][2] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[0][2] = currentCharacter ;
                break;
            case 3:
                if (this.currentLayout[0][4] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[0][4] = currentCharacter ;
                break;
            case 4:
                if (this.currentLayout[2][0] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[2][0] = currentCharacter ;
                break;
            case 5:
                if (this.currentLayout[2][2] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[2][2] = currentCharacter ;
                break;
            case 6:
                if (this.currentLayout[2][4] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[2][4] = currentCharacter ;
                break;
            case 7:
                if (this.currentLayout[4][0] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[4][0] = currentCharacter ;
                break;
            case 8:
                if (this.currentLayout[4][2] != " "){
                    printCorrectLanguage("Taken", false);
                    this.startGame();
                }
                this.currentLayout[4][2] = currentCharacter ;
                break;
            case 9:
                if (this.currentLayout[4][4] != " "){
                    printCorrectLanguage("Taken", false);
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
        System.out.println("Choose your language/Wybierz swój język:\n1. Polish/Polski\n2. English/Angielski");
        try{
            Scanner input = new Scanner(System.in);
            int lang = Integer.parseInt(input.nextLine());
            if (lang == 1){
                System.out.println("Wybrałeś/aś język polski.\n");
                GamePrinter.language = "Polish";
            }
            else if (lang == 2){
                System.out.println("You've chosen english language\n");
                GamePrinter.language = "English";
            }
            else{
                System.out.println("Invalid character\n");
                this.setLanguage();
            }
        }
        catch(NumberFormatException e){
            System.out.println("Invalid character\n");
            this.setLanguage();
        }
    }

    public void printTutorial() {
        printCorrectLanguage("tutorialOne", true);
        for (int i = 0; i < GamePrinter.layout.length; ++i) {
            for (int j = 0; j < GamePrinter.layout[i].length; ++j) {
                System.out.print(GamePrinter.layout[i][j]);
            }
            System.out.print("\n");
        }
        printCorrectLanguage("tutorialTwo", true);
        for (int i = 0; i < GamePrinter.filledLayout.length; ++i) {
            for (int j = 0; j < GamePrinter.filledLayout[i].length; ++j) {
                System.out.print(GamePrinter.filledLayout[i][j]);
            }
            System.out.print("\n");
        }
    }

    public static void printCorrectLanguage(String name, boolean line) {
        try {
            String path = System.getProperty("user.dir");
            File file = new File(path + "\\src\\txt\\" + name + "_" + GamePrinter.language + ".txt");
            Scanner reading = new Scanner(file);
            while (reading.hasNextLine()) {
                System.out.print(reading.nextLine());
                if (line) {
                    System.out.print("\n");
                }
            }
            reading.close();
        } catch (FileNotFoundException e) {
            System.out.println("file_error\n" + e);
        }
    }
}