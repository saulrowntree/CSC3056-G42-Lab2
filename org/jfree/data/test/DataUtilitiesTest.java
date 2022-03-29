package org.jfree.data.test;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class DataUtilitiesTest extends TestCase {

	private Values2D values2D;
	DefaultKeyedValues2D validTestValues;
	DefaultKeyedValues2D emptyValues = new DefaultKeyedValues2D();

	public void setUp() {
		validTestValues = new DefaultKeyedValues2D();
		values2D = validTestValues;
		validTestValues.addValue(1, 0, 0);
		validTestValues.addValue(2, 0, 1);
		validTestValues.addValue(3, 0, 2);
		validTestValues.addValue(99, 0, 3);
		validTestValues.addValue(-1, 1, 0);
		validTestValues.addValue(-2, 1, 1);
		validTestValues.addValue(7, 1, 2);
		validTestValues.addValue(400, 1, 3);
	}

	protected void tearDown() {
		values2D = null;
	}

	public void testValidDataAndColumnTotal() {
		assertEquals("Wrong sum returned. It should be 0.0", 0.0, DataUtilities.calculateColumnTotal(values2D, 0),
				0.0000001d);
	}

	public void testNullDataColumnTotal() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	// 5 Custom Method Tests

	// 1 //
	// CalculateColumnTotal

	@Test
	public void testCalculateColumnTotalTC1() {
		values2D = validTestValues;
		assertEquals("calculateColumnTotal: Did not return the expected output.",
				DataUtilities.calculateColumnTotal(values2D, 3), 499.0);
	}

	@Test
	public void testCalculateColumnTotalTC2() {
		try {
		values2D = validTestValues;
		assertEquals("calculateColumnTotal: Did not return the expected output.",
				DataUtilities.calculateColumnTotal(values2D, 12), 0.0);
		}catch(Exception e) {
			fail("Exception encountered"+e.getClass());
		}
	}

	@Test
	public void testCalculateColumnTotalTC3() {
		try {
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	@Test
	public void testCalculateColumnTotalTC4() {
		try {
			DataUtilities.calculateColumnTotal(null, -80);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	@Test
	public void testCalculateColumnTotalTC5() {
		values2D = validTestValues;
		assertEquals("calculateColumnTotal: Did not return the expected output.",
				DataUtilities.calculateColumnTotal(emptyValues, 0), 0.0);
	}

	@Test
	public void testCalculateColumnTotalTC6() {
		values2D = validTestValues;
		assertEquals("calculateColumnTotal: Did not return the expected output.",
				DataUtilities.calculateColumnTotal(emptyValues, -452), 0.0);
	}

	// 2 //
	// CalculateRowTotal

	@Test
	public void testCalculateRowTotalTC1() {
		values2D = validTestValues;
		assertEquals("calculateRowTotal: Did not return the expected output.",
				DataUtilities.calculateRowTotal(values2D, 0), 105.0);
	}

	@Test
	public void testCalculateRowTotalTC2() {
		try {
		values2D = validTestValues;
		assertEquals("calculateRowTotal: Did not return the expected output.",
				DataUtilities.calculateRowTotal(values2D, 3), 0);
	}catch(Exception e) {
		fail("Exception encountered"+e.getClass());
	}
	}

	@Test
	public void testCalculateRowTotalTC3() {
		try {
			DataUtilities.calculateRowTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	@Test
	public void testCalculateRowTotalTC4() {
		try {
			DataUtilities.calculateRowTotal(null, -80);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	@Test
	public void testCalculateRowTotalTC5() {
		values2D = validTestValues;
		assertEquals("calculateColumnTotal: Did not return the expected output.",
				DataUtilities.calculateRowTotal(emptyValues, 0), 0.0);
	}

	@Test
	public void testCalculateRowTotalTC6() {
		values2D = validTestValues;
		assertEquals("calculateColumnTotal: Did not return the expected output.",
				DataUtilities.calculateRowTotal(emptyValues, -452), 0.0);
	}

	// 3 //
	// CreateNumberArray

	@Test
	public void testCreateNumberArrayTC1() {
		double[] doubles = { 1.0, 2.0, -1.0, -2.0, -1000.0, 45.0 };

		Number[] nums = DataUtilities.createNumberArray(doubles);
		assertEquals("createNumberArray: Index 0 did not contain the expected value.", doubles[0], nums[0]);
		assertEquals("createNumberArray: Index 1 did not contain the expected value.", doubles[1], nums[1]);
		assertEquals("createNumberArray: Index 2 did not contain the expected value.", doubles[2], nums[2]);
		assertEquals("createNumberArray: Index 3 did not contain the expected value.", doubles[3], nums[3]);
		assertEquals("createNumberArray: Index 4 did not contain the expected value.", doubles[4], nums[4]);
		assertEquals("createNumberArray: Index 5 did not contain the expected value.", doubles[5], nums[5]);
	}

	@Test
	public void testCreateNumberArrayTC2() {
		try {
			Number[] nums = DataUtilities.createNumberArray(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	@Test
	public void testCreateNumberArrayTC3() {
		double[] empty = {};
		Number[] nums = DataUtilities.createNumberArray(empty);
		assertEquals("createNumberArray: Did not contain the expected output.", nums.length, 0);
	}
	
	// 4 //
	// CreateNumberArray2D
	
	@Test
	public void testCreateNumberArray2DTC1() {
		double[][] doubles = {{ 1.0, 2.0, 3.0},{-8.0, -43.0, 200.0}};

		Number[][] nums = DataUtilities.createNumberArray2D(doubles);
		assertEquals("createNumberArray2D: Index 0,0 did not contain the expected value.", doubles[0][0], nums[0][0]);
		assertEquals("createNumberArray2D: Index 0,1 did not contain the expected value.", doubles[0][1], nums[0][1]);
		assertEquals("createNumberArray2D: Index 0,2 did not contain the expected value.", doubles[0][2], nums[0][2]);
		assertEquals("createNumberArray2D: Index 1,0 did not contain the expected value.", doubles[1][0], nums[1][0]);
		assertEquals("createNumberArray2D: Index 1,1 did not contain the expected value.", doubles[1][1], nums[1][1]);
		assertEquals("createNumberArray2D: Index 1,2 did not contain the expected value.", doubles[1][2], nums[1][2]);
	}

	@Test
	public void testCreateNumberArray2DTC2() {
		try {
			Number[][] nums = DataUtilities.createNumberArray2D(null);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	@Test
	public void testCreateNumberArray2DTC3() {
		double[][] empty = {{},{}};
		Number[][] nums = DataUtilities.createNumberArray2D(empty);
		assertEquals("createNumberArray2D: Did not contain the expected output.", nums.length, 2);
	}
	
	
	// 5 //
	// GetCumulativePercentages
	
	@Test
	public void testGetCumulativePercentagesTC1() {
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
        keyedValues.addValue((Comparable) 0, 6.0);
        keyedValues.addValue((Comparable) 1, 11.0);
        keyedValues.addValue((Comparable) 2, 3.0);
        keyedValues.addValue((Comparable) 3, -4.0);
        keyedValues.addValue((Comparable) 4, 1.0);
        keyedValues.addValue((Comparable) 5, 9.0);
        KeyedValues objectUnderTest = DataUtilities.getCumulativePercentages((KeyedValues) keyedValues);
        assertEquals("getCumulativePercentages: Did not contain the expected output.",
        		0.23076923076923078, (double)objectUnderTest.getValue(0));
        assertEquals("getCumulativePercentages: Did not contain the expected output.",
        		0.6538461538461539, (double)objectUnderTest.getValue(1));
        assertEquals("getCumulativePercentages: Did not contain the expected output.",
        		0.7692307692307693, (double)objectUnderTest.getValue(2));
        assertEquals("getCumulativePercentages: Did not contain the expected output.",
        		0.6153846153846154, (double)objectUnderTest.getValue(3));
        assertEquals("getCumulativePercentages: Did not contain the expected output.",
        		0.6538461538461539, (double)objectUnderTest.getValue(4));
        assertEquals("getCumulativePercentages: Did not contain the expected output.",
        		1.0, (double)objectUnderTest.getValue(5));
	}
	
	@Test
	public void testGetCumulativePercentagesTC2() {
        try {
        	DefaultKeyedValues keyedValues = null;
            KeyedValues objectUnderTest = DataUtilities.getCumulativePercentages((KeyedValues) keyedValues);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	@Test
	public void testGetCumulativePercentagesTC3() {
		DefaultKeyedValues keyedValues = new DefaultKeyedValues();
        KeyedValues objectUnderTest = DataUtilities.getCumulativePercentages((KeyedValues) keyedValues);
        assertEquals("getCumulativePercentages: Did not contain the expected output.",0,objectUnderTest.getItemCount());
}
}
