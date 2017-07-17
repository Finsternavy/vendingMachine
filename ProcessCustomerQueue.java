package vendingMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import javafx.stage.Stage;
import java.util.Queue;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import vendingMachineGUIBoss.Animation;
import vendingMachineGUIBoss.ReceiptBox;
import java.lang.Object;
import vendingMachine.CHOICE;

//Read the lost of customers from a text file into a queue structure
//Implement the complete queue functionality as individual methods: first(), length(), in(), out(), isEmpty()

public class ProcessCustomerQueue{

	static int i = 0;
	Customer[] readInCustomers = new Customer[30];
	Queue<Customer> allCustomers = new ArrayDeque<Customer>();
	File CustomerQueue = new File("C:\\Users\\Finst\\VendingMachine\\src\\vendingMachine\\customerQueue.csv");
	Scanner scanner = null;
	Dispenser dispenser = new Dispenser("Vend-O-Matic 6000!", 20);
	StringBuilder sb = new StringBuilder();
	
	public void readInFiles(File file){
	
	try{
		scanner = new Scanner(file);
		while(scanner.hasNext()){
			String line = scanner.nextLine();
			String[] fields = line.split(",");
			readInCustomers[i] = new Customer(fields[0], (fields[1]));
			allCustomers.add(readInCustomers[i]);
			i++;
			
		}
		
	}catch (FileNotFoundException e){
		System.out.println("File not found, argggggggggg");
	}

}
	public void selectRandomProduct(){
		
	}
	
	public void attemptSale(String name, String purchase, Dispenser dispenser){
		
		name = allCustomers.peek().name;
		purchase = allCustomers.peek().purchase;
		
			switch(purchase){
				//dispenser method already checks if the product is available
				case "Lays": 
					dispenser.dispense(0, dispenser.laysStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(0).getPrice() + "0\n\n");
					break;
					
				case "Sun Chips":
					dispenser.dispense(1,  dispenser.sunChipsStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(1).getPrice() + "0\n\n");
					break;
					
				case "Doritos":
					dispenser.dispense(2,  dispenser.doritosStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(2).getPrice() + "0\n\n");
					break;
					
				case "Miss Vickie's":
					dispenser.dispense(3,  dispenser.missVickiesStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(3).getPrice() + "0\n\n");
					break;
					
				case "Skittles":
					dispenser.dispense(4,  dispenser.skittlesStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(4).getPrice() + "0\n\n");
					break;
					
				case "Snickers":
					dispenser.dispense(5,  dispenser.snickersStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(5).getPrice() + "0\n\n");
					break;
					
				case "Starburst":
					dispenser.dispense(6,  dispenser.starburstStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(6).getPrice() + "0\n\n");
					break;
					
				case "M&M's":
					dispenser.dispense(7,  dispenser.mandMStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(7).getPrice() + "0\n\n");
					break;
					
				case "Big Red":
					dispenser.dispense(8,  dispenser.bigRedStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(8).getPrice() + "0\n\n");
					break;
					
				case "Trident":
					dispenser.dispense(9,  dispenser.tridentStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(9).getPrice() + "0\n\n");
					break;
					
				case "Extra":
					dispenser.dispense(10,  dispenser.extraStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(10).getPrice() + "0\n\n");
					break;
					
				case "Wrigley's":
					dispenser.dispense(11,  dispenser.wrigleysStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(11).getPrice() + "0\n\n");
					break;
					
				case "Coca-Cola":
					dispenser.dispense(12,  dispenser.cocaColaStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(12).getPrice() + "0\n\n");
					break;
					
				case "Sprite":
					dispenser.dispense(13,  dispenser.spriteStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(13).getPrice() + "0\n\n");
					break;
					
				case "Minute Maid":
					dispenser.dispense(14,  dispenser.minuteMaidStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(14).getPrice() + "0\n\n");
					break;
					
				case "Dasani":
					dispenser.dispense(15,  dispenser.dasaniStock, dispenser);
					sb.append(name + " bought " + purchase + "\nTotal: $" + dispenser.products.get(15).getPrice() + "0\n\n");
					break;
					
				default:
					return;
			}
			out();
			String sbToString = sb.toString();
			

	}
	
	public void getRandomProduct(){
		int random = (int)Math.random() * 30;
		attemptSale(dispenser.products.get(random).getName(), dispenser.products.get(random).getName(), dispenser);
	}
	
	public String first(){
		return allCustomers.peek().toString();
	}
	
	public String length(){
		return "Length of Queue: " + allCustomers.size();
	}
	
	public String in(Customer itemToAdd){
		allCustomers.offer(itemToAdd);
		return "Adding to Queue: " + itemToAdd.toString();
	}
	
	public String out(){
		return "Remove from Queue: " + allCustomers.remove();
	}
	
	public String isEmpty(){
		return "Queue is empty";
	}
	
}
	
	
	