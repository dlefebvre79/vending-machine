package com.techelevator.ui;

import java.util.Map;

import com.techelevator.models.Inventory;
import com.techelevator.models.products.Product;


public class UserOutput 
{
	public static void clearScreen() {  
		System.out.print("\033[H\033[2J");  
		System.out.flush();  
	}

	public static void displayMessage(String message)
	{
		System.out.println();
		System.out.println(message);
		System.out.println();
	}

	public static void displayHomeScreen()
	{
		clearScreen();
		
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("                      Home");
		System.out.println("***************************************************");
		System.out.println();
	}
	
	public static void displayFeedMoneyScreen()
	{
		clearScreen();
		
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("                      Insert Bills");
		System.out.println("***************************************************");
		System.out.println();
	}
	
	public static void displayPurchaseMenu()
	{
		clearScreen();
		
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("                      Purchase");
		System.out.println("***************************************************");
		System.out.println();
	}
	
	public static void displayInventory(Inventory inventory)
	{
		clearScreen();

		System.out.println();
		System.out.println("***************************************************");
		System.out.println("                    Products");
		System.out.println("***************************************************");
		System.out.println();
		
		for(Map.Entry<Product, Integer> entry: inventory.getProducts().entrySet())
		{
			System.out.print(entry.getKey().getProductId());
			System.out.print(" | " + String.format("%-20s", entry.getKey().getName()));
			System.out.print(" | $" + String.format("%.2f", entry.getKey().getPrice()));
			if(entry.getValue() == 0)
			{
				System.out.print(" | Quantity: SOLD OUT\n");
			}
			else
			{
				System.out.print(" | Quantity: " + entry.getValue() + "\n");
			}
		}
		System.out.println();
		
	}
	public static void displayInvalidDepositAmount()
	{
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("  Sorry, this machine can only accept whole dollar");
		System.out.println("amounts from $1-$10: $1, $2, $5, or $10 bills only.");
		System.out.println("***************************************************");
	}

	public static void displayInvalidProductId(String invalidId)
	{
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("  The Product ID " + invalidId + " does not exist.");
		System.out.println("               Please try again.");
		System.out.println("***************************************************");
	}
	
	public static void displayOutOfStock(Product product)
	{
		System.out.println();
		System.out.println("***************************************************");
		System.out.println(" Sorry, " + product.getName() + " is out of stock.");
		System.out.println("  Please enjoy another one of our tempting items!");
		System.out.println("***************************************************");
	}

	public static void displayInsufficientFunds(Product product)
	{
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("     Sorry, you don't have enough funds to buy");
		System.out.println(" " + product.getName()+". Please feed");
		System.out.println("  more into the machine or select a cheaper snack.");
		System.out.println("***************************************************");
	}

	
	public static void displayPurchasedProduct(Product product)
	{
		clearScreen();
		
		System.out.println();
		System.out.println("***************************************************");
		System.out.println("         Dispensing your " + product.getName());
		System.out.println("***************************************************");
		System.out.println();
		System.out.println(product.getSound());
	}
	
	public static void displayChange(int quarters, int dimes, int nickels)
	{
		clearScreen();

		System.out.println();
		System.out.println("***************************************************");
		System.out.println("               Please take your change");
		System.out.println("***************************************************");
		System.out.println();
		
		System.out.println(quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels");
	}
}