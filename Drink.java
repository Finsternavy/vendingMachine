package vendingMachine;

public class Drink extends Product implements Comparable<Product>{
	
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
	
	public static void main(String[] args){
		
		Drink Coke = new Drink("Coke", 1.00);
		Drink Coke2 = new Drink ("Coke", 1.25);
		Drink Pepsi = new Drink("Pepsi", 1.50);
		
		System.out.println("Compare to returns: " + Coke.compareTo(Pepsi));
		int result = Coke.compareTo(Pepsi);
		int resultPrice = Coke.compareTo(Coke2);
		
		if(result < 0)
			System.out.println(Coke.getName() + " comes before " + Pepsi.getName());
		else if(result > 0)
			System.out.println(Pepsi.getName() + " comes before " + Coke.getName());
		else
			System.out.println(Coke.getName() + " is equal to " + Pepsi.getName());
		
		System.out.println("Compare to returns: " + Coke.compareTo(Coke2));
		
		if(resultPrice < 0)
			System.out.println(Coke.getName() + " that costs " + Coke.getPrice() +" comes before " + Coke2.getName() +" that costs " + Coke2.getPrice());
		else if(resultPrice > 0)
			System.out.println(Coke2.getName() + " that costs " + Coke2.getPrice() + " comes before " + Coke.getName() + " that costs " + Coke.getPrice());
		else
			System.out.println(Coke.getName() + " that costs " + Coke.getPrice() + " is equal to " + Coke2.getName() + " that costs " + Coke2.getPrice());
		
	}
	  
}
