package services;

import entities.BankAccount;

public class BankService {

    public void deposit(BankAccount bankAccount, Double amount){
        if (amount <= 0) {
            System.out.println("Invalid! Deposit must be more than 0");
        } 
        bankAccount.setBalance(bankAccount.getBalance() + amount);
        System.out.println("Deposit success ! Your balance: $ " + bankAccount.getBalance());
        System.out.println();
    }

    public void withdraw(BankAccount bankAccount, Double amount){
        if (amount <= 0){
            System.out.println("Invalid! Witdhraw must be more than 0.");
        }
        if (amount >= bankAccount.getBalance()){
            System.out.println("Error! Insuficient balance.");
        }
        bankAccount.setBalance(bankAccount.getBalance() - amount);
        System.out.println("Success withdraw! Your balance: $ " + bankAccount.getBalance());
        System.out.println();
    }

    public void payBills(BankAccount bankAccount, Double billValue){
        if (billValue <= 0) {
            System.out.println();
            System.out.println("Invalid! Bill value must be more than 0.");
            System.out.println();
        }  
        if (billValue > bankAccount.getBalance()) {
            System.out.println();
            System.out.println("Invalid! Bill is higher than your balance.");
            System.out.println();
        }
        if (billValue <= bankAccount.getBalance()){
            bankAccount.setBalance(bankAccount.getBalance() - billValue);
            System.out.println();
            System.out.println("Succes! Your balance: $ " + bankAccount.getBalance());
            System.out.println();
        }

    }

}
