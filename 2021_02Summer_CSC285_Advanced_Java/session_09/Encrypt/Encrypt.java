import java.io.File;
import java.util.Scanner;
import java.io.IOException;

public class Encrypt {
    public static void main(String arg[]) throws IOException {
        File file = new File("input.txt"); // read the file
        Scanner scan = new Scanner(file); // read the first line

        while (scan.hasNextLine()) {

            String text = scan.nextLine();
            char[] chars = text.toCharArray();
            for (char c : chars) {
                System.out.print(++c);
            }

        }
    }
}
