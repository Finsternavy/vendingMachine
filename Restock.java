package vendingMachine;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import vendingMachine.Global_Inventory_Management;
import vendingMachine.Dispenser;

public class Restock {
	
	Global_Inventory_Management myGIM = new Global_Inventory_Management();
	String location;
	String name;
	int quantityToOrder;
	double costToOrder;

	public static void checkInventory(ArrayList<Product> arrayList, Dispenser dispenser){
		if(arrayList.size() <= 3){
			String location = dispenser.name;
			String name = arrayList.get(0).getName();
			String quantityToOrder = Integer.toString(dispenser.slotMax - arrayList.size());
			String costToOrder = Double.toString((arrayList.get(0).getPrice() / 2) * ((double)dispenser.slotMax - arrayList.size()));
			generatePurchaseOrder(location, name, quantityToOrder, costToOrder);
		}else
			return;
	}
	

	
	public static void generatePurchaseOrder(String location, String name, String quantityToOrder, String costToOrder){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Restocking List");
		window.setMinHeight(400);
		window.setMinWidth(400);
		
		Label purchaseOrderLabel = new Label("Purchase order:");
		GridPane.setConstraints(purchaseOrderLabel, 0, 0);
		Label machineName = new Label(" Location: " + location);
		GridPane.setConstraints(machineName, 0, 1);
		Label itemName = new Label("Item to order: " + name);
		GridPane.setConstraints(itemName, 0, 2);
		Label toOrder = new Label("Quantity to order: " + quantityToOrder);
		GridPane.setConstraints(toOrder, 0, 3);
		Label cost = new Label("Total cost: $" + costToOrder);
		GridPane.setConstraints(cost, 0, 4);
		
		Button closeButton = new Button("CLOSE WINDOW");
		GridPane.setConstraints(closeButton, 0, 6);
		closeButton.setOnAction(e -> window.close());
		
		GridPane layout = new GridPane();
		layout.getChildren().addAll(purchaseOrderLabel, machineName, itemName, toOrder, cost, closeButton);
		layout.setAlignment(Pos.CENTER);
		layout.setPadding(new Insets(10, 10, 10, 10));
		
		
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		window.showAndWait();
		
		
	}
	
}
