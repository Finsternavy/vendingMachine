package vendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Global_Inventory_Management extends Product implements Comparable<Product>{
	
	public static void main(String[] args){
		String fileName = "Inventory.csv";
		File file = new File(fileName);
		try{
			Scanner inputStream = new Scanner(file);
			while (inputStream.hasNext()){
				String data = inputStream.next();
				System.out.println(data);
				}
			inputStream.close();
		
		} catch (FileNotFoundException e){
			e.printStackTrace();
		}
		
		
	}

}
