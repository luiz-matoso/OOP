package application;
import java.util.Scanner;

import entities.Customer;
import services.BankService;
import services.InformationService;

public class App {
    public static void main(String[] args){

        Customer customer;
        BankService bankService = new BankService();
        InformationService informationService = new InformationService();

        Scanner sc = new Scanner(System.in);

        boolean bankMenu = true;

        System.out.println("Welcome! Let's start with your registration.");
        System.out.print("Enter account number: ");
        Integer accountNumber = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter your age: ");
        Integer age = sc.nextInt();

        Double balance = 0.0;

        customer = new Customer(accountNumber, name, age, balance);

        while (bankMenu) {
            System.out.println();
            System.out.println("Welcome " + customer.getName() + "! Check our options:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Pay bills");
            System.out.println("5. Information update");
            System.out.println("0. Leave");

            System.out.print("Choose an option to start: ");
            Integer option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println();
                    System.out.print("Enter amount to deposit: ");
                    Double depositAmount = sc.nextDouble();
                    bankService.deposit(customer, depositAmount);
                    break;
                case 2:
                    System.out.println();
                    System.out.println("Enter amount to withdraw: ");
                    Double withdrawAmount = sc.nextDouble();
                    bankService.withdraw(customer, withdrawAmount);
                    break;
                case 3:
                    System.out.println();
                    System.out.println(customer.getName()  + ", your updated balance: $ " + customer.getBalance());
                    System.out.println();
                    break;
                case 4:
                    System.out.println();
                    System.out.println("Pay your bills");
                    System.out.print("Enter the barcode: ");
                    Integer barcode = sc.nextInt();
                    System.out.print("Enter the value of the bill: ");
                    Double billValue = sc.nextDouble();
                    bankService.payBills(customer, billValue);
                    break;
                case 5:
                    informationService.updateInformation(customer, sc);
                    break;
                case 0:
                    System.out.println("Leaving...");
                    bankMenu = false;
                    break;
            
                default:
                    System.out.println("Invalid option! Try again.");
            }
            
        }

        sc.close();

    }
}
