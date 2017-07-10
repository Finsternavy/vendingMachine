package vendingMachine;

import java.util.ArrayList;
import java.util.stream.Stream;

public abstract class Product implements Comparable<Product>{
	
	  String name = "New Product"; 
	  double price = 1.00; 
	  int quantity = 1;
	  String location = "";
	   
	  public Product(){ 
	  } 
	  
	  public Product(String name, double price){
		  this.name = name;
		  this.price = price;
	  }
	   
	  public Product(String name, double price, double costToOrder, int quantity, String location){ 
	    this.name = name; 
	    this.price = price; 
	    this.quantity = quantity;
	    this.location = location;
	    
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
	    
	    public String getLocation(){
	    	return location;
	    }
	    
	    public void setQuantity(int quantity){
	    	this.quantity = quantity;
	    }
	    
	    public int getQuantity(){
	    	return quantity;
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
