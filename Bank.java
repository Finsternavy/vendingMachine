package vendingMachine;

public class Bank {
	double income; 
	double change; 
	double changeAvailable; 
	double credit; 
	  
	  public Bank(double income, double change, double changeAvailable, double credit){
	    this.income = income;
	    this.change = change;
	    this.changeAvailable = changeAvailable;
	    this.credit = credit;
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
	   
	  public void setCredit(double credit){ 
	   this.credit = credit;  
	  } 
	 
	  public double getCredit(){ 
	   return credit;  
	 } 
}
