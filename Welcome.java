package vendingMachineGUIBoss;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import vendingMachine.Dispenser;
import vendingMachine.Product;

public class Welcome extends Application {
	
	Button drinksButton;
	Button chipsButton;
	Button candyButton;
	Button gumButton;
	Button cocaColaButton;
	Button spriteButton;
	Button minuteMaidButton;
	Button dasaniButton;
	Button doritosButton;
	Button laysButton;
	Button sunChipsButton;
	Button missVickiesButton;
	Button starburstButton;
	Button skittlesButton;
	Button snickersButton;
	Button mandMButton;
	Button tridentButton;
	Button extraButton;
	Button wrigleysButton;
	Button bigRedButton;
	Button drinksBackButton;
	Button chipsBackButton;
	Button candyBackButton;
	Button gumBackButton;
	Button backButton;
	Button done;
	GridPane layout;
	Stage window;
	Scene drinks, chips, candy, gum, home, receipt;
	public static ArrayList<Product> cart = new ArrayList<>();
	
	Dispenser dispenser = new Dispenser();
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		primaryStage.setTitle("Title of the Window");
		
		drinksButton = new Button("DRINKS");
		GridPane.setConstraints(drinksButton, 1, 1);
		drinksButton.setMinSize(250.0, 50.0);
		drinksButton.setOnAction(e -> window.setScene(drinks));
		
			cocaColaButton = new Button("$1.50");
			Image cocaColaImage = new Image(getClass().getResourceAsStream("coke.png"));
			ImageView cocaColaView = new ImageView(cocaColaImage);
			cocaColaView.setFitHeight(200);
			cocaColaView.setFitWidth(150);
			cocaColaButton.setGraphic(cocaColaView);
			GridPane.setConstraints(cocaColaButton, 1, 1);
			cocaColaButton.setMinSize(250.0, 50.0);
			cocaColaButton.setOnAction(e -> {
				dispenser.dispense(12);
				window.setScene(home);});
			
			
			spriteButton = new Button("$1.50");
			Image spriteImage = new Image(getClass().getResourceAsStream("sprite.png"));
			ImageView spriteView = new ImageView(spriteImage);
			spriteView.setFitHeight(200);
			spriteView.setFitWidth(150);
			spriteButton.setGraphic(spriteView);
			GridPane.setConstraints(spriteButton, 1, 2);
			spriteButton.setMinSize(250.0, 50.0);
			spriteButton.setOnAction(e -> {
				dispenser.dispense(13);
				window.setScene(home);});
			
			minuteMaidButton = new Button("$2.00");
			Image minuteMaidImage = new Image(getClass().getResourceAsStream("minutemaid.png"));
			ImageView minuteMaidView = new ImageView(minuteMaidImage);
			minuteMaidView.setFitHeight(200);
			minuteMaidView.setFitWidth(150);
			minuteMaidButton.setGraphic(minuteMaidView);
			GridPane.setConstraints(minuteMaidButton, 2, 1);
			minuteMaidButton.setMinSize(250.0, 50.0);
			minuteMaidButton.setOnAction(e -> {
				dispenser.dispense(14);
				window.setScene(home);});
			
			dasaniButton = new Button ("$1.00");
			Image dasaniImage = new Image(getClass().getResourceAsStream("dasani.png"));
			ImageView dasaniView = new ImageView(dasaniImage);
			dasaniView.setFitHeight(200);
			dasaniView.setFitWidth(150);
			dasaniButton.setGraphic(dasaniView);
			GridPane.setConstraints(dasaniButton, 2, 2);
			dasaniButton.setMinSize(250.0, 50.0);
			dasaniButton.setOnAction(e -> {
				dispenser.dispense(15);
				window.setScene(home);});
		
		chipsButton = new Button("CHIPS");
		GridPane.setConstraints(chipsButton, 2, 1);
		chipsButton.setMinSize(250.0, 50.0);
		chipsButton.setOnAction(e -> window.setScene(chips));
		
			doritosButton = new Button("$1.00");
			Image doritosImage = new Image(getClass().getResourceAsStream("Doritos-nacho-cheese.png"));
			ImageView doritosView = new ImageView(doritosImage);
			doritosView.setFitHeight(200);
			doritosView.setFitWidth(150);
			doritosButton.setGraphic(doritosView);
			GridPane.setConstraints(doritosButton, 1, 1);
			doritosButton.setMinSize(250.0, 50.0);
			doritosButton.setOnAction(e -> {
				dispenser.dispense(2);
				window.setScene(home);});
			
			laysButton = new Button("$1.00");
			Image laysImage = new Image(getClass().getResourceAsStream("Lays_Chips.png"));
			ImageView laysView = new ImageView(laysImage);
			laysView.setFitHeight(200);
			laysView.setFitWidth(150);
			laysButton.setGraphic(laysView);
			GridPane.setConstraints(laysButton, 1, 2);
			laysButton.setMinSize(250.0, 50.0);
			laysButton.setOnAction(e -> {
				dispenser.dispense(0);
				window.setScene(home);});
			
