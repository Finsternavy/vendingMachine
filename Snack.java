package vendingMachine;

public class Snack extends Product implements Comparable<Snack>{
	
    public Snack () {
        super();
    }
    
    public Snack (String name, double price, int quantity, int maxQuantity) {
    	super ();
    	this.name = name;
    	this.price = price;
    	this.currentStock = quantity;
    	this.maxStock = maxQuantity;

    }

	@Override
	public int compareTo(Snack o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
