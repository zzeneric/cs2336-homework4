// Raghav Pillai, 7/10/21

import java.text.DateFormat; // For date formatting
import java.text.SimpleDateFormat; // Simple date formatting
import java.util.Date; // Date class type

public class account{
    private int id; // ID int
    private double balance, annualInterestRate; // Balance and interest rate doubles
    private Date dateCreated = new Date(); // Date class

    public account(){ // Default constructor
        id = 0;
        balance = 0;
        annualInterestRate = 0;
    }

    public account(int newId, double newBalance){ // Overload constructor
        id = newId;
        balance = newBalance;
        dateCreated = new Date();
    }

    // Accessors
    public int getId(){return id;}
    public double getBalance(){return balance;}
    public double getInterestRate(){return annualInterestRate * 100;}
    public Date getDateCreated(){return dateCreated;}

    public double getMonthlyInterestRate(){return annualInterestRate/12;} // (/12 for per month)
    public double getMonthlyInterest(){return balance * (annualInterestRate/12);} // (balance * monthly)

    // Mutators
    public void setId(int newId){id = newId;}
    public void setBalance(int newBalance){balance = newBalance;}
    public void setInterestRate(double newInterestRate){
        annualInterestRate = newInterestRate/100; // /100 to input percentage
    }

    public void withdraw(double toRemove){
        balance = balance - toRemove;
    }

    public void deposit(double toAdd){
        balance = balance + toAdd;
    }

    public static void main(String[] args){ // Testing object
        account testObj = new account(1122, 20000); // Overload constructor
        testObj.setInterestRate(4.5);
        testObj.withdraw(2500);
        testObj.deposit(3000);

        System.out.println("Account ID: " + testObj.getId());
        System.out.println("Balance " + testObj.getBalance() + "$");
        System.out.println("Monthly interest " + testObj.getMonthlyInterest());

        DateFormat dateFormat = new SimpleDateFormat("mm-dd-yyyy"); // Format date
        String strDate = dateFormat.format(testObj.getDateCreated());
        
        System.out.println("Date created " + strDate);
    }
}