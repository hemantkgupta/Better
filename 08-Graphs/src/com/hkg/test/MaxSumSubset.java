package com.hkg.test;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class MaxSumSubset {

	static ArrayList<Integer> input = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Pattern pattern = Pattern.compile(System.getProperty("line.separator")
				+ "|\\s");
		scanner.useDelimiter(pattern);

		int intval, tempMax = 0;

		while (scanner.hasNextInt()) {
			intval = scanner.nextInt();
			input.add(intval);
		}

		int[] vals = new int[input.size()];

		if (vals.length > 1) {
			vals[0] = input.get(0);
			vals[1] = Math.max(input.get(0), input.get(1));

			for (int i = 2; i < input.size(); i++) {

				tempMax = Math.max(vals[i - 2], vals[i - 2] + input.get(i));

				vals[i] = Math.max(tempMax, input.get(i));
				if (i - 3 >= 0) {

					int tempMax2 = Math.max(vals[i - 3],
							vals[i - 3] + input.get(i));
					vals[i] = Math.max(tempMax2, vals[i]);
				}
			}
		}
		tempMax = -99999999;
		for (int i = 0; i < vals.length; i++) {
			if (vals[i] > tempMax) {
				tempMax = vals[i];
			}
		}
		System.out.println("Maximum sum=" + tempMax);
	}
}