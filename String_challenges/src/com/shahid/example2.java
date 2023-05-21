package com.shahid;

public class example2 {
	public static void main(String[] args) {
		String s = "#ja&va!star";
		
		String all = s.replaceAll("[^a-zA-Z0-9]", "");
		System.out.println(all);
	}

}
