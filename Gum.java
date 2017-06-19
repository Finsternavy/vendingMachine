package vendingMachine;

public class Gum extends Snack{
	
	int sticksInPackage = 1;
	
	public Gum(){
		super();
	}
	
	public Gum(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public Gum(String name, double price, int currentStock, int maxStock, int sticksInPackage){
		this.name = name;
		this.price = price;
		this.currentStock = currentStock;
		this.maxStock = maxStock;
		this.sticksInPackage = sticksInPackage;
	}
	

	public Gum(Gum gum){
		this.name = gum.getName();
		this.price = gum.getPrice();
		this.currentStock = gum.currentStock;
		this.maxStock = gum.maxStock;
		this.sticksInPackage = gum.sticksInPackage;
		
	}
	
	public void setSticksInPackage(int sticksInPackage){
		this.sticksInPackage = sticksInPackage;
	}
	
	public int getSticksInPackage(){
		return sticksInPackage;
	}
	
	@Override
	public String toString(){
		return "\n" + name + ":\nPrice: " + price;
	}
	
	
}
