/**
 * 
 */
package vendingMachine;

import java.util.ArrayList;
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
import vendingMachineGUIBoss.Animation;
import vendingMachineGUIBoss.ReceiptBox;
import java.lang.Object;
import vendingMachine.CHOICE;


/**
 * @author Finst
 *
 */
public class Dispenser extends Application{

	public String name = "";
	public int slotMax = 0;
	public double total = 0;
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
	Button loginButton;
	Button loginCancelButton;
	Button loginOneButton;
	Button loginTwoButton;
	Button loginThreeButton;
	Button loginFourButton;
	Button loginFiveButton;
	Button loginSixButton;
	Button loginSevenButton;
	Button loginEightButton;
	Button loginNineButton;
	Button loginSubmitButton;
	Button bossHomeBackButton;
	Button myVendingMachinesButton;
	Button vendingMachineFromCSVButton;
	Button myMachinesBackButton;
	Button simulationButton;
	Button restockButton, laysRestockButton, doritosRestockButton, missVickiesRestockButton, sunChipsRestockButton, mandmRestockButton,
		snickersRestockButton, starburstRestockButton, skittlesRestockButton, tridentRestockButton, bigRedRestockButton, wrigleysRestockButton,
		cocaColaRestockButton, spriteRestockButton, minuteMaidRestockButton, dasaniRestockButton, restockBackButton, extraRestockButton;
	Button bankButton, profitsButton, changeAvailableButton, bankBackButton;
	GridPane homeLayout;
	Stage window;
	Scene drinks, chips, candy, gum, home, receipt, inventory, addMoney, login, bossHome, myVendingMachines, restockScene, bankScene;

	public InventoryManager myInventoryManager = new InventoryManager();
	public ArrayList<Product> products = new ArrayList<>();
	public ArrayList<Product> sunChipsStock = new ArrayList<>();
	public ArrayList<Product> doritosStock = new ArrayList<>();
	public ArrayList<Product> missVickiesStock = new ArrayList<>();
	public ArrayList<Product> laysStock = new ArrayList<>();
	public ArrayList<Product> mandMStock = new ArrayList<>();
	public ArrayList<Product> snickersStock = new ArrayList<>();
	public ArrayList<Product> skittlesStock = new ArrayList<>();
	public ArrayList<Product> starburstStock = new ArrayList<>();
	public ArrayList<Product> tridentStock = new ArrayList<>();
	public ArrayList<Product> bigRedStock = new ArrayList<>();
	public ArrayList<Product> extraStock = new ArrayList<>();
	public ArrayList<Product> wrigleysStock = new ArrayList<>();
	public ArrayList<Product> cocaColaStock = new ArrayList<>();
	public ArrayList<Product> spriteStock = new ArrayList<>();
	public ArrayList<Product> minuteMaidStock = new ArrayList<>();
	public ArrayList<Product> dasaniStock = new ArrayList<>();
	public ArrayList<Product> cart = new ArrayList<>();
	public TransactionProcessing myBank = new TransactionProcessing(0.00, 0.00, 100.00, 0.00);
	
	public StringBuilder currentPassword = new StringBuilder("1" + "2" + "3" + "4");
	public StringBuilder passwordAttempt = new StringBuilder();

	public Dispenser() {
		this.createVendingMachine();
	}

	public Dispenser(String name, int slotMax) {
		this.name = name;
		this.slotMax = slotMax;
		this.createVendingMachine();

	}

	public void setSlotMax(int slotMax) {
		this.slotMax = slotMax;
	}

	public int getSlotMax() {
		return slotMax;
	}
	

	// call dispense() of item to adjust currentStock and gets the price of
	// that item and adds the value to income. Adjusts credit value and change 
	// as needed and for display purposes.

	public void dispense(int numSelected, ArrayList<Product> arrayList, Dispenser dispenser) {
		if(arrayList.size() != 0){
			dispenser.cart.add((Product) arrayList.get(0));
		dispenser.myInventoryManager.reduceInventory(arrayList);
		double newTotal = dispenser.total + dispenser.products.get(numSelected).getPrice();
		dispenser.total = newTotal;
		dispenser.myBank.setChange(dispenser.myBank.getCreditAvailable() - dispenser.products.get(numSelected).getPrice());
		dispenser.myBank.setCreditAvailable(dispenser.myBank.getChange());
		dispenser.myBank.setIncome(dispenser.myBank.getIncome() + dispenser.products.get(numSelected).getPrice());
		} else {
			return;
		}
	}
	
	public String displayProducts(){
		return products.toString();
		}
	
