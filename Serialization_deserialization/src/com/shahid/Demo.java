package com.shahid;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Demo implements Serializable{
	public int i;   
	public String s;   
	public Demo(int i, String s) //default constructor  
	{   
	this.i = i;   
	this.s = s;   
	}
	public static void main(String[] args) {
		
		Demo object = new Demo(8, "javatpoint");   
		String filename = "Demofile.ser";       //specified file name (must have extension .ser)  
		/*-----------------Serialization----------*/  
		try  
		{      
		FileOutputStream file = new FileOutputStream(filename);  //Saving of object in the file   
		ObjectOutputStream out = new ObjectOutputStream(file);     
		out.writeObject(object);            //serialize object  
		out.close();                    //closes the ObjectOutputStream  
		file.close();                   //closes the file  
		System.out.println("Object serialized");   
		}   
		catch(IOException e)   
		{   
		e.printStackTrace();  
		}   
		Demo obj = null;   
	}

}
