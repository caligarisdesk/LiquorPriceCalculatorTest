/**
 * 
 */
package com.example.liquorpricecalculator.test;

import com.example.liquorpricecalculator.EditNumber;

import android.test.AndroidTestCase;

/**
 * @author Jack
 *
 */
public class EditNumberTests extends AndroidTestCase {

	private EditNumber mEditNumber;

	/**
	 * @param name
	 */
	public EditNumberTests(String name) {
		setName(name);
	}
	public EditNumberTests() {
		setName("EditNumberTests");
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#setUp()
	 */
	protected void setUp() throws Exception {
		super.setUp();
		mEditNumber = new EditNumber(mContext);
		mEditNumber.setFocusable(true);
	}

	/* (non-Javadoc)
	 * @see android.test.AndroidTestCase#tearDown()
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link com.example.liquorpricecalculator.EditNumber#setNumber(double)}.
	 */
	public final void testSetNumber() {
		mEditNumber.setNumber(123.45);
		final String expected = "123.45";
		final String actual = mEditNumber.getText().toString();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.example.liquorpricecalculator.EditNumber#getNumber()}.
	 */
	public final void testGetNumber() {
		mEditNumber.setNumber(123.45);
		final double expected = 123.45;
		final double actual = mEditNumber.getNumber();
		assertEquals(expected, actual);
	}

	/**
	 * Test method for {@link com.example.liquorpricecalculator.EditNumber#clear()}.
	 */
	public final void testClear() {
		final String value = "123.45";
		mEditNumber.setText(value);
		mEditNumber.clear();
		String expected = "";
		String actual = mEditNumber.getText().toString();
		assertEquals(expected, actual);
	}

}
