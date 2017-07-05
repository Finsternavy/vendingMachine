package vendingMachineGUIBoss;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
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
	Button cartHomeButton;
	Button cartDrinksButton;
	Button cartCandyButton;
	Button cartChipsButton;
	Button cartGumButton;
	GridPane homeLayout;
	Stage window;
	Scene drinks, chips, candy, gum, home, receipt, inventory, addMoney;
	
	Dispenser dispenser = new Dispenser("Vend-O-matic 6000", 20);
	
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
		window.setTitle("Vend-O-matic 6000!");
		
		Label homeCreditText = new Label("Credit: " + dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(homeCreditText, 1, 0);
		homeCreditText.setStyle("-fx-font: 20 arial;");
		
		Label drinkCreditText = new Label("Credit: " + dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(drinkCreditText, 1, 0);
		drinkCreditText.setStyle("-fx-font: 20 arial;");
		
		Label chipsCreditText = new Label("Credit: " + dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(chipsCreditText, 1, 0);
		chipsCreditText.setStyle("-fx-font: 20 arial;");
		
		Label candyCreditText = new Label("Credit: " + dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(candyCreditText, 1, 0);
		candyCreditText.setStyle("-fx-font: 20 arial;");
		
		Label gumCreditText = new Label("Credit: " + dispenser.myBank.getCreditAvailable() + "0");
		GridPane.setConstraints(gumCreditText, 1, 0);
		gumCreditText.setStyle("-fx-font: 20 arial;");
		
		Label insufficientFunds = new Label("Not enough credit, please add more money!");
		GridPane.setConstraints(insufficientFunds, 1, 0);
		insufficientFunds.setStyle("-fx-font: 50 arial;\n\n");
		
		Label outOfStockText = new Label();
		GridPane.setConstraints(outOfStockText, 1, 1);
		outOfStockText.setText("out of stock");
		
		

		//Displays all available drinks in new scene
		drinksButton = new Button("DRINKS");
		GridPane.setConstraints(drinksButton, 1, 2);
		drinksButton.setMinSize(250.0, 50.0);
		drinksButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		
		drinksButton.setOnAction(e -> window.setScene(drinks));
		
		//Clicking the button adds the product to cart and adds the price to total. Also goes back to home screen to make another selection
		//or click done if no more items are wanted.
		cocaColaButton = new Button("$1.50");
		Image cocaColaImage = new Image(getClass().getResourceAsStream("coke.png"));
		ImageView cocaColaView = new ImageView(cocaColaImage);
		cocaColaView.setFitHeight(100);
		cocaColaView.setFitWidth(100);
		cocaColaButton.setGraphic(cocaColaView);
		GridPane.setConstraints(cocaColaButton, 1, 1);
		cocaColaButton.setMinSize(250.0, 100.0);
		cocaColaButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cocaColaButton.setOnAction(e -> {
			if(dispenser.cocaColaStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.cocaColaStock.get(0).getPrice()){
				Animation.animateStart(cocaColaView);
				dispenser.dispense(12, dispenser.cocaColaStock);
				homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			else if(dispenser.cocaColaStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			
			
			});
			
		//same functionality as cocaColaButton
		spriteButton = new Button("$1.50");
		Image spriteImage = new Image(getClass().getResourceAsStream("sprite.png"));
		ImageView spriteView = new ImageView(spriteImage);
		spriteView.setFitHeight(100);
		spriteView.setFitWidth(50);
		spriteButton.setGraphic(spriteView);
		GridPane.setConstraints(spriteButton, 1, 2);
		spriteButton.setMinSize(250.0, 50.0);
		spriteButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		spriteButton.setOnAction(e -> {
			if(dispenser.spriteStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.spriteStock.get(0).getPrice()){
				Animation.animateStart(spriteView);
			dispenser.dispense(13, dispenser.spriteStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			
			}
			
			else if(dispenser.spriteStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		minuteMaidButton = new Button("$2.00");
		Image minuteMaidImage = new Image(getClass().getResourceAsStream("minutemaid.png"));
		ImageView minuteMaidView = new ImageView(minuteMaidImage);
		minuteMaidView.setFitHeight(100);
		minuteMaidView.setFitWidth(50);
		minuteMaidButton.setGraphic(minuteMaidView);
		GridPane.setConstraints(minuteMaidButton, 2, 1);
		minuteMaidButton.setMinSize(250.0, 50.0);
		minuteMaidButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		minuteMaidButton.setOnAction(e -> {
			if(dispenser.minuteMaidStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.minuteMaidStock.get(0).getPrice()){
				Animation.animateStart(minuteMaidView);
			dispenser.dispense(14, dispenser.minuteMaidStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.minuteMaidStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		dasaniButton = new Button ("$1.00");
		Image dasaniImage = new Image(getClass().getResourceAsStream("dasani.png"));
		ImageView dasaniView = new ImageView(dasaniImage);
		dasaniView.setFitHeight(100);
		dasaniView.setFitWidth(50);
		dasaniButton.setGraphic(dasaniView);
		GridPane.setConstraints(dasaniButton, 2, 2);
		dasaniButton.setMinSize(250.0, 50.0);
		dasaniButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		dasaniButton.setOnAction(e -> {
			if(dispenser.dasaniStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.dasaniStock.get(0).getPrice()){
				Animation.animateStart(dasaniView);
			dispenser.dispense(15, dispenser.dasaniStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.dasaniStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//Displays all available chips in new scene
		chipsButton = new Button("CHIPS");
		GridPane.setConstraints(chipsButton, 2, 2);
		chipsButton.setMinSize(250.0, 50.0);
		chipsButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		chipsButton.setOnAction(e -> window.setScene(chips));
			
		//same functionality as cocaColaButton
		doritosButton = new Button("$1.00");
		Image doritosImage = new Image(getClass().getResourceAsStream("Doritos-nacho-cheese.png"));
		ImageView doritosView = new ImageView(doritosImage);
		doritosView.setFitHeight(100);
		doritosView.setFitWidth(100);
		doritosButton.setGraphic(doritosView);
		GridPane.setConstraints(doritosButton, 1, 1);
		doritosButton.setMinSize(250.0, 50.0);
		doritosButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		doritosButton.setOnAction(e -> {
			if(dispenser.doritosStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.doritosStock.get(0).getPrice()){
				Animation.animateStart(doritosView);
			dispenser.dispense(2, dispenser.doritosStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.doritosStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		laysButton = new Button("$1.00");
		Image laysImage = new Image(getClass().getResourceAsStream("Lays_Chips.png"));
		ImageView laysView = new ImageView(laysImage);
		laysView.setFitHeight(100);
		laysView.setFitWidth(100);
		laysButton.setGraphic(laysView);
		GridPane.setConstraints(laysButton, 1, 2);
		laysButton.setMinSize(250.0, 50.0);
		laysButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		laysButton.setOnAction(e -> {
			if(dispenser.laysStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.laysStock.get(0).getPrice()){
				Animation.animateStart(laysView);
			dispenser.dispense(0, dispenser.laysStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.laysStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		sunChipsButton = new Button("$1.00");
		Image sunChipsImage = new Image(getClass().getResourceAsStream("sunchips.png"));
		ImageView sunChipsView = new ImageView(sunChipsImage);
		sunChipsView.setFitHeight(100);
		sunChipsView.setFitWidth(100);
		sunChipsButton.setGraphic(sunChipsView);
		GridPane.setConstraints(sunChipsButton, 2, 1);
		sunChipsButton.setMinSize(250.0, 50.0);
		sunChipsButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		sunChipsButton.setOnAction(e -> {
			if(dispenser.sunChipsStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.sunChipsStock.get(0).getPrice()){
				Animation.animateStart(sunChipsView);
			dispenser.dispense(1, dispenser.sunChipsStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.sunChipsStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		missVickiesButton = new Button("$1.00");
		Image missVickiesImage = new Image(getClass().getResourceAsStream("miss-vickies-jalapeno.png"));
		ImageView missVickiesView = new ImageView(missVickiesImage);
		missVickiesView.setFitHeight(100);
		missVickiesView.setFitWidth(100);
		missVickiesButton.setGraphic(missVickiesView);
		GridPane.setConstraints(missVickiesButton, 2, 2);
		missVickiesButton.setMinSize(250.0, 50.0);
		missVickiesButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		missVickiesButton.setOnAction(e -> {
			if(dispenser.missVickiesStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.missVickiesStock.get(0).getPrice()){
				Animation.animateStart(missVickiesView);
			dispenser.dispense(3, dispenser.missVickiesStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.missVickiesStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
	
		//Displays all available candy in new scene
		candyButton = new Button("CANDY");
		GridPane.setConstraints(candyButton, 1, 3);
		candyButton.setMinSize(250.0, 50.0);
		candyButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		candyButton.setOnAction(e -> window.setScene(candy));
		
		//same functionality as cocaColaButton
		starburstButton = new Button("$1.50");
		Image starburstImage = new Image(getClass().getResourceAsStream("starburst.png"));
		ImageView starburstView = new ImageView(starburstImage);
		starburstView.setFitHeight(100);
		starburstView.setFitWidth(100);
		starburstButton.setGraphic(starburstView);			
		GridPane.setConstraints(starburstButton, 1, 1);
		starburstButton.setMinSize(250.0, 50.0);
		starburstButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		starburstButton.setOnAction(e -> {
			if(dispenser.starburstStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.starburstStock.get(0).getPrice()){
				Animation.animateStart(starburstView);
			dispenser.dispense(6, dispenser.starburstStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.starburstStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		skittlesButton = new Button("$1.50");
		Image skittlesImage = new Image(getClass().getResourceAsStream("skittles.png"));
		ImageView skittlesView = new ImageView(skittlesImage);
		skittlesView.setFitHeight(100);
		skittlesView.setFitWidth(100);
		skittlesButton.setGraphic(skittlesView);			
		GridPane.setConstraints(skittlesButton, 1, 2);
		skittlesButton.setMinSize(250.0, 50.0);
		skittlesButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		skittlesButton.setOnAction(e -> {
			if(dispenser.skittlesStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.skittlesStock.get(0).getPrice()){
				Animation.animateStart(skittlesView);
			dispenser.dispense(4, dispenser.skittlesStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.skittlesStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		snickersButton = new Button("$1.50");
		Image snickersImage = new Image(getClass().getResourceAsStream("Snickers.png"));
		ImageView snickersView = new ImageView(snickersImage);
		snickersView.setFitHeight(100);
		snickersView.setFitWidth(100);
		snickersButton.setGraphic(snickersView);			
		GridPane.setConstraints(snickersButton, 2, 1);
		snickersButton.setMinSize(250.0, 50.0);
		snickersButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		snickersButton.setOnAction(e -> {
			if(dispenser.snickersStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.snickersStock.get(0).getPrice()){
				Animation.animateStart(snickersView);
			dispenser.dispense(5, dispenser.snickersStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.snickersStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		mandMButton = new Button("$1.50");
		Image mandMImage = new Image(getClass().getResourceAsStream("mandms.png"));
		ImageView mandMView = new ImageView(mandMImage);
		mandMView.setFitHeight(100);
		mandMView.setFitWidth(100);
		mandMButton.setGraphic(mandMView);			
		GridPane.setConstraints(mandMButton, 2, 2);
		mandMButton.setMinSize(250.0, 50.0);
		mandMButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		mandMButton.setOnAction(e -> {
			if(dispenser.mandMStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.mandMStock.get(0).getPrice()){
				Animation.animateStart(mandMView);
			dispenser.dispense(7, dispenser.mandMStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.mandMStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//Displays all available gum in new scene
		gumButton = new Button("GUM");
		GridPane.setConstraints(gumButton, 2, 3);
		gumButton.setMinSize(250.0, 50.0);
		gumButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		
		gumButton.setOnAction(e -> window.setScene(gum));
		
		//same functionality as cocaColaButton
		tridentButton = new Button("$1.00");
		Image tridentImage = new Image(getClass().getResourceAsStream("trident.png"));
		ImageView tridentView = new ImageView(tridentImage);
		tridentView.setFitHeight(100);
		tridentView.setFitWidth(100);
		tridentButton.setGraphic(tridentView);			
		GridPane.setConstraints(tridentButton, 1, 1);
		tridentButton.setMinSize(250.0, 50.0);
		tridentButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		tridentButton.setOnAction(e -> {
			if(dispenser.tridentStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.tridentStock.get(0).getPrice()){
				Animation.animateStart(tridentView);
			dispenser.dispense(9, dispenser.tridentStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.tridentStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		extraButton = new Button("$1.00");
		Image extraImage = new Image(getClass().getResourceAsStream("extra.png"));
		ImageView extraView = new ImageView(extraImage);
		extraView.setFitHeight(100);
		extraView.setFitWidth(100);
		extraButton.setGraphic(extraView);			
		GridPane.setConstraints(extraButton, 1, 2);
		extraButton.setMinSize(250.0, 50.0);
		extraButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		extraButton.setOnAction(e -> {
			if(dispenser.extraStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.extraStock.get(0).getPrice()){
				Animation.animateStart(extraView);
			dispenser.dispense(10, dispenser.extraStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.extraStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		wrigleysButton = new Button("$1.00");
		Image wrigleysImage = new Image(getClass().getResourceAsStream("wrigleys.png"));
		ImageView wrigleysView = new ImageView(wrigleysImage);
		wrigleysView.setFitHeight(100);
		wrigleysView.setFitWidth(100);
		wrigleysButton.setGraphic(wrigleysView);			
		GridPane.setConstraints(wrigleysButton, 2, 1);
		wrigleysButton.setMinSize(250.0, 50.0);
		wrigleysButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		wrigleysButton.setOnAction(e -> {
			if(dispenser.wrigleysStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.wrigleysStock.get(0).getPrice()){
				Animation.animateStart(wrigleysView);
			dispenser.dispense(11, dispenser.wrigleysStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.wrigleysStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
		
		//same functionality as cocaColaButton
		bigRedButton = new Button("$1.00");
		Image bigRedImage = new Image(getClass().getResourceAsStream("bigRed.png"));
		ImageView bigRedView = new ImageView(bigRedImage);
		bigRedView.setFitHeight(100);
		bigRedView.setFitWidth(100);
		bigRedButton.setGraphic(bigRedView);			
		GridPane.setConstraints(bigRedButton, 2, 2);
		bigRedButton.setMinSize(250.0, 50.0);
		bigRedButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		bigRedButton.setOnAction(e -> {
			if(dispenser.bigRedStock.size() > 0 && dispenser.myBank.getCreditAvailable() >= dispenser.bigRedStock.get(0).getPrice()){
				Animation.animateStart(bigRedView);
			dispenser.dispense(8, dispenser.bigRedStock);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			}
			
			else if(dispenser.bigRedStock.size() < 1)
				ReceiptBox.display(outOfStockText);
			else
				ReceiptBox.display(insufficientFunds);
			
			});
			
		//Takes the user back to the home screen.
		drinksBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(drinksBackButton, 2, 0);
		drinksBackButton.setMinSize(250.0, 50.0);
		drinksBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		drinksBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		chipsBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(chipsBackButton, 2, 0);
		chipsBackButton.setMinSize(250.0, 50.0);
		chipsBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		chipsBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		candyBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(candyBackButton, 2, 0);
		candyBackButton.setMinSize(250.0, 50.0);
		candyBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		candyBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		gumBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(gumBackButton, 2, 0);
		gumBackButton.setMinSize(250.0, 50.0);
		gumBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		gumBackButton.setOnAction(e -> window.setScene(home));
		
		//Takes the user back to the home screen.
		backButton = new Button("BACK TO HOME");
		GridPane.setConstraints(backButton, 2, 0);
		backButton.setMinSize(250.0, 50.0);
		backButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		backButton.setOnAction(e -> window.setScene(home));
		
		inventoryBackButton = new Button("BACK TO HOME");
		GridPane.setConstraints(inventoryBackButton, 2, 0);
		inventoryBackButton.setMinSize(250.0, 50.0);
		inventoryBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		inventoryBackButton.setOnAction(e -> window.setScene(home));
		
		//Placeholder for receipt
		Label receiptText = new Label();
		GridPane.setConstraints(receiptText, 1, 1);
		
			
		//Finalizes purchase. Opens the Receipt pane, waits for user interaction then resets cart and total value.
		doneButton = new Button("DONE");
		GridPane.setConstraints(doneButton, 2, 4);
		doneButton.setMinSize(150.0, 50.0);
		doneButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		doneButton.setOnAction(e -> {
			receiptText.setText("Your purchase: \n" + dispenser.cart.toString() + "\n\n\nTotal: $" + dispenser.total + "0\n"
					+ "Your Change: $" + dispenser.myBank.getChange() + "0");
			ReceiptBox.display(receiptText);
			dispenser.cart.clear();
			dispenser.total = 0;
			dispenser.myBank.setCreditAvailable(0.00);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(addMoney);});
		
		Label inventoryText = new Label();
		GridPane.setConstraints(inventoryText, 1, 1);
		
		inventoryButton = new Button("Display Inventory");
		GridPane.setConstraints(inventoryButton, 2, 0);
		inventoryButton.setMinSize(250.0, 50.0);
		inventoryButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		inventoryButton.setOnAction(e -> {
			inventoryText.setText("Current Inventory: \n\n" + "Lays" + ": " + dispenser.laysStock.size() + "\n"
					+ "Doritos" + ": " + dispenser.doritosStock.size() + "\n"
					+ "Sun Chips" + ": " + dispenser.sunChipsStock.size() + "\n"
					+ "Miss Vickie's" + ": " + dispenser.missVickiesStock.size() + "\n"
					+ "Skittles" + ": " + dispenser.skittlesStock.size() + "\n"
					+ "Snickers" + ": " + dispenser.snickersStock.size() + "\n"
					+ "M&M's" + ": " + dispenser.mandMStock.size() + "\n"
					+ "Starburst" + ": " + dispenser.starburstStock.size() + "\n"
					+ "Trident" + ": " + dispenser.tridentStock.size() + "\n"
					+ "Big Red" + ": " + dispenser.bigRedStock.size() + "\n"
					+ "Extra" + ": " + dispenser.extraStock.size() + "\n"
					+ "Wrigleys" + ": " + dispenser.wrigleysStock.size() + "\n"
					+ "Coca-Cola" + ": " + dispenser.cocaColaStock.size() + "\n"
					+ "Sprite" + ": " + dispenser.spriteStock.size() + "\n"
					+ "Minute Maid" + ": " + dispenser.minuteMaidStock.size() + "\n"
					+ "Dasani" + ": " + dispenser.dasaniStock.size() + "\n");
			ReceiptBox.display(inventoryText);
			});
		
		
		
		cancelButton = new Button("CANCEL");
		GridPane.setConstraints(cancelButton, 1, 4);
		cancelButton.setMinSize(150.0, 50.0);
		cancelButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cancelButton.setOnAction(e -> {
			int size = dispenser.cart.size();
			for(int i = 0; i < size; i++){
				String name = dispenser.cart.get(i).getName();
				double price = dispenser.cart.get(i).getPrice();
				switch (name){
				case "Lays":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.LAYS, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Doritos":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.DORITOS, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Sun Chips":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SUNCHIPS, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Miss Vickie's":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.MISSVICKIES, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Snickers":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SNICKERS, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Skittles":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SKITTLES, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "M&M's":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.MANDM, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Starburst":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.STARBURST, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Trident":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.TRIDENT, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Extra":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.EXTRA, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Big Red":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.BIGRED, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Wrigley's":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.WRIGLEYS, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Coca-Cola":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.COCACOLA, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Sprite":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.SPRITE, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Dasani":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.DASANI, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				case "Minute Maid":
					dispenser.myInventoryManager.addOneToInventory(CHOICE.MINUTEMAID, dispenser);
					dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + price);
					dispenser.myBank.setIncome(dispenser.myBank.getIncome() - price);
					dispenser.myBank.setChange(dispenser.myBank.getChange() + price);
					homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
					break;
				}
			};
			dispenser.cart.clear();
			dispenser.total = 0;
			receiptText.setText("Your purchase: \n" + dispenser.cart.toString() + "\n\n\nTotal: $" + dispenser.total + "0\n"
					+ "Your Change: $" + dispenser.myBank.getChange() + "0");
			ReceiptBox.display(receiptText);
			window.setScene(home);
		});
		

		Label addMoneyWelcomeLabel = new Label("Welcome! Please deposit cash.");
		GridPane.setConstraints(addMoneyWelcomeLabel, 1, 1, 2, 1);
		addMoneyWelcomeLabel.setStyle("-fx-font: 35 arial;");
		
		oneDollarButton = new Button("$1");
		GridPane.setConstraints(oneDollarButton, 1, 2);
		oneDollarButton.setMinSize(250.0, 50.0);
		oneDollarButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		oneDollarButton.setOnAction(e -> {
			dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + 1.00);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});

		fiveDollarButton = new Button("$5");
		GridPane.setConstraints(fiveDollarButton, 2, 2);
		fiveDollarButton.setMinSize(250.0, 50.0);
		fiveDollarButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		fiveDollarButton.setOnAction(e -> {
			dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + 5.00);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});
		
		tenDollarButton = new Button("$10");
		GridPane.setConstraints(tenDollarButton, 1, 3);
		tenDollarButton.setMinSize(250.0, 50.0);
		tenDollarButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		tenDollarButton.setOnAction(e -> {
			dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + 10.00);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: " + dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});
		
		twentyDollarButton = new Button("$20");
		GridPane.setConstraints(twentyDollarButton, 2, 3);
		twentyDollarButton.setMinSize(250.0, 50.0);
		twentyDollarButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		twentyDollarButton.setOnAction(e -> {
			dispenser.myBank.setCreditAvailable(dispenser.myBank.getCreditAvailable() + 20.00);
			homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
			window.setScene(home);});
		
		addFundsButton = new Button("Add More Funds");
		GridPane.setConstraints(addFundsButton, 2, 0);
		addFundsButton.setMinSize(250.0, 50.0);
		addFundsButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		addFundsButton.setOnAction(e -> window.setScene(addMoney));
		
		Label currentCartText = new Label();
		GridPane.setConstraints(currentCartText, 1, 0);
		
		
		cartHomeButton = new Button();
		Image cartImageHome = new Image(getClass().getResourceAsStream("cart.png"));
		ImageView cartViewHome = new ImageView(cartImageHome);
		cartViewHome.setFitHeight(260);
		cartViewHome.setFitWidth(150);
		cartHomeButton.setGraphic(cartViewHome);
		cartHomeButton.setMinSize(500.0, 50.0);
		GridPane.setConstraints(cartHomeButton, 1, 6, 2, 2);
		cartHomeButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cartHomeButton.setOnAction(e -> {
			currentCartText.setText("Your Cart\n\n" + dispenser.cart.toString() + "\n\n" + "Current Total: $" + dispenser.total + "0");
			ReceiptBox.display(currentCartText);
		});
		
		cartDrinksButton = new Button();
		Image cartImageDrinks = new Image(getClass().getResourceAsStream("cart.png"));
		ImageView cartViewDrinks = new ImageView(cartImageDrinks);
		cartViewDrinks.setFitHeight(260);
		cartViewDrinks.setFitWidth(150);
		cartDrinksButton.setGraphic(cartViewDrinks);
		cartDrinksButton.setMinSize(500.0, 50.0);
		GridPane.setConstraints(cartDrinksButton, 1, 3, 2, 2);
		cartDrinksButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cartDrinksButton.setOnAction(e -> {
			currentCartText.setText("Your Cart\n\n" + dispenser.cart.toString() + "\n\n" + "Current Total: $" + dispenser.total + "0");
			ReceiptBox.display(currentCartText);
		});
		
		cartCandyButton = new Button();
		Image cartImageCandy = new Image(getClass().getResourceAsStream("cart.png"));
		ImageView cartViewCandy = new ImageView(cartImageCandy);
		cartViewCandy.setFitHeight(260);
		cartViewCandy.setFitWidth(150);
		cartCandyButton.setGraphic(cartViewCandy);
		cartCandyButton.setMinSize(500.0, 50.0);
		GridPane.setConstraints(cartCandyButton, 1, 3, 2, 2);
		cartCandyButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cartCandyButton.setOnAction(e -> {
			currentCartText.setText("Your Cart\n\n" + dispenser.cart.toString() + "\n\n" + "Current Total: $" + dispenser.total + "0");
			ReceiptBox.display(currentCartText);
		});
		
		cartChipsButton = new Button();
		Image cartImageChips = new Image(getClass().getResourceAsStream("cart.png"));
		ImageView cartViewChips = new ImageView(cartImageChips);
		cartViewChips.setFitHeight(260);
		cartViewChips.setFitWidth(150);
		cartChipsButton.setGraphic(cartViewChips);
		cartChipsButton.setMinSize(500.0, 50.0);
		GridPane.setConstraints(cartChipsButton, 1, 3, 2, 2);
		cartChipsButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cartChipsButton.setOnAction(e -> {
			currentCartText.setText("Your Cart\n\n" + dispenser.cart.toString() + "\n\n" + "Current Total: $" + dispenser.total + "0");
			ReceiptBox.display(currentCartText);
		});
		
		cartGumButton = new Button();
		Image cartImageGum = new Image(getClass().getResourceAsStream("cart.png"));
		ImageView cartViewGum = new ImageView(cartImageGum);
		cartViewGum.setFitHeight(260);
		cartViewGum.setFitWidth(150);
		cartGumButton.setGraphic(cartViewGum);
		cartGumButton.setMinSize(500.0, 50.0);
		GridPane.setConstraints(cartGumButton, 1, 3, 2, 2);
		cartGumButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cartGumButton.setOnAction(e -> {
			currentCartText.setText("Your Cart\n\n" + dispenser.cart.toString() + "\n\n" + "Current Total: $" + dispenser.total + "0");
			ReceiptBox.display(currentCartText);
		});
		
	
		Label creditText = new Label();
		GridPane.setConstraints(creditText, 1, 0);
		
		//Displays Welcome text
		Label homeLable = new Label("WELCOME!");
		GridPane.setConstraints(homeLable, 1, 1, 2, 1);
		homeLable.setAlignment(Pos.CENTER);
		homeLable.setStyle("-fx-font: 94 arial;");
		homeLable.setMinSize(100, 100);
		
		Image backgroundImage = new Image(getClass().getResourceAsStream("bluespots.jpg"));
		
		BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);
		Background newBackground = new Background(background);
		
		//Sets the layout for the home screen.
		GridPane homeLayout = new GridPane();
		homeLayout.setPadding(new Insets(10, 10, 10, 10));
		homeLayout.setVgap(10);
		homeLayout.setHgap(8);
		homeLayout.setBackground(newBackground);
		homeLayout.getChildren().addAll(drinksButton, chipsButton, candyButton, gumButton, homeLable, doneButton, cancelButton, homeCreditText, cartHomeButton, 
				addFundsButton);
		
		//Sets the layout for the drinks screen.
		GridPane drinksLayout = new GridPane();
		drinksLayout.setPadding(new Insets(10, 10, 10, 10));
		drinksLayout.setVgap(10);
		drinksLayout.setHgap(8);
		drinksLayout.setBackground(newBackground);
		drinksLayout.getChildren().addAll(dasaniButton, spriteButton, cocaColaButton,  minuteMaidButton, drinksBackButton, drinkCreditText, cartDrinksButton);
		
		//Sets the layout for the chips screen.
		GridPane chipsLayout = new GridPane();
		chipsLayout.setPadding(new Insets(10, 10, 10, 10));
		chipsLayout.setVgap(10);
		chipsLayout.setHgap(8);
		chipsLayout.setBackground(newBackground);
		chipsLayout.getChildren().addAll(laysButton, missVickiesButton, doritosButton, sunChipsButton, chipsBackButton, chipsCreditText, cartChipsButton);
		
		//Sets the layout for the candy screen.
		GridPane candyLayout = new GridPane();
		candyLayout.setPadding(new Insets(10, 10, 10, 10));
		candyLayout.setVgap(10);
		candyLayout.setHgap(8);
		candyLayout.setBackground(newBackground);
		candyLayout.getChildren().addAll(skittlesButton, mandMButton, candyBackButton, snickersButton, starburstButton, candyCreditText, cartCandyButton);
		
		//Sets the layout for the gum screen.
		GridPane gumLayout = new GridPane();
		gumLayout.setPadding(new Insets(10, 10, 10, 10));
		gumLayout.setVgap(10);
		gumLayout.setHgap(8);
		gumLayout.setBackground(newBackground);
		gumLayout.getChildren().addAll( extraButton, bigRedButton, gumBackButton, wrigleysButton, tridentButton, gumCreditText, cartGumButton);
		
		GridPane inventoryLayout = new GridPane();
		inventoryLayout.setPadding(new Insets(10, 10, 10, 10));
		inventoryLayout.setVgap(10);
		inventoryLayout.setHgap(8);
		inventoryLayout.setBackground(newBackground);
		inventoryLayout.getChildren().addAll(inventoryText, inventoryBackButton);
		
		GridPane insertMoney = new GridPane();
		insertMoney.setPadding(new Insets(10, 10, 10, 10));
		insertMoney.setVgap(10);
		insertMoney.setHgap(8);
		insertMoney.setBackground(newBackground);
		insertMoney.getChildren().addAll(oneDollarButton, fiveDollarButton, tenDollarButton, twentyDollarButton, addMoneyWelcomeLabel, inventoryButton);
		
		//Different screens in this application. Sets layout to each scene and defines the screen size.
		home = new Scene(homeLayout, 545, 740);
		drinks = new Scene(drinksLayout, 545, 740);
		chips = new Scene(chipsLayout, 545, 740);
		candy = new Scene(candyLayout, 545, 740);
		gum = new Scene(gumLayout, 545, 740);
		inventory = new Scene(inventoryLayout, 545, 740);
		addMoney = new Scene(insertMoney, 545, 740);
		
		//Sets the home screen to display on start.
		primaryStage.setScene(addMoney);
		primaryStage.show();

	}
	
	public static void main(String[] args){
		launch(args);
	}



}
