/**
 * 
 */
package vendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import vendingMachineGUIBoss.Welcome.CHOICE;

/**
 * @author Finst
 *
 */
public class Dispenser {

	public int slotMax = 0;
	public double total = 0;

	public InventoryManager myInventoryManager = new InventoryManager();
	public static ArrayList<Product> snacks = new ArrayList<>();
	public static ArrayList<Product> drinks = new ArrayList<>();
	public static ArrayList<Product> products = new ArrayList<>();
	public static ArrayList<Product> chips = new ArrayList<>();
	public static ArrayList<Product> candy = new ArrayList<>();
	public static ArrayList<Product> gum = new ArrayList<>();
	public static ArrayList<Product> sunChipsStock = new ArrayList<>();
	public static ArrayList<Product> doritosStock = new ArrayList<>();
	public static ArrayList<Product> missVickiesStock = new ArrayList<>();
	public static ArrayList<Product> laysStock = new ArrayList<>();
	public static ArrayList<Product> mandMStock = new ArrayList<>();
	public static ArrayList<Product> snickersStock = new ArrayList<>();
	public static ArrayList<Product> skittlesStock = new ArrayList<>();
	public static ArrayList<Product> starburstStock = new ArrayList<>();
	public static ArrayList<Product> tridentStock = new ArrayList<>();
	public static ArrayList<Product> bigRedStock = new ArrayList<>();
	public static ArrayList<Product> extraStock = new ArrayList<>();
	public static ArrayList<Product> wrigleysStock = new ArrayList<>();
	public static ArrayList<Product> cocaColaStock = new ArrayList<>();
	public static ArrayList<Product> spriteStock = new ArrayList<>();
	public static ArrayList<Product> minuteMaidStock = new ArrayList<>();
	public static ArrayList<Product> dasaniStock = new ArrayList<>();
	public static ArrayList<Product> cart = new ArrayList<>();
	public static Bank myBank = new Bank(0.00, 0.00, 100.00, 0.00);

	public Dispenser() {
		this.createVendingMachine();
	}

	public Dispenser(int slotMax) {
		this.slotMax = slotMax;
		this.createVendingMachine();

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

	public void dispense(int numSelected, ArrayList<Product> arrayList) {
		if(arrayList.size() != 0){
		cart.add((Product) arrayList.get(0));
		myInventoryManager.reduceInventory(arrayList);
		double newTotal = total + products.get(numSelected).getPrice();
		total = newTotal;
		} else {
			return;
		}
	}

	public void restock(ArrayList<Product> arrayList){
		int productsToAdd = slotMax - arrayList.size();
		for(int i = 0; i < productsToAdd; i++){
			String name = arrayList.get(0).getName();
			switch (name){
			case "Lays":
				myInventoryManager.addOneToInventory(CHOICE.LAYS);
				break;
			case "Doritos":
				myInventoryManager.addOneToInventory(CHOICE.DORITOS);
				break;
			case "Sun Chips":
				myInventoryManager.addOneToInventory(CHOICE.SUNCHIPS);
				break;
			case "Miss Vickie's":
				myInventoryManager.addOneToInventory(CHOICE.MISSVICKIES);
				break;
			case "Snickers":
				myInventoryManager.addOneToInventory(CHOICE.SNICKERS);
				break;
			case "Skittles":
				myInventoryManager.addOneToInventory(CHOICE.SKITTLES);
				break;
			case "M&M's":
				myInventoryManager.addOneToInventory(CHOICE.MANDM);
				break;
			case "Starburst":
				myInventoryManager.addOneToInventory(CHOICE.STARBURST);
				break;
			case "Trident":
				myInventoryManager.addOneToInventory(CHOICE.TRIDENT);
				break;
			case "Extra":
				myInventoryManager.addOneToInventory(CHOICE.EXTRA);
				break;
			case "Big Red":
				myInventoryManager.addOneToInventory(CHOICE.BIGRED);
				break;
			case "Wrigley's":
				myInventoryManager.addOneToInventory(CHOICE.WRIGLEYS);
				break;
			case "Coca-Cola":
				myInventoryManager.addOneToInventory(CHOICE.COCACOLA);
				break;
			case "Sprite":
				myInventoryManager.addOneToInventory(CHOICE.SPRITE);
				break;
			case "Dasani":
				myInventoryManager.addOneToInventory(CHOICE.DASANI);
				break;
			case "Minute Maid":
				myInventoryManager.addOneToInventory(CHOICE.MINUTEMAID);
				break;
				
			}
		}
	}
	
	public String displayProducts(){
		return products.toString();
		}
	
	public String displayCart(){
		return cart.toString();
	}

	
	public void createVendingMachine() {
		for(int i = 0; i < slotMax; i++){

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
		Snack wrigleys = new Gum("Wrigley's", 1.00);
		Drink cocaCola = new Drink("Coca-Cola", 1.50);
		Drink sprite = new Drink("Sprite", 1.50);
		Drink minuteMain = new Drink("Minute Maid", 2.00);
		Drink dasani = new Drink("Dasani", 1.00);
		
		laysStock.add(lays);
		sunChipsStock.add(sunChips);
		doritosStock.add(doritos);
		missVickiesStock.add(missVickies);
		skittlesStock.add(skittles);
		snickersStock.add(snickers);
		starburstStock.add(starburst);
		mandMStock.add(mandM);
		bigRedStock.add(bigRed);
		tridentStock.add(trident);
		extraStock.add(extra);
		wrigleysStock.add(wrigleys);
		cocaColaStock.add(cocaCola);
		spriteStock.add(sprite);
		minuteMaidStock.add(minuteMain);
		dasaniStock.add(dasani);
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
		snacks.add(lays);
		snacks.add(sunChips);
		snacks.add(doritos);
		snacks.add(missVickies);
		snacks.add(skittles);
		snacks.add(snickers);
		snacks.add(starburst);
		snacks.add(mandM);
		snacks.add(bigRed);
		snacks.add(trident);
		snacks.add(extra);
		snacks.add(wrigleys);
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
		drinks.add(cocaCola);
		drinks.add(sprite);
		drinks.add(minuteMain);
		drinks.add(dasani);
		products.add(cocaCola);
		products.add(sprite);
		products.add(minuteMain);
		products.add(dasani);

		}

	}

	public static void main(String [] args){
		Dispenser dispenser = new Dispenser(10);
		
		Collections.sort(products);

		System.out.println(dispenser.displayProducts());
	
	}
	
}
