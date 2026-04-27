import view.MainMenu;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MainMenu.menu(scanner);
        scanner.close();
    }
}