package com.techelevator.models.products;

import java.math.BigDecimal;

public abstract class Product
{
	private String productId;
	private String name;
	private BigDecimal price;
	private String sound;
	
	
	public Product(String productId, String name, BigDecimal price, String sound)
	{
		this.productId = productId;
		this.name = name;
		this.price = price;
		this.sound = sound;
	}

	public String getProductId()
	{
		return productId;
	}

	public String getName()
	{
		return name;
	}

	public BigDecimal getPrice()
	{
		return price;
	}

	public String getSound()
	{
		return sound;
	}
	
	
}
