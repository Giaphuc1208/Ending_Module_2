import java.util.Scanner;

public class Helper {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getInt() {
        try{
            return Integer.parseInt(scanner.nextLine());
        }catch (Exception e) {
            System.err.println("Please enter number!");
            return getInt();
        }
    }

    public static String getText() {
        return scanner.nextLine();
    }
}
