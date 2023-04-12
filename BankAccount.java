/******************************************************************************
 * Bellevue Class: CS-210
 *           Term: Fall 2014
 *     Instructor: Robert Main
 *     
 * Textbook: Building Java Programs, A Back to Basics Approach
 *  Edition: 3rd
 *  Authors: Stuart Reges and Marty Stepp
 *  
 * Assigned Project: 9
 *
 *     Class: BankAccount
 * File Name: BankAccount.java
 *
 * Programmer: Bao Tran
 *
 * Revision     Date                        Release Comment
 * --------  ----------  ------------------------------------------------------
 *   1.0     11/23/2104  Initial Release
 *
 * File Description
 * ----------------
 * This file defines the the class BankAccount, which includes all methods,
 * variables, and constant values. Specifically, this class contains the Console
 * application entry method, main(), which is a static method, since no object
 * of the class type is ever instantiated.
 *
 * 
 * Program Inputs
 * --------------
 *  Device                              Description
 * --------  ------------------------------------------------------------------
 * Keyboard none
 *
 * 
 * Program Outputs
 * ---------------
 *  Device                            Description
 * --------  ------------------------------------------------------------------
 * Monitor   The balance, what left after withdrawal, deposit, transfer
 *
 * 
 * Class Methods
 * -------------
 *    Name                                    Description
 * ----------  ----------------------------------------------------------------
 * BankAccount	It actually constructor of my class, there are three total with different
 * 				 signature to take in different information from user
 * name			Return the name of account
 * deposit		Add the money to balance of the account, also check if transaction can be done
 * withdrawal	Take away the money from account's balance, also check if transaction can be done
 * transfer		transfer the money from current account to destination account, the amount is given
 * toString		print name of account and current balance when call
 *  ******************************************************************************
 */
// Imported Packages
package Chapter8;

public class BankAccount {
	private String name;
	private double balance;
	private double transactionFee=0.0;
	
	/**************************************************************************
	 * Method: BankAccount(String name, double balance)
	 * 
	 * Method Description
	 * ------------------
	 * constructor
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String	  name         name of account
	 * double					the current balance of account
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * N/A
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * Project9_BankAccount		
	 *                         
	 **************************************************************************                         
	 */
	public BankAccount(String name, double balance){
		this.name = name;
		this.balance = balance;
	}
	/**************************************************************************
	 * Method: BankAccount (String name)
	 * 
	 * Method Description
	 * ------------------
	 * constructors.
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String	  name         name of account
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * N/A		
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * Project9_BankAccount		
	 *                         
	 **************************************************************************                         
	 */
	public BankAccount(String name){
		this.name = name;
		
	}
	/**************************************************************************
	 * Method: BankAccount (String name, double balance, double transactionFee)
	 * 
	 * Method Description
	 * ------------------
	 * constructors.
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * String	  name         name of account
	 * double					the current balance of account
	 * transactionFee			fee when transactions are made
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * N/A	
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * Project9_BankAccount		
	 *                         
	 **************************************************************************                         
	 */
	public BankAccount(String name, double balance, double transactionFee){
		this.name = name;
		this.balance = balance;
		this.transactionFee = transactionFee;
	}
	
	
	
	/**************************************************************************
	 * Method: name()
	 * 
	 * Method Description
	 * ------------------
	 * return name of account
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * 
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * String   return name
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * None
	 *                         
	 **************************************************************************                         
	 */
	public String name(){
		return name;
	}
	
	
	
	/**************************************************************************
	 * Method: deposit(double amount)
	 * 
	 * Method Description
	 * ------------------
	 * add given money to the account's balance
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 *	
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * boolean	to check whether the transaction is succeed for not
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * None
	 *                         
	 **************************************************************************                         
	 */
	public boolean deposit(double amount){
		if (amount>0){
			balance = balance + amount;
			System.out.println("  Total fees: "+ transactionFee);
			return true;
		}else{
			return false;
		}
		
		
	}
	
	/**************************************************************************
	 * Method: withdrawal(double amount)
	 * 
	 * Method Description
	 * ------------------
	 * minus the money from balance
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * 
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * boolean	to check whether the transaction is succeed for not
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * None
	 *                         
	 **************************************************************************                         
	 */
	public boolean withdrawal(double amount){
		if (balance>=amount+transactionFee &&amount>0){
			balance = balance - amount-transactionFee;
			System.out.println("  Total fees: "+ transactionFee);
			return true;
		}else{
			return false;
		}
		
	}
	
	/**************************************************************************
	 * Method: transfer(BankAccount destination, double amount)
	 * 
	 * Method Description
	 * ------------------
	 * move money from balance to destination account
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * Bankaccount	destination	where money should be after method called
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * boolean	to check whether the transaction is succeed for not
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * None
	 *                         
	 **************************************************************************                         
	 */
	public boolean transfer(BankAccount destination, double amount){
		double transfer= 5.00;
		double total = amount +transfer;
		if (amount>balance&& balance>5.00){
			balance-=5.00;
			destination.balance+= balance;
			balance =0;
			return true;
		}else if(total<= balance&&amount >0){
			balance -= total;
			destination.balance +=amount;
			System.out.println("  Total fees: "+ (transfer+transactionFee));
			return true;
		}else
			return false;
		
		
	}
	/**************************************************************************
	 * Method: toString()
	 * 
	 * Method Description
	 * ------------------
	 * return name and balance of account
	 * 
	 * 
	 * Pre-Conditions
	 * --------------
	 * none
	 *
	 * 
	 * ---------------------------- Method Arguments --------------------------
	 *   Type        Name                         Description
	 * --------  ------------  ------------------------------------------------
	 * 
	 * 
	 * 
	 * RETurn
	 *  Type                            Description
	 * ------  ----------------------------------------------------------------
	 * String	return a string of name and balance
	 *
	 * 
	 * ---------------------------- Invoked Methods ---------------------------
	 *  Class       Name                        Description
	 * --------  ----------  --------------------------------------------------
	 * None
	 *                         
	 **************************************************************************                         
	 */
	public String toString(){
		return String.format(name+" Balance: %.2f", balance);
		
	}
}