			sunChipsButton = new Button("$1.00");
			Image sunChipsImage = new Image(getClass().getResourceAsStream("sunchips.png"));
			ImageView sunChipsView = new ImageView(sunChipsImage);
			sunChipsView.setFitHeight(200);
			sunChipsView.setFitWidth(150);
			sunChipsButton.setGraphic(sunChipsView);
			GridPane.setConstraints(sunChipsButton, 2, 1);
			sunChipsButton.setMinSize(250.0, 50.0);
			sunChipsButton.setOnAction(e -> {
				dispenser.dispense(1);
				window.setScene(home);});
			
			missVickiesButton = new Button("$1.00");
			Image missVickiesImage = new Image(getClass().getResourceAsStream("miss-vickies-jalapeno.png"));
			ImageView missVickiesView = new ImageView(missVickiesImage);
			missVickiesView.setFitHeight(200);
			missVickiesView.setFitWidth(150);
			missVickiesButton.setGraphic(missVickiesView);
			GridPane.setConstraints(missVickiesButton, 2, 2);
			missVickiesButton.setMinSize(250.0, 50.0);
			missVickiesButton.setOnAction(e -> {
				dispenser.dispense(3);
				window.setScene(home);});
		
		candyButton = new Button("CANDY");
		GridPane.setConstraints(candyButton, 1, 2);
		candyButton.setMinSize(250.0, 50.0);
		candyButton.setOnAction(e -> window.setScene(candy));
		
			starburstButton = new Button("$1.50");
			Image starburstImage = new Image(getClass().getResourceAsStream("starburst.png"));
			ImageView starburstView = new ImageView(starburstImage);
			starburstView.setFitHeight(200);
			starburstView.setFitWidth(150);
			starburstButton.setGraphic(starburstView);			GridPane.setConstraints(starburstButton, 1, 1);
			starburstButton.setMinSize(250.0, 50.0);
			starburstButton.setOnAction(e -> {
				dispenser.dispense(6);
				window.setScene(home);});
			
			skittlesButton = new Button("$1.50");
			Image skittlesImage = new Image(getClass().getResourceAsStream("skittles.png"));
			ImageView skittlesView = new ImageView(skittlesImage);
			skittlesView.setFitHeight(200);
			skittlesView.setFitWidth(150);
			skittlesButton.setGraphic(skittlesView);			GridPane.setConstraints(skittlesButton, 1, 2);
			skittlesButton.setMinSize(250.0, 50.0);
			skittlesButton.setOnAction(e -> {
				dispenser.dispense(4);
				window.setScene(home);});
			
			snickersButton = new Button("$1.50");
			Image snickersImage = new Image(getClass().getResourceAsStream("Snickers.png"));
			ImageView snickersView = new ImageView(snickersImage);
			snickersView.setFitHeight(200);
			snickersView.setFitWidth(150);
			snickersButton.setGraphic(snickersView);			GridPane.setConstraints(snickersButton, 2, 1);
			snickersButton.setMinSize(250.0, 50.0);
			snickersButton.setOnAction(e -> {
				dispenser.dispense(5);
				window.setScene(home);});
			
			mandMButton = new Button("$1.50");
			Image mandMImage = new Image(getClass().getResourceAsStream("mandms.png"));
			ImageView mandMView = new ImageView(mandMImage);
			mandMView.setFitHeight(200);
			mandMView.setFitWidth(150);
			mandMButton.setGraphic(mandMView);			GridPane.setConstraints(mandMButton, 2, 2);
			mandMButton.setMinSize(250.0, 50.0);
			mandMButton.setOnAction(e -> {
				dispenser.dispense(7);
				window.setScene(home);});
		
		gumButton = new Button("GUM");
		GridPane.setConstraints(gumButton, 2, 2);
		gumButton.setMinSize(250.0, 50.0);
		gumButton.setOnAction(e -> window.setScene(gum));
		
			tridentButton = new Button("$1.00");
			Image tridentImage = new Image(getClass().getResourceAsStream("trident.png"));
			ImageView tridentView = new ImageView(tridentImage);
			tridentView.setFitHeight(200);
			tridentView.setFitWidth(150);
			tridentButton.setGraphic(tridentView);			GridPane.setConstraints(tridentButton, 1, 1);
			tridentButton.setMinSize(250.0, 50.0);
			tridentButton.setOnAction(e -> {
				dispenser.dispense(9);
				window.setScene(home);});
			
			extraButton = new Button("$1.00");
			Image extraImage = new Image(getClass().getResourceAsStream("extra.png"));
			ImageView extraView = new ImageView(extraImage);
			extraView.setFitHeight(200);
			extraView.setFitWidth(150);
			extraButton.setGraphic(extraView);			GridPane.setConstraints(extraButton, 1, 2);
			extraButton.setMinSize(250.0, 50.0);
			extraButton.setOnAction(e -> {
				dispenser.dispense(10);
				window.setScene(home);});
			
