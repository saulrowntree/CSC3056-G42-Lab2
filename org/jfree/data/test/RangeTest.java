package org.jfree.data.test;

import java.security.InvalidParameterException;

import org.jfree.data.DataUtilities;
import org.jfree.data.Range;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class RangeTest extends TestCase {

	private Range rangeObjectUnderTest;

	@Before
	protected void setUp() throws Exception {
		rangeObjectUnderTest = new Range(-1, 1);
	}

	@After
	protected void tearDown() throws Exception {

	}

	@Test
	public void testCentralValueShouldBeZero() {
		assertEquals("The central value of -1 and 1 should be 0", 0, rangeObjectUnderTest.getCentralValue(),
				0.000000001d);
	}

	@Test
	public void testGetLength() {
		Range r1 = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output.", 0.0, r1.getLength());

		Range r2 = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output.", 5.0, r2.getLength());

		Range r3 = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output.", 0.0, r3.getLength());

		Range r4 = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output.", 7.0, r4.getLength());

		Range r5 = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output.", 8.0, r5.getLength());
	}

	// 5 Custom Method Tests

	// 1 //
	// Get Lower Bound

	@Test
	public void testGetLowerBoundTwoIdenticalPositives() {
		Range r1 = new Range(10.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 10.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTwoIdenticalNegatives() {
		Range r1 = new Range(-10.0, -10.0);
		assertEquals("getLowerBound: Did not return the expected output.", -10.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTwoDifferentPositives() {
		Range r1 = new Range(5.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 5.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTwoDifferentNegatives() {
		Range r1 = new Range(-4.0, -1.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundOneNegativeOnePositive() {
		Range r1 = new Range(-9.0, 14.0);
		assertEquals("getLowerBound: Did not return the expected output.", -9.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundOneZeroOnePositive() {
		Range r1 = new Range(0.0, 7.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundOneNegativeOneZero() {
		Range r1 = new Range(-4.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTwoZeroes() {
		Range r1 = new Range(0.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, r1.getLowerBound());
	}

	// 2 //
	// Get Upper Bound

	@Test
	public void testGetUpperBoundTwoIdenticalPositives() {
		Range r1 = new Range(10.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTwoIdenticalNegatives() {
		Range r1 = new Range(-10.0, -10.0);
		assertEquals("getUpperBound: Did not return the expected output.", -10.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTwoDifferentPositives() {
		Range r1 = new Range(5.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTwoDifferentNegatives() {
		Range r1 = new Range(-4.0, -1.0);
		assertEquals("getUpperBound: Did not return the expected output.", -1.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundOneNegativeOnePositive() {
		Range r1 = new Range(-9.0, 14.0);
		assertEquals("getUpperBound: Did not return the expected output.", 14.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundOneZeroOnePositive() {
		Range r1 = new Range(0.0, 7.0);
		assertEquals("getUpperBound: Did not return the expected output.", 7.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundOneNegativeOneZero() {
		Range r1 = new Range(-4.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTwoZeroes() {
		Range r1 = new Range(0.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, r1.getUpperBound());
	}

	// 3 //
	// Contains

	@Test
	public void testContainsExtremeInvalidMinimum() {
		Range r1 = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", r1.contains(-100.1));
	}

	@Test
	public void testContainsMinimum() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(-100));
	}

	@Test
	public void testContainsExtremeValidMinimum() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(-99.9));
	}

	@Test
	public void testContainsNominal() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(0));
	}

	@Test
	public void testContainsExtremeInvalidMaximum() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(99.9));
	}

	@Test
	public void testContainsBoundaryMaximum() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(100));
	}

	@Test
	public void testContainsExtremeValidMaximum() {
		Range r1 = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", r1.contains(100.1));
	}

	// 4 //
	// Intersects

	@Test
	public void testIntersectsExtremeJustBelowLowerBound() {
		Range r1 = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", r1.intersects(-200, -100.1));
	}

	@Test
	public void testIntersectsOnLowerBound() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(-200, -100));
	}

	@Test
	public void testIntersectsJustAboveLowerBound() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(-200, -99.9));
	}

	@Test
	public void testIntersectsNominalValue() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(-50, 50));
	}

	@Test
	public void testIntersectsExtremeJustBelowUpperBound() {
		Range r1 = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", r1.intersects(99.9, 200));
	}

	@Test
	public void testIntersectsOnUpperBound() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(100, 200));
	}

	@Test
	public void testIntersectsJustAboveUpperBound() {
		Range r1 = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", r1.intersects(100.1, 200));
	}

	@Test
	public void testIntersectsLowerGreaterThanUpper() {
		try {
			Range r1 = new Range(-100, 100);
			r1.intersects(200, 100);
			fail("No exception thrown-Expected outcome was: a thrown exception of type: InvalidParameterException");
		} catch (Exception e) {
			assertTrue("Incorrect exception type thrown", e.getClass().equals(InvalidParameterException.class));
		}
	}

	@Test
	public void testIntersectsLowerEqualToUpper() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(50, 50));
	}
	
	
	// 5 //
	// Constrain
	
	@Test
	public void testConstrainExtremeInvalidMinimum() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(-100.1), -100);
	}

	@Test
	public void testConstrainMinimum() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(-100), -100.0);
	}

	@Test
	public void testConstrainExtremeValidMinimum() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(-99.9), -99.9);
	}

	@Test
	public void testConstrainNominal() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(0.0), 0.0);
	}

	@Test
	public void testConstrainExtremeInvalidMaximum() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(99.9), 99.9);
	}

	@Test
	public void testConstrainBoundaryMaximum() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(100), 100.0);
	}

	@Test
	public void testConstrainExtremeValidMaximum() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(100.1), 100);
	}
	

}