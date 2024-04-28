package com.ashok.in;

import java.util.Arrays;

public class example1 {
	public static void main(String[] args) {
		int [] a = {1,2,3};
		int [] b = {4,5,6};
		int [] c = new int[a.length +b.length];
		
		for(int i=0;i<a.length;i++) {
			c[i]=a[i];//123
		}
		for(int i=0;i<a.length;i++) {
			c[i + a.length]= b[i];//123456
		
		}
		System.out.println(Arrays.toString(c));
	}

}
