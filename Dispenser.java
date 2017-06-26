/**
 * 
 */
package vendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Finst
 *
 */
public class Dispenser {

	public int slotMax = 20;
	public double total = 0;

	public static ArrayList<Product> snacks = new ArrayList<>();
	public static ArrayList<Product> drinks = new ArrayList<>();
	public static ArrayList<Product> products = new ArrayList<>();
	public static ArrayList<Product> chips = new ArrayList<>();
	public static ArrayList<Product> candy = new ArrayList<>();
	public static ArrayList<Product> gum = new ArrayList<>();
	public static ArrayList<Product> cart = new ArrayList<>();
	public static Bank myBank = new Bank(0.00, 0.00, 100.00, 0.00);

	public Dispenser() {
		this.createVendingMachine();
	}

	public Dispenser(int slotMax) {
		this.slotMax = slotMax;

	}

	public void setSlotMax(int slotMax) {
		this.slotMax = slotMax;
	}

	public int getSlotMax() {
		return slotMax;
	}
	

	// call dispense() of item to adjust currentStock and gets the price of
	// that item and adds the value to income. Adjusts credit value and change 
	// as needed and for display purposes.

	public void dispense(int numSelected) {
		cart.add(products.get(numSelected));
		double newTotal = total + products.get(numSelected).getPrice();
		total = newTotal;
	}

	public void restock(int numSelected){
		
	}
	
	public String displayProducts(){
		return products.toString();
		}
	
	public String displayCart(){
		return cart.toString();
	}

	
	public void createVendingMachine() {

		Snack lays = new Chips("Lays", 1.00);
		Snack sunChips = new Chips("Sun Chips", 1.00);
		Snack doritos = new Chips("Doritos", 1.00);
		Snack missVickies = new Chips("Miss Vickie's", 1.00);
		Snack skittles = new Candy("Skittles", 1.50);
		Snack snickers = new Candy("Snicker", 1.50);
		Snack starburst = new Candy("Starburst", 1.50);
		Snack mandM = new Gum("M&M's", 1.50);
		Snack bigRed = new Gum("Big Red", 1.00);
		Snack trident = new Gum("Trident", 1.00);
		Snack extra = new Gum("Extra", 1.00);
		Snack wrigleys = new Gum("Wrigleys", 1.00);
		chips.add(lays);
		chips.add(sunChips);
		chips.add(doritos);
		chips.add(missVickies);
		candy.add(skittles);
		candy.add(snickers);
		candy.add(starburst);
		candy.add(mandM);
		gum.add(bigRed);
		gum.add(trident);
		gum.add(extra);
		gum.add(wrigleys);
		products.add(lays);
		products.add(sunChips);
		products.add(doritos);
		products.add(missVickies);
		products.add(skittles);
		products.add(snickers);
		products.add(starburst);
		products.add(mandM);
		products.add(bigRed);
		products.add(trident);
		products.add(extra);
		products.add(wrigleys);

		
		Drink cocaCola = new Drink("Coca-Cola", 1.50);
		Drink sprite = new Drink("Sprite", 1.50);
		Drink minuteMain = new Drink("Minute Maid", 2.00);
		Drink dasani = new Drink("Dasani", 1.00);

		drinks.add(cocaCola);
		drinks.add(sprite);
		drinks.add(minuteMain);
		drinks.add(dasani);
		products.add(cocaCola);
		products.add(sprite);
		products.add(minuteMain);
		products.add(dasani);

	

	}

	public static void main(String [] args){
		Dispenser dispenser = new Dispenser();
		
		Collections.sort(products);

		System.out.println(dispenser.displayProducts());
	
	}
	
}
