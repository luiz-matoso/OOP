import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controllers.AuthController;
import controllers.MenuController;
import controllers.TweetController;
import entities.User;
import services.UserService;

public class TwitterApp {
    public static void main(String[] args) throws Exception {

        List<User> users = new ArrayList<>();
        UserService userService = new UserService();
        MenuController mainMenu = new MenuController(userService);
        AuthController authController = new AuthController(userService);
        TweetController tweetController = new TweetController(userService);
        Scanner sc = new Scanner(System.in);

        int option = -1;

        while (option != 0){
            mainMenu.showMainMenu();
            System.out.println();
            System.out.print("Select an option: ");
            if( sc.hasNextInt()){
                option = sc.nextInt();
                sc.nextLine();

                switch(option){
                    case 1:
                    authController.signUp(sc);
                    break;
                    case 2:
                    authController.signIn(sc);
                    break;
                    case 3:
                    tweetController.postTweet(sc);
                    break;
                    case 4:
                    tweetController.seeTweets();
                    break;
                    case 5:
                    tweetController.likeTweet(sc);
                    case 6:
                    tweetController.retweetTweet(sc);
                    case 0:
                    System.out.println("Leaving...");
                    break;
                default:
                    System.out.println("Invalid option! Try again.");
                }
            } else{
                System.out.println("Please enter a valid number");
                sc.nextLine();
            }
        }

        sc.close();
    }
}