	public String displayCart(){
		return cart.toString();
	}

	
	public void createVendingMachine() {
		for(int i = 0; i < slotMax; i++){

		Snack lays = new Chips("Lays", 1.00, 1, this.name);
		Snack sunChips = new Chips("Sun Chips", 1.00, 1, this.name);
		Snack doritos = new Chips("Doritos", 1.00, 1, this.name);
		Snack missVickies = new Chips("Miss Vickie's", 1.00, 1, this.name);
		Snack skittles = new Candy("Skittles", 1.50, 1, this.name);
		Snack snickers = new Candy("Snicker", 1.50, 1, this.name);
		Snack starburst = new Candy("Starburst", 1.50, 1, this.name);
		Snack mandM = new Gum("M&M's", 1.50, 1, this.name);
		Snack bigRed = new Gum("Big Red", 1.00, 1, this.name);
		Snack trident = new Gum("Trident", 1.00, 1, this.name);
		Snack extra = new Gum("Extra", 1.00, 1, this.name);
		Snack wrigleys = new Gum("Wrigley's", 1.00, 1, this.name);
		Drink cocaCola = new Drink("Coca-Cola", 1.50, 1, this.name);
		Drink sprite = new Drink("Sprite", 1.50, 1, this.name);
		Drink minuteMaid = new Drink("Minute Maid", 2.00, 1, this.name);
		Drink dasani = new Drink("Dasani", 1.00, 1, this.name);
		
		laysStock.add(lays);
		sunChipsStock.add(sunChips);
		doritosStock.add(doritos);
		missVickiesStock.add(missVickies);
		skittlesStock.add(skittles);
		snickersStock.add(snickers);
		starburstStock.add(starburst);
		mandMStock.add(mandM);
		bigRedStock.add(bigRed);
		tridentStock.add(trident);
		extraStock.add(extra);
		wrigleysStock.add(wrigleys);
		cocaColaStock.add(cocaCola);
		spriteStock.add(sprite);
		minuteMaidStock.add(minuteMaid);
		dasaniStock.add(dasani);
		products.add(lays);
		products.add(sunChips);
		products.add(doritos);
		products.add(missVickies);
		products.add(skittles);
		products.add(snickers);
		products.add(starburst);
		products.add(mandM);
		products.add(bigRed);
		products.add(trident);
		products.add(extra);
		products.add(wrigleys);
		products.add(cocaCola);
		products.add(sprite);
		products.add(minuteMaid);
		products.add(dasani);

		}

	}
	

	
	public void restoreDefaultPassword(){
		currentPassword.setLength(0);
		currentPassword.append("1");
		currentPassword.append("2");
		currentPassword.append("3");
		currentPassword.append("4");
	}
	
	public void resetPasswordAttempt(){
		passwordAttempt.setLength(0);
	}
	
	

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Vend-O-matic 6000!");
		Dispenser dispenser = new Dispenser("Vend-O-Matic 6000", 20);
		
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
				dispenser.dispense(12, dispenser.cocaColaStock, dispenser);
				homeCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				drinkCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				chipsCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				candyCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				gumCreditText.setText("Credit: $" + dispenser.myBank.getCreditAvailable() + "0");
				if(dispenser.cocaColaStock.size() != 0)
					Restock.checkInventory(dispenser.cocaColaStock, dispenser);
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
			dispenser.dispense(13, dispenser.spriteStock, dispenser);
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
			dispenser.dispense(14, dispenser.minuteMaidStock, dispenser);
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
			dispenser.dispense(15, dispenser.dasaniStock, dispenser);
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
			dispenser.dispense(2, dispenser.doritosStock, dispenser);
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
			dispenser.dispense(0, dispenser.laysStock, dispenser);
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
			dispenser.dispense(1, dispenser.sunChipsStock, dispenser);
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
			dispenser.dispense(3, dispenser.missVickiesStock, dispenser);
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
			dispenser.dispense(6, dispenser.starburstStock, dispenser);
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
			dispenser.dispense(4, dispenser.skittlesStock, dispenser);
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
			dispenser.dispense(5, dispenser.snickersStock, dispenser);
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
			dispenser.dispense(7, dispenser.mandMStock, dispenser);
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
			dispenser.dispense(9, dispenser.tridentStock, dispenser);
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
			dispenser.dispense(10, dispenser.extraStock, dispenser);
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
			dispenser.dispense(11, dispenser.wrigleysStock, dispenser);
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
			dispenser.dispense(8, dispenser.bigRedStock, dispenser);
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
			dispenser.myBank.setChangeAvailable(dispenser.myBank.getChangeAvailable() - dispenser.myBank.getChange());
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
		
