import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Check {
    Scanner scanner = new Scanner(System.in);

    public int charMatch(String random) {
        char[] randomArray = new char[random.length()];
        char[] index = new char[random.length()];
        Arrays.fill(index, '_');
        for (int k =0;k<random.length();k++){
            randomArray[k]=random.charAt(k);
        }

        for (int i = 0; i < randomArray.length * 2; i++) {
            int tryLeft = randomArray.length * 2 - i;
            System.out.println("Tries left :" + tryLeft);
            System.out.println("Enter Character:(Bhai kitna hi daal , pehla hi uthayenge) :");
            char u = scanner.next().charAt(0);
            boolean isMatch = false;
            boolean isComplete = true;
            u = Character.toUpperCase(u);
            for (int j = 0; j < randomArray.length; j++) {
                if (randomArray[j] == u) {
                    index[j] = u;
                    isMatch = true;

                }
                if (index[j] == '_') {
                    isComplete = false;
                }
            }
            printArray(index);
            System.out.println();
            if (!isMatch && tryLeft != 1)
                System.out.println("Try Again , Haar ni manni .");
            System.out.println("----------------------------------------------------------------");

            if (isComplete) {
                System.out.println("You won , Mashallah kya khela hai.");
                return tryLeft*100;

            }
            if (tryLeft == 1) {
                System.out.println("Game Over , Khelna nhi ata kya?");
                return 0;
            }
        }
        return 0;
    }

    public void printArray(char[] index) {
        for (int i = 0; i < index.length; i++) {
            System.out.print(index[i]);
            if (i < index.length - 1) {
                System.out.print(","); // Print comma only if it's not the last character
            }

    }}

    public int strMatch(String randomString) {
        char[] index = new char[randomString.length()];
        Arrays.fill(index, '_');
        String user = new String();

        for (int i = 0; i < randomString.length() * 2; i++) {
            int tryLeft = randomString.length() * 2 - i;
            System.out.println("Tries left :" + tryLeft);
            System.out.println("Enter string :");
            user = scanner.nextLine();
            user = user.toUpperCase();
            boolean isMatch = false;
            boolean isComplete = true;
            if (user.length() > index.length || user.length() < 1) {
                System.out.println("Invalid Input , Khelna nhi ata kya?");
            } else {

                if (randomString.contains(user)) {
                    isMatch = true;
                    int startIndex = randomString.toUpperCase().indexOf(user);
                    while (startIndex != -1) {
                        isMatch = true; // We found at least one match
                        // Update the index array with the matched substring
                        for (int j = 0; j < user.length(); j++) {
                            index[startIndex + j] = user.charAt(j);
                        }

                        // Look for the next occurrence
                        startIndex = randomString.toUpperCase().indexOf(user, startIndex + 1);
                    }

                }

                    for (char c : index)
                        if (c == '_') {
                            isComplete = false;
                            break;
                        }


                    printArray(index);
                System.out.println("");
                    System.out.println("----------------------------------------------------------------");
                    if (isComplete) {
                        System.out.println("You won , Mashallah kya khela hai.");
                        return tryLeft*100;
                    }

                }
                if (!isMatch && tryLeft != 1) {

                    System.out.println("Try Again , Haar ni manni .");
                    System.out.println("----------------------------------------------------------------");
                }

                if (tryLeft == 1) {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("Game Over , Khelna nhi ata kya?");
                    return 0;
                }
            }
        return 0;}

    }

