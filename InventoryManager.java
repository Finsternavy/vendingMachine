package vendingMachine;

import java.util.ArrayList;

import vendingMachineGUIBoss.Welcome.CHOICE;

public class InventoryManager {
	

	
	
	public void reduceInventory(ArrayList<Product> arrayList){
		if(arrayList.size() != 0) {
			arrayList.remove(0);
		}
	}
	
	public void addOneToInventory(CHOICE choice){
		switch (choice){
			case LAYS:
				Chips lays = new Chips(Dispenser.products.get(0).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.laysStock.add(lays);
				break;
			case SUNCHIPS:
				Chips sunChips = new Chips(Dispenser.products.get(1).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.sunChipsStock.add(sunChips);
				break;
			case DORITOS:
				Chips doritos = new Chips(Dispenser.products.get(2).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.doritosStock.add(doritos);
				break;
			case MISSVICKIES:
				Chips missVickies = new Chips(Dispenser.products.get(3).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.missVickiesStock.add(missVickies);
				break;
			case SKITTLES:
				Candy skittles = new Candy(Dispenser.products.get(4).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.skittlesStock.add(skittles);
				break;
			case SNICKERS:
				Candy snickers = new Candy(Dispenser.products.get(5).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.snickersStock.add(snickers);
				break;
			case STARBURST:
				Candy starburst = new Candy(Dispenser.products.get(6).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.starburstStock.add(starburst);
				break;
			case MANDM:
				Candy mandM = new Candy(Dispenser.products.get(7).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.mandMStock.add(mandM);
				break;
			case BIGRED:
				Gum bigRed = new Gum(Dispenser.products.get(8).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.bigRedStock.add(bigRed);
				break;
			case TRIDENT:
				Gum trident = new Gum(Dispenser.products.get(9).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.tridentStock.add(trident);
				break;
			case EXTRA:
				Gum extra = new Gum(Dispenser.products.get(10).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.extraStock.add(extra);
				break;
			case WRIGLEYS:
				Gum wrigleys = new Gum(Dispenser.products.get(11).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.wrigleysStock.add(wrigleys);
				break;
			case COCACOLA:
				Drink cocaCola = new Drink(Dispenser.products.get(12).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.cocaColaStock.add(cocaCola);
				break;
			case SPRITE:
				Drink sprite = new Drink(Dispenser.products.get(13).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.spriteStock.add(sprite);
				break;
			case MINUTEMAID:
				Drink minuteMaid = new Drink(Dispenser.products.get(14).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.minuteMaidStock.add(minuteMaid);
				break;
			case DASANI:
				Drink dasani = new Drink(Dispenser.products.get(15).getName(), Dispenser.products.get(12).getPrice());
				Dispenser.dasaniStock.add(dasani);
				break;
		}
	}
	
	public void restock(CHOICE choice){
		
	}
}
