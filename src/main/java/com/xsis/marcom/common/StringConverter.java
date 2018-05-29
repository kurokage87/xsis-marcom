package com.xsis.marcom.common;

public class StringConverter {
	public static String intToString(int num, int digits) {
	    String output = Integer.toString(num);
	    while (output.length() < digits) output = "0" + output;
	    return output;
	}
}
