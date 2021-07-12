// Raghav Pillai, 7/11/21

import java.util.ArrayList; // Array lists
import java.util.Scanner; // Scanner for inputs

public class ATM{
    ArrayList<account> accountHolder = new ArrayList<account>(); // Array list to hold accounts
    Scanner scanner = new Scanner(System.in); // Global scanner

    public ATM(){ // Constructor
        for(int i = 0; i <= 10; i++){ // Make 10 accounts with default value of 100
            account testObj = new account(i, 100); // 1 to 10
            accountHolder.add(testObj);
        }
        promptID(); // Start the prompt
    }

    public void promptID(){ // 4/first, splash screen
        System.out.println("What is your ID [0-10]?"); // Prompt for ID
        int option = scanner.nextInt();
        if(option <= 10 && option >= 0){ // If valid
            mainMenu(accountHolder.get(option));
            System.out.println("---------");
        }else{ // Invalid restarts
            System.out.println("Enter a valid ID.");
            System.out.println("---------");
            promptID();
        }
    }

    public void mainMenu(account account){ // Main
        System.out.println( // Prompt for option
            "Options:\n" +
            "1 - Current Balance\n" +
            "2 - Withdraw\n" +
            "3 - Deposit\n" +
            "4 - Exit"
        );

        int option = scanner.nextInt();
        switch(option){ // Case 1-4 valid, anything else invalid
            case 1: 
                System.out.println("---------");
                currBalance(account);
            case 2: 
                System.out.println("---------");
                withdraw(account);
            case 3: 
                System.out.println("---------");
                deposit(account);
            case 4: 
                System.out.println("---------");
                promptID();
            default: // Outliers
                System.out.print("Invalid ID. Pick a valid option. ");
                mainMenu(account);
        }
    }

    public void currBalance(account account){ // Option 1, balance (input account)
        System.out.println("Account balance for ID [" + account.getId() + "]");
        System.out.println("$" + account.getBalance());// Get from account class
        System.out.println("---------");
        mainMenu(account); // Back to main menu after the prompt is done
    }

    public void withdraw(account account){ // Option 2, withdraw (input account)
        System.out.println("How much to withdraw?");
        Double money = scanner.nextDouble();
        account.withdraw(money); // Withdraw from account class
        System.out.println("Withdrew $" + money + " from account ID [" + account.getId() + "]"); // Confirm statement
        System.out.println("---------");
        mainMenu(account); // Back to main menu after the prompt is done
    }

    public void deposit(account account){ // Option 3, deposit (input account)
        System.out.println("How much to deposit?");
        Double money = scanner.nextDouble();
        account.deposit(money);// Deposit to account class
        System.out.println("Deposited $" + money + " to account ID [" + account.getId() + "]"); // Confirm statement
        System.out.println("---------");
        mainMenu(account); // Back to main menu after the prompt is done
    } 

    public static void main(String[] args){
        new ATM(); // Start ATM prompt
    }
}