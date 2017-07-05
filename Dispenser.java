/**
 * 
 */
package vendingMachine;

import java.util.ArrayList;

/**
 * @author Finst
 *
 */
public class Dispenser {

	public String name = "";
	public int slotMax = 0;
	public double total = 0;

	public InventoryManager myInventoryManager = new InventoryManager();
	public ArrayList<Product> snacks = new ArrayList<>();
	public ArrayList<Product> drinks = new ArrayList<>();
	public ArrayList<Product> products = new ArrayList<>();
	public ArrayList<Product> chips = new ArrayList<>();
	public ArrayList<Product> candy = new ArrayList<>();
	public ArrayList<Product> gum = new ArrayList<>();
	public ArrayList<Product> sunChipsStock = new ArrayList<>();
	public ArrayList<Product> doritosStock = new ArrayList<>();
	public ArrayList<Product> missVickiesStock = new ArrayList<>();
	public ArrayList<Product> laysStock = new ArrayList<>();
	public ArrayList<Product> mandMStock = new ArrayList<>();
	public ArrayList<Product> snickersStock = new ArrayList<>();
	public ArrayList<Product> skittlesStock = new ArrayList<>();
	public ArrayList<Product> starburstStock = new ArrayList<>();
	public ArrayList<Product> tridentStock = new ArrayList<>();
	public ArrayList<Product> bigRedStock = new ArrayList<>();
	public ArrayList<Product> extraStock = new ArrayList<>();
	public ArrayList<Product> wrigleysStock = new ArrayList<>();
	public ArrayList<Product> cocaColaStock = new ArrayList<>();
	public ArrayList<Product> spriteStock = new ArrayList<>();
	public ArrayList<Product> minuteMaidStock = new ArrayList<>();
	public ArrayList<Product> dasaniStock = new ArrayList<>();
	public ArrayList<Product> cart = new ArrayList<>();
	public TransactionProcessing myBank = new TransactionProcessing(0.00, 0.00, 100.00, 0.00);

	public Dispenser() {
		this.createVendingMachine();
	}

	public Dispenser(String name, int slotMax) {
		this.name = name;
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
		myBank.setChange(myBank.getCreditAvailable() - products.get(numSelected).getPrice());
		myBank.setCreditAvailable(myBank.getChange());
		myBank.setIncome(myBank.getIncome() + products.get(numSelected).getPrice());
		} else {
			return;
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

		Snack lays = new Chips("Lays", 1.00, this.name);
		Snack sunChips = new Chips("Sun Chips", 1.00, this.name);
		Snack doritos = new Chips("Doritos", 1.00, this.name);
		Snack missVickies = new Chips("Miss Vickie's", 1.00, this.name);
		Snack skittles = new Candy("Skittles", 1.50, this.name);
		Snack snickers = new Candy("Snicker", 1.50, this.name);
		Snack starburst = new Candy("Starburst", 1.50, this.name);
		Snack mandM = new Gum("M&M's", 1.50, this.name);
		Snack bigRed = new Gum("Big Red", 1.00, this.name);
		Snack trident = new Gum("Trident", 1.00, this.name);
		Snack extra = new Gum("Extra", 1.00, this.name);
		Snack wrigleys = new Gum("Wrigley's", 1.00, this.name);
		Drink cocaCola = new Drink("Coca-Cola", 1.50, this.name);
		Drink sprite = new Drink("Sprite", 1.50, this.name);
		Drink minuteMain = new Drink("Minute Maid", 2.00, this.name);
		Drink dasani = new Drink("Dasani", 1.00, this.name);
		
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
	
	public static void main(String[] args){
		Dispenser myDispenser = new Dispenser("Vending101", 20);
		Dispenser yourDispenser = new Dispenser("Vending201", 20);
		
		System.out.println(myDispenser.laysStock.get(1).toString());
		System.out.println(yourDispenser.laysStock.get(1).toString());
	}
}
