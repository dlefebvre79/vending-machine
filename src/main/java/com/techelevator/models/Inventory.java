package com.techelevator.models;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.techelevator.file_io.FileReader;
import com.techelevator.models.products.Product;

public class Inventory 
{
	private Map<Product, Integer> products = new HashMap<Product, Integer>();
	private Map<String, Product> productIds = new HashMap<String, Product>();
	
	public Inventory(File inventory)
	{
		products = FileReader.loadInventory(inventory);
		for (Map.Entry<Product, Integer> entry : products.entrySet())
		{
			productIds.put(entry.getKey().getProductId(), entry.getKey());
		}
	}

	public Map<String, Product> getProductIds()
	{
		return productIds;
	}

	public Map<Product, Integer> getProducts() 
	{
		return products;
	}
	
	public void removeProduct(Product product)
	{
		int quantity = products.get(product);
		products.put(product, (quantity - 1));
	}
	
	
}
