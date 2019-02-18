package com.softserve.edu.opencart.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class AccidentalUtils {
	private static final long MAX_REMAINDER = 10000L;
	private static final int MIN_CHARACTER = 97;
	private static final int MAX_CHARACTER = 122;
	private static final int MAX_USERNAME = 7;
	private static final int MAX_EMAIL = 10;
	private static final String EMAIL_POSTFIX = "@gmail.com";
	//
	private static long initialNumber = 0; 

	private AccidentalUtils() {
	}

	public static List<Integer> randomInt(int count, int minNumber, int maxNumber) {
		List<Integer> result = new ArrayList<>();
		initialNumber = initialNumber + 1;
		Random random = new Random(System.currentTimeMillis() % MAX_REMAINDER + initialNumber);
		for (int i = 0; i < count; i++) {
			result.add(random.nextInt((maxNumber - minNumber) + 1) + minNumber);
		}
		//System.out.println("result = " + result);
		return result;
	}

	public static List<String> randomChar(int count) {
		List<String> result = new ArrayList<>();
		for (Integer current : randomInt(count, MIN_CHARACTER, MAX_CHARACTER)) {
			result.add(String.valueOf((char) current.intValue()));
		}
		//System.out.println("result = " + result);
		return result;
	}

	public static String randomString(int count) {
		String result = "";
		for (String current : randomChar(count)) {
			result = result + current;
		}
		return result;
	}

	public static String randomUsername() {
		return randomString(MAX_USERNAME);
	}

	public static String randomEmail() {
		return randomString(MAX_EMAIL) + EMAIL_POSTFIX;
	}
}
