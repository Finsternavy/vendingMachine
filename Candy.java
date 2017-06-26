package vendingMachine;

public class Candy extends Snack{
	
	boolean isSour = false;
	
	public Candy(){
		super();
	}
	
	public Candy(String name, double price){
		this.name = name;
		this.price = price;
	}

	public Candy(String name, double price, int currentStock, int maxStock, boolean isSour){
		super();
		this.name = name;
		this.price = price;
		this.isSour = isSour;
	}
	
	public Candy(Candy candy){
		this.name = candy.getName();
		this.price = candy.getPrice();
		this.isSour = candy.isSour;
	}
	
	public void setIsSour(boolean isSour){
		this.isSour = isSour;
	}
	
	public boolean getIsSour(){
		return isSour;
	}
	
	@Override
	public String toString() {
		return "\n" + name + ":\nPrice: $" + price;
	}
	
	
}
