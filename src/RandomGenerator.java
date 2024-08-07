import java.util.Random;
import java.util.Scanner;

public class RandomGenerator {
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    // create random string builder
    StringBuilder sb = new StringBuilder();

    // create an object of Random class
    Random random = new Random();

    Scanner scanner = new Scanner(System.in);

    public String Generate() {
        System.out.println("Enter The Level You Want TO Play (1-10) :");
        // specify length of random string
        int length = scanner.nextInt();
        if (length > 10 || length < 1) {
            System.out.println("Bhai Bataya To Sahi , 1-10 Ke beech Me Daalna HAi.");
        } else {
            for (int i = 0; i < length; i++) {

                // generate random index number
                int index = random.nextInt(alphabet.length());

                // get character specified by index
                // from the string
                char randomChar = alphabet.charAt(index);

                // append the character to string builder
                sb.append(randomChar);

            }
            System.out.println("Random String is: " + sb);
        }
        return sb.toString();

    }
}