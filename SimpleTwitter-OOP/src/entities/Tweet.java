package entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Tweet {

    private User author;
    private String text;
    private LocalDateTime timestamp;
    private List<Like> likes = new ArrayList<>();
    private List<Retweet> retweets = new ArrayList<>();
    
    public Tweet(User author, String text, LocalDateTime timestamp, List<Like> likes, List<Retweet> retweets) {
        this.author = author;
        this.text = text;
        this.timestamp = timestamp;
        this.likes = likes;
        this.retweets = retweets;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void addLike(User user) {
        this.likes.add(new Like(user, LocalDateTime.now())); 
    }

    public int getLikeCount(){
        return likes.size();
    }
    
    public void addRetweet(User user){
        this.retweets.add(new Retweet(user, LocalDateTime.now()));
    }

    public int getRetweetCount(){
        return retweets.size();
    }
    
}