		inventoryButton = new Button("Vend-O-Matic 6000 Inventory");
		GridPane.setConstraints(inventoryButton, 0, 1);
		inventoryButton.setMinSize(250.0, 50.0);
		inventoryButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		inventoryButton.setOnAction(e -> {
			inventoryText.setText("Current Inventory: \n\n" + "Lays" + ": " + dispenser.laysStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" + 
						((dispenser.slotMax - dispenser.laysStock.size()) * .5) + "0\n"
					+ "Doritos" + ": " + dispenser.doritosStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.doritosStock.size()) * .5) + "0\n"
					+ "Sun Chips" + ": " + dispenser.sunChipsStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.sunChipsStock.size()) * .5) + "0\n"
					+ "Miss Vickie's" + ": " + dispenser.missVickiesStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.missVickiesStock.size()) * .5) + "0\n"
					+ "Skittles" + ": " + dispenser.skittlesStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.skittlesStock.size()) * .5) + "0\n"
					+ "Snickers" + ": " + dispenser.snickersStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.snickersStock.size()) * .5) + "0\n"
					+ "M&M's" + ": " + dispenser.mandMStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.mandMStock.size()) * .5) + "0\n"
					+ "Starburst" + ": " + dispenser.starburstStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.starburstStock.size()) * .5) + "0\n"
					+ "Trident" + ": " + dispenser.tridentStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.tridentStock.size()) * .5) + "0\n"
					+ "Big Red" + ": " + dispenser.bigRedStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.bigRedStock.size()) * .5) + "0\n"
					+ "Extra" + ": " + dispenser.extraStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.extraStock.size()) * .5) + "0\n"
					+ "Wrigleys" + ": " + dispenser.wrigleysStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.wrigleysStock.size()) * .5) + "0\n"
					+ "Coca-Cola" + ": " + dispenser.cocaColaStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.cocaColaStock.size()) * .5) + "0\n"
					+ "Sprite" + ": " + dispenser.spriteStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.spriteStock.size()) * .5) + "0\n"
					+ "Minute Maid" + ": " + dispenser.minuteMaidStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.minuteMaidStock.size()) * .5) + "0\n"
					+ "Dasani" + ": " + dispenser.dasaniStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((dispenser.slotMax - dispenser.dasaniStock.size()) * .5) + "0\n");
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
		

		Label addMoneyWelcomeLabel = new Label("\t\t Welcome!\n \tPlease deposit cash.");
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
		
		loginButton = new Button("Admin Login");
		loginButton.setMinSize(250,  50);
		GridPane.setConstraints(loginButton, 1, 0);
		loginButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		loginButton.setOnAction(e -> window.setScene(login));
		
		
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
		
		bossHomeBackButton = new Button ("Back to Main Menu");
		bossHomeBackButton.setMinSize(250, 50);
		GridPane.setConstraints(bossHomeBackButton, 0, 0);
		bossHomeBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		bossHomeBackButton.setOnAction(e -> window.setScene(addMoney));
		
		loginCancelButton = new Button ("Cancel");
		loginCancelButton.setMinSize(315, 50);
		loginCancelButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		loginCancelButton.setOnAction(e -> window.setScene(addMoney));
		GridPane.setConstraints(loginCancelButton, 1, 6, 3, 1);
		
		loginOneButton = new Button ("1");
		loginOneButton.setMinSize(100, 100);
		loginOneButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginOneButton.setOnAction(e -> dispenser.passwordAttempt.append("1"));
		GridPane.setConstraints(loginOneButton, 1, 2);
		
		loginTwoButton = new Button ("2");
		loginTwoButton.setMinSize(100, 100);
		loginTwoButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginTwoButton.setOnAction(e -> dispenser.passwordAttempt.append("2"));
		GridPane.setConstraints(loginTwoButton, 2, 2);
		
		loginThreeButton = new Button ("3");
		loginThreeButton.setMinSize(100, 100);
		loginThreeButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginThreeButton.setOnAction(e -> dispenser.passwordAttempt.append("3"));
		GridPane.setConstraints(loginThreeButton, 3, 2);
		
		loginFourButton = new Button ("4");
		loginFourButton.setMinSize(100, 100);
		loginFourButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginFourButton.setOnAction(e -> dispenser.passwordAttempt.append("4"));
		GridPane.setConstraints(loginFourButton, 1, 3);
		
		loginFiveButton = new Button ("5");
		loginFiveButton.setMinSize(100, 100);
		loginFiveButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginFiveButton.setOnAction(e -> dispenser.passwordAttempt.append("5"));
		GridPane.setConstraints(loginFiveButton, 2, 3);
		
		loginSixButton = new Button ("6");
		loginSixButton.setMinSize(100, 100);
		loginSixButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginSixButton.setOnAction(e -> dispenser.passwordAttempt.append("6"));
		GridPane.setConstraints(loginSixButton, 3, 3);
		
		loginSevenButton = new Button ("7");
		loginSevenButton.setMinSize(100, 100);
		loginSevenButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginSevenButton.setOnAction(e -> dispenser.passwordAttempt.append("7"));
		GridPane.setConstraints(loginSevenButton, 1, 4);
		
		loginEightButton = new Button ("8");
		loginEightButton.setMinSize(100, 100);
		loginEightButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginEightButton.setOnAction(e -> dispenser.passwordAttempt.append("8"));
		GridPane.setConstraints(loginEightButton, 2, 4);
		
		loginNineButton = new Button ("9");
		loginNineButton.setMinSize(100, 100);
		loginNineButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 50px;");
		loginNineButton.setOnAction(e -> dispenser.passwordAttempt.append("9"));
		GridPane.setConstraints(loginNineButton, 3, 4);
		
		Label wrongPassword = new Label("Password incorrect, try again.");
		
		loginSubmitButton = new Button ("Submit");
		loginSubmitButton.setMinSize(315, 50);
		GridPane.setConstraints(loginSubmitButton, 1, 5, 3, 1);
		loginSubmitButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		loginSubmitButton.setOnAction(e -> {
			if(dispenser.currentPassword.toString().equals(dispenser.passwordAttempt.toString())){
				window.setScene(bossHome);
				dispenser.passwordAttempt.setLength(0);
			}else{
				dispenser.resetPasswordAttempt();
				ReceiptBox.display(wrongPassword);
			}
		});
		
		Global_Inventory_Management.readInFiles(Global_Inventory_Management.InventoryFile);
		StringBuilder vendOMatic5000Inventory = new StringBuilder();
		for (int i = 0; i < Global_Inventory_Management.allProducts.size(); i++){
			vendOMatic5000Inventory.append(Global_Inventory_Management.readInProducts[i].getName());
			vendOMatic5000Inventory.append(": Quantity: ");
			vendOMatic5000Inventory.append(Global_Inventory_Management.readInProducts[i].getQuantity());
			vendOMatic5000Inventory.append(" Location: ");
			vendOMatic5000Inventory.append(Global_Inventory_Management.readInProducts[i].getLocation());
			vendOMatic5000Inventory.append("\n");
		}
			
		myVendingMachinesButton = new Button ("My Machines");
		myVendingMachinesButton.setMinSize(250, 50);
		GridPane.setConstraints(myVendingMachinesButton, 0, 1);
		myVendingMachinesButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		myVendingMachinesButton.setOnAction(e -> window.setScene(myVendingMachines));
		
		vendingMachineFromCSVButton = new Button("Vend-O-Matic 5000 Inventory");
		vendingMachineFromCSVButton.setMinSize(250, 50);
		GridPane.setConstraints(vendingMachineFromCSVButton, 0, 2);
		vendingMachineFromCSVButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		vendingMachineFromCSVButton.setOnAction(e -> {
			String newText = vendOMatic5000Inventory.toString();
			inventoryText.setText(newText);
			ReceiptBox.display(inventoryText);
		});
		
		myMachinesBackButton = new Button("Back");
		GridPane.setConstraints(myMachinesBackButton, 0, 5);
		myMachinesBackButton.setMinSize(250,  50);
		myMachinesBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		myMachinesBackButton.setOnAction(e -> window.setScene(bossHome));
		
		simulationButton = new Button("Simulation");
		GridPane.setConstraints(simulationButton, 2, 0);
		simulationButton.setMinSize(250, 50);
		simulationButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		myMachinesBackButton.setOnAction(e -> window.setScene(bossHome));
		simulationButton.setOnAction(e -> {
			CustomerDisplay display = new CustomerDisplay();
			try {
				display.start(primaryStage);
			} catch (Exception e1) {
				
				e1.printStackTrace();
			}
		});
		
		Label restockSummary = new Label();
		
		restockButton = new Button("Restock");
		GridPane.setConstraints(restockButton, 0, 2);
		restockButton.setMinSize(250, 50);
		restockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		restockButton.setOnAction(e -> window.setScene(restockScene));
		
		
		laysRestockButton = new Button("Restock Lays");
		GridPane.setConstraints(laysRestockButton, 0, 1);
		laysRestockButton.setMinSize(250, 50);
		laysRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		laysRestockButton.setOnAction(e -> {
			if(dispenser.laysStock.size() > 0){
				int onHand = dispenser.laysStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.laysStock, dispenser);
				int newOnHand = dispenser.laysStock.size();
				double restockCost = toRestock * (dispenser.laysStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		doritosRestockButton = new Button("Restock Doritos");
		GridPane.setConstraints(doritosRestockButton, 0, 2);
		doritosRestockButton.setMinSize(250, 50);
		doritosRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		doritosRestockButton.setOnAction(e -> {
			if(dispenser.doritosStock.size() > 0){
				int onHand = dispenser.doritosStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.doritosStock, dispenser);
				int newOnHand = dispenser.doritosStock.size();
				double restockCost = toRestock * (dispenser.doritosStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		missVickiesRestockButton = new Button("Restock Miss Vickie's");
		GridPane.setConstraints(missVickiesRestockButton, 0, 3);
		missVickiesRestockButton.setMinSize(250, 50);
		missVickiesRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		missVickiesRestockButton.setOnAction(e -> {
			if(dispenser.missVickiesStock.size() > 0){
				int onHand = dispenser.missVickiesStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.missVickiesStock, dispenser);
				int newOnHand = dispenser.missVickiesStock.size();
				double restockCost = toRestock * (dispenser.missVickiesStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		sunChipsRestockButton = new Button("Restock Sun Chips");
		GridPane.setConstraints(sunChipsRestockButton, 0, 4);
		sunChipsRestockButton.setMinSize(250, 50);
		sunChipsRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		sunChipsRestockButton.setOnAction(e -> {
			if(dispenser.sunChipsStock.size() > 0){
				int onHand = dispenser.sunChipsStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.sunChipsStock, dispenser);
				int newOnHand = dispenser.sunChipsStock.size();
				double restockCost = toRestock * (dispenser.sunChipsStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		mandmRestockButton = new Button("Restock M&M's");
		GridPane.setConstraints(mandmRestockButton, 0, 5);
		mandmRestockButton.setMinSize(250, 50);
		mandmRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		mandmRestockButton.setOnAction(e -> {
			if(dispenser.mandMStock.size() > 0){
				int onHand = dispenser.mandMStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.mandMStock, dispenser);
				int newOnHand = dispenser.mandMStock.size();
				double restockCost = toRestock * (dispenser.mandMStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		snickersRestockButton = new Button("Restock Snickers");
		GridPane.setConstraints(snickersRestockButton, 0, 6);
		snickersRestockButton.setMinSize(250, 50);
		snickersRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		snickersRestockButton.setOnAction(e -> {
			if(dispenser.snickersStock.size() > 0){
				int onHand = dispenser.snickersStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.snickersStock, dispenser);
				int newOnHand = dispenser.snickersStock.size();
				double restockCost = toRestock * (dispenser.snickersStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		starburstRestockButton = new Button("Restock Starburst");
		GridPane.setConstraints(starburstRestockButton, 0, 7);
		starburstRestockButton.setMinSize(250, 50);
		starburstRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		starburstRestockButton.setOnAction(e -> {
			if(dispenser.starburstStock.size() > 0){
				int onHand = dispenser.starburstStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.starburstStock, dispenser);
				int newOnHand = dispenser.starburstStock.size();
				double restockCost = toRestock * (dispenser.starburstStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		skittlesRestockButton = new Button("Restock Skittles");
		GridPane.setConstraints(skittlesRestockButton, 0, 8);
		skittlesRestockButton.setMinSize(250, 50);
		skittlesRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		skittlesRestockButton.setOnAction(e -> {
			if(dispenser.skittlesStock.size() > 0){
				int onHand = dispenser.skittlesStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.skittlesStock, dispenser);
				int newOnHand = dispenser.skittlesStock.size();
				double restockCost = toRestock * (dispenser.skittlesStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		tridentRestockButton = new Button("Restock Trident");
		GridPane.setConstraints(tridentRestockButton, 1, 1);
		tridentRestockButton.setMinSize(250, 50);
		tridentRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		tridentRestockButton.setOnAction(e -> {
			if(dispenser.tridentStock.size() > 0){
				int onHand = dispenser.tridentStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.tridentStock, dispenser);
				int newOnHand = dispenser.tridentStock.size();
				double restockCost = toRestock * (dispenser.tridentStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		bigRedRestockButton = new Button("Restock Big Red");
		GridPane.setConstraints(bigRedRestockButton, 1, 2);
		bigRedRestockButton.setMinSize(250, 50);
		bigRedRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		bigRedRestockButton.setOnAction(e -> {
			if(dispenser.bigRedStock.size() > 0){
				int onHand = dispenser.bigRedStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.bigRedStock, dispenser);
				int newOnHand = dispenser.bigRedStock.size();
				double restockCost = toRestock * (dispenser.bigRedStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		wrigleysRestockButton = new Button("Restock Wrigley's");
		GridPane.setConstraints(wrigleysRestockButton, 1, 3);
		wrigleysRestockButton.setMinSize(250, 50);
		wrigleysRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		wrigleysRestockButton.setOnAction(e -> {
			if(dispenser.wrigleysStock.size() > 0){
				int onHand = dispenser.wrigleysStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.wrigleysStock, dispenser);
				int newOnHand = dispenser.wrigleysStock.size();
				double restockCost = toRestock * (dispenser.wrigleysStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		extraRestockButton = new Button("Restock Wrigley's");
		GridPane.setConstraints(extraRestockButton, 1, 4);
		extraRestockButton.setMinSize(250, 50);
		extraRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		extraRestockButton.setOnAction(e -> {
			if(dispenser.extraStock.size() > 0){
				int onHand = dispenser.extraStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.extraStock, dispenser);
				int newOnHand = dispenser.extraStock.size();
				double restockCost = toRestock * (dispenser.extraStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		cocaColaRestockButton = new Button("Restock Coca-Cola");
		GridPane.setConstraints(cocaColaRestockButton, 1, 5);
		cocaColaRestockButton.setMinSize(250, 50);
		cocaColaRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		cocaColaRestockButton.setOnAction(e -> {
			if(dispenser.cocaColaStock.size() > 0){
				int onHand = dispenser.cocaColaStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.cocaColaStock, dispenser);
				int newOnHand = dispenser.cocaColaStock.size();
				double restockCost = toRestock * (dispenser.cocaColaStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.total + (dispenser.myBank.getIncome() - restockCost));
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		spriteRestockButton = new Button("Restock Sprite");
		GridPane.setConstraints(spriteRestockButton, 1, 6);
		spriteRestockButton.setMinSize(250, 50);
		spriteRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		spriteRestockButton.setOnAction(e -> {
			if(dispenser.laysStock.size() > 0){
				int onHand = dispenser.spriteStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.spriteStock, dispenser);
				int newOnHand = dispenser.spriteStock.size();
				double restockCost = toRestock * (dispenser.spriteStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		minuteMaidRestockButton = new Button("Restock Minute Maid");
		GridPane.setConstraints(minuteMaidRestockButton, 1, 7);
		minuteMaidRestockButton.setMinSize(250, 50);
		minuteMaidRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		minuteMaidRestockButton.setOnAction(e -> {
			if(dispenser.minuteMaidStock.size() > 0){
				int onHand = dispenser.minuteMaidStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.minuteMaidStock, dispenser);
				int newOnHand = dispenser.minuteMaidStock.size();
				double restockCost = toRestock * (dispenser.minuteMaidStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		
		dasaniRestockButton = new Button("Restock Dasani");
		GridPane.setConstraints(dasaniRestockButton, 1, 8);
		dasaniRestockButton.setMinSize(250, 50);
		dasaniRestockButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		dasaniRestockButton.setOnAction(e -> {
			if(dispenser.dasaniStock.size() > 0){
				int onHand = dispenser.dasaniStock.size();
				int toRestock = dispenser.slotMax - onHand;
				dispenser.myInventoryManager.restock(dispenser.dasaniStock, dispenser);
				int newOnHand = dispenser.dasaniStock.size();
				double restockCost = toRestock * (dispenser.dasaniStock.get(0).getPrice() / 2);
				dispenser.myBank.setIncome(dispenser.myBank.getIncome() - restockCost);
				restockSummary.setText("Lays currently on hand: " + onHand + "\nQuantity ordered: " + toRestock + "\nNew quantity: " + newOnHand + "\n\nTotal Cost: "
						+ restockCost);
				ReceiptBox.display(restockSummary);
			}else{
				restockSummary.setText("List is empty");
				ReceiptBox.display(restockSummary);
			}
		});
		
		restockBackButton = new Button("Back");
		GridPane.setConstraints(restockBackButton, 0, 0);
		restockBackButton.setMinSize(150, 50);
		restockBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		restockBackButton.setOnAction(e -> window.setScene(bossHome));
		
		Label bankInfoLabel = new Label();
		
		bankBackButton = new Button("Back");
		GridPane.setConstraints(bankBackButton, 0, 0);
		bankBackButton.setMinSize(150, 50);
		bankBackButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		bankBackButton.setOnAction(e -> window.setScene(bossHome));
		
		bankButton = new Button("Bank");
		GridPane.setConstraints(bankButton, 0, 4);
		bankButton.setMinSize(250, 50);
		bankButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		bankButton.setOnAction(e -> window.setScene(bankScene));
		
		profitsButton = new Button("Profits");
		GridPane.setConstraints(profitsButton, 0, 1);
		profitsButton.setMinSize(250, 50);
		profitsButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		profitsButton.setOnAction(e -> {
			double profits = dispenser.myBank.getIncome();
			bankInfoLabel.setText("Vend-O-Matic 6000! profits to date: $" + Double.toString(profits) + "0");
			ReceiptBox.display(bankInfoLabel);
		});
		
		changeAvailableButton = new Button("Change Available");
		GridPane.setConstraints(changeAvailableButton, 0, 2);
		changeAvailableButton.setMinSize(250, 50);
		changeAvailableButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
				"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
		changeAvailableButton.setOnAction(e -> {
			double changeAvailable = dispenser.myBank.getChangeAvailable();
			bankInfoLabel.setText("Vend-O-Matic 6000! change available: $" + Double.toString(changeAvailable) + "0");
			ReceiptBox.display(bankInfoLabel);
		});
		
		
		Label enterPinLabel = new Label("Enter your PIN");
		GridPane.setConstraints(enterPinLabel, 1, 1, 3, 1);
		enterPinLabel.setStyle("-fx-font: 48 arial;");
		
		
	
		Label creditText = new Label();
		GridPane.setConstraints(creditText, 1, 0);
		
		//Displays Welcome text
		Label homeLabel = new Label("  Choose A Category!");
		GridPane.setConstraints(homeLabel, 1, 1, 2, 1);
		homeLabel.setAlignment(Pos.CENTER);
		homeLabel.setStyle("-fx-font: 50 arial;");
		homeLabel.setMinSize(100, 100);
		
		Image backgroundImage = new Image(getClass().getResourceAsStream("bluespots.jpg"));
		
		BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);
		Background newBackground = new Background(background);
		
		GridPane bankLayout = new GridPane();
		bankLayout.setPadding(new Insets(10, 10, 10, 10));
		bankLayout.setVgap(10);
		bankLayout.setHgap(8);
		bankLayout.setBackground(newBackground);
		bankLayout.setAlignment(Pos.CENTER);
		bankLayout.getChildren().addAll(bankBackButton, profitsButton, changeAvailableButton);
		
		GridPane restockHomeLayout = new GridPane();
		restockHomeLayout.setPadding(new Insets(10, 10, 10, 10));
		restockHomeLayout.setVgap(10);
		restockHomeLayout.setHgap(8);
		restockHomeLayout.setAlignment(Pos.CENTER);
		restockHomeLayout.setBackground(newBackground);
		restockHomeLayout.getChildren().addAll(laysRestockButton, doritosRestockButton, missVickiesRestockButton, sunChipsRestockButton, mandmRestockButton,
				snickersRestockButton, starburstRestockButton, skittlesRestockButton, tridentRestockButton, bigRedRestockButton, wrigleysRestockButton,
				extraRestockButton, cocaColaRestockButton, spriteRestockButton, minuteMaidRestockButton, dasaniRestockButton, restockBackButton);
		
		
		//Sets the layout for the home screen.
		GridPane homeLayout = new GridPane();
		homeLayout.setPadding(new Insets(10, 10, 10, 10));
		homeLayout.setVgap(10);
		homeLayout.setHgap(8);
		homeLayout.setAlignment(Pos.CENTER);
		homeLayout.setBackground(newBackground);
		homeLayout.getChildren().addAll(drinksButton, chipsButton, candyButton, gumButton, homeLabel, doneButton, cancelButton, homeCreditText, cartHomeButton, 
				addFundsButton);
		
		//Sets the layout for the drinks screen.
		GridPane drinksLayout = new GridPane();
		drinksLayout.setPadding(new Insets(10, 10, 10, 10));
		drinksLayout.setVgap(10);
		drinksLayout.setHgap(8);
		drinksLayout.setAlignment(Pos.CENTER);
		drinksLayout.setBackground(newBackground);
		drinksLayout.getChildren().addAll(dasaniButton, spriteButton, cocaColaButton,  minuteMaidButton, drinksBackButton, drinkCreditText, cartDrinksButton);
		
		//Sets the layout for the chips screen.
		GridPane chipsLayout = new GridPane();
		chipsLayout.setPadding(new Insets(10, 10, 10, 10));
		chipsLayout.setVgap(10);
		chipsLayout.setHgap(8);
		chipsLayout.setAlignment(Pos.CENTER);
		chipsLayout.setBackground(newBackground);
		chipsLayout.getChildren().addAll(laysButton, missVickiesButton, doritosButton, sunChipsButton, chipsBackButton, chipsCreditText, cartChipsButton);
		
		//Sets the layout for the candy screen.
		GridPane candyLayout = new GridPane();
		candyLayout.setPadding(new Insets(10, 10, 10, 10));
		candyLayout.setVgap(10);
		candyLayout.setHgap(8);
		candyLayout.setAlignment(Pos.CENTER);
		candyLayout.setBackground(newBackground);
		candyLayout.getChildren().addAll(skittlesButton, mandMButton, candyBackButton, snickersButton, starburstButton, candyCreditText, cartCandyButton);
		
		//Sets the layout for the gum screen.
		GridPane gumLayout = new GridPane();
		gumLayout.setPadding(new Insets(10, 10, 10, 10));
		gumLayout.setVgap(10);
		gumLayout.setHgap(8);
		gumLayout.setAlignment(Pos.CENTER);
		gumLayout.setBackground(newBackground);
		gumLayout.getChildren().addAll( extraButton, bigRedButton, gumBackButton, wrigleysButton, tridentButton, gumCreditText, cartGumButton);
		
		GridPane inventoryLayout = new GridPane();
		inventoryLayout.setPadding(new Insets(10, 10, 10, 10));
		inventoryLayout.setVgap(10);
		inventoryLayout.setHgap(8);
		inventoryLayout.setAlignment(Pos.CENTER);
		inventoryLayout.setBackground(newBackground);
		inventoryLayout.getChildren().addAll(inventoryText, inventoryBackButton);
		
		GridPane insertMoney = new GridPane();
		insertMoney.setPadding(new Insets(10, 10, 10, 10));
		insertMoney.setVgap(10);
		insertMoney.setHgap(8);
		insertMoney.setAlignment(Pos.CENTER);
		insertMoney.setBackground(newBackground);
		insertMoney.getChildren().addAll(simulationButton, oneDollarButton, fiveDollarButton, tenDollarButton, twentyDollarButton, addMoneyWelcomeLabel, loginButton);
		
		GridPane loginGrid = new GridPane();
		loginGrid.setPadding(new Insets(10, 10, 10, 10));
		loginGrid.setVgap(10);
		loginGrid.setHgap(8);
		loginGrid.setAlignment(Pos.CENTER);
		loginGrid.setBackground(newBackground);
		loginGrid.getChildren().addAll(loginOneButton, loginTwoButton, loginThreeButton, loginFourButton, loginFiveButton, loginSixButton, loginSevenButton,
				loginEightButton, loginNineButton, loginCancelButton, loginSubmitButton, enterPinLabel);
		
		GridPane bossHomeGrid = new GridPane();
		bossHomeGrid.setPadding(new Insets(10, 10, 10, 10));
		bossHomeGrid.setVgap(10);
		bossHomeGrid.setHgap(8);
		bossHomeGrid.setAlignment(Pos.CENTER);
		bossHomeGrid.setBackground(newBackground);
		bossHomeGrid.getChildren().addAll(bossHomeBackButton, myVendingMachinesButton, restockButton, bankButton);
		
		GridPane myVendingMachinesGrid = new GridPane();
		myVendingMachinesGrid.setPadding(new Insets(10, 10, 10, 10));
		myVendingMachinesGrid.setVgap(10);
		myVendingMachinesGrid.setHgap(8);
		myVendingMachinesGrid.setAlignment(Pos.CENTER);
		myVendingMachinesGrid.setBackground(newBackground);
		myVendingMachinesGrid.getChildren().addAll(inventoryButton, vendingMachineFromCSVButton, myMachinesBackButton);
		
		
		//Different screens in this application. Sets layout to each scene and defines the screen size.
		home = new Scene(homeLayout, 545, 740);
		drinks = new Scene(drinksLayout, 545, 740);
		chips = new Scene(chipsLayout, 545, 740);
		candy = new Scene(candyLayout, 545, 740);
		gum = new Scene(gumLayout, 545, 740);
		inventory = new Scene(inventoryLayout, 545, 740);
		addMoney = new Scene(insertMoney, 545, 740);
		login = new Scene(loginGrid, 545, 740);
		bossHome = new Scene(bossHomeGrid, 545, 740);
		myVendingMachines = new Scene(myVendingMachinesGrid, 545, 740);
		restockScene = new Scene(restockHomeLayout, 545, 740);
		bankScene = new Scene(bankLayout, 545, 740);
	
		
		//Sets the home screen to display on start.
		primaryStage.setScene(addMoney);
		primaryStage.show();

	}
	
	
	public static void main(String[] args){
		launch(args);
	}
}
