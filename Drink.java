package vendingMachine;

public class Drink extends Product implements Comparable<Drink> {
	
	String flavor; 
	  boolean isHot; 
	   
	  public Drink(){ 
	  } 
	   
	  public Drink(String name, double price, int currentStock, int maxStock, String flavor, boolean isHot){ 
	   super(); 
	    this.name = name; 
	    this.price = price; 
	    this.currentStock = currentStock; 
	    this.maxStock = maxStock; 
	    this.flavor = flavor; 
	    this.isHot = isHot; 
	  }
	  
	  public Drink(String name, double price){
		  this.name = name;
		  this.price = price;
	  }
	  
	  public Drink (Drink drink){
		  this.name = drink.getName();
		  this.price = drink.getPrice();
		  this.currentStock = drink.getCurrentStock();
		  this.maxStock = drink.getMaxStock();
		  this.flavor = drink.getFlavor();
		  this.isHot = drink.getIsHot();
	  }
	  
	  public void setFlavor(String flavor){
		  this.flavor = flavor;
	  }
	  
	  public String getFlavor(){
		  return flavor;
	  }
	  
	  public void setIsHot(boolean isHot){
		  this.isHot = isHot;
	  }
	  
	  public boolean getIsHot(){
		  return isHot;
	  }
	  
	  @Override
	  public int compareTo(Drink otherDrink) {
		  int nameDiff = name.compareToIgnoreCase(otherDrink.name);
		  if (nameDiff != 0) {
			  return nameDiff;
		  }	return (int) (price - otherDrink.price);

	  }
	  
	  @Override
	  public String toString(){
		  return "\n" + flavor + " " + name + "\nPrice: $" + price + "0 \nCurrent Stock: " + currentStock + "\nIs hot: " + isHot;
	  }

}
