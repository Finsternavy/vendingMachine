package vendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Global_Inventory_Management extends Product implements Comparable<Product>{
	
	
		
		static int i = 0;
		static Product[] readInProducts = new Product[16];
		static ArrayList<Product> allProducts = new ArrayList<Product>();
		static File InventoryFile = new File("C:\\Users\\Finst\\VendingMachine\\src\\vendingMachine\\Inventory.csv");
		static Scanner scanner = null;
		
		public static void readInFiles(File file){
		
		try{
			scanner = new Scanner(file);
			scanner.nextLine();
			while(scanner.hasNext()){
				String line = scanner.nextLine();
				String[] fields = line.split(",");
				if(fields[0].equals("Chips"))
					readInProducts[i] = new Chips(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), fields[4]);
				else if(fields[0].equals("Drink"))
					readInProducts[i] = new Drink(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), fields[4]);
				else if(fields[0].equals("Candy"))
					readInProducts[i] = new Candy(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), fields[4]);
				else if(fields[0].equals("Gum"))
					readInProducts[i] = new Gum(fields[1], Double.parseDouble(fields[2]), Integer.parseInt(fields[3]), fields[4]);
				allProducts.add(readInProducts[i]);
				i++;
				
			}
			
		}catch (FileNotFoundException e){
			System.out.println("File not found, argggggggggg");
		}
		
		Arrays.sort(readInProducts);
	}
		
		
		public static Object recursiveSearch(String target, int startingIndex){
			System.out.println("Printing stack trace: ");
			StackTraceElement[] elements = Thread.currentThread().getStackTrace();
			for (int i = 1; i < elements.length; i++){
				StackTraceElement s = elements[i];
				System.out.println("\tat " + s.getClassName() + "." + s.getMethodName() + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");}
			
			if(startingIndex > allProducts.size() -1)
				return -1;
			if(allProducts.get(startingIndex).getName().equals(target))
				return allProducts.get(startingIndex).getLocation() + " " + allProducts.get(startingIndex).getQuantity();
			else
				return recursiveSearch(target, startingIndex + 1);
				
		}
		
}
