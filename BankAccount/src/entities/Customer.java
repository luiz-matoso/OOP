package entities;

public class Customer {

    private Integer accountNumber;
    private String name;
    private Integer age;
    private BankAccount bankAccount;

    public Customer(Integer accountNumber, String name, Integer age, BankAccount bankAccount) {
        this.accountNumber = accountNumber;
        this.name = name.toUpperCase();
        this.age = age;
        this.bankAccount = bankAccount;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name.toUpperCase();
    }

    public void setName(String name) {
        this.name = name.toUpperCase();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BankAccount getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(BankAccount bankAccount) {
        this.bankAccount = bankAccount;
    }

    
    
    

}
