package com.ashok.in;

import java.util.Arrays;

public class example3 {
	public static void main(String[] args) {
		int a[] = { 1, 5, 9, 5, 4, 1, 2, 2 };
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] == a[j]) {
					System.out.println("Dulipcate numbers " + a[j]);
				}
			}
		}
	}

}
