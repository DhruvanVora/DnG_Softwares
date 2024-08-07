import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;


public class Main {

    static void startGame(String username) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        Check check = new Check();
        JDBC_Connection jdbc = new JDBC_Connection();
        String randomString = random.Generate();
        for (int i =0;i<randomString.length();i++){
            System.out.print("_");
        }
        System.out.println("");

        System.out.println("You want to enter character(1) or String(2)");


        int type=scanner.nextInt();
        if (type ==1){
         int score = check.charMatch(randomString);
        int high_score = jdbc.updateHighScore(score, username);
            System.out.println("Current Score :"+ score+", Aur jor lgao. ");
            System.out.println("Highest Score : "+high_score);
        } else if (type==2) {
        int score=    check.strMatch(randomString);
            int high_score = jdbc.updateHighScore(score, username);
            System.out.println(" high score : "+high_score);
        }
        else{
            System.out.println("Invalid , Bhaiya Ji apne to unexpected hi krdia.");
        }
    }

   public static RandomGenerator random=new RandomGenerator();

    public Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

       Scanner sc = new Scanner(System.in);
        System.out.println("Login(1) or SignUp(2) user : ");
        int login = sc.nextInt();
        sc.nextLine();

        JDBC_Connection jdbc = new JDBC_Connection();


        if(login == 1){

      try{
          System.out.println("Enter your username : ");
          String username = sc.nextLine();
          boolean isLogin = jdbc.logIn(username);
          startGame(username);
      }
       catch (SQLException e) {

           System.out.println("Ho kon aap ? Id check krvao .");
           System.out.println("Enter your username : ");
           String username = sc.nextLine();
           boolean isLogin = jdbc.logIn(username);
           startGame(username);
      }

        } else if (login ==2) {
            System.out.println("Enter username :");
            String username = sc.nextLine();

            String email;
            while (true) {
                System.out.println("Enter your email: ");
                email = sc.nextLine();

                // Validate email format
                if (isValidEmail(email)) {
                    break; // Exit the loop if the email is valid
                } else {
                    System.out.println("Invalid email format. Please enter a valid email.");
                }
            }
            jdbc.createUser(username, email);
//            jdbc.logIn(username);
            startGame(username);
        }else {
            System.out.println("Aunty ji screen time kam kro apna.");
        }









    }private static boolean isValidEmail(String email) {
        // Regular expression for validating email
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return email.matches(emailRegex);
    }


}
