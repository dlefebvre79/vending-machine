package com.techelevator.file_io;

import java.io.File;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.techelevator.models.products.Candy;
import com.techelevator.models.products.Chip;
import com.techelevator.models.products.Drink;
import com.techelevator.models.products.Gum;
import com.techelevator.models.products.Product;

public class FileReader 
{
	
	private static Map<Product, Integer> products = new HashMap<Product, Integer>();
	
	
	public static Map<Product, Integer> loadInventory(File inventoryFile)
	{
		File inventory = new File(inventoryFile.getAbsolutePath());
		
		try(Scanner scanner = new Scanner(inventory);)
		{
			
			while(scanner.hasNextLine())
			{
				Product product = null;
				String line = scanner.nextLine();
				String[] splits = line.split("\\|");
				// [0] = ID
				String productId = splits[0];
				// [1] = name
				String name = splits[1];
				// [2] = price
				String price = splits[2];
				// [3] = type of item
				String type = splits[3];
				
				if(type.equals("Chip"))
				{
					product = new Chip(productId, name, new BigDecimal(price), "Crunch Crunch, Yum!");	
				}
				else if(type.equals("Candy"))
				{
					product = new Candy(productId, name, new BigDecimal(price), "Munch Munch, Yum!");	
				}
				else if(type.equals("Drink"))
				{
					product = new Drink(productId, name, new BigDecimal(price), "Glug Glug, Yum!");	
				}
				else if(type.equals("Gum"))
				{
					product = new Gum(productId, name, new BigDecimal(price), "Chew Chew, Yum!");	
				}
				
				products.put(product, 5);
				
			}
					
		}
		catch (Exception e)
		{
			
		}
		return products;

	}

}
