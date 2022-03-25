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
		rangeObjectUnderTest = new Range(2, 2);
		assertEquals("getLength: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLength());

		rangeObjectUnderTest = new Range(4, 9);
		assertEquals("getLength: Did not return the expected output.", 5.0, rangeObjectUnderTest.getLength());

		rangeObjectUnderTest = new Range(-99, -99);
		assertEquals("getLength: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLength());

		rangeObjectUnderTest = new Range(-11, -4);
		assertEquals("getLength: Did not return the expected output.", 7.0, rangeObjectUnderTest.getLength());

		rangeObjectUnderTest = new Range(-5, 3);
		assertEquals("getLength: Did not return the expected output.", 8.0, rangeObjectUnderTest.getLength());
	}

	// 5 Custom Method Tests

	// 1 //
	// Get Lower Bound

	@Test
	public void testGetLowerBoundTC1() {
		rangeObjectUnderTest = new Range(10.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 10.0, rangeObjectUnderTest.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC2() {
		rangeObjectUnderTest = new Range(-10.0, -10.0);
		assertEquals("getLowerBound: Did not return the expected output.", -10.0, rangeObjectUnderTest.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC3() {
		rangeObjectUnderTest = new Range(5.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 5.0, rangeObjectUnderTest.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC4() {
		rangeObjectUnderTest = new Range(-4.0, -1.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, rangeObjectUnderTest.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC5() {
		rangeObjectUnderTest = new Range(-9.0, 14.0);
		assertEquals("getLowerBound: Did not return the expected output.", -9.0, rangeObjectUnderTest.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC6() {
		rangeObjectUnderTest = new Range(0.0, 7.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC7() {
		rangeObjectUnderTest = new Range(-4.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, rangeObjectUnderTest.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC8() {
		rangeObjectUnderTest = new Range(0.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getLowerBound());
	}

	// 2 //
	// Get Upper Bound

	@Test
	public void testGetUpperBoundTC1() {
		rangeObjectUnderTest = new Range(10.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, rangeObjectUnderTest.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC2() {
		rangeObjectUnderTest = new Range(-10.0, -10.0);
		assertEquals("getUpperBound: Did not return the expected output.", -10.0, rangeObjectUnderTest.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC3() {
		rangeObjectUnderTest = new Range(5.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, rangeObjectUnderTest.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC4() {
		rangeObjectUnderTest = new Range(-4.0, -1.0);
		assertEquals("getUpperBound: Did not return the expected output.", -1.0, rangeObjectUnderTest.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC5() {
		rangeObjectUnderTest = new Range(-9.0, 14.0);
		assertEquals("getUpperBound: Did not return the expected output.", 14.0, rangeObjectUnderTest.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC6() {
		rangeObjectUnderTest = new Range(0.0, 7.0);
		assertEquals("getUpperBound: Did not return the expected output.", 7.0, rangeObjectUnderTest.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC7() {
		rangeObjectUnderTest = new Range(-4.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC8() {
		rangeObjectUnderTest = new Range(0.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, rangeObjectUnderTest.getUpperBound());
	}

	// 3 //
	// Contains

	@Test
	public void testContainsTC1() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", rangeObjectUnderTest.contains(-100.1));
	}

	@Test
	public void testContainsTC2() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(-100));
	}

	@Test
	public void testContainsTC3() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(-99.9));
	}

	@Test
	public void testContainsTC4() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(0));
	}

	@Test
	public void testContainsTC5() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(99.9));
	}

	@Test
	public void testContainsTC6() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", rangeObjectUnderTest.contains(100));
	}

	@Test
	public void testContainsTC7() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", rangeObjectUnderTest.contains(100.1));
	}

	// 4 //
	// Intersects

	@Test
	public void testIntersectsTC1() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-200, -100.1));
	}

	@Test
	public void testIntersectsTC2() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-200, -100));
	}

	@Test
	public void testIntersectsTC3() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-200, -99.9));
	}

	@Test
	public void testIntersectsTC4() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(-50, 50));
	}

	@Test
	public void testIntersectsTC5() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(99.9, 200));
	}

	@Test
	public void testIntersectsTC6() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(100, 200));
	}

	@Test
	public void testIntersectsTC7() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(100.1, 200));
	}

	@Test
	public void testIntersectsTC8() {
		try {
			rangeObjectUnderTest = new Range(-100, 100);
			rangeObjectUnderTest.intersects(200, 100);
			fail("No exception thrown-Expected outcome was: a thrown exception");
		} catch (Exception e) {
			return;
		}
	}

	@Test
	public void testIntersectsTC9() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", rangeObjectUnderTest.intersects(50, 50));
	}
	
	
	// 5 //
	// Constrain
	
	@Test
	public void testConstrainTC1() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", rangeObjectUnderTest.constrain(-100.1), -100);
	}

	@Test
	public void testConstrainTC2() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", rangeObjectUnderTest.constrain(-100), -100.0);
	}

	@Test
	public void testConstrainTC3() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", rangeObjectUnderTest.constrain(-99.9), -99.9);
	}

	@Test
	public void testConstrainTC4() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", rangeObjectUnderTest.constrain(0.0), 0.0);
	}

	@Test
	public void testConstrainTC5() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", rangeObjectUnderTest.constrain(99.9), 99.9);
	}

	@Test
	public void testConstrainTC6() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", rangeObjectUnderTest.constrain(100), 100.0);
	}

	@Test
	public void testConstrainTC7() {
		rangeObjectUnderTest = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", rangeObjectUnderTest.constrain(100.1), 100);
	}
	

}