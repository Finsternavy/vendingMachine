package vendingMachine;

public class Chips extends Snack{
	
	int servingSize = 1;
	
	public Chips(){
		super();
	}
	
	public Chips(String name, double price){
		this.name = name;
		this.price = price;
	}

	public Chips(String name, double price, int currentStock, int maxStock, int servingSize){
		super();
		this.name = name;
		this.price = price;
		this.currentStock = currentStock;
		this.maxStock = maxStock;
		this.servingSize = servingSize;
	}
	
	public Chips(Chips chips){
		this.name = chips.getName();
		this.price = chips.getPrice();
		this.currentStock = chips.getCurrentStock();
		this.maxStock = chips.getMaxStock();
		this.servingSize = chips.servingSize;
	}
	
	public void setServingSize(int servingSize){
		this.servingSize = servingSize;
	}
	
	public int getServingSize(){
		return servingSize;
	}
	
	
	@Override
	public String toString() {
		return "\n" + name + ":\nPrice: $" + price + "0\nIn Stock: " + currentStock + "\nServings per bag: " + servingSize;
	}

	
}
