package org.jfree.data.test;

import java.security.InvalidParameterException;
import java.util.Arrays;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
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
	DefaultKeyedValues2D emptyValues = new DefaultKeyedValues2D();;

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
		assertEquals("Wrong sum returned. It should be 5.0", 5.0, DataUtilities.calculateColumnTotal(values2D, 0),
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
		assertEquals("calculateColumnTotal: ")
	}

}
