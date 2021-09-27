package edu.ncsu.csc326.coffeemaker;

import junit.framework.TestCase;



/**
 * 
 * @author Sarah Heckman
 *
 * Extended by Mike Whalen
 *
 * Unit tests for CoffeeMaker class.
 */

public class CoffeeMakerTest extends TestCase {
	
	private Recipe r1;
	private Recipe r2;
	private Recipe r3;
	private Recipe r4;
	private Recipe r5;
	private CoffeeMaker cm;
	private RecipeBook recipeBookStub;
	private Recipe [] stubRecipies; 
	
	protected void setUp() throws Exception {
		
		cm = new CoffeeMaker();
		
		//Set up for r1
		r1 = new Recipe();
		r1.setName("Coffee");
		r1.setAmtChocolate("0");
		r1.setAmtCoffee("3");
		r1.setAmtMilk("1");
		r1.setAmtSugar("1");
		r1.setPrice("50");
		
		//Set up for r2
		r2 = new Recipe();
		r2.setName("Mocha");
		r2.setAmtChocolate("20");
		r2.setAmtCoffee("3");
		r2.setAmtMilk("1");
		r2.setAmtSugar("1");
		r2.setPrice("75");
		
		//Set up for r3
		r3 = new Recipe();
		r3.setName("Latte");
		r3.setAmtChocolate("0");
		r3.setAmtCoffee("3");
		r3.setAmtMilk("3");
		r3.setAmtSugar("1");
		r3.setPrice("100");
		
		//Set up for r4
		r4 = new Recipe();
		r4.setName("Hot Chocolate");
		r4.setAmtChocolate("4");
		r4.setAmtCoffee("0");
		r4.setAmtMilk("1");
		r4.setAmtSugar("1");
		r4.setPrice("65");
		
		//Set up for r5 (added by MWW)
		r5 = new Recipe();
		r5.setName("Super Hot Chocolate");
		r5.setAmtChocolate("6");
		r5.setAmtCoffee("0");
		r5.setAmtMilk("1");
		r5.setAmtSugar("1");
		r5.setPrice("100");

		stubRecipies = new Recipe [] {r1, r2, r3};
		
		super.setUp();
	}
	
	
	// put your tests here!
	
	public void testMakeCoffee() {
		assertTrue(true);
		
		assertTrue(cm.addRecipe(r1)); 
		
		assertFalse(cm.addRecipe(r1));
	assertFalse(false);
	assertFalse(cm.addRecipe(r1));
	
	cm.addRecipe(r1);
	assertEquals(25, cm.makeCoffee(0, 75));
	
	cm.addRecipe(r1);
	assertEquals(25, cm.makeCoffee(0, 75));
	
	cm.addRecipe(r1);
	assertEquals(25, cm.makeCoffee(0, 75));
	
	cm.addRecipe(r1);
	assertEquals(25, cm.makeCoffee(0, 75));
	
	cm.addRecipe(r1);
	assertEquals(75, cm.makeCoffee(9, 75));
	
	cm.addRecipe(r1);
	assertEquals(25, cm.makeCoffee(0, 75));
	
	cm.addRecipe(r1);
	assertEquals(15, cm.makeCoffee(0, 15));
	
	cm.addRecipe(r1);
	assertEquals(0, cm.makeCoffee(0, 0));
}
	
	
	public void testMakeCoffee2() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		
		cm.makeCoffee(0, 75);
		assertTrue(true);
		cm.makeCoffee(1, 40);
		assertTrue(true);
		cm.makeCoffee(0, 0);
		assertTrue(true);
		cm.makeCoffee(2, 0);
		assertTrue(true);
		cm.makeCoffee(1, 75);
		assertTrue(true);
		
	
	}
	
	public void testAddRecipe() {
		assertTrue(cm.addRecipe(r1));
		assertFalse(cm.addRecipe(r1));
		assertTrue(cm.addRecipe(r2));
		assertTrue(cm.addRecipe(r3));
		assertFalse(cm.addRecipe(r4));
		
		
	}
	
	public void testGetRecipe() {
		cm.getRecipes();
		assertTrue(true);
	}
	public void testCheckInventory() {
	   cm.checkInventory();
	   assertTrue(true);
	}
	
	public void testDeleteRecipe() {
		boolean statusAdd = cm.addRecipe(r1); 
		assertTrue(statusAdd);
		String statusDeleted = cm.deleteRecipe(0); 
		assertTrue(statusDeleted == r1.getName());
		
	}
	public void testDeleteRecipe2() {
		String statusDeleted = cm.deleteRecipe(0);
		assertTrue(statusDeleted == null);
		
	}
	
	
	public void testEditRecipe() {
		cm.addRecipe(r2);
		assertTrue(true);
		cm.editRecipe(2,r3); 
		assertTrue(true);
		
		
		}
	public void testEditRecipe2() {
		cm.addRecipe(r1);
		cm.addRecipe(r2);
		cm.addRecipe(r3);
		cm.editRecipe(1, r2);
		assertTrue(true);
	}
	}

	
