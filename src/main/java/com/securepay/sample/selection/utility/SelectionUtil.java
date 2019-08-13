package com.securepay.sample.selection.utility;

import java.util.Random;

public class SelectionUtil {

	public static int generateRandomIntegerWithinRange(int max, int min) {
		return new Random().nextInt((max - min) + 1) + min;
	}
}
