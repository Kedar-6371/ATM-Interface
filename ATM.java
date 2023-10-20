import java.util.*;
class BankAccount
{
    private double balance;

    public BankAccount(double initialBalance)
    {
        balance=initialBalance;
    }

    public double getBalance()
    {
        return balance;
    }

    public void deposite(double amount)
    {
        if(amount > 0)
        {
            balance += amount;
            System.out.println("Deposite Successful. New balance: $"+balance);
        }
        else{
            System.out.println("Invalid Deposite Amopunt.");
        }
    }

    public boolean withdraw(double amount)
    {
        if(amount > 0 && amount <= balance)
        {
            balance -= amount;
            System.out.println("Withdrawal Successful. New balance: $"+balance);
            return true;
        }
        else{
            System.out.println("Insufficient balance");
            return false;
        }
    }
}

public class ATM {
    private BankAccount account;
    public ATM(BankAccount account)
    {
        this.account=account;
    }

    public void checkBalance()
    {
        double balance = account.getBalance();
        System.out.println("Your Account Balance: $"+balance);
    }

    public void deposite(double amount)
    {
        account.deposite(amount);
    }

    public void withdraw(double amount)
    {
        account.withdraw(amount);
    }

    public static void main(String[] args)
    {
        BankAccount userAccount = new BankAccount(1000.0);
        ATM atm = new ATM(userAccount);
        Scanner sc = new Scanner (System.in);
        
        while(true)
        {
            System.out.println("Welcome to ATM. Choose an option");
            System.out.println("1.check balance");
            System.out.println("2.Deposite");
            System.out.println("3.Withdraw");
            System.out.println("4.Exit");
            System.out.println("Enter your choice:");

            int choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    atm.checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the deposit amount: $");
                    double depositAmount = sc.nextDouble();
                    atm.deposite(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the withdrawal amount: $");
                    double withdrawalAmount = sc.nextDouble();
                    atm.withdraw(withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}