package vendingMachineGUIBoss;

import java.awt.GridLayout;
import java.util.Locale.Category;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


public class CategoryScrene extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		BorderPane pane = new BorderPane();
		
		HBox hbox = getHBox();
		pane.setCenter(hbox);
		pane.setMinSize(600.0, 500.0);
		pane.setTop(getTopGridPane());
		pane.setBottom(getCenterGridPane());
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Dispencer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane getTopGridPane() {
		GridPane topGrid = new GridPane();
		topGrid.setAlignment(Pos.TOP_CENTER);
		topGrid.setHgap(15);
		topGrid.setVgap(10);
		topGrid.setPadding(new Insets(10, 10, 10, 10));
		
		Text category = new Text("Categories");
		category.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		topGrid.add(category, 1, 0);
		
		/*ImageView imageDorito = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageDorito, 0, 0, 1, 2);
		ImageView imageLay = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageLay, 0, 5, 0, 5);
		ImageView imageSunChip = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageSunChip, 0, 10, 0, 10);
		ImageView imageMissVickie = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageMissVickie, 0, 15, 0, 15);
		grid.getChildren().addAll(imageDorito, imageLay, imageSunChip, imageMissVickie);*/
		
		return topGrid;
	}
	
	private GridPane getCenterGridPane() {
		GridPane centerGrid = new GridPane();
		centerGrid.setAlignment(Pos.TOP_CENTER);
		centerGrid.setHgap(15);
		centerGrid.setVgap(10);
		centerGrid.setPadding(new Insets(10, 10, 10, 10));
		
		return centerGrid;
	}

	private HBox getHBox() {
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15, 12, 15, 12));
		hBox.setStyle("-fx-background-color: black");
		
        Button drinkBtn = new Button("Drinks");
        drinkBtn.setMinSize(120.0, 50.0);
        Button chipsBtn = new Button("Chips");
        chipsBtn.setMinSize(120.0, 50.0);
        Button candyBtn = new Button("Candy");
        candyBtn.setMinSize(120.0, 50.0);
        Button gumBtn = new Button("Gum");
        gumBtn.setMinSize(120.0, 50.0);
        
        hBox.getChildren().addAll(drinkBtn, chipsBtn, candyBtn, gumBtn);
		
		return hBox;
	}
	
	public static void main(String[] args) {
        launch(args);
    }
	
}









