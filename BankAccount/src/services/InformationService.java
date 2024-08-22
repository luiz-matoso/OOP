package services;

import java.util.Scanner;

import entities.Customer;

public class InformationService {

    public void updateInformation(Customer customer, Scanner sc){
        System.out.println("What information you want to update?");
        System.out.println("1. Name");
        System.out.println("2. Age");
        System.out.println("3. Cancel");

        System.out.print("Choose an option: ");
        Integer updateOption = sc.nextInt();
        sc.nextLine();

        switch (updateOption) {
            case 1:
                System.out.println();
                System.out.print("Enter new name: ");
                String newName = sc.nextLine().toUpperCase();
                customer.setName(newName);
                System.out.println("Name updated!");
                System.out.println();
                break;
            case 2:
                System.out.println();
                System.out.print("Enter new age: ");
                Integer newAge = sc.nextInt();
                sc.nextLine();
                customer.setAge(newAge);
                System.out.println("Age updated!");
                System.out.println();
                break;
            case 3:
                System.out.println();
                System.out.println("Canceled...");
                System.out.println();
                break;
        
            default:
                System.out.println();
                System.out.println("Invalid otion! Try again.");
                System.out.println();
                break;
        }
    }

}
