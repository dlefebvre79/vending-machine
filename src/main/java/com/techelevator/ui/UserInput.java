package com.techelevator.ui;

import java.math.BigDecimal;
import java.util.Scanner;


public class UserInput 
{
	private static Scanner scanner = new Scanner(System.in);
	
	public static String getHomeScreenOption()
	{
		System.out.println("Welcome to Pair 5's Badass Vending Machine");
		System.out.println();

		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
		
		System.out.println();
		System.out.print("Please select an option: ");
		
		String selectedOption = scanner.nextLine();
		String option = selectedOption.trim();
		
		if(option.equals("1"))
		{
			return "display";
		}
		else if(option.equals("2"))
		{
			return "purchase";
		}
		else if(option.equals("3"))
		{
			return "exit";
		}
		else
		{
			return "";
		}
		
	}
  
	public static String getSelectedProduct()
	{
		System.out.print("Enter the product ID: ");
		String productId = scanner.nextLine();
		return productId.toUpperCase().trim();
	}

	public static void waitForEnter()
	{
		System.out.print("Press enter to continue...");
		scanner.nextLine();
	}

	public static BigDecimal getCash()
	{
		System.out.print("Enter amount to feed (any USD bill up to $10): $");
		String payment = scanner.nextLine().trim();
		BigDecimal paymentAmount;
		int amount = Integer.parseInt(payment);
		if(amount == 1 || amount == 2 || amount == 5 || amount == 10)
		{
			paymentAmount = new BigDecimal(payment);
		}
		else
		{
			UserOutput.displayInvalidDepositAmount();
			paymentAmount = new BigDecimal("0.00");
		}

		return paymentAmount;
	}
	
	public static String getPurchaseMenuOption(BigDecimal balance)
	{
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		
		System.out.println();
		System.out.println("Current money provided: " + balance);
		
		System.out.println();
		System.out.print("Please select an option: ");
		
		String selectedOption = scanner.nextLine();
		String option = selectedOption.trim();
		
		if(option.equals("1"))
		{
			return "feed";
		}
		else if(option.equals("2"))
		{
			return "select";
		}
		else if(option.equals("3"))
		{
			return "finish";
		}
		else
		{
			return "";
		}
		
	}
}