package application;

import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainException;
import java.lang.RuntimeException;


public class BankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		
		Scanner scanner = new Scanner(System.in);
		
		try {
		
			System.out.println("Enter account data: ");
			
			System.out.print("Account number: ");
			int accountNumber = scanner.nextInt();
			scanner.nextLine();
			
			System.out.print("Holder name: ");
			String holderName = scanner.nextLine();
			
			System.out.print("Balance: ");
			double balance = scanner.nextDouble();
			
			System.out.print("Withdraw Limit: ");
			double withdrawLimit = scanner.nextDouble();
			
			Account account = new Account(accountNumber, holderName, balance, withdrawLimit);
			
			System.out.print("\nEnter the value for withdraw: ");
			double withdrawValue = scanner.nextDouble();
			
			account.withdraw(withdrawValue);
			
			System.out.println("\nACCOUNT BALANCE: ");
			System.out.println(account);
			
		}
		
		catch (DomainException e) {
			System.out.println("Domain Exception: " + e.getMessage());
		}
		
		catch (RuntimeException e) {
			System.out.println("Runtime Exception: " + e.getMessage());
		}
	

		finally {
			scanner.close();	
		}
		
		
		
		
	}

}
