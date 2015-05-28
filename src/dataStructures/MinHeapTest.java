package dataStructures;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MinHeapTest {
	public MinHeap<Integer> testHeap;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		Integer[] in = {3,2,6,1,7,8};
		testHeap = new MinHeap<Integer>(in);
	}
	
	@Test
	public void buildTest(){
		assertEquals("Built heap, should be {1 2 6 3 7 8}", "{1 2 6 3 7 8}", testHeap.heapString());
	}
	
	@Test
	public void peekTest() {
		assertEquals("Peek() should be 1", 1, testHeap.peek().intValue());
	}
	
	@Test
	public void addTest(){
		testHeap.add(4);
		assertEquals("Built heap, should be {1 2 4 3 7 8 6}", "{1 2 4 3 7 8 6}", testHeap.heapString());
	}
	
	@Test
	public void pollTest(){
		Integer polled = testHeap.poll();
		assertEquals("Polled 1, should be 1", 1, polled.intValue());
		while (testHeap.size() > 0){
			assertNotNull(testHeap.poll());
		}
		assertNull(testHeap.poll());
		assertEquals(testHeap.size(), 0);
	}
	
	

	@After
	public void tearDown() throws Exception {
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

}
