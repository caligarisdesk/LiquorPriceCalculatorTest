package com.example.liquorpricecalculator.test;

public class HelperFunctions {
	public static String generateFailMessage(String expected, String actual)
	{
		final String msg = new StringBuilder("Expected:")
		.append(expected)
		.append(", Actual: ")
		.append(actual)				
		.toString();
		return msg;
	}
	public static String generateFailMessage(double expected, double actual)
	{
		return generateFailMessage(String.valueOf(expected), String.valueOf(actual));
	}
}
