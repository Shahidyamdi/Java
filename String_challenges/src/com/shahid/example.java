package com.shahid;

public class example {
	public static void main(String[] args) {
		String str = "hello";

		char[] cs = str.toCharArray();
		for (int i = cs.length - 1; i >= 0; i--) {
			System.out.print(cs[i]);
		}
		System.out.println("");

		for (int i = str.length() - 1; i >= 0; i--) {
			System.out.print(str.charAt(i));
		}
		System.out.println("");

		StringBuffer buffer = new StringBuffer(str);
		System.out.print(buffer.reverse());
		System.out.println("");
		
		StringBuilder builder = new StringBuilder(str);
		System.out.print(builder.reverse());

	}

}
