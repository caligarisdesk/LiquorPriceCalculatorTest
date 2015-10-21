package com.example.liquorpricecalculator.test;
import com.example.liquorpricecalculator.EditNumber;
import com.example.liquorpricecalculator.MainActivity;
import android.test.ActivityInstrumentationTestCase2;
import android.test.UiThreadTest;
import android.test.suitebuilder.annotation.LargeTest;
import static android.test.ViewAsserts.*;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;

public class LiquorPriceCalculatorTests extends
		ActivityInstrumentationTestCase2<MainActivity> {

	private MainActivity mActivity;
	private EditNumber mBasePrice;
	private EditNumber mBottleSize;
	private TextView mBasePriceLabel;
	private TextView mBottleSizeLabel;
	private TextView mFinalPrice;

	public LiquorPriceCalculatorTests() {
		this("LiquorPriceCalculatorTests");
	}
	public LiquorPriceCalculatorTests(String name) {
		super(MainActivity.class);
		setName(name);
	}
	protected void setUp() throws Exception {
		super.setUp();
		mActivity = getActivity();
		mBasePrice = (EditNumber)
				mActivity.findViewById(com.example.liquorpricecalculator.R.id.baseprice);
		mBottleSize = (EditNumber)
				mActivity.findViewById(com.example.liquorpricecalculator.R.id.bottlesize);
		mBasePriceLabel = (TextView)
				mActivity.findViewById(com.example.liquorpricecalculator.R.id.baseprice_label);
		mBottleSizeLabel = (TextView)
				mActivity.findViewById(com.example.liquorpricecalculator.R.id.bottlesize_label);
		mFinalPrice = (TextView)
				mActivity.findViewById(com.example.liquorpricecalculator.R.id.price);
	}
	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public final void testPreconditions() {
		assertNotNull(mActivity);
	}
	public final void testHasInputFields() {
		assertNotNull(mBasePrice);
		assertNotNull(mBottleSize);
	}
	public final void testFieldsShouldStartEmpty()
	{
		assertEquals("", mBasePrice.getText().toString());
		assertEquals("", mBottleSize.getText().toString());	
	}
	public final void testFieldsOnScreen()
	{
		final Window window = mActivity.getWindow();
		final View origin = window.getDecorView();
		assertOnScreen(origin, mBasePrice);
		assertOnScreen(origin, mBottleSize);
	}
	public final void testAlignment()
	{
		assertRightAligned(mBottleSize, mBasePrice);
		assertLeftAligned(mBottleSize, mBasePrice);
		assertLeftAligned(mBasePrice, mBasePriceLabel);
		assertLeftAligned(mBottleSize, mBottleSizeLabel);
	}
	public final void testBasePriceInputFieldCoverEntireScreen()
	{
		final int expected = LayoutParams.MATCH_PARENT;
		final LayoutParams lp = mBasePrice.getLayoutParams();
		assertEquals("mBasePrice layout width is not MATCH_PARENT", expected, lp.width);
	}
	public final void testBottleSizeInputFieldCoverEntireScreen()
	{
		final int expected = LayoutParams.MATCH_PARENT;
		final LayoutParams lp = mBottleSize.getLayoutParams();
		assertEquals("mBottleSize layout width is not MATCH_PARENT", expected, lp.width);
	}
	public final void testFontSizes()
	{
		final float expected = 24.0f;
		assertEquals(expected, mBasePriceLabel.getTextSize());
		assertEquals(expected, mBottleSizeLabel.getTextSize());
	}
	public final void testMargins()
	{
		LinearLayout.LayoutParams lp;
		final int expected = 6;
		lp = (LinearLayout.LayoutParams) mBasePrice.getLayoutParams();
		assertEquals(expected, lp.leftMargin);
		assertEquals(expected, lp.rightMargin);
		lp = (LinearLayout.LayoutParams) mBottleSize.getLayoutParams();
		assertEquals(expected, lp.leftMargin);
		assertEquals(expected, lp.rightMargin);
	}
	public final void testJustification()
	{
		final int expected = Gravity.RIGHT|Gravity.CENTER_VERTICAL;
		int actual = mBasePrice.getGravity();
		assertEquals(String.format("Expected 0x0%02x but was 0x0%02x",
				expected, actual), expected, actual);
		actual = mBottleSize.getGravity();
		assertEquals(String.format("Expected 0x0%02x but was 0x0%02x",
				expected, actual), expected, actual);
	}
	public final void testVirtualKeyboardSpaceReserved()
	{
		final int expected = 280;
		final int actual = mBottleSize.getBottom();
		assertTrue(actual <= expected);
	}
	
	@UiThreadTest
	@LargeTest
	public final void testPriceCalculation()
	{
		// arrange
		mBasePrice.clear();
		mBottleSize.clear();
		final double base = 10;
		final double bottle = 750;
		final double expected = 14.88;
		
		// act
		mBasePrice.requestFocus();
		mBasePrice.setNumber(base);
		mBottleSize.requestFocus();
		mBottleSize.setNumber(bottle);
		final double actualPrice = Double.parseDouble(mFinalPrice.getText().toString());
		
		final double delta = expected - actualPrice;
		final String msg = new StringBuilder("Expected:")
			.append(expected)
			.append(", Actual: ")
			.append(actualPrice)				
			.toString();

		//assert
		assertTrue(msg, delta == 0);
	}
	
	public final void testFails()
	{
		assertFalse(true);
	}
}
