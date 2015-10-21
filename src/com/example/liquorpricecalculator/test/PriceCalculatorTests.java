/**
 * 
 */
package com.example.liquorpricecalculator.test;

import java.util.HashMap;

import com.example.liquorpricecalculator.PriceCalculator;

import junit.framework.TestCase;

/**
 * @author Jack
 *
 */
public class PriceCalculatorTests extends TestCase {

	private static final HashMap<Double, Double> conversionTable750 = new HashMap<Double, Double>();
	private static final HashMap<Double, Double> conversionTable375 = new HashMap<Double, Double>();
	private static final HashMap<Double, Double> conversionTable1750 = new HashMap<Double, Double>();
	
	
	static {
		conversionTable375.put(0.0,1.41);
		conversionTable750.put(0.0,2.83);
		conversionTable750.put(10.0,14.88);
		conversionTable1750.put(0.0,6.60);
	}
	/**
	 * @param name
	 */
	public PriceCalculatorTests(String name) {
		super(name);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.example.liquorpricecalculator.PriceCalculator#calcPrice(double, double)}.
	 */
	public final void testCalcPrice() {
		for(double c: conversionTable1750.keySet())
		{
			final double expected = conversionTable1750.get(c);
			final double actual = PriceCalculator.calcPrice(c, 1750.0);
			final String msg = HelperFunctions.generateFailMessage(expected, actual);
			assertTrue(msg, actual == expected);
		}
		for(double c: conversionTable750.keySet())
		{
			final double expected = conversionTable750.get(c);
			final double actual = PriceCalculator.calcPrice(c, 750.0);
			final String msg = HelperFunctions.generateFailMessage(expected, actual);
			assertTrue(msg, actual == expected);
		}
		for(double c: conversionTable375.keySet())
		{
			final double expected = conversionTable375.get(c);
			final double actual = PriceCalculator.calcPrice(c, 375.0);
			final String msg = HelperFunctions.generateFailMessage(expected, actual);
			assertTrue(msg, actual == expected);
		}
	}
}
