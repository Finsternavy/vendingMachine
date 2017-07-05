package vendingMachine;

import java.util.ArrayList;

import vendingMachineGUIBoss.Welcome.CHOICE;

public class InventoryManager {
	

	
	
	public void reduceInventory(ArrayList<Product> arrayList){
		if(arrayList.size() != 0) {
			arrayList.remove(0);
		}
	}
	
	public void addOneToInventory(CHOICE choice, Dispenser dispenser){
		switch (choice){
			case LAYS:
				Chips lays = new Chips(dispenser.products.get(0).getName(), dispenser.products.get(0).getPrice());
				dispenser.laysStock.add(lays);
				break;
			case SUNCHIPS:
				Chips sunChips = new Chips(dispenser.products.get(1).getName(), dispenser.products.get(1).getPrice());
				dispenser.sunChipsStock.add(sunChips);
				break;
			case DORITOS:
				Chips doritos = new Chips(dispenser.products.get(2).getName(), dispenser.products.get(2).getPrice());
				dispenser.doritosStock.add(doritos);
				break;
			case MISSVICKIES:
				Chips missVickies = new Chips(dispenser.products.get(3).getName(), dispenser.products.get(3).getPrice());
				dispenser.missVickiesStock.add(missVickies);
				break;
			case SKITTLES:
				Candy skittles = new Candy(dispenser.products.get(4).getName(), dispenser.products.get(4).getPrice());
				dispenser.skittlesStock.add(skittles);
				break;
			case SNICKERS:
				Candy snickers = new Candy(dispenser.products.get(5).getName(), dispenser.products.get(5).getPrice());
				dispenser.snickersStock.add(snickers);
				break;
			case STARBURST:
				Candy starburst = new Candy(dispenser.products.get(6).getName(), dispenser.products.get(6).getPrice());
				dispenser.starburstStock.add(starburst);
				break;
			case MANDM:
				Candy mandM = new Candy(dispenser.products.get(7).getName(), dispenser.products.get(7).getPrice());
				dispenser.mandMStock.add(mandM);
				break;
			case BIGRED:
				Gum bigRed = new Gum(dispenser.products.get(8).getName(), dispenser.products.get(8).getPrice());
				dispenser.bigRedStock.add(bigRed);
				break;
			case TRIDENT:
				Gum trident = new Gum(dispenser.products.get(9).getName(), dispenser.products.get(9).getPrice());
				dispenser.tridentStock.add(trident);
				break;
			case EXTRA:
				Gum extra = new Gum(dispenser.products.get(10).getName(), dispenser.products.get(10).getPrice());
				dispenser.extraStock.add(extra);
				break;
			case WRIGLEYS:
				Gum wrigleys = new Gum(dispenser.products.get(11).getName(), dispenser.products.get(11).getPrice());
				dispenser.wrigleysStock.add(wrigleys);
				break;
			case COCACOLA:
				Drink cocaCola = new Drink(dispenser.products.get(12).getName(), dispenser.products.get(12).getPrice());
				dispenser.cocaColaStock.add(cocaCola);
				break;
			case SPRITE:
				Drink sprite = new Drink(dispenser.products.get(13).getName(), dispenser.products.get(13).getPrice());
				dispenser.spriteStock.add(sprite);
				break;
			case MINUTEMAID:
				Drink minuteMaid = new Drink(dispenser.products.get(14).getName(), dispenser.products.get(14).getPrice());
				dispenser.minuteMaidStock.add(minuteMaid);
				break;
			case DASANI:
				Drink dasani = new Drink(dispenser.products.get(15).getName(), dispenser.products.get(15).getPrice());
				dispenser.dasaniStock.add(dasani);
				break;
		}
	}
	
	public void restock(ArrayList<Product> arrayList, Dispenser dispenser){
		int productsToAdd = dispenser.slotMax - arrayList.size();
		for(int i = 0; i < productsToAdd; i++){
			String name = arrayList.get(0).getName();
			switch (name){
			case "Lays":
				this.addOneToInventory(CHOICE.LAYS, dispenser);
				break;
			case "Doritos":
				this.addOneToInventory(CHOICE.DORITOS, dispenser);
				break;
			case "Sun Chips":
				this.addOneToInventory(CHOICE.SUNCHIPS, dispenser);
				break;
			case "Miss Vickie's":
				this.addOneToInventory(CHOICE.MISSVICKIES, dispenser);
				break;
			case "Snickers":
				this.addOneToInventory(CHOICE.SNICKERS, dispenser);
				break;
			case "Skittles":
				this.addOneToInventory(CHOICE.SKITTLES, dispenser);
				break;
			case "M&M's":
				this.addOneToInventory(CHOICE.MANDM, dispenser);
				break;
			case "Starburst":
				this.addOneToInventory(CHOICE.STARBURST, dispenser);
				break;
			case "Trident":
				this.addOneToInventory(CHOICE.TRIDENT, dispenser);
				break;
			case "Extra":
				this.addOneToInventory(CHOICE.EXTRA, dispenser);
				break;
			case "Big Red":
				this.addOneToInventory(CHOICE.BIGRED, dispenser);
				break;
			case "Wrigley's":
				this.addOneToInventory(CHOICE.WRIGLEYS, dispenser);
				break;
			case "Coca-Cola":
				this.addOneToInventory(CHOICE.COCACOLA, dispenser);
				break;
			case "Sprite":
				this.addOneToInventory(CHOICE.SPRITE, dispenser);
				break;
			case "Dasani":
				this.addOneToInventory(CHOICE.DASANI, dispenser);
				break;
			case "Minute Maid":
				this.addOneToInventory(CHOICE.MINUTEMAID, dispenser);
				break;
				
			}
		}
	}
}
