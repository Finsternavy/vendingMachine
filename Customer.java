package vendingMachine;

public class Customer {
	
	String name;
	String purchase;
	double cash = 5.00;
	
	public Customer(){
		
	}
	
	public Customer(String name, String purchase){
		this.name = name;
		this.purchase = purchase;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public void setPurchase(String purchase){
		this.purchase = purchase;
	}
	
	public String getPurchase(){
		return purchase;
	}
	
	public void setCash(double cash){
		this.cash = cash;
	}
	
	public double getCash(){
		return cash;
	}
	
	public String toString(){
		return name + ", " + purchase;
	}

}
