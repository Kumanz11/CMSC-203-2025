package assignment5;

import static org.junit.Assert.*;
import java.io.*;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent {

	double[][] data = {
			{ 1.0, 2.0, 3.0 },
			{ 4.0, 5.0 },
			{ -1.0, 10.0, 2.0, 1.0 }
	};

	@Test
	public void testGetAverage() {
		double avg = TwoDimRaggedArrayUtility.getAverage(data);
		assertEquals( (1+2+3+4+5-1+10+2+1)/9.0 , avg, 0.001);
	}

	@Test
	public void testGetColumnTotal() {
		double col0 = TwoDimRaggedArrayUtility.getColumnTotal(data, 0);
		assertEquals(1 + 4 + (-1), col0, 0.001);
	}

	@Test
	public void testGetHighestInArray() {
		assertEquals(10.0, TwoDimRaggedArrayUtility.getHighestInArray(data), 0.001);
	}

	@Test
	public void testGetHighestInColumn() {
		double highestCol1 = TwoDimRaggedArrayUtility.getHighestInColumn(data, 1);
		assertEquals(10.0, highestCol1, 0.001);
	}

	@Test
	public void testGetHighestInColumnIndex() {
		int idx = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, 1);
		assertEquals(2, idx);
	}

	@Test
	public void testGetHighestInRow() {
		assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(data, 0), 0.001);
	}

	@Test
	public void testGetHighestInRowIndex() {
		assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(data, 0));
	}

	@Test
	public void testGetLowestInArray() {
		assertEquals(-1.0, TwoDimRaggedArrayUtility.getLowestInArray(data), 0.001);
	}

	@Test
	public void testGetLowestInColumn() {
		double lowestCol1 = TwoDimRaggedArrayUtility.getLowestInColumn(data, 1);
		assertEquals(2.0, lowestCol1, 0.001);
	}

	@Test
	public void testGetLowestInColumnIndex() {
		int idx = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, 1);
		assertEquals(0, idx);
	}

	@Test
	public void testGetLowestInRow() {
		assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(data, 0), 0.001);
	}

	@Test
	public void testGetLowestInRowIndex() {
		assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(data, 2));
	}

	@Test
	public void testGetRowTotal() {
		assertEquals(1 + 2 + 3, TwoDimRaggedArrayUtility.getRowTotal(data, 0), 0.001);
	}

	@Test
	public void testGetTotal() {
		assertEquals(1+2+3+4+5-1+10+2+1, TwoDimRaggedArrayUtility.getTotal(data), 0.001);
	}	
}
