package datastruct;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class MyUnsortedListTest {
	
	private UnsortedList<Integer> list;


	@Before 
	public void init() {
		list = MyUnsortedList.of();
	}
	
	
	
		//test isEmpty()
		
	@Test
	public void testIsEmpty_init() {
		assertTrue("Init list is Empty", list.isEmpty());
	}
	
	@Test
	public void testIsEmpty_afterInsertingAppend() {
		list.append(1);
		assertFalse("List with an element is not empty",list.isEmpty());
	}
	
	@Test
	public void testIsEmpty_afterInsertingPrepend() {
		list.append(1);
		assertFalse("List with an element is not empty",list.isEmpty());
	}
	
	@Test
	public void testIsEmpty_afterRemovePop() {
		list.append(1);
		list.pop();
		assertTrue("List after deleting the first element is Empty", list.isEmpty());
	}
	
	@Test
	public void testIsEmpty_afterRemovePopLast() {
		list.append(1);
		list.popLast();
		assertTrue("List after deleting the last element is Empty", list.isEmpty());
	}
	
	@Test
	public void testIsEmpty_afterRemove() {
		list.append(1);
		list.remove(0);
		assertTrue("List after deleting the last element is Empty", list.isEmpty());
	}
	
	

	
		//test size()
	
	@Test
	public void testSize_empty() {
		assertEquals("List empty have size to 0", 0, list.size());
	}
	
	@Test
	public void testSize_insert1Elemnt() {
		list.append(1);
		assertEquals("List with 1 inserting have size to 1", 1, list.size());
	}
	
	@Test
	public void testSize_remove1Elment() {
		list.append(1);
		list.pop();
		assertEquals("List with 1 inserting and 1 deleting have size to 0", 0, list.size());
	}
	
	@Test
	public void testSize_insertingSeveralElemnts() {
		for(int i = 1; i< 10; i++) {
			list.append(i);
			assertEquals("List with i insertion have size to i", i, list.size());
		}
	}
	
	@Test
	public void testSize_deletingAllElements() {
		for(int i = 1; i< 10; i++) {
			list.append(i);
		}
		for(int i = 1; i < 10; i++) {
			list.pop();
		}
		assertEquals("List empty after removing all element have size to 0", 0, list.size());
	}
	
	
	
	
		//test prepend()
	
	@Test
	public void testPrepend_Insert1Element() {
		int result;
		list.prepend(0);
		result = list.pop();
		assertEquals("Result must be the last element inserting", 0, result);
	}
	
	@Test
	public void testPrepend_insert1ElementSeveralTime() {
		int result;

		for(int i = 1; i< 10; i++) {
			list.prepend(i);
			result = list.pop();
			assertEquals("Result must be the i element inserting", i, result);
		}
	}
	
	@Test
	public void testPrepend_insertSeveralElement() {
		int result;
		
		for(int i = 1; i< 10; i++) {
			list.prepend(i);
		}
		result = list.pop();
		assertEquals("Result must be the last element inserting", 9, result);
	}
	
	
	
	
		//test append()
	
	@Test
	public void testAppend_insert1Element() {
		int result;
		list.append(0);
		result = list.popLast();
		assertEquals("Result must be the first element", 0, result);
	}
	
	@Test
	public void testAppend_inserting1ElementSeveralTime() {
		int result;
		list.append(0);
		
		for(int i = 1; i< 10; i++) {
			list.append(i);

			result = list.popLast();// bug ici : manque le size -- de popLast()
			assertEquals("Result must be the ith element", i, result);
		}
	}
	
	@Test
	public void testAppend_insertSeveralElement() {
		int result;
		list.append(0);
		
		for(int i = 1; i< 10; i++) {
			list.append(i);
		}
		
		result = list.popLast();
		assertEquals("Result must be the last element of the list",9, result);
	}
	
	
	
	
		//test insert()
	
	@Test
	public void testInsert_insert1Element() {
		list.insert(0, 0);
		int result;
		result = list.popLast();
		assertEquals("Result must be the last element add", 0, result);
		
	}
	
	@Test
	public void testInsert_insertSeveralElement() {
		int result;
		for(int i = 0; i<10; i++) {
			list.insert(i, 0);
			
			result = list.popLast();
			assertEquals("Result must be the last element add", i, result);
		}
	}
	
	@Test
	public void testInsert_insert1ElementSeveralTime() {
		int result;
		
		for(int i = 1; i< 10; i++) {
			list.append(i);
		}
		
		result = list.popLast();
		assertEquals("Result must be the last element add", 9, result);
	}
	
	@Test
	public void testInsert_insert1ElementAtTheSamePosition() {
		list.insert(0, 0);
		list.insert(1, 0);
		
		int result;
		result = list.pop();
		assertEquals("Result must be the second element add", 1, result);
		
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsert_ExcepetionPositionOutofBoundsMax() throws Exception {
		list.insert(0, 666);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testInsert_ExcepetionPositionOutofBoundsMin() throws Exception {
		list.insert(0, -1);
	}
	
	
		//test pop()
	
	@Test(expected = EmptyListException.class)
	public void testPop_ExceptionListEmpty() {
		list.pop();
	}
	
	@Test
	public void testPop_getfirstElementListSize1() {
		list.insert(0, 0);
		int result = list.pop();
		assertEquals("Result must be the previous insert value", 0, result);
	}
	
	@Test
	public void testPop_getfirstElementListSize10() {
		for (int i =0; i<10; i++) {
			list.insert(i, i);		
		}
		int result = list.pop();
		assertEquals("Result must be the first insert value", 0, result);
	}
	
	@Test
	public void testPop_getfirstElementSeveralTimes() {
		for (int i =0; i<10; i++) {
			list.insert(i, i);		
		}
		int result;
		for (int i =0; i<10; i++) {
			result = list.pop();
			assertEquals("Result must be the ith insert value", i, result);
		}
	}
	
	
	
	
		//test popLast()
	
	@Test(expected = EmptyListException.class)
	public void testPopLast_ExceptionListEmpty() {
		list.popLast();
	}
	
	@Test
	public void testPopLast_getLastElementListSize1() {
		list.insert(0, 0);
		int result = list.popLast();
		assertEquals("Result must be the previous insert value", 0, result);
	}
	
	@Test
	public void testPopLast_getLastElementListSize10() {
		int i;
		for (i =0; i<10; i++) {
			list.insert(i, i);		
		}
		int result = list.popLast();
		assertEquals("Result must be the last insert value", i-1, result);
	}
	
	@Test
	public void testPopLast_getLastElementSeveralTimes() {
		for (int i =0; i<10; i++) {
			list.insert(i, i);		
		}
		
		int result;
		for (int i =list.size()-1; i>0; i--) {
			result = list.popLast();
			assertEquals("Result must be the last insert value", i, result);
		}
	}
	
	
	
	
		//test remove()
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_ExcepetionPositionOutofBoundsMax() throws Exception {
		list.remove(666);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_ExcepetionPositionOutofBoundsMin() throws Exception {
		list.remove (-1);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testRemove_ExcepetionPositionOutofBoundsListEmpty() throws Exception {
		list.remove (0);
	}
	
	@Test
	public void testRemove_Remove1Element() throws Exception {
		list.insert(0,0);
		int result = list.remove (0);
		assertEquals("Result must be the last insert value", 0, result);
		
	}
	
	@Test
	public void testRemove_RemoveLastElement() throws Exception {
		int i;
		for (i =0; i<10; i++) {
			list.insert(i, i);		
		}
		
		int result;
		
		result = list.remove(i-1);
		assertEquals("Result must be the last insert value", i-1, result);
		
	}
	
	@Test
	public void testRemove_RemoveFirstElement() throws Exception {
		int i;
		for (i =0; i<10; i++) {
			list.insert(i, i);		
		}
		
		int result;
		
		result = list.remove(0);
		assertEquals("Result must be the first insert value", 0, result);
		
	}
	
	@Test
	public void testRemove_RemoveOneElement() throws Exception {
		int i;
		for (i =0; i<10; i++) {
			list.insert(i, i);		
		}
		
		int result;
		
		result = list.remove(5);
		assertEquals("Result must be the 5th insert value", 5, result);
		
	}

}
