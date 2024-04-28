package com.shahid;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializationExample {
	public int i;
	public String s;

	public DeserializationExample(int i, String s) {// default constructor

		this.i = i;
		this.s = s;
	}

	@Override
	public String toString() {
		return "DeserializationExample [i=" + i + ", s=" + s + "]";
	}

	public static void main(String[] args) {
		try {
		 // reading an object from a file
			ObjectInputStream is = new ObjectInputStream(new FileInputStream("Demofile.ser"));
			Object Demo = (Demo) is.readObject(); // deserialize object
			is.close(); // closes the ObjectInputStream
	 // closes the file
			System.out.println("Object deserialized ");
			System.out.println("number = " + Demo);
		} catch (IOException e) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException e) {
			System.out.println("ClassNotFoundException is caught");
		}
	}
}
