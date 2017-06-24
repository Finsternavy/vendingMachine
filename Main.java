package application;

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


public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		BorderPane pane = new BorderPane();
		
		HBox hbox = getHBox();
		pane.setBottom(hbox);
		
		pane.setTop(getGridPane());
		
		Scene scene = new Scene(pane);
		primaryStage.setTitle("Dispencer");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	private GridPane getGridPane() {
		// TODO Auto-generated method stub
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.TOP_CENTER);
		grid.setHgap(15);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		Text category = new Text("Categories");
		category.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
		grid.add(category, 1, 0);
		
		/*ImageView imageDorito = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageDorito, 0, 0, 1, 2);
		ImageView imageLay = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageLay, 0, 5, 0, 5);
		ImageView imageSunChip = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageSunChip, 0, 10, 0, 10);
		ImageView imageMissVickie = new ImageView(new Image("https://vignette3.wikia.nocookie.net/doritos/images/6/62/Doritos-nacho-cheese.gif/revision/latest?cb=20130727212532"));
		grid.add(imageMissVickie, 0, 15, 0, 15);
		grid.getChildren().addAll(imageDorito, imageLay, imageSunChip, imageMissVickie);*/
		
		return grid;
	}

	private HBox getHBox() {
		// TODO Auto-generated method stub
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15, 12, 15, 12));
		hBox.setStyle("-fx-background-color: black");
		
        Button drinkBtn = new Button("Drinks");
        Button chipsBtn = new Button("Chips");
        Button candyBtn = new Button("Candy");
        Button gumBtn = new Button("Gum");
        
        hBox.getChildren().addAll(drinkBtn, chipsBtn, candyBtn, gumBtn);
		
		return hBox;
	}
	
	public static void main(String[] args) {
        launch(args);
    }
	
}









