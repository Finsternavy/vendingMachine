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
		this.servingSize = servingSize;
	}
	
	public Chips(Chips chips){
		this.name = chips.getName();
		this.price = chips.getPrice();
		this.servingSize = chips.servingSize;
	}
	
	public void setServingSize(int servingSize){
		this.servingSize = servingSize;
	}
	
	public int getServingSize(){
		return servingSize;
	}
	
	public Object clone(){
		return new Chips();
		
	}
	
	
	@Override
	public String toString() {
		return "\n" + name + ":\nPrice: $" + price + "0";
	}

	
}
