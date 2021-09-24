/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 * 
 * Permission has been explicitly granted to the University of Minnesota 
 * Software Engineering Center to use and distribute this source for 
 * educational purposes, including delivering online education through
 * Coursera or other entities.  
 * 
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including 
 * fitness for purpose.
 * 
 * 
 * Modifications 
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to 
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

/**
 * Unit tests for CoffeeMaker class.
 * 
 * @author Sarah Heckman
 */
public class CoffeeMakerTest {
	
	/**
	 * The object under test.
	 */
	private CoffeeMaker coffeeMaker;
	
	// Sample recipes to use in testing.
	private Recipe recipe1;
	private Recipe recipe2;
	private Recipe recipe3;
	private Recipe recipe4;

	/**
	 * Initializes some recipes to test with and the {@link CoffeeMaker} 
	 * object we wish to test.
	 * 
	 * @throws RecipeException  if there was an error parsing the ingredient 
	 * 		amount when setting up the recipe.
	 */
	@Before
	public void setUp() throws RecipeException {
		coffeeMaker = new CoffeeMaker();
		
		//Set up for r1
		recipe1 = new Recipe();
		recipe1.setName("Coffee1");
		recipe1.setAmtChocolate("1");
		recipe1.setAmtCoffee("2");
		recipe1.setAmtMilk("3");
		recipe1.setAmtSugar("4");
		recipe1.setPrice("10");
		
		//Set up for r2
		recipe2 = new Recipe();
		recipe2.setName("Coffee2");
		recipe2.setAmtChocolate("6");
		recipe2.setAmtCoffee("7");
		recipe2.setAmtMilk("8");
		recipe2.setAmtSugar("9");
		recipe2.setPrice("50");
		//Set up for r3
		recipe3 = new Recipe();
		recipe3.setName("Coffee3");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("0");
		recipe3.setAmtMilk("0");
		recipe3.setAmtSugar("0");
		recipe3.setPrice("0");
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Coffee4");
		recipe4.setAmtChocolate("1");
		recipe4.setAmtCoffee("2");
		recipe4.setAmtMilk("3");
		recipe4.setAmtSugar("4");
		recipe4.setPrice("5");
		
		//Set up for r3
		/*recipe3 = new Recipe();
		recipe3.setName("Latte");
		recipe3.setAmtChocolate("0");
		recipe3.setAmtCoffee("3");
		recipe3.setAmtMilk("3");
		recipe3.setAmtSugar("1");
		recipe3.setPrice("100");
		
		//Set up for r4
		recipe4 = new Recipe();
		recipe4.setName("Hot Chocolate");
		recipe4.setAmtChocolate("4");
		recipe4.setAmtCoffee("0");
		recipe4.setAmtMilk("1");
		recipe4.setAmtSugar("1");
		recipe4.setPrice("65");*/

		coffeeMaker.addRecipe(recipe1);
		coffeeMaker.addRecipe(recipe2);
		coffeeMaker.addRecipe(recipe3);
		coffeeMaker.addRecipe(recipe4);
	}
	
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with well-formed quantities
	 * Then we do not get an exception trying to read the inventory quantities.
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	/*@Test
	public void testAddInventory() throws InventoryException {
		String inv = coffeeMaker.checkInventory();

		System.out.println("");
		System.out.println("Initial Inventory");
		System.out.println(inv);

		int initialCoffee = getIngredientCount(inv,"Coffee");
		int initialMilk = getIngredientCount(inv,"Milk");
		int initialSugar = getIngredientCount(inv,"Sugar");
		int initialChocolate = getIngredientCount(inv,"Chocolate");

		try
		{
			cm.addInventory("1","1","1","1");
		}
		catch (InventoryException e)
		{
			fail("InventoryException should not be thrown");
    		}

 		inv = cm.checkInventory();
		System.out.println("Final Inventory");
		System.out.println(inv);

		int finalCoffee = getIngredientCount(inv,"Coffee");
		int finalMilk = getIngredientCount(inv,"Milk");
		int finalSugar = getIngredientCount(inv,"Sugar");
		int finalChocolate = getIngredientCount(inv,"Chocolate");

		assertEquals((initialCoffee + 1),finalCoffee );
		assertEquals((initialMilk + 1), finalMilk );
		assertEquals((initialSugar + 1), finalSugar );
		assertEquals((initialChocolate + 1), finalChocolate );

	} 
	}
	
	/**
	 * Given a coffee maker with the default inventory
	 * When we add inventory with malformed quantities (i.e., a negative 
	 * quantity and a non-numeric string)
	 * Then we get an inventory exception
	 * 
	 * @throws InventoryException  if there was an error parsing the quanity
	 * 		to a positive integer.
	 */
	@Test(expected = InventoryException.class)
	public void testAddInventoryException() throws InventoryException {
		coffeeMaker.addInventory("4", "-1", "asdf", "3");
	}
	
	/**
	 * Given a coffee maker with one valid recipe
	 * When we make coffee, selecting the valid recipe and paying more than 
	 * 		the coffee costs
	 * Then we get the correct change back.
	 */
	@Test
	public void testMakeCoffee() {
		coffeeMaker.addRecipe(recipe1);
		assertFalse(coffeeMaker.addRecipe(recipe1));
		assertEquals(5, coffeeMaker.makeCoffee(0, 15));
		coffeeMaker.addRecipe(recipe3);
		assertEquals(0, coffeeMaker.makeCoffee(0, 0));
		coffeeMaker.addRecipe(recipe2);
		assertEquals(0, coffeeMaker.makeCoffee(1, 50));
		coffeeMaker.addRecipe(recipe2);
		/*assertEquals(0, coffeeMaker.makeCoffee(0, 50));
		coffeeMaker.addRecipe(recipe3);
		assertEquals(-1, coffeeMaker.makeCoffee(9, -1));
		coffeeMaker.addRecipe(recipe4);
		assertEquals(0, coffeeMaker.makeCoffee(9, 0));
		/*assertEquals(0, coffeeMaker.makeCoffee(0, 5));
		assertEquals(0, coffeeMaker.makeCoffee(0, 5));*/


	}

	@Test 
	public void testMakeCoffee1() {
		coffeeMaker.addRecipe(recipe2);
		assertEquals(-15, coffeeMaker.makeCoffee(-2, -15));
	}

	/*@Test
	public void testMakeCoffee2() {
		assertTrue(coffeeMaker.addRecipe(recipe1));
		assertEquals(3, coffeeMaker.makeCoffee(0, 8));
		/*assertTrue(coffeeMaker.addRecipe(recipe1));
		assertFalse(3, coffeeMaker.makeCoffee(0, 8));
		
	}

	@Test
	public void testMakeCoffee3() {
		coffeeMaker.addRecipe(recipe1);
		assertEquals(5, coffeeMaker.makeCoffee(0, 10));
		
	}*/
	

}