package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineItemTest.
 */
public class VendingMachineItemTest {
	
	/** The item. */
	VendingMachineItem item;
	
	
	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
	
		item = new VendingMachineItem("bread", 3.75);
			
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test vending machine item.
	 */
	@Test
	public void testVendingMachineItem_1(){
		
		item = new VendingMachineItem("bread", 3.75);
		
		assertNotNull(item);
		assertEquals("bread", item.getName());
		assertEquals(3.75, item.getPrice(), 3.75);
		
		
	}
	
	@Test(expected=VendingMachineException.class)
	public void testVendingMachineItem_2(){
		
		item = new VendingMachineItem("bread", -3.75);
		
		assertNotNull(item);
		
		assertEquals(-3.75, item.getPrice(), -3.75);
	}
	
	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() throws Exception {
		
		
		assertEquals("bread", item.getName());
	}

	/**
	 * Test get price.
	 */
	@Test
	public void testGetPrice() throws Exception {
		
		
		assertEquals(3.75, item.getPrice(), 0.01);
	}

}
