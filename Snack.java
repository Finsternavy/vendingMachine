package vendingMachine;

public abstract class Snack extends Product implements Comparable<Product>{
	
    public Snack () {
        super();
    }
    
    public Snack(String name, double price){
    	super();
    	this.name = name;
    	this.price = price;
    }
    
    public Snack (String name, double price, int quantity, String location) {
    	super ();
    	this.name = name;
    	this.price = price;
    	this.quantity = quantity;
    	this.location = location;

    }
    
	@Override
	public String toString(){
		return name + " Price: $" + price + " Location: " + location;
	}
    
	@Override
	public int compareTo(Product other) {
		if(getName().compareToIgnoreCase(other.getName()) > 0){
			return 1;
		}else if(getName().compareToIgnoreCase(other.getName()) < 0){
			return -1;
		}else if(getPrice() > other.getPrice()){
			return 1;
		}else if(getPrice() < other.getPrice()){
			return -1;
		}else{
			return 0;
		}
	}
}
