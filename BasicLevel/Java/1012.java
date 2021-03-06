﻿import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] str = br.readLine().split(" ");
		br.close();

		int[] arr = new int[str.length - 1];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str[i+1]);
		}
		

		int sumOfA1 = 0, sumOfA2 = 0, cntOfA2 = 0, cntOfA3 = 0, sumOfA4 = 0, maxOfA5 = 0;
		double cntOfA4 = 0, averageOfA4 = 0;
		boolean isA1Null = true, isA3Null = true;
		String[] result = { "N", "N", "N", "N", "N", "N" };
		

		
		for (int i = 0; i < arr.length; i++) {
			int remain = arr[i] % 5;
			
			if (arr[i] % 10 == 0) {
				sumOfA1 += arr[i];
				isA1Null = false;
			} else if (remain == 1) {
				cntOfA2++;
				if (cntOfA2 % 2 == 1) {
					sumOfA2 += arr[i];
				} else {
					sumOfA2 -= arr[i];
				}
			} else if (remain == 2) {
				cntOfA3++;
				isA3Null = false;
			} else if (remain == 3) {
				sumOfA4 += arr[i];
				cntOfA4++;
			} else if (remain == 4) {
				if (arr[i] > maxOfA5) {
					maxOfA5 = arr[i];
				}
			}
		}
		// A1
		if (!isA1Null) {
			result[1] = String.valueOf(sumOfA1);
		}
		// A2
		if (cntOfA2 != 0) {
			result[2] = String.valueOf(sumOfA2);
		}
		// A3
		if (!isA3Null) {
			result[3] = String.valueOf(cntOfA3);
		}
		// A4
		if (sumOfA4 != 0) {
			averageOfA4 = sumOfA4 / cntOfA4;
			result[4] = String.format("%.1f", averageOfA4);
		}
		// A5
		if (maxOfA5 != 0) {
			result[5] = String.valueOf(maxOfA5);
		}

		String answer = "";
		for (int i = 1; i < result.length; i++) {
			answer += result[i] + " ";
		}
		System.out.println(answer.trim());
	}
}