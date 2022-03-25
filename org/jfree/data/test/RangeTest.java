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
	public void testGetLowerBoundTC1() {
		Range r1 = new Range(10.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 10.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC2() {
		Range r1 = new Range(-10.0, -10.0);
		assertEquals("getLowerBound: Did not return the expected output.", -10.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC3() {
		Range r1 = new Range(5.0, 10.0);
		assertEquals("getLowerBound: Did not return the expected output.", 5.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC4() {
		Range r1 = new Range(-4.0, -1.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC5() {
		Range r1 = new Range(-9.0, 14.0);
		assertEquals("getLowerBound: Did not return the expected output.", -9.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC6() {
		Range r1 = new Range(0.0, 7.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC7() {
		Range r1 = new Range(-4.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", -4.0, r1.getLowerBound());
	}

	@Test
	public void testGetLowerBoundTC8() {
		Range r1 = new Range(0.0, 0.0);
		assertEquals("getLowerBound: Did not return the expected output.", 0.0, r1.getLowerBound());
	}

	// 2 //
	// Get Upper Bound

	@Test
	public void testGetUpperBoundTC1() {
		Range r1 = new Range(10.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC2() {
		Range r1 = new Range(-10.0, -10.0);
		assertEquals("getUpperBound: Did not return the expected output.", -10.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC3() {
		Range r1 = new Range(5.0, 10.0);
		assertEquals("getUpperBound: Did not return the expected output.", 10.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC4() {
		Range r1 = new Range(-4.0, -1.0);
		assertEquals("getUpperBound: Did not return the expected output.", -1.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC5() {
		Range r1 = new Range(-9.0, 14.0);
		assertEquals("getUpperBound: Did not return the expected output.", 14.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC6() {
		Range r1 = new Range(0.0, 7.0);
		assertEquals("getUpperBound: Did not return the expected output.", 7.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC7() {
		Range r1 = new Range(-4.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, r1.getUpperBound());
	}

	@Test
	public void testGetUpperBoundTC8() {
		Range r1 = new Range(0.0, 0.0);
		assertEquals("getUpperBound: Did not return the expected output.", 0.0, r1.getUpperBound());
	}

	// 3 //
	// Contains

	@Test
	public void testContainsTC1() {
		Range r1 = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", r1.contains(-100.1));
	}

	@Test
	public void testContainsTC2() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(-100));
	}

	@Test
	public void testContainsTC3() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(-99.9));
	}

	@Test
	public void testContainsTC4() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(0));
	}

	@Test
	public void testContainsTC5() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(99.9));
	}

	@Test
	public void testContainsTC6() {
		Range r1 = new Range(-100, 100);
		assertTrue("contains: Did not return the expected output.", r1.contains(100));
	}

	@Test
	public void testContainsTC7() {
		Range r1 = new Range(-100, 100);
		assertFalse("contains: Did not return the expected output.", r1.contains(100.1));
	}

	// 4 //
	// Intersects

	@Test
	public void testIntersectsTC1() {
		Range r1 = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", r1.intersects(-200, -100.1));
	}

	@Test
	public void testIntersectsTC2() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(-200, -100));
	}

	@Test
	public void testIntersectsTC3() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(-200, -99.9));
	}

	@Test
	public void testIntersectsTC4() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(-50, 50));
	}

	@Test
	public void testIntersectsTC5() {
		Range r1 = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", r1.intersects(99.9, 200));
	}

	@Test
	public void testIntersectsTC6() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(100, 200));
	}

	@Test
	public void testIntersectsTC7() {
		Range r1 = new Range(-100, 100);
		assertFalse("intersects: Did not return the expected output.", r1.intersects(100.1, 200));
	}

	@Test
	public void testIntersectsTC8() {
		try {
			Range r1 = new Range(-100, 100);
			r1.intersects(200, 100);
			fail("No exception thrown-Expected outcome was: a thrown exception");
		} catch (Exception e) {
			return;
		}
	}

	@Test
	public void testIntersectsTC9() {
		Range r1 = new Range(-100, 100);
		assertTrue("intersects: Did not return the expected output.", r1.intersects(50, 50));
	}
	
	
	// 5 //
	// Constrain
	
	@Test
	public void testConstrainTC1() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(-100.1), -100);
	}

	@Test
	public void testConstrainTC2() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(-100), -100.0);
	}

	@Test
	public void testConstrainTC3() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(-99.9), -99.9);
	}

	@Test
	public void testConstrainTC4() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(0.0), 0.0);
	}

	@Test
	public void testConstrainTC5() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(99.9), 99.9);
	}

	@Test
	public void testConstrainTC6() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(100), 100.0);
	}

	@Test
	public void testConstrainTC7() {
		Range r1 = new Range(-100, 100);
		assertEquals("contains: Did not return the expected output.", r1.constrain(100.1), 100);
	}
	

}