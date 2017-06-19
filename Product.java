package vendingMachine;

public class Product implements Comparable<Product>{
	
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