			wrigleysButton = new Button("$1.00");
			Image wrigleysImage = new Image(getClass().getResourceAsStream("wrigleys.png"));
			ImageView wrigleysView = new ImageView(wrigleysImage);
			wrigleysView.setFitHeight(200);
			wrigleysView.setFitWidth(150);
			wrigleysButton.setGraphic(wrigleysView);			GridPane.setConstraints(wrigleysButton, 2, 1);
			wrigleysButton.setMinSize(250.0, 50.0);
			wrigleysButton.setOnAction(e -> {
				dispenser.dispense(11);
				window.setScene(home);});
			
			bigRedButton = new Button("$1.00");
			Image bigRedImage = new Image(getClass().getResourceAsStream("bigRed.png"));
			ImageView bigRedView = new ImageView(bigRedImage);
			bigRedView.setFitHeight(200);
			bigRedView.setFitWidth(150);
			bigRedButton.setGraphic(bigRedView);			GridPane.setConstraints(bigRedButton, 2, 2);
			bigRedButton.setMinSize(250.0, 50.0);
			bigRedButton.setOnAction(e -> {
				dispenser.dispense(8);
				window.setScene(home);});
			
		drinksBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(drinksBackButton, 2, 0);
		drinksBackButton.setMinSize(250.0, 50.0);
		drinksBackButton.setOnAction(e -> window.setScene(home));
		
		chipsBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(chipsBackButton, 2, 0);
		chipsBackButton.setMinSize(250.0, 50.0);
		chipsBackButton.setOnAction(e -> window.setScene(home));
		
		candyBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(candyBackButton, 2, 0);
		candyBackButton.setMinSize(250.0, 50.0);
		candyBackButton.setOnAction(e -> window.setScene(home));
		
		gumBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(gumBackButton, 2, 0);
		gumBackButton.setMinSize(250.0, 50.0);
		gumBackButton.setOnAction(e -> window.setScene(home));
		
		backButton = new Button("BACK TO HOME");
		GridPane.setConstraints(backButton, 2, 0);
		backButton.setMinSize(250.0, 50.0);
		backButton.setOnAction(e -> window.setScene(home));
		
		Label receiptText = new Label();
		GridPane.setConstraints(receiptText, 1, 1);
		
		StringBuilder purchase = new StringBuilder();
		
		
		done = new Button("DONE");
		GridPane.setConstraints(done, 2, 3);
		done.setMinSize(250.0, 50.0);
		done.setOnAction(e -> {
			receiptText.setText("Your purchase: \n" + dispenser.cart.toString() + "\nTotal: $" + dispenser.total + "0");
			window.setScene(receipt);});
		
		
		Label homeLable = new Label("WELCOME!");
		GridPane.setConstraints(homeLable, 1, 0);
		
		
		GridPane homeLayout = new GridPane();
		homeLayout.setPadding(new Insets(10, 10, 10, 10));
		homeLayout.setVgap(10);
		homeLayout.setHgap(8);
		homeLayout.getChildren().addAll(drinksButton, chipsButton, candyButton, gumButton, backButton, homeLable, done);
		
		GridPane drinksLayout = new GridPane();
		drinksLayout.setPadding(new Insets(10, 10, 10, 10));
		drinksLayout.setVgap(10);
		drinksLayout.setHgap(8);
		drinksLayout.getChildren().addAll(cocaColaButton, spriteButton, minuteMaidButton, dasaniButton, drinksBackButton);
		
		GridPane chipsLayout = new GridPane();
		chipsLayout.setPadding(new Insets(10, 10, 10, 10));
		chipsLayout.setVgap(10);
		chipsLayout.setHgap(8);
		chipsLayout.getChildren().addAll(doritosButton, laysButton, sunChipsButton, missVickiesButton, chipsBackButton);
		
		GridPane candyLayout = new GridPane();
		candyLayout.setPadding(new Insets(10, 10, 10, 10));
		candyLayout.setVgap(10);
		candyLayout.setHgap(8);
		candyLayout.getChildren().addAll(starburstButton, skittlesButton, snickersButton, mandMButton, candyBackButton);
		
		GridPane gumLayout = new GridPane();
		gumLayout.setPadding(new Insets(10, 10, 10, 10));
		gumLayout.setVgap(10);
		gumLayout.setHgap(8);
		gumLayout.getChildren().addAll(tridentButton, extraButton, wrigleysButton, bigRedButton, gumBackButton);
		
		GridPane receiptLayout = new GridPane();
		receiptLayout.setPadding(new Insets(10, 10, 10, 10));
		receiptLayout.setVgap(10);
		receiptLayout.setHgap(8);
		receiptLayout.getChildren().addAll(receiptText);
		
		
		
		home = new Scene(homeLayout, 545, 500);
		
		drinks = new Scene(drinksLayout, 545, 500);
		
		chips = new Scene(chipsLayout, 545, 500);
		
		candy = new Scene(candyLayout, 545, 500);
		
		gum = new Scene(gumLayout, 545, 500);
		
		receipt = new Scene(receiptLayout, 545, 500);
		
		
		primaryStage.setScene(home);
		primaryStage.show();

	}
	
	public static void main(String[] args){
		launch(args);
	}



}
