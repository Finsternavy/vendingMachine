/**
 * 
 */
package vendingMachine;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Finst
 *
 */
public class Dispenser {

	public int slotMax = 20;

	public static ArrayList<Product> snacks = new ArrayList<>();
	public static ArrayList<Product> drinks = new ArrayList<>();
	public static ArrayList<Product> products = new ArrayList<>();
	public static Bank myBank = new Bank(0.00, 0.00, 100.00, 0.00);

	public Dispenser() {
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
		double credit = myBank.getCreditAvailable();
		double price = snacks.get(numSelected).getPrice();
		int inStock = snacks.get(numSelected).getCurrentStock();
		// checks to make sure customer put in enough money
		if (credit >= price && inStock > 0) {
			// adjusts item stock levels
			snacks.get(numSelected).setCurrentStock(inStock - 1);
			// adjusts financial's
			myBank.setIncome(myBank.getIncome() + price);
			myBank.setChange(credit - price);
			myBank.setChangeAvailable(myBank.getChangeAvailable() - myBank.getChange());
			// if item out of stock
		} else if (credit >= price && inStock < 1) {
			System.out.println("Sorry! Sold out.");
			// if not enough credit
		} else {
			System.out.println("Not enough credit. Please add credit and try again.");
		}
	}

	public void restock(int numSelected){
		snacks.get(numSelected).setCurrentStock(getSlotMax());
	}
	
	public String displayProducts(){
		return products.toString();
		}

	
	public void createVendingMachine() {

		Snack bakedChips = new Chips("Baked Chips", 1.00, slotMax, slotMax, 2);
		Snack bbqChips = new Chips("BBQ Chips", 1.00, slotMax, slotMax, 2);
		Snack doritos = new Chips("Doritos", 1.00, slotMax, slotMax, 2);
		Snack skittles = new Candy("Skittles", 1.50, slotMax, slotMax, false);
		Snack snickers = new Candy("Snicker", 1.50, slotMax, slotMax, false);
		Snack mints = new Candy("Mints", 1.50, slotMax, slotMax, false);
		Snack juicyFruit = new Gum("Juicy Fruit", 0.50, slotMax, slotMax, 5);
		Snack spearmint = new Gum("Spearmint", 0.50, slotMax, slotMax, 5);
		Snack bigRed = new Gum("Big Red", 1.00, slotMax, slotMax, 15);
		snacks.add(bakedChips);
		snacks.add(bbqChips);
		snacks.add(doritos);
		snacks.add(skittles);
		snacks.add(snickers);
		snacks.add(mints);
		snacks.add(juicyFruit);
		snacks.add(spearmint);
		snacks.add(bigRed);
		products.add(bakedChips);
		products.add(bbqChips);
		products.add(doritos);
		products.add(skittles);
		products.add(snickers);
		products.add(mints);
		products.add(juicyFruit);
		products.add(spearmint);
		products.add(bigRed);
		
		Drink coffee = new Drink("Coffee", 2.00, slotMax, slotMax, "Vanilla", true);
		Drink water = new Drink("Water", 2.00, slotMax, slotMax, "Natural", false);
		Drink tea = new Drink("Tea", 2.00, slotMax, slotMax, "Lemon", true);
		Drink cola = new Drink("Cola", 2.00, slotMax, slotMax, "Root Beer", false);
		Drink monster = new Drink("Monster", 2.00, slotMax, slotMax, "Original", false);
		Drink redbull = new Drink("Redbull", 2.00, slotMax, slotMax, "Original", false);
		drinks.add(coffee);
		drinks.add(water);
		drinks.add(tea);
		drinks.add(cola);
		drinks.add(monster);
		drinks.add(redbull);
		products.add(coffee);
		products.add(water);
		products.add(tea);
		products.add(cola);
		products.add(monster);
		products.add(redbull);
	

	}

	public static void main(String [] args){
		Dispenser dispenser = new Dispenser();
		dispenser.createVendingMachine();
		System.out.println(dispenser.displayProducts());
	}
	
}
