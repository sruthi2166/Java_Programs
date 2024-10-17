package LAB2;
 
class Person {
    private String name;
    private float age;
 
    public Person(String name, float age) {
        this.name = name;
        this.age = age;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public float getAge() {
        return age;
    }
 
    public void setAge(float age) {
        this.age = age;
    }
 
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }
}
 
abstract class Account {
    private long accNum;
    private double balance;
    private Person accHolder;
    private static long accCounter = 1000;
 
    public Account(Person accHolder, double initialBalance) {
        this.accHolder = accHolder;
        this.balance = initialBalance;
        this.accNum = accCounter++; // Auto-generate accNum
    }
 
    public long getAccNum() {
        return accNum;
    }
 
    public double getBalance() {
        return balance;
    }
 
    public void setBalance(double balance) {
        this.balance = balance;
    }
 
    public Person getAccHolder() {
        return accHolder;
    }
 
    public void setAccHolder(Person accHolder) {
        this.accHolder = accHolder;
    }
 
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited INR " + amount + " to account: " + accNum);
        } else {
            System.out.println("Invalid deposit amount");
        }
    }
 
    public abstract boolean withdraw(double amount);
 
    public String toString() {
        return "Account [accNum=" + accNum + ", balance=" + balance + ", accHolder=" + accHolder + "]";
    }
}
 
class SavingsAccount extends Account {
    public SavingsAccount(Person accHolder, double initialBalance) {
        super(accHolder, initialBalance);
    }
 
    @Override
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Withdrawn INR " + amount + " from account: " + getAccNum());
            return true;
        } else {
            System.out.println("Insufficient balance or invalid amount for withdrawal");
            return false;
        }
    }
}
 
public class LAB22 {
    public static void main(String[] args) {
        Person smith = new Person("Smith", 30);
        Person kathy = new Person("Kathy", 28);
 
        Account smithAccount = new SavingsAccount(smith, 2000);
        Account kathyAccount = new SavingsAccount(kathy, 3000);
 
        smithAccount.deposit(2000);
        kathyAccount.withdraw(2000);
 
        System.out.println("Updated balance in Smith's account: " + smithAccount.getBalance());
        System.out.println("Updated balance in Kathy's account: " + kathyAccount.getBalance());
 
        System.out.println(smithAccount);
        System.out.println(kathyAccount);
    }
}