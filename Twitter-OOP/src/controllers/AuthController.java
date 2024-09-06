package controllers;

import java.util.Scanner;

import services.UserService;

public class AuthController {

    private UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public void signUp(Scanner sc) {
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();
        System.out.print("Enter your display name: ");
        String displayName = sc.nextLine();

        boolean success = userService.signUpUser(username, password, displayName);
        if (success) {
            System.out.println("User signed up successfully.");
        } else {
            System.out.println("User already exists or invalid input.");
        }
    }

    public void signIn(Scanner sc) {
        System.out.print("Enter your username: ");
        String username = sc.nextLine();
        System.out.print("Enter your password: ");
        String password = sc.nextLine();

        boolean success = userService.signInUser(username, password);
        if (success) {
            System.out.println("User signed in successfully.");
        } else {
            System.out.println("Invalid username or password.");
        }
    }
}
