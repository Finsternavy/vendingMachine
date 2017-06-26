package vendingMachine;

public class Drink extends Product implements Comparable<Product>{
	
	   
	  public Drink(){ 
	  } 
	   
	  public Drink(String name, double price){ 
	   super(); 
	    this.name = name; 
	    this.price = price; 
	  }
	  
	  
	  public Drink (Drink drink){
		  this.name = drink.getName();
		  this.price = drink.getPrice();
	  }
	  
	  
	  @Override
	  public String toString(){
		  return "\n" + name + "\nPrice: $" + price;
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
