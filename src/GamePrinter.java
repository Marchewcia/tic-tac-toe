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
    String[][] filledLayout = {
            {"1", "|", "2", "|", "3"},
            {"-", "-", "-", "-", "-"},
            {"4", "|", "5", "|", "6"},
            {"-", "-", "-", "-", "-"},
            {"7", "|", "8", "|", "9"}
    };
    String[][] currentLayout;

    public void startGame() {
        this.currentLayout = layout;

    }

    public void setLanguage() {
        System.out.println("Choose your language: Polish or English. \nWybierz swój język: Polish (polski) czy English (angielski).\nPlease type exactly how it is written in this instruction. \nProszę aby wpisać dokładnie jak w tej instrukcji.");
        Scanner input = new Scanner(System.in);
        GamePrinter.language = input.nextLine();
        System.out.print("\n");
    }

    public void printTutorial() {
        System.out.println("Tutorial do gry w kółko i krzyżyk \nTak wygląda pusta plansza:");
        for (int i = 0; i < GamePrinter.layout.length; ++i) {
            for (int j = 0; j < GamePrinter.layout[i].length; ++j) {
                System.out.print(GamePrinter.layout[i][j]);
            }
            System.out.print("\n");
        }
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
            System.out.println("Zjebałeś");
        }
    }
}