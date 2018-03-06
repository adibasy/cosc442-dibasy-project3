package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// TODO: Auto-generated Javadoc
/**
 * The Class VendingMachineTest.
 */
public class VendingMachineTest {
	
	/** The item. */
	VendingMachineItem item;
	
	/** The vm. */
	VendingMachine vm;
	
	

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		item = new VendingMachineItem("bread", 3.25);
		
		vm = new VendingMachine();
		
		
	}

	/**
	 * Tear down.
	 *
	 * @throws Exception the exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testVendingMachine_1() throws Exception{
		assertNotNull(vm);
		assertEquals(0.0, vm.getBalance(), 1.0);
		assertEquals(0.0, vm.returnChange(), 1.0);
		
	}
	
	
	@Test
	public void testVendingMachine_2() throws Exception{
		assertNotNull(vm);
		assertEquals(0.0, vm.getBalance(), 1.0);
		assertEquals(0.0, vm.returnChange(), 1.0);
		
	}
	
	/**
	 * Test add item.
	 */
	@Test
	public void testAddItem_1() throws Exception {
		vm.balance = 0.1;
		vm.addItem(item, "A");
	}

	@Test
	public void testAddItem_2() throws Exception {
		vm.balance = 0.1;
		vm.addItem(item, "B");
	}
	
	@Test
	public void testAddItem_3() throws Exception {
		vm.balance = 0.1;
		vm.addItem(item, "C");
	}
	
	@Test(expected=VendingMachineException.class)
	public void testAddItem_4(){
		vm.balance = 0.1;
		vm.addItem(item, "D");
		vm.addItem(item, "f");
	}
	
	@Test(expected=VendingMachineException.class)
	public void testAddItem_5(){
		vm.balance = 0.1;
		vm.addItem(item, "A");	
		vm.addItem(item, "A");
	}
	
	/**
	 * Test remove item.
	 */
	@Test(expected=VendingMachineException.class)
	public void testRemoveItem_1(){
		
		assertEquals("Remove the Item", vm.removeItem("A"), item);
	}

	@Test
	public void testRemoveItem_2() throws Exception {
		
		vm.addItem(item, "A");	
		assertEquals("Remove the Item", vm.removeItem("A"), item);
	}
	
	/**
	 * Test insert money.
	 */
	@Test(expected=VendingMachineException.class)
	public void testInsertMoney_1(){
		
		vm.insertMoney(-3.50);	
		
	}
	
	@Test
	public void testInsertMoney_2() throws Exception {
		
		vm.insertMoney(3.50);	
		assertEquals(3.50, vm.getBalance(), 0.01);
	}
	
	@Test
	public void testInsertMoney_3() throws Exception {
		
		vm.insertMoney(3.50);	
		assertEquals(3.50, vm.getBalance(), 0.01);
	}


	/**
	 * Test get balance.
	 */
	@Test
	public void testGetBalance_1() throws Exception {
		
		vm.getBalance();
		
	}
	
	@Test
	public void testGetBalance_2() throws Exception {
		
		vm.insertMoney(3.50);
		assertEquals(3.50, vm.getBalance(), 0.01);
	}
	
	@Test
	public void testGetBalance_3() throws Exception {
		
		vm.insertMoney(5.50);
		assertEquals(5.50, vm.getBalance(), 0.01);
	}
	
	/**
	 * Test make purchase.
	 */
	@Test
	public void testMakePurchase_1() throws Exception {
		
		vm.balance = Double.MAX_VALUE;
		
		assertNotNull(item);
			
		vm.insertMoney(0);
		vm.makePurchase("A");
		vm.addItem(item, "A");
		assertEquals("bread", item.getName());
			
		assertEquals(2.50, 3.50, item.getPrice());
		
		assertEquals("Remove the Item", vm.removeItem("A"), item);				
	}
	
	@Test
	public void testMakePurchase_2() throws Exception {
		
		vm.balance = Double.MAX_VALUE;
		
		assertNotNull(item);
			
		vm.insertMoney(0);
		vm.makePurchase("A");
		vm.addItem(item, "A");
		
		assertEquals("Remove the Item", vm.removeItem("A"), item);				
	}
	
	
	@Test
	public void testMakePurchase_3() {
		
		//if(( item != null ) && ( this.balance >= item.getPrice() )) {
		//	removeItem(code);
		//	this.balance -= item.getPrice();
		//	returnCode = true;
		
		vm.balance = 4.50;
		vm.addItem(item, "A");
		assertNotNull(item);
		assertTrue(vm.balance >= item.getPrice());
		vm.removeItem("A");	
	}


	/**
	 * Test return change.
	 */
	@Test
	public void testReturnChange_1() {
		
		vm.insertMoney(3.50);	
		assertEquals(2.50, 3.50, vm.getBalance());
	}

	@Test
	public void testReturnChange_2() {
		
		vm.insertMoney(5.50);	
		assertEquals(2.50, 3.50, vm.getBalance());
	}
	
	@Test
	public void testReturnChange_3() {
		
		vm.insertMoney(2.00);	
		assertEquals(2.50, 3.50, vm.getBalance());
	}
}
