package vendingMachineGUIBoss;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import vendingMachine.Dispenser;


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
	Button doneButton;
	Button cancelButton;
	Button inventoryButton;
	Button inventoryBackButton;
	Button oneDollarButton;
	Button fiveDollarButton;
	Button tenDollarButton;
	Button twentyDollarButton;
	Button addFundsButton;
	GridPane homeLayout;
	Stage window;
	Scene drinks, chips, candy, gum, home, receipt, inventory, addMoney;
	
	Dispenser dispenser = new Dispenser(20);
	
	public enum CHOICE{
		LAYS,
		SUNCHIPS,
		DORITOS,
		MISSVICKIES,
		SKITTLES,
		SNICKERS,
		STARBURST,
		MANDM,
		BIGRED,
		TRIDENT,
		EXTRA,
		WRIGLEYS,
		COCACOLA,
		SPRITE,
		MINUTEMAID,
		DASANI
		
	}
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Title of the Window");
		
		Label homeCreditText = new Label("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(homeCreditText, 1, 0);
		
		Label drinkCreditText = new Label("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(drinkCreditText, 1, 0);
		
		Label chipsCreditText = new Label("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(chipsCreditText, 1, 0);
		
		Label candyCreditText = new Label("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(candyCreditText, 1, 0);
		
		Label gumCreditText = new Label("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(gumCreditText, 1, 0);
		
		Label insufficientFunds = new Label("Not enough credit, please add more money!");
		GridPane.setConstraints(insufficientFunds, 1, 0);

		//Displays all available drinks in new scene
		drinksButton = new Button("DRINKS");
		GridPane.setConstraints(drinksButton, 1, 2);
		drinksButton.setMinSize(250.0, 50.0);
		drinksButton.setOnAction(e -> window.setScene(drinks));
		
		//Clicking the button adds the product to cart and adds the price to total. Also goes back to home screen to make another selection
		//or click done if no more items are wanted.
		cocaColaButton = new Button("$1.50");
		Image cocaColaImage = new Image(getClass().getResourceAsStream("coke.png"));
		ImageView cocaColaView = new ImageView(cocaColaImage);
		cocaColaView.setFitHeight(200);
		cocaColaView.setFitWidth(150);
		cocaColaButton.setGraphic(cocaColaView);
		GridPane.setConstraints(cocaColaButton, 1, 1);
		cocaColaButton.setMinSize(250.0, 50.0);
		cocaColaButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.cocaColaStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.cocaColaStock.get(0).getPrice()){
			dispenser.dispense(12, Dispenser.cocaColaStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			
			}
			else if(Dispenser.cocaColaStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);
			});
			
		//same functionality as cocaColaButton
		spriteButton = new Button("$1.50");
		Image spriteImage = new Image(getClass().getResourceAsStream("sprite.png"));
		ImageView spriteView = new ImageView(spriteImage);
		spriteView.setFitHeight(200);
		spriteView.setFitWidth(150);
		spriteButton.setGraphic(spriteView);
		GridPane.setConstraints(spriteButton, 1, 2);
		spriteButton.setMinSize(250.0, 50.0);
		spriteButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.spriteStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.spriteStock.get(0).getPrice()){
			dispenser.dispense(13, Dispenser.spriteStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.spriteStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		minuteMaidButton = new Button("$2.00");
		Image minuteMaidImage = new Image(getClass().getResourceAsStream("minutemaid.png"));
		ImageView minuteMaidView = new ImageView(minuteMaidImage);
		minuteMaidView.setFitHeight(200);
		minuteMaidView.setFitWidth(150);
		minuteMaidButton.setGraphic(minuteMaidView);
		GridPane.setConstraints(minuteMaidButton, 2, 1);
		minuteMaidButton.setMinSize(250.0, 50.0);
		minuteMaidButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.minuteMaidStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.minuteMaidStock.get(0).getPrice()){
			dispenser.dispense(14, Dispenser.minuteMaidStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.minuteMaidStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		dasaniButton = new Button ("$1.00");
		Image dasaniImage = new Image(getClass().getResourceAsStream("dasani.png"));
		ImageView dasaniView = new ImageView(dasaniImage);
		dasaniView.setFitHeight(200);
		dasaniView.setFitWidth(150);
		dasaniButton.setGraphic(dasaniView);
		GridPane.setConstraints(dasaniButton, 2, 2);
		dasaniButton.setMinSize(250.0, 50.0);
		dasaniButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.dasaniStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.dasaniStock.get(0).getPrice()){
			dispenser.dispense(15, Dispenser.dasaniStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.dasaniStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//Displays all available chips in new scene
		chipsButton = new Button("CHIPS");
		GridPane.setConstraints(chipsButton, 2, 2);
		chipsButton.setMinSize(250.0, 50.0);
		chipsButton.setOnAction(e -> window.setScene(chips));
			
		//same functionality as cocaColaButton
		doritosButton = new Button("$1.00");
		Image doritosImage = new Image(getClass().getResourceAsStream("Doritos-nacho-cheese.png"));
		ImageView doritosView = new ImageView(doritosImage);
		doritosView.setFitHeight(200);
		doritosView.setFitWidth(150);
		doritosButton.setGraphic(doritosView);
		GridPane.setConstraints(doritosButton, 1, 1);
		doritosButton.setMinSize(250.0, 50.0);
		doritosButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.doritosStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.doritosStock.get(0).getPrice()){
			dispenser.dispense(2, Dispenser.doritosStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.doritosStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		laysButton = new Button("$1.00");
		Image laysImage = new Image(getClass().getResourceAsStream("Lays_Chips.png"));
		ImageView laysView = new ImageView(laysImage);
		laysView.setFitHeight(200);
		laysView.setFitWidth(150);
		laysButton.setGraphic(laysView);
		GridPane.setConstraints(laysButton, 1, 2);
		laysButton.setMinSize(250.0, 50.0);
		laysButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.laysStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.laysStock.get(0).getPrice()){
			dispenser.dispense(0, Dispenser.laysStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.laysStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		sunChipsButton = new Button("$1.00");
		Image sunChipsImage = new Image(getClass().getResourceAsStream("sunchips.png"));
		ImageView sunChipsView = new ImageView(sunChipsImage);
		sunChipsView.setFitHeight(200);
		sunChipsView.setFitWidth(150);
		sunChipsButton.setGraphic(sunChipsView);
		GridPane.setConstraints(sunChipsButton, 2, 1);
		sunChipsButton.setMinSize(250.0, 50.0);
		sunChipsButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.sunChipsStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.sunChipsStock.get(0).getPrice()){
			dispenser.dispense(1, Dispenser.sunChipsStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.sunChipsStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		missVickiesButton = new Button("$1.00");
		Image missVickiesImage = new Image(getClass().getResourceAsStream("miss-vickies-jalapeno.png"));
		ImageView missVickiesView = new ImageView(missVickiesImage);
		missVickiesView.setFitHeight(200);
		missVickiesView.setFitWidth(150);
		missVickiesButton.setGraphic(missVickiesView);
		GridPane.setConstraints(missVickiesButton, 2, 2);
		missVickiesButton.setMinSize(250.0, 50.0);
		missVickiesButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.missVickiesStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.missVickiesStock.get(0).getPrice()){
			dispenser.dispense(3, Dispenser.missVickiesStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.missVickiesStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
	
		//Displays all available candy in new scene
		candyButton = new Button("CANDY");
		GridPane.setConstraints(candyButton, 1, 3);
		candyButton.setMinSize(250.0, 50.0);
		candyButton.setOnAction(e -> window.setScene(candy));
		
		//same functionality as cocaColaButton
		starburstButton = new Button("$1.50");
		Image starburstImage = new Image(getClass().getResourceAsStream("starburst.png"));
		ImageView starburstView = new ImageView(starburstImage);
		starburstView.setFitHeight(200);
		starburstView.setFitWidth(150);
		starburstButton.setGraphic(starburstView);			
		GridPane.setConstraints(starburstButton, 1, 1);
		starburstButton.setMinSize(250.0, 50.0);
		starburstButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.starburstStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.starburstStock.get(0).getPrice()){
			dispenser.dispense(6, Dispenser.starburstStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.starburstStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		skittlesButton = new Button("$1.50");
		Image skittlesImage = new Image(getClass().getResourceAsStream("skittles.png"));
		ImageView skittlesView = new ImageView(skittlesImage);
		skittlesView.setFitHeight(200);
		skittlesView.setFitWidth(150);
		skittlesButton.setGraphic(skittlesView);			
		GridPane.setConstraints(skittlesButton, 1, 2);
		skittlesButton.setMinSize(250.0, 50.0);
		skittlesButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.skittlesStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.skittlesStock.get(0).getPrice()){
			dispenser.dispense(4, Dispenser.skittlesStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.skittlesStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		snickersButton = new Button("$1.50");
		Image snickersImage = new Image(getClass().getResourceAsStream("Snickers.png"));
		ImageView snickersView = new ImageView(snickersImage);
		snickersView.setFitHeight(200);
		snickersView.setFitWidth(150);
		snickersButton.setGraphic(snickersView);			
		GridPane.setConstraints(snickersButton, 2, 1);
		snickersButton.setMinSize(250.0, 50.0);
		snickersButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.snickersStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.snickersStock.get(0).getPrice()){
			dispenser.dispense(5, Dispenser.snickersStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.snickersStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		mandMButton = new Button("$1.50");
		Image mandMImage = new Image(getClass().getResourceAsStream("mandms.png"));
		ImageView mandMView = new ImageView(mandMImage);
		mandMView.setFitHeight(200);
		mandMView.setFitWidth(150);
		mandMButton.setGraphic(mandMView);			
		GridPane.setConstraints(mandMButton, 2, 2);
		mandMButton.setMinSize(250.0, 50.0);
		mandMButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.mandMStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.mandMStock.get(0).getPrice()){
			dispenser.dispense(7, Dispenser.mandMStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.mandMStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//Displays all available gum in new scene
		gumButton = new Button("GUM");
		GridPane.setConstraints(gumButton, 2, 3);
		gumButton.setMinSize(250.0, 50.0);
		gumButton.setOnAction(e -> window.setScene(gum));
		
		//same functionality as cocaColaButton
		tridentButton = new Button("$1.00");
		Image tridentImage = new Image(getClass().getResourceAsStream("trident.png"));
		ImageView tridentView = new ImageView(tridentImage);
		tridentView.setFitHeight(200);
		tridentView.setFitWidth(150);
		tridentButton.setGraphic(tridentView);			
		GridPane.setConstraints(tridentButton, 1, 1);
		tridentButton.setMinSize(250.0, 50.0);
		tridentButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.tridentStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.tridentStock.get(0).getPrice()){
			dispenser.dispense(9, Dispenser.tridentStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.tridentStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		extraButton = new Button("$1.00");
		Image extraImage = new Image(getClass().getResourceAsStream("extra.png"));
		ImageView extraView = new ImageView(extraImage);
		extraView.setFitHeight(200);
		extraView.setFitWidth(150);
		extraButton.setGraphic(extraView);			
		GridPane.setConstraints(extraButton, 1, 2);
		extraButton.setMinSize(250.0, 50.0);
		extraButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.extraStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.extraStock.get(0).getPrice()){
			dispenser.dispense(10, Dispenser.extraStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.extraStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		wrigleysButton = new Button("$1.00");
		Image wrigleysImage = new Image(getClass().getResourceAsStream("wrigleys.png"));
		ImageView wrigleysView = new ImageView(wrigleysImage);
		wrigleysView.setFitHeight(200);
		wrigleysView.setFitWidth(150);
		wrigleysButton.setGraphic(wrigleysView);			
		GridPane.setConstraints(wrigleysButton, 2, 1);
		wrigleysButton.setMinSize(250.0, 50.0);
		wrigleysButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.wrigleysStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.wrigleysStock.get(0).getPrice()){
			dispenser.dispense(11, Dispenser.wrigleysStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.wrigleysStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
		
		//same functionality as cocaColaButton
		bigRedButton = new Button("$1.00");
		Image bigRedImage = new Image(getClass().getResourceAsStream("bigRed.png"));
		ImageView bigRedView = new ImageView(bigRedImage);
		bigRedView.setFitHeight(200);
		bigRedView.setFitWidth(150);
		bigRedButton.setGraphic(bigRedView);			
		GridPane.setConstraints(bigRedButton, 2, 2);
		bigRedButton.setMinSize(250.0, 50.0);
		bigRedButton.setOnAction(e -> {
			Label outOfStockText = new Label();
			GridPane.setConstraints(outOfStockText, 1, 1);
			outOfStockText.setText("out of stock");
			if(Dispenser.bigRedStock.size() > 0 && Dispenser.myBank.getCreditAvailable() >= Dispenser.bigRedStock.get(0).getPrice()){
			dispenser.dispense(8, Dispenser.bigRedStock);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(Dispenser.bigRedStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			window.setScene(home);});
			
		//Takes the user back to the home screen.
		drinksBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(drinksBackButton, 2, 0);
		drinksBackButton.setMinSize(250.0, 50.0);
		drinksBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		chipsBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(chipsBackButton, 2, 0);
		chipsBackButton.setMinSize(250.0, 50.0);
		chipsBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		candyBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(candyBackButton, 2, 0);
		candyBackButton.setMinSize(250.0, 50.0);
		candyBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		gumBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(gumBackButton, 2, 0);
		gumBackButton.setMinSize(250.0, 50.0);
		gumBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		backButton = new Button("BACK TO HOME");
		GridPane.setConstraints(backButton, 2, 0);
		backButton.setMinSize(250.0, 50.0);
		backButton.setOnAction(e -> window.setScene(home));
		
		inventoryBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(inventoryBackButton, 2, 0);
		inventoryBackButton.setMinSize(250.0, 50.0);
		inventoryBackButton.setOnAction(e -> window.setScene(home));
		
		//Placeholder for receipt
		Label receiptText = new Label();
		GridPane.setConstraints(receiptText, 1, 1);
		
			
		//Finalizes purchase. Opens the Receipt pane, waits for user interaction then resets cart and total value.
		doneButton = new Button("DONE");
		GridPane.setConstraints(doneButton, 2, 4);
		doneButton.setMinSize(150.0, 50.0);
		doneButton.setOnAction(e -> {
			receiptText.setText("Your purchase: \n" + Dispenser.cart.toString() + "\n\n\nTotal: $" + dispenser.total + "0\n"
					+ "Your Change: $" + Dispenser.myBank.getChange() + "0");
			ReceiptBox.display(receiptText);
			Dispenser.cart.clear();
			dispenser.total = 0;
			Dispenser.myBank.setCreditAvailable(0.00);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(addMoney);});
		
		Label inventoryText = new Label();
		GridPane.setConstraints(inventoryText, 1, 1);
		
		inventoryButton = new Button("Display Inventory");
		GridPane.setConstraints(inventoryButton, 2, 0);
		inventoryButton.setMinSize(250.0, 50.0);
		inventoryButton.setOnAction(e -> {
			inventoryText.setText("Current Inventory: \n\n" + "Lays" + ": " + Dispenser.laysStock.size() + "\n"
					+ "Doritos" + ": " + Dispenser.doritosStock.size() + "\n"
					+ "Sun Chips" + ": " + Dispenser.sunChipsStock.size() + "\n"
					+ "Miss Vickie's" + ": " + Dispenser.missVickiesStock.size() + "\n"
					+ "Skittles" + ": " + Dispenser.skittlesStock.size() + "\n"
					+ "Snickers" + ": " + Dispenser.snickersStock.size() + "\n"
					+ "M&M's" + ": " + Dispenser.mandMStock.size() + "\n"
					+ "Starburst" + ": " + Dispenser.starburstStock.size() + "\n"
					+ "Trident" + ": " + Dispenser.tridentStock.size() + "\n"
					+ "Big Red" + ": " + Dispenser.bigRedStock.size() + "\n"
					+ "Extra" + ": " + Dispenser.extraStock.size() + "\n"
					+ "Wrigleys" + ": " + Dispenser.wrigleysStock.size() + "\n"
					+ "Coca-Cola" + ": " + Dispenser.cocaColaStock.size() + "\n"
					+ "Sprite" + ": " + Dispenser.spriteStock.size() + "\n"
					+ "Minute Maid" + ": " + Dispenser.minuteMaidStock.size() + "\n"
					+ "Dasani" + ": " + Dispenser.dasaniStock.size() + "\n");
			ReceiptBox.display(inventoryText);
			window.setScene(home);});
		
		
		
		cancelButton = new Button("CANCEL");
		GridPane.setConstraints(cancelButton, 1, 4);
		cancelButton.setMinSize(150.0, 50.0);
		cancelButton.setOnAction(e -> {
			int size = Dispenser.cart.size();
			for(int i = 0; i < size; i++){
				String name = Dispenser.cart.get(i).getName();
				double price = Dispenser.cart.get(i).getPrice();
				switch (name){
				case "Lays":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.LAYS);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Doritos":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.DORITOS);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Sun Chips":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SUNCHIPS);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Miss Vickie's":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.MISSVICKIES);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Snickers":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SNICKERS);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Skittles":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SKITTLES);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "M&M's":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.MANDM);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Starburst":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.STARBURST);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Trident":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.TRIDENT);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Extra":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.EXTRA);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Big Red":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.BIGRED);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Wrigley's":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.WRIGLEYS);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Coca-Cola":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.COCACOLA);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Sprite":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SPRITE);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Dasani":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.DASANI);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Minute Maid":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.MINUTEMAID);
					Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + price);
					Dispenser.myBank.setIncome(Dispenser.myBank.getIncome() - price);
					Dispenser.myBank.setChange(Dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
					break;
				}
			};
			Dispenser.cart.clear();
			dispenser.total = 0;
			receiptText.setText("Your purchase: \n" + Dispenser.cart.toString() + "\n\n\nTotal: $" + dispenser.total + "0\n"
					+ "Your Change: $" + Dispenser.myBank.getChange() + "0");
			ReceiptBox.display(receiptText);
			window.setScene(home);
		});
		

		Label addMoneyWelcomeLabel = new Label("Welcome! Please deposit cash.");
		GridPane.setConstraints(addMoneyWelcomeLabel, 1, 0);
		
		oneDollarButton = new Button("$1");
		GridPane.setConstraints(oneDollarButton, 1, 1);
		oneDollarButton.setMinSize(250.0, 50.0);
		oneDollarButton.setOnAction(e -> {
			Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + 1.00);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});

		fiveDollarButton = new Button("$5");
		GridPane.setConstraints(fiveDollarButton, 2, 1);
		fiveDollarButton.setMinSize(250.0, 50.0);
		fiveDollarButton.setOnAction(e -> {
			Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + 5.00);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});
		
		tenDollarButton = new Button("$10");
		GridPane.setConstraints(tenDollarButton, 1, 2);
		tenDollarButton.setMinSize(250.0, 50.0);
		tenDollarButton.setOnAction(e -> {
			Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + 10.00);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});
		
		twentyDollarButton = new Button("$20");
		GridPane.setConstraints(twentyDollarButton, 2, 2);
		twentyDollarButton.setMinSize(250.0, 50.0);
		twentyDollarButton.setOnAction(e -> {
			Dispenser.myBank.setCreditAvailable(Dispenser.myBank.getCreditAvailable() + 20.00);
			homeCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + Dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});
		
		addFundsButton = new Button("Add More Funds");
		GridPane.setConstraints(addFundsButton, 2, 1);
		addFundsButton.setMinSize(250.0, 50.0);
		addFundsButton.setOnAction(e -> window.setScene(addMoney));

		Label creditText = new Label();
		GridPane.setConstraints(creditText, 1, 0);
		
		//Displays Welcome text
		Label homeLable = new Label("WELCOME!");
		GridPane.setConstraints(homeLable, 1, 1);
		homeLable.setAlignment(Pos.CENTER);
		homeLable.setStyle("-fx-font: 40 arial;");
		homeLable.setMinSize(100, 100);
		
		//Sets the layout for the home screen.
		GridPane homeLayout = new GridPane();
		homeLayout.setPadding(new Insets(10, 10, 10, 10));
		homeLayout.setVgap(10);
		homeLayout.setHgap(8);
		homeLayout.getChildren().addAll(drinksButton, chipsButton, candyButton, gumButton, homeLable, doneButton, cancelButton, inventoryButton, homeCreditText, 
				addFundsButton);
		
		//Sets the layout for the drinks screen.
		GridPane drinksLayout = new GridPane();
		drinksLayout.setPadding(new Insets(10, 10, 10, 10));
		drinksLayout.setVgap(10);
		drinksLayout.setHgap(8);
		drinksLayout.getChildren().addAll(cocaColaButton, spriteButton, minuteMaidButton, dasaniButton, drinksBackButton, drinkCreditText);
		
		//Sets the layout for the chips screen.
		GridPane chipsLayout = new GridPane();
		chipsLayout.setPadding(new Insets(10, 10, 10, 10));
		chipsLayout.setVgap(10);
		chipsLayout.setHgap(8);
		chipsLayout.getChildren().addAll(doritosButton, laysButton, sunChipsButton, missVickiesButton, chipsBackButton, chipsCreditText);
		
		//Sets the layout for the candy screen.
		GridPane candyLayout = new GridPane();
		candyLayout.setPadding(new Insets(10, 10, 10, 10));
		candyLayout.setVgap(10);
		candyLayout.setHgap(8);
		candyLayout.getChildren().addAll(starburstButton, skittlesButton, snickersButton, mandMButton, candyBackButton, candyCreditText);
		
		//Sets the layout for the gum screen.
		GridPane gumLayout = new GridPane();
		gumLayout.setPadding(new Insets(10, 10, 10, 10));
		gumLayout.setVgap(10);
		gumLayout.setHgap(8);
		gumLayout.getChildren().addAll(tridentButton, extraButton, wrigleysButton, bigRedButton, gumBackButton, gumCreditText);
		
		GridPane inventoryLayout = new GridPane();
		inventoryLayout.setPadding(new Insets(10, 10, 10, 10));
		inventoryLayout.setVgap(10);
		inventoryLayout.setHgap(8);
		inventoryLayout.getChildren().addAll(inventoryText, inventoryBackButton);
		
		GridPane insertMoney = new GridPane();
		insertMoney.setPadding(new Insets(10, 10, 10, 10));
		insertMoney.setVgap(10);
		insertMoney.setHgap(8);
		insertMoney.getChildren().addAll(oneDollarButton, fiveDollarButton, tenDollarButton, twentyDollarButton, addMoneyWelcomeLabel);
		
		//Different screens in this application. Sets layout to each scene and defines the screen size.
		home = new Scene(homeLayout, 545, 500);
		drinks = new Scene(drinksLayout, 545, 500);
		chips = new Scene(chipsLayout, 545, 500);
		candy = new Scene(candyLayout, 545, 500);
		gum = new Scene(gumLayout, 545, 500);
		inventory = new Scene(inventoryLayout, 545, 500);
		addMoney = new Scene(insertMoney, 545, 500);
		
		//Sets the home screen to display on start.
		primaryStage.setScene(addMoney);
		primaryStage.show();

	}
	
	public static void main(String[] args){
		launch(args);
	}



}
