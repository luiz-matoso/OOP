package controllers;

import services.UserService;

public class MenuController {

    private UserService userService;
    
    public MenuController(UserService userService) {
        this.userService = userService;
    }

    public void showMainMenu() {
        System.out.println("1. Sign up");
        System.out.println("2. Sign in");
        System.out.println("3. Tweet");
        System.out.println("4. Feed");
        System.out.println("5. Like tweet");
        System.out.println("6. Re-tweet");
        System.out.println("0. Leave");
    }
}
