package com.techelevator;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Test;

import com.techelevator.application.VendingMachine;

public class VendingMachineTests 
{
	@Test
	
	public void feedMoney()
	{
		VendingMachine vendingMachine = new VendingMachine();
		
		BigDecimal amountToAdd = new BigDecimal("10.00");
		vendingMachine.feedMoney(amountToAdd);
		BigDecimal actual = vendingMachine.getBalance();
		
		assertEquals(amountToAdd, actual);
	}
	
@Test
	
	public void giveChange()
	{
		VendingMachine vendingMachine = new VendingMachine();
		
		BigDecimal amountToAdd = new BigDecimal("10.00");
		vendingMachine.feedMoney(amountToAdd);
		int[] actual = vendingMachine.giveChange();
		int[] expected = {40, 0, 0};
		
		assertArrayEquals(expected, actual);
	}

@Test

	public void giveChange_145()
	{
		VendingMachine vendingMachine = new VendingMachine();
		
		BigDecimal amountToAdd = new BigDecimal("1.45");
		vendingMachine.feedMoney(amountToAdd);
		int[] actual = vendingMachine.giveChange();
		int[] expected = {5, 2, 0};
		
		assertArrayEquals(expected, actual);
	}
}
