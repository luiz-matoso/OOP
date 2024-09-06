package entities;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String username;
    private String displayName;
    private String password;
    private boolean isLoggedIn;
    private List<Tweet> tweets = new ArrayList<>(); 
    private List<Retweet> retweets = new ArrayList<>();

    public User(String username, String displayName, String password, List<Tweet> tweets, List<Retweet> retweets) {
        this.username = username;
        this.displayName = displayName;
        this.password = password;
        this.tweets = tweets;
        this.retweets = retweets;
    }

    public User(String username, String displayName, String password) {
        this.username = username;
        this.displayName = displayName;
        this.password = password;
        this.isLoggedIn = false;
    }

    public boolean signIn(String username, String password){
        if (this.username.equals(username) && this.password.equals(password)){
            this.isLoggedIn = true;
            return true;
        }
        return false;
    }

    public void signOut() {
        this.isLoggedIn = false;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void addTweet(Tweet tweet) {
        this.tweets.add(tweet);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Retweet> getRetweets() {
        return retweets;
    }

    public void setRetweets(List<Retweet> retweets) {
        this.retweets = retweets;
    }

    

}
