package entities;

import java.time.LocalDateTime;

public class Retweet {

    private User user;
    private LocalDateTime timestamp;
    
    public Retweet(User user, LocalDateTime timestamp) {
        this.user = user;
        this.timestamp = timestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
