package entities;

public class Customer {

    private Integer accountNumber;
    private String name;
    private Integer age;
    private Double balance;
    
    public Customer(Integer accountNumber, String name, Integer age, Double balance) {
        this.accountNumber = accountNumber;
        this.name = name.toUpperCase();
        this.age = age;
        this.balance = balance;
    }

    public Integer getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Integer accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getName() {
        return name;
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

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

}
