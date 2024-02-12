import java.io.File;
import java.io.FileNotFoundException;
import java.util.Objects;
import java.util.Scanner;

import static java.lang.System.exit;


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
    static String[][] currentLayout = {
            {},
            {},
            {},
            {},
            {}
    };
    static int inputInt;
    static int currentTurn = 1;
    static String currentCharacter = "X";
    static boolean firstTime = true;
    static boolean gameWon = false;

    static PlayerDataHandler player1 = new PlayerDataHandler();
    static PlayerDataHandler player2 = new PlayerDataHandler();

    public static void grabData(){
        player1.grabPlayerName(1);
        player2.grabPlayerName(2);
    }
    public static void startGame() {
        if (firstTime){
            System.out.print("\n");
            System.arraycopy(layout, 0, currentLayout, 0, layout.length);
            currentTurn = 1;
            firstTime = false ;
        }
        while(!gameWon){
            for (String[] strings : currentLayout) {
                for (String string : strings) {
                    System.out.print(string);
                }
                System.out.print("\n");
            }
            switch(currentTurn){
                case 1:
                    printCorrectLanguage("round", false);
                    System.out.print(player1.name + "\n");
                    break;
                case 2:
                    printCorrectLanguage("round", false);
                    System.out.print(player2.name + "\n");
                    break;
            }
            try{
                Scanner input = new Scanner(System.in);
                inputInt = Integer.parseInt(input.nextLine());
                if (inputInt > 9 || inputInt < 1){
                    printCorrectLanguage("tooManyOrTooLittleNumber", false);
                    System.out.print("\n");
                    startGame();
                }
                inputHandler();
            }
            catch(NumberFormatException e){
                printCorrectLanguage("incorrectKey", false);
                System.out.print("\n");
                startGame();
            }
            for (int i = 0; i < 6; i += 2){
                if ((Objects.equals(currentLayout[i][0], currentLayout[i][2]) && Objects.equals(currentLayout[i][0], currentLayout[i][4])) && (!Objects.equals(currentLayout[i][0], " ") && !Objects.equals(currentLayout[i][2], " ") && !Objects.equals(currentLayout[i][4], " "))) {
                    gameWon = true;
                    break;
                }
            }
            for (int i = 0; i < 6; i += 2){
                if((Objects.equals(currentLayout[0][i], currentLayout[2][i]) && Objects.equals(currentLayout[0][i], currentLayout[4][i])) && (!Objects.equals(currentLayout[0][i], " ") && !Objects.equals(currentLayout[2][i], " ") && !Objects.equals(currentLayout[4][i], " "))){
                    gameWon = true;
                    break;
                }
            }
            if((Objects.equals(currentLayout[0][0], currentLayout[2][2]) && Objects.equals(currentLayout[0][0], currentLayout[4][4])) && (!Objects.equals(currentLayout[0][0], " ") && !Objects.equals(currentLayout[2][2], " ") && !Objects.equals(currentLayout[4][4], " "))){
                gameWon = true;
            }
            if((Objects.equals(currentLayout[0][4], currentLayout[2][2]) && Objects.equals(currentLayout[0][4], currentLayout[4][0])) && (!Objects.equals(currentLayout[0][4], " ") && !Objects.equals(currentLayout[2][2], " ") && !Objects.equals(currentLayout[4][0], " "))){
                gameWon = true;
            }
            if(!Objects.equals(currentLayout[0][0], " ") && !Objects.equals(currentLayout[0][2], " ") && !Objects.equals(currentLayout[0][4], " ") && !Objects.equals(currentLayout[2][0], " ") && !Objects.equals(currentLayout[2][2], " ") && !Objects.equals(currentLayout[2][4], " ") && !Objects.equals(currentLayout[4][0], " ") && !Objects.equals(currentLayout[4][2], " ") && !Objects.equals(currentLayout[4][4], " ") && !Objects.equals(currentLayout[0][4], " ")){
                System.out.println("Remis");
                firstTime = true ;
                startGame();
            }
        }
        if (currentTurn == 2){
            System.out.print("\n" + player1.name);
            player1.score += 1;
        }
        else if (currentTurn == 1){
            System.out.print("\n" + player2.name);
            player2.score += 1;
        }
        printCorrectLanguage("Won", true);
        System.out.print(player1.name + ": " + player1.score + "\n" + player2.name + ": " + player2.score + "\n");
        gameWon = false ;
        firstTime = true ;
        printCorrectLanguage("Next", true);
        gameContinue();
    }

    private static void gameContinue(){
        Scanner input = new Scanner(System.in);
        String input1 = input.nextLine();
        if (input1.equals("T")){
            startGame();
        }
        else{
            exit(0);
        }
    }

    public static void inputHandler(){
        if(currentTurn == 1){
            currentCharacter = "X";
        }
        else{
            currentCharacter = "O";
        }
        switch (inputInt){
            case 1:
                if (!Objects.equals(currentLayout[0][0], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[0][0] = currentCharacter ;
                break;
            case 2:
                if (!Objects.equals(currentLayout[0][2], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[0][2] = currentCharacter ;
                break;
            case 3:
                if (!Objects.equals(currentLayout[0][4], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[0][4] = currentCharacter ;
                break;
            case 4:
                if (!Objects.equals(currentLayout[2][0], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[2][0] = currentCharacter ;
                break;
            case 5:
                if (!Objects.equals(currentLayout[2][2], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[2][2] = currentCharacter ;
                break;
            case 6:
                if (!Objects.equals(currentLayout[2][4], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[2][4] = currentCharacter ;
                break;
            case 7:
                if (!Objects.equals(currentLayout[4][0], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[4][0] = currentCharacter ;
                break;
            case 8:
                if (!Objects.equals(currentLayout[4][2], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[4][2] = currentCharacter ;
                break;
            case 9:
                if (!Objects.equals(currentLayout[4][4], " ")){
                    printCorrectLanguage("Taken", true);
                    startGame();
                }
                currentLayout[4][4] = currentCharacter ;
                break;
        }
        if (currentTurn == 1){
            currentTurn = 2;
        }
        else if (currentTurn == 2){
            currentTurn = 1;
        }
    }

    public static void setLanguage() {
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
                setLanguage();
            }
        }
        catch(NumberFormatException e){
            System.out.println("Invalid character\n");
            setLanguage();
        }
    }

    public static void printTutorial() {
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
            File file = new File(path + "\\txt\\" + name + "_" + GamePrinter.language + ".txt"); //dla nie skompilowanego: File(path + "\\src\\txt\\" + name + "_" + GamePrinter.language + ".txt");
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