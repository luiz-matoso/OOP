package controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Tweet;
import entities.User;
import services.UserService;

public class TweetController {

    private UserService userService;

    public TweetController(UserService userService){
        this.userService = userService;
    }

    public void postTweet(Scanner sc){
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null && loggedInUser.isLoggedIn()){
            System.out.print("Enter your tweet: ");
            String text = sc.nextLine();

            Tweet tweet = new Tweet(loggedInUser, text, LocalDateTime.now(), new ArrayList<>(), new ArrayList<>());
            loggedInUser.addTweet(tweet);

            System.out.println("Tweet posted!");
        } else {
            System.out.println("You need to be signed in to tweet.");
        }
    }

    public void seeTweets(){
        List<User> users = userService.getAllUsers();

        boolean hasTweets = false;
        for (User user : users){
            List<Tweet> tweets = user.getTweets();

            if (!tweets.isEmpty()){
                hasTweets = true;
                System.out.println("-----------------------------");
                System.out.println(user.getDisplayName());
                for (Tweet tweet : tweets){
                    System.out.println("Tweet: " + tweet.getText());
                    System.out.println("Posted on: " + tweet.getTimestamp());
                    System.out.println("Likes: " + tweet.getLikeCount());
                    System.out.println("Re-tweets: " + tweet.getRetweetCount());
                    System.out.println("-----------------------------");
                }
            }
        }

        if (!hasTweets){
            System.out.println("No tweets yet :(");
        }
    }

    public void likeTweet(Scanner sc) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null && loggedInUser.isLoggedIn()) {
            System.out.print("Enter the username of the tweet's author: ");
            String username = sc.nextLine();
            User user = userService.findByUsername(username);
    
            if (user != null) {
                List<Tweet> tweets = user.getTweets();
                if (!tweets.isEmpty()) {
                    System.out.println(user.getDisplayName() + "s tweets :");
                    for (int i = 0; i < tweets.size(); i++) {
                        System.out.println(i + ": " + tweets.get(i).getText());
                    }
                    System.out.print("Choose the tweet that you want to like: ");
                    int showUserTweets = sc.nextInt();
                    sc.nextLine();
    
                    if (showUserTweets >= 0 && showUserTweets < tweets.size()) {
                        tweets.get(showUserTweets).addLike(loggedInUser);
                        System.out.println("You liked the tweet!");
                    } else {
                        System.out.println("Invalid tweet number.");
                    }
                } else {
                    System.out.println("This user has no tweets.");
                }
            } else {
                System.out.println("User not found.");
            }
        } else {
            System.out.println("You need to be signed in to like a tweet.");
        }
    }

    public void retweetTweet(Scanner sc) {
        User loggedInUser = userService.getLoggedInUser();
        if (loggedInUser != null && loggedInUser.isLoggedIn()) {
            System.out.print("Enter the username of the tweet's author: ");
            String username = sc.nextLine();
            User user = userService.findByUsername(username);
    
            if (user != null) {
                List<Tweet> tweets = user.getTweets();
                if (!tweets.isEmpty()) {
                    System.out.println(user.getDisplayName() + "s tweets :");
                    for (int i = 0; i < tweets.size(); i++) {
                        System.out.println(i + ": " + tweets.get(i).getText());
                    }
                    System.out.print("Choose the tweet you that want to re-tweet: ");
                    int showUserTweets = sc.nextInt();
                    sc.nextLine();
    
                    if (showUserTweets >= 0 && showUserTweets < tweets.size()) {
                        tweets.get(showUserTweets).addRetweet(user);
                        System.out.println("You re-tweeted it!");
                    } else {
                        System.out.println("Invalid tweet number.");
                    }
                } else {
                    System.out.println("This user has no tweets.");
                }
            } else {
                System.out.println("User not found.");
            }
        } else {
            System.out.println("You need to be signed in to re-tweet it.");
        }
    }
    
}
