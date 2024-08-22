package services;

import entities.Customer;

public class BankService {

    public void deposit(Customer customer, Double amount){
        if (amount <= 0) {
            System.out.println("Invalid! Deposit must be more than 0");
        } 
        customer.setBalance(customer.getBalance() + amount);
        System.out.println("Deposit success ! Your balance: $ " + customer.getBalance());
        System.out.println();
    }

    public void withdraw(Customer customer, Double amount){
        if (amount <= 0){
            System.out.println("Invalid! Witdhraw must be more than 0.");
        }
        if (amount >= customer.getBalance()){
            System.out.println("Error! Insuficient balance.");
        }
        customer.setBalance(customer.getBalance() - amount);
        System.out.println("Success withdraw! Your balance: $ " + customer.getBalance());
        System.out.println();
    }

    public void payBills(Customer customer, Double billValue){
        if (billValue <= 0) {
            System.out.println();
            System.out.println("Invalid! Bill value must be more than 0.");
            System.out.println();
        }  
        if (billValue > customer.getBalance()) {
            System.out.println();
            System.out.println("Invalid! Bill is higher than your balance.");
            System.out.println();
        }
        if (billValue <= customer.getBalance()){
            customer.setBalance(customer.getBalance() - billValue);
            System.out.println();
            System.out.println("Succes! Your balance: $ " + customer.getBalance());
            System.out.println();
        }

    }

}
