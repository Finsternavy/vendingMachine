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
				Chips lays = new Chips(Dispenser.laysStock.get(0).getName(), Dispenser.laysStock.get(0).getPrice());
				Dispenser.laysStock.add(lays);
				break;
			case SUNCHIPS:
				Chips sunChips = new Chips(Dispenser.sunChipsStock.get(0).getName(), Dispenser.sunChipsStock.get(0).getPrice());
				Dispenser.sunChipsStock.add(sunChips);
				break;
			case DORITOS:
				Chips doritos = new Chips(Dispenser.doritosStock.get(0).getName(), Dispenser.doritosStock.get(0).getPrice());
				Dispenser.doritosStock.add(doritos);
				break;
			case MISSVICKIES:
				Chips missVickies = new Chips(Dispenser.missVickiesStock.get(0).getName(), Dispenser.missVickiesStock.get(0).getPrice());
				Dispenser.missVickiesStock.add(missVickies);
				break;
			case SKITTLES:
				Candy skittles = new Candy(Dispenser.skittlesStock.get(0).getName(), Dispenser.skittlesStock.get(0).getPrice());
				Dispenser.skittlesStock.add(skittles);
				break;
			case SNICKERS:
				Candy snickers = new Candy(Dispenser.snickersStock.get(0).getName(), Dispenser.snickersStock.get(0).getPrice());
				Dispenser.snickersStock.add(snickers);
				break;
			case STARBURST:
				Candy starburst = new Candy(Dispenser.starburstStock.get(0).getName(), Dispenser.starburstStock.get(0).getPrice());
				Dispenser.starburstStock.add(starburst);
				break;
			case MANDM:
				Candy mandM = new Candy(Dispenser.mandMStock.get(0).getName(), Dispenser.mandMStock.get(0).getPrice());
				Dispenser.mandMStock.add(mandM);
				break;
			case BIGRED:
				Gum bigRed = new Gum(Dispenser.bigRedStock.get(0).getName(), Dispenser.bigRedStock.get(0).getPrice());
				Dispenser.bigRedStock.add(bigRed);
				break;
			case TRIDENT:
				Gum trident = new Gum(Dispenser.tridentStock.get(0).getName(), Dispenser.tridentStock.get(0).getPrice());
				Dispenser.tridentStock.add(trident);
				break;
			case EXTRA:
				Gum extra = new Gum(Dispenser.extraStock.get(0).getName(), Dispenser.extraStock.get(0).getPrice());
				Dispenser.extraStock.add(extra);
				break;
			case WRIGLEYS:
				Gum wrigleys = new Gum(Dispenser.wrigleysStock.get(0).getName(), Dispenser.wrigleysStock.get(0).getPrice());
				Dispenser.wrigleysStock.add(wrigleys);
				break;
			case COCACOLA:
				Drink cocaCola = new Drink(Dispenser.cocaColaStock.get(0).getName(), Dispenser.cocaColaStock.get(0).getPrice());
				Dispenser.cocaColaStock.add(cocaCola);
				break;
			case SPRITE:
				Drink sprite = new Drink(Dispenser.spriteStock.get(0).getName(), Dispenser.spriteStock.get(0).getPrice());
				Dispenser.spriteStock.add(sprite);
				break;
			case MINUTEMAID:
				Drink minuteMaid = new Drink(Dispenser.minuteMaidStock.get(0).getName(), Dispenser.minuteMaidStock.get(0).getPrice());
				Dispenser.minuteMaidStock.add(minuteMaid);
				break;
			case DASANI:
				Drink dasani = new Drink(Dispenser.dasaniStock.get(0).getName(), Dispenser.dasaniStock.get(0).getPrice());
				Dispenser.dasaniStock.add(dasani);
				break;
		}
	}
}
