package services;

import java.util.ArrayList;
import java.util.List;

import entities.User;

public class UserService {

    private List<User> users = new ArrayList<>();
    private User isLoggedInUser = null;

    public boolean signUpUser(String username, String password, String displayName){
        if (findByUsername(username) != null){
            return false;
        }

        User user = new User(username, displayName, password);
        users.add(user);
        return true;
    }

    public boolean signInUser(String username, String password){
        User user = findByUsername(username);
        if (user != null && user.signIn(username, password)){
            isLoggedInUser = user;
            return true;
        }
        return false;
    }

    public User getLoggedInUser() {
        return isLoggedInUser;
    }

    public User findByUsername(String username){
        for (User user : users){
            if (user.getUsername().equals(username)){
                return user;
            }
        }
        return null;
    }

    public List<User> getAllUsers(){
        return users;
    }

    public void signOut(){
        if (isLoggedInUser != null) {
            isLoggedInUser.signOut();
            isLoggedInUser = null;
        }
    }

}
