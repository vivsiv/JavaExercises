package dataStructures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


public class BinarySearchTreeTest {
	public BinarySearchTree<Integer> testBst;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void searchTest() {
		//Set up
		Integer[] initArray = {2,1,3};
		testBst = new BinarySearchTree<Integer>(initArray);
		//Tests
		Integer i = testBst.bstSearch(1);
		assertEquals("The test BST should have 1", 1, i.intValue());
		
		i = testBst.bstSearch(4);
		assertNull("The test BST should NOT have 4", i);
	}
	
	@Test
	public void traversalTest(){
		//Set Up
		Integer[] initArray = {3,1,2,4,5,6};
		testBst = new BinarySearchTree<Integer>(initArray);
		//Tests
		assertEquals("PreOrder Traversal should be 3 1 2 4 5 6", 
				"3 1 2 4 5 6", 
				testBst.treeTraversal("preOrder"));
		assertEquals("InOrder Traversal should be 1 2 3 4 5 6", 
				"1 2 3 4 5 6", 
				testBst.treeTraversal("inOrder"));
		assertEquals("PostOrder Traversal should be 2 1 6 5 4 3", 
				"2 1 6 5 4 3", 
				testBst.treeTraversal("postOrder"));
	}
	
	@Test
	public void addTest() {
		//Set Up
		Integer[] initArray = {2,1,3};
		testBst = new BinarySearchTree<Integer>(initArray);
		//Tests
		Integer i = testBst.bstSearch(4);
		assertNull("The test BST should NOT have 4", i);
		testBst.bstAdd(4);
		assertEquals("The test BST should have 4", 4, testBst.bstSearch(4).intValue());
		assertEquals("The tree should be 1 2 3 4", 
				"1 2 3 4", 
				testBst.treeTraversal("inOrder"));
	}
	
	
	
	@Test
	public void deleteTest(){
		//Set Up
		Integer[] initArray = {3,1,2,4,5,6};
		testBst = new BinarySearchTree<Integer>(initArray);
		//Tests
		testBst.bstDelete(5);
		assertEquals("After deleting 5 The tree should be 1 2 3 4 6", 
				"1 2 3 4 6", 
				testBst.treeTraversal("inOrder"));
		testBst.bstDelete(4);
		assertEquals("After deleting 4 then 5 The tree should be 1 2 3 6", 
				"1 2 3 6", 
				testBst.treeTraversal("inOrder"));
		testBst.bstDelete(3);
		assertEquals("After deleting 4 then 5 then 3 The tree should be 2 1 6", 
				"2 1 6", 
				testBst.treeTraversal("inOrder"));
	}
	
	
	
	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
