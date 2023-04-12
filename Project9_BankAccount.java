/******************************************************************************
 * Bellevue Class: CS-210
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach, 3rd Edition
 *  Authors: Stuart Reges and Marty Stepp
 *
 * Instructor Project Solution
 *
 * Assigned Project: 9
 *         Exercise: 11, 12, and 13
 *             Page: 568
 *
 * Class/File Name: Project8_BankAcount
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     08/02/2013  Initial Release
 *   1.1     01/01/2014  Changed Project Number, WAS: 8, IS: 9
 *
 * File Description
 * ----------------
 * This file defines the the class "Project9_BankAccount", which includes all
 * methods, variables, and constant values. Specifically, this class contains
 * the Console application entry method, main(), which is a static method,
 * since no object of the class type is ever instantiated.
 * 
 * Class Methods
 * -------------
 *     Name                                Description
 * -------------  -------------------------------------------------------------
 * main           OS transfers control to this method upon program execution
 * makeDeposit    Add deposit to referenced "BankAccount" object
 * makeWithdrawal Withdrawal from referenced "BankAccount" object
 *
 ******************************************************************************
 */
// Imported Packages
package Chapter8;

public class Project9_BankAccount
{	
	/**************************************************************************
	 * Method: main(String[])
	 * 
	 * Method Description
	 * ------------------
	 * This static method is the entry point to the program.
	 * 
	 * The program tests the class "BankAccount", which allows for deposits and
	 * withdrawals from a "BankAccount" object. The class, "BankAccount",
	 * supports three initializing Constructors, one that takes the name of the
	 * account only, one that takes the name and the beginning balance, and the
	 * third that takes the name, beginning balance, and the withdrawal
	 * transaction fee. Three objects will be defined to test all three allowed
	 * Constructors. In addition, deposits and withdrawals will be performed to
	 * verify the arithmetic.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * None
	 *
	 * ------------------------------- Arguments ------------------------------
	 *   Type    Name                         Description
	 * --------  ----  --------------------------------------------------------
	 * String[]  args  Array of "String" argument(s) passed to main() when the
	 *                 Console program is invoked by the User.
	 * 
	 * Invoked Methods
	 * ---------------
	 *      Name                              Description
	 * --------------  --------------------------------------------------------
	 * introduction    Inform User of the Project solution
	 * makeDeposit     Add deposit to referenced "BankAccount"
	 * makeWithdrawal  Withdrawal from referenced "BankAccount"
	 * transfer        Transfer amount from one account to another account
	 *
	 **************************************************************************
	 */
	public static void main(String[] args)
	{
        // Constant "final" Value Declarations
        final double BEGINNING_BALANCE1 = 23.67;
        final double BEGINNING_BALANCE2 = 34.57;
        final double TRANSACTION_FEE =    2.50;
        
		// Create a "BankAccount" object, specifying just the account holder's
		// name. The beginning balance and withdrawal fee will be set to $0.0.
        BankAccount myAccount =  new BankAccount("John Doe");
        
        // Create arrays of deposit, withdrawal, and transfer amounts.
        double[] deposits =    new double[] { 51.75, 14.78, -4.59 };
        double[] withdrawals = new double[] { 7.96, 45.79, -3.57, 12.78, .01, 75.86 };
        double[] transfers =   new double[] { 41.38, -8.79, 78.67, 94.74, .01 };
        
        // Uninitialized Variable Declarations
        double deposit, withdrawal, transfer;

        
        // Inform the User of the Project Solution
        introduction();
        
        // Example #1: Account name only specified to Constructor
        System.out.println("\nExample #1: Account object instantiated with name only");
        // Display the beginning account balance
        System.out.println("  Beginning account:" +
        				 "\n    " + myAccount);
        
        // Make a deposit to the account object, then "display" the object
        // via the overloaded "toString()" class method.
        deposit = deposits[0];
        System.out.println("\n  Depositing: $" + deposit);
        makeDeposit(myAccount, deposit);
        
        // Now make a withdrawal
        withdrawal = withdrawals[0];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(myAccount, withdrawal);
        
        // Then another deposit
        deposit = deposits[1];
        System.out.println("\n  Depositing: $" + deposit);        
        makeDeposit(myAccount, deposit);
        
        // Then another deposit that is a negative value
        deposit = deposits[2];
        System.out.println("\n  Depositing: $" + deposit);        
        makeDeposit(myAccount, deposit);
        
        // Another withdrawal
        withdrawal = withdrawals[1];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(myAccount, withdrawal);
        
        // Another withdrawal that is a negative value
        withdrawal = withdrawals[2];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(myAccount, withdrawal);
        
        // Another withdrawal that will result in a balance of $0.00.
        withdrawal = withdrawals[3];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(myAccount, withdrawal);
        
        // Finally, a withdrawal the will exceed the current account balance
        withdrawal = withdrawals[4];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(myAccount, withdrawal);


        // Example #2: Account name and beginning balance specified to the Constructor
        System.out.println("\nExample #2: Account object instantiated with name and" +
        				   "\n            beginning balance: $" + BEGINNING_BALANCE1);
		// Create a "BankAccount" object, specifying the account holder's name
		// and beginning balance. The withdrawal fee will be set to $0.00.
        // Note: This is an example of the Java feature of "garbage" collection.
        //       The REFERENCE "account" is assigned to a new "BankAccount" class
        //       object. Java will detect that no other reference refers to the
        //       previous object (Name: John Doe) and will automatically return
        //       the memory allocated for that object to the Heap Memory Manager.
        myAccount =  new BankAccount("Sarah Jones", BEGINNING_BALANCE1);
        // Display the beginning account balance
        System.out.println("  Beginning account:" +
        				 "\n    " + myAccount);
        
        // Make a deposit to the account object, then "display" the object
        // via the overloaded "toString()" class method.
        deposit = deposits[0];
        System.out.println("\n  Depositing: $" + deposit);
        makeDeposit(myAccount, deposit);
        
        // Now make a withdrawal
        withdrawal = withdrawals[0];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(myAccount, withdrawal);


        // Example #3: Account name, beginning balance, and transaction fee are
        //             specified to the Constructor
        System.out.println("\nExample #3: Account object instantiated with name," +
        				   "\n            beginning balance: $" + BEGINNING_BALANCE2 +
        				   ", and transaction fee: $" + String.format("%.2f", TRANSACTION_FEE));
		// Create a "BankAccount" object, specifying the account holder's name,
		// the beginning balance, and the transaction fee.
        BankAccount yourAccount =
        		new BankAccount("Samuel Johnson", BEGINNING_BALANCE2, TRANSACTION_FEE);
        // Display the beginning account balance
        System.out.println("  Beginning account:" +
        				 "\n    " + yourAccount);
        
        // Make a deposit to the account object, then "display" the object
        // via the overloaded "toString()" class method.
        deposit = deposits[0];
        System.out.println("\n  Depositing: $" + deposit);
        makeDeposit(yourAccount, deposit);
        
        // Now make a withdrawal
        withdrawal = withdrawals[0];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(yourAccount, withdrawal);
        
        // Now make a withdrawal of the exact remaining balance
        // Note: The fee + withdrawal will exceed the remaining balance!
        withdrawal = withdrawals[5];
        System.out.println("\n  Withdrawing: $" + withdrawal);
        makeWithdrawal(yourAccount, withdrawal);


        // Example #4: Transfer between accounts
        System.out.println("\nExample #4: Transfers between two accounts");
        System.out.println(  "    myAccount: " + myAccount +
        				   "\n  yourAccount: " + yourAccount);
        // Make a valid transfer from "myAccount" to "yourAccount"
        transfer = transfers[0];
        System.out.println("\n  Transfering $" + transfer + " from " + myAccount.name() +
        		"'s account to " + yourAccount.name() + "'s account");
        transfer(myAccount, yourAccount, transfer);
        
        // Make an invalid transfer (negative amount) from "myAccount" to "yourAccount"
        transfer = transfers[1];
        System.out.println("\n  Transfering $" + transfer + " from " + myAccount.name() +
        		"'s account to " + yourAccount.name() + "'s account");
        transfer(myAccount, yourAccount, transfer);
        
        // Make a valid transfer from "yourAccount" to "myAccount"
        transfer = transfers[2];
        System.out.println("\n  Transfering $" + transfer + " from " + yourAccount.name() +
        		"'s account to " + myAccount.name() + "'s account");
        transfer(yourAccount, myAccount, transfer);
        
        // Make a second valid transfer from "yourAccount" to "myAccount" that results
        // in a balance of $0.01 in "myAccount"
        transfer = transfers[3];
        System.out.println("\n  Transfering $" + transfer + " from " + myAccount.name() +
        		"'s account to " + yourAccount.name() + "'s account");
        transfer(myAccount, yourAccount, transfer);
        
        // Make an invalid transfer (insufficient funds) from "myAccount" to "yourAccount"
        transfer = transfers[4];
        System.out.println("\n  Transfering $" + transfer + " from " + myAccount.name() +
        		"'s account to " + yourAccount.name() + "'s account");
        transfer(myAccount, yourAccount, transfer);
        
	}   // End static method: main(String[])
	
	
	/**************************************************************************
	 * Method: introduction()
	 * 
	 * Method Description
	 * ------------------
	 * This static method describes the Project solution to the User.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * None
	 *
	 * ------------------------------- Arguments ------------------------------
	 * None
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
	private static void introduction()
	{
		System.out.println("      Project #8 Solution" +
						 "\nChapter 8, Exercise #11, page 568\n");
	}
	
	
	/**************************************************************************
	 * Method: makeDeposit(BankAccount,double)
	 * 
	 * Method Description
	 * ------------------
	 * This static method deposits the amount specified (argument) into the
	 * specified (reference argument) "BankAccount" object. After the deposit,
	 * the account is displayed by calling, indirectly, the overloaded
	 * "toString()" class method.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * None
	 *
	 * ------------------------------- Arguments ------------------------------
	 *     Type        Name                         Description
	 * ------------  --------  ------------------------------------------------
	 * BankAccount   account   Reference to a "BankAccount" object
	 * double        deposit   Amount of the deposit
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
	private static void makeDeposit(BankAccount account, double deposit)
	{
		// First, attempt to make the deposit
        if (account.deposit(deposit) )
        {	// A deposit amount >0 was specified, continue... 
        	// Now "display" the object to the User. By specifying the REFERENCE
        	// to the object as an argument in the "println" method, the compiler
        	// will generate a call to the overloaded class method, "toString()".
        	System.out.println("    " + account);
        }
        else
        {	// Otherwise, an invalid deposit amount was specified
        	System.out.println("    Unable to deposit $" +
        		String.format("%.2f", deposit));
        }
	}
	
	/**************************************************************************
	 * Method: makeWithdrawal(BankAccount,double)
	 * 
	 * Method Description
	 * ------------------
	 * This static method deposits the amount specified (argument) into the
	 * specified (reference argument) "BankAccount" object. After the deposit,
	 * the account is displayed by calling, indirectly, the overloaded
	 * "toString()" class method.
	 * 
	 * RETurn
	 *  Type
	 * ------
	 * None
	 *
	 * ------------------------------- Arguments ------------------------------
	 *     Type         Name                         Description
	 * ------------  ----------  ----------------------------------------------
	 * BankAccount   account     Reference to a "BankAccount" object
	 * double        withdrawal  Amount of the withdrawal
	 * 
	 * Invoked Methods
	 * ---------------
	 * None
	 *
	 **************************************************************************
	 */
	private static void makeWithdrawal(BankAccount account, double withdrawal)
	{
		// Attempt to make the withdrawal. The class method, "withdrawal" will
		// RETurn a "boolean" value; "true": Withdrawal made,
		// "false": Withdrawal (+ fee, if applicable) will exceed current
		// balance.
		boolean status = account.withdrawal(withdrawal);
		
		if (status)
		{	// Withdrawal was successful, display the remaining balance.
        	System.out.println("    " + account);
		}
        else
        {	// Otherwise, inform the User that withdrawal was NOT made.
        	System.out.println("    Unable to withdraw $" +
        		String.format("%.2f", withdrawal));
        }
		
		// Note: A "return" statement is unnecessary for a method that "returns"
		//       "void", but is allowed for completeness.
		return;
	}
	
	
	private static void transfer(BankAccount source, BankAccount destination,
								 double transferAmount)
	{
		// Attempt to make the transfer. The class method, "transfer" will
		// RETurn a "boolean" value; "true": Transfer was made,
		// "false": Transfer + fee will exceed current balance of the
		// source account.
		boolean status = source.transfer(destination, transferAmount);
		
		if (status)
		{	// Transfer was successful, display the two accounts.
	        System.out.println("         Source Account: " + source +
			   		 		 "\n    Destination Account: " + destination);
		}
        else
        {	// Otherwise, inform the User that withdrawal was NOT made.
        	System.out.println("    Unable to transfer $" +
        		String.format("%.2f", transferAmount));
        }
	}
	
}   // End class definition: Project9_BankAccount