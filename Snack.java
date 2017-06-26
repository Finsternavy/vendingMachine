package vendingMachine;

public abstract class Snack extends Product implements Comparable<Product>{
	
    public Snack () {
        super();
    }
    
    public Snack (String name, double price, int quantity, int maxQuantity) {
    	super ();
    	this.name = name;
    	this.price = price;

    }
    
	@Override
	public String toString(){
		return "\n" + name + ":\nPrice: " + price;
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
