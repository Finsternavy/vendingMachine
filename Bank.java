package vendingMachine;

public class Bank {
	double income; 
	double change; 
	double changeAvailable; 
	double creditAvailable; 
	  
	  public Bank(double income, double change, double changeAvailable, double creditAvailable){
	    this.income = income;
	    this.change = change;
	    this.changeAvailable = changeAvailable;
	    this.creditAvailable = creditAvailable;
	  }
	   
	   
	  public void setIncome(double income){ 
	   this.income = income;  
	  } 
	   
	  public double getIncome(){ 
	   return income;  
	  } 
	   
	  public void setChange(double change){ 
	   this.change = change;  
	  } 
	   
	  public double getChange(){ 
	   return change;  
	  } 
	   
	  public void setChangeAvailable(double changeAvailable){ 
	   this.changeAvailable = changeAvailable;  
	  } 
	   
	  public double getChangeAvailable(){ 
	   return changeAvailable;  
	  } 
	   
	  public void setCredit(double creditAvailable){ 
	   this.creditAvailable = creditAvailable;  
	  } 
	 
	  public double getCredit(){ 
	   return creditAvailable;  
	 } 
}
