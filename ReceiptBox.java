package vendingMachineGUIBoss;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ReceiptBox{

	public static void display(Label label){
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Receipt");
		window.setMinHeight(400);
		window.setMinWidth(400);
		
		Label receiptlable = new Label();
		receiptlable.setText(label.getText());
		
		Button closeButton = new Button("CLOSE WINDOW");
		closeButton.setOnAction(e -> {
		window.close();});
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label, closeButton);
		layout.setAlignment(Pos.CENTER);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		
		window.showAndWait();
		
		
	}

}
