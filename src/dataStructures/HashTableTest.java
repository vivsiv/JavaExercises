package dataStructures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HashTableTest {
	public HashTable<Integer> testTable;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		testTable = new HashTable<Integer>();
	}
	
	@Test
	public void containsTest() {
		assertFalse("Table should NOT have 1", testTable.contains(1));
		testTable.add(1);
		assertTrue("Table should have 1", testTable.contains(1));
		testTable.add(2);
		assertTrue("Table should have 2", testTable.contains(2));
		assertFalse("Table should NOT have 3", testTable.contains(3));
		testTable.remove(1);
		assertFalse("Table should NOT have 1", testTable.contains(1));
	}

	@Test
	public void addTest() {
		assertFalse("Table should NOT have 1", testTable.contains(1));
		testTable.add(1);
		assertTrue("Table should have 1", testTable.contains(1));
	}
	
	@Test
	public void removeTest() {
		testTable.add(1);
		assertTrue("Table should have 1", testTable.contains(1));
		testTable.remove(1);
		assertFalse("Table should NOT have 1", testTable.contains(1));
	}
	
	@Test
	public void sizeTest() {
		assertEquals("Size should be 0", testTable.size(), 0);
		testTable.add(1);
		assertEquals("Size should be 1", testTable.size(), 1);
		testTable.add(2);
		assertEquals("Size should be 2", testTable.size(), 2);
		testTable.add(2);
		assertEquals("Size should STILL be 2", testTable.size(), 2);
		testTable.remove(1);
		testTable.remove(2);
		assertEquals("Size should be 0 again", testTable.size(), 0);
	}
	
	@Test
	public void rehashTest(){
		testTable = new HashTable<Integer>(3);
		testTable.add(1);
		testTable.add(2);
		testTable.add(3);
		testTable.add(4);
		assertEquals("Array should look like", 
				testTable.arrayString(testTable.getBuckets()), 
				"[null [1] [2] [3] [4] null]");
	}
	
	@After
	public void tearDown() throws Exception {
		
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
