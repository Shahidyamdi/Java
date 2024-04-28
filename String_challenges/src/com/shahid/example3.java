package com.shahid;

public class example3 {
	public static void main(String[] args) {
		String str = "    ja   va   s   t ar";
		
		
		String all = str.replaceAll("\\s", "");
		System.out.println(all);
	}

}
