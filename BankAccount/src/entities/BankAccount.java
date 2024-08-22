package entities;

public class BankAccount {
    private Integer accountNumber;
    private Double balance;

    public BankAccount(Integer accountNumber, Double balance) {
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
