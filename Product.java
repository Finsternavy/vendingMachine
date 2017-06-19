package vendingMachine;

public class Product {
	
	  String name = "New Product"; 
	  double price = 1.00; 
	  int currentStock = 0; 
	  static int maxStock = 20;
	   
	  public Product(){ 
	  } 
	   
	  public Product(String name, double price, int currentStock, int maxStock){ 
	    this.name = name; 
	    this.price = price; 
	    this.currentStock = currentStock; 
	    this.maxStock = maxStock; 
	    } 
	                  
	    public void setName(String name) { 
	    this.name = name; 
	    } 
	 
	    public String getName(){ 
	    return name;  
	    } 
	                  
	    public void setPrice(double price){ 
	    this.price = price;  
	    } 
	                  
	    public double getPrice(){ 
	    return price;  
	    } 
	                  
	    public void setCurrentStock(int currentStock) { 
	    this.currentStock = currentStock;  
	    } 
	                  
	    public int getCurrentStock(){ 
	    return currentStock;  
	    } 
	                  
	    public void setMaxStock(int maxStock){ 
	    this.maxStock = maxStock;  
	    } 
	     
	    public int getMaxStock(){ 
	    return maxStock;  
	    } 
	    
	    @Override
	    public String toString(){
	    	return name + " Price: $" + price;
	    }
	
}
