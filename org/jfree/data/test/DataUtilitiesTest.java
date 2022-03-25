package org.jfree.data.test;

import java.security.InvalidParameterException;

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
	
	public void setUp()
	{
		DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
		values2D = testValues;
		testValues.addValue(1, 0, 0);
		testValues.addValue(4, 1, 0);
	}

	protected void tearDown() {
		values2D = null;
	}

	public void testValidDataAndColumnTotal() {
		assertEquals("Wrong sum returned. It should be 5.0",
				5.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
	}
	
	public void testNullDataColumnTotal() {
		try 
		{
			DataUtilities.calculateColumnTotal(null, 0);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		}
		catch (Exception e)
		{
			assertTrue("Incorrect exception type thrown",
			e.getClass().equals(InvalidParameterException.class));
		}
	}
	
	// 5 Custom Method Tests

}
