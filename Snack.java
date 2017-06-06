package vendingMachine;

public abstract class Snack extends Product{
	
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

}
