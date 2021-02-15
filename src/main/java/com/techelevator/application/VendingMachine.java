package com.techelevator.application;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import com.techelevator.file_io.ActivityLogger;
import com.techelevator.models.Inventory;
import com.techelevator.models.products.Product;
import com.techelevator.ui.UserInput;
import com.techelevator.ui.UserOutput;

public class VendingMachine 
{

	private File inventoryFile = new File("vendingmachine.csv");
	private Inventory inventory = new Inventory(inventoryFile);
	private BigDecimal balance = new BigDecimal("0.00");
	private ActivityLogger logger = new ActivityLogger(inventoryFile.getParent());
	
	BigDecimal previousBalance = new BigDecimal("0.00");
	
	public void run()
    {
		String choice = "home";
        while(true)
        {
            if(choice.equals("home"))
            {
                UserOutput.displayHomeScreen();
                choice = UserInput.getHomeScreenOption();
            }
            else if(choice.equals("display"))
            {
                UserOutput.displayInventory(inventory);
                UserInput.waitForEnter();
                choice = "home";
            }
            else if(choice.equals("purchase"))
            {
                UserOutput.displayPurchaseMenu();
                choice = UserInput.getPurchaseMenuOption(balance);
            }
            else if(choice.equals("feed"))
            {
                feedMoney(UserInput.getCash());
                choice = UserInput.getPurchaseMenuOption(balance);
            }
            else if(choice.equals("select"))
            {
                UserOutput.displayInventory(inventory);
                String productId = UserInput.getSelectedProduct();
    			if(inventory.getProductIds().containsKey(productId))
    			{
                    buyProduct(inventory.getProductIds().get(productId));
    			}
	    		else
	    		{
	    			UserOutput.displayInvalidProductId(productId);
	    		}
                choice = "purchase";
            }
            else if(choice.equals("finish"))
            {
                int[] change = giveChange();
            	UserOutput.displayChange(change[0], change[1], change[2]);
                choice = "home";
            }

            else if(choice.equals("exit"))
            {
                break;
            }
        }
 	
    	
    }

	public Inventory getInventory()
	{
		return inventory;
	}
	
	public BigDecimal getBalance()
	{
		return balance;
	}
	
	public void feedMoney(BigDecimal amount)
	{
		this.balance = this.balance.add(amount);
		logger.logMessage("FEED MONEY: $" + amount.setScale(2) + " $" + balance.setScale(2));
	}

	public int[] giveChange()
	{
		BigDecimal centsDecimal = balance.multiply(new BigDecimal(100));
		String balanceString = centsDecimal.toString();
		double balanceDouble = Double.parseDouble(balanceString);
		int balanceCents = (int)balanceDouble;
		
		int remainder = balanceCents;
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
				
		quarters = balanceCents / 25;
		remainder = balanceCents % 25;
		
		dimes = remainder / 10;
		remainder = remainder % 10;
		
		nickels = remainder / 5;
		remainder = remainder % 5;
		
		previousBalance = balance;
		int[] coins = {quarters, dimes, nickels};
		balance = new BigDecimal("0.00");

		logger.logMessage("GIVE CHANGE: $" + previousBalance + " $" + balance);

		return coins;

		//		// call UserOutput.displayChange
//		System.out.println("Quarters: " + quarters);
//		System.out.println("Dimes: " + dimes);
//		System.out.println("Nickels: " + nickels);

	}
	
	public void buyProduct(Product product)
	{
		previousBalance = balance;

		// before dispensing product, check for stock
		if(inventory.getProducts().get(product) > 0)
		{
			if(balance.compareTo(product.getPrice()) < 0)
			{
				UserOutput.displayInsufficientFunds(product);
			}
			else {
				balance = balance.subtract(product.getPrice());
				inventory.removeProduct(product);
				UserOutput.displayPurchasedProduct(product);
				logger.logMessage(product.getName() + " " + product.getProductId() + " $" + previousBalance + " $" + balance);
			}
		}
		else
		{
			UserOutput.displayOutOfStock(product);
		}
	}
}
