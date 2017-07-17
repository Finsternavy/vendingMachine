package vendingMachine;


import javafx.scene.paint.Color;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Screen;
import javafx.stage.Stage;
import vendingMachineGUIBoss.ReceiptBox;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.util.Duration;


public class CustomerDisplay extends Application {
	
	Stage window;
	Scene animationScene, startSimulationScene;
	GridPane animationPane, startPane;
	Button startSimulationButton;
	TextField customersPurchaseLabel;
	Label purchasedLabel, inventoryLabel;
	private Timeline timeline;
	private AnimationTimer timer;
	private Integer i = 0;

public void start(Stage primaryStage) throws Exception{
	

	
	final Circle circle = new Circle(20.0);
	circle.setFill(Color.RED);
	
	Text text = new Text(i.toString());
	text.setStroke(Color.BLACK);
	
	Rectangle rectangle = new Rectangle();
	rectangle.setFill(Color.BLUE);
	
	Text vendingMachineText = new Text("Vend-O-Matic 6000!");
	vendingMachineText.setStroke(Color.WHITE);;
	

	
	TranslateTransition nextPlaceInLineCircle = new TranslateTransition();
	nextPlaceInLineCircle.setDuration(Duration.seconds(5));
	nextPlaceInLineCircle.setCycleCount(1);
	nextPlaceInLineCircle.setAutoReverse(false);
	nextPlaceInLineCircle.setFromX(-200);
	nextPlaceInLineCircle.setFromY(250);
	nextPlaceInLineCircle.setToX(190);
	nextPlaceInLineCircle.setToY(250);
	nextPlaceInLineCircle.setNode(circle);
	
	TranslateTransition nextPlaceInLineText = new TranslateTransition();
	nextPlaceInLineText.setDuration(Duration.seconds(5));
	nextPlaceInLineText.setCycleCount(1);
	nextPlaceInLineText.setAutoReverse(false);
	nextPlaceInLineText.setFromX(-210);
	nextPlaceInLineText.setFromY(215);
	nextPlaceInLineText.setToX(180);
	nextPlaceInLineText.setToY(215);
	nextPlaceInLineText.setNode(text);
	
	TranslateTransition waitCircle = new TranslateTransition();
	waitCircle.setDuration(Duration.seconds(5));
	waitCircle.setCycleCount(1);
	waitCircle.setAutoReverse(false);
	waitCircle.setFromX(190);
	waitCircle.setFromY(250);
	waitCircle.setToX(190);
	waitCircle.setToY(250);
	waitCircle.setNode(circle);
	
	TranslateTransition waitText = new TranslateTransition();
	waitText.setDuration(Duration.seconds(5));
	waitText.setCycleCount(1);
	waitText.setAutoReverse(false);
	waitText.setFromX(180);
	waitText.setFromY(215);
	waitText.setToX(180);
	waitText.setToY(215);
	waitText.setNode(text);
	
	TranslateTransition leaveScreenCircle = new TranslateTransition();
	leaveScreenCircle.setDuration(Duration.seconds(3));
	leaveScreenCircle.setFromX(190);
	leaveScreenCircle.setFromY(250);
	leaveScreenCircle.setToX(190);
	leaveScreenCircle.setToY(735);
	leaveScreenCircle.setAutoReverse(false);
	leaveScreenCircle.setNode(circle);
	
	TranslateTransition leaveScreenText = new TranslateTransition();
	leaveScreenText.setDuration(Duration.seconds(3));
	leaveScreenText.setFromX(180);
	leaveScreenText.setFromY(215);
	leaveScreenText.setToX(180);
	leaveScreenText.setToY(700);
	leaveScreenText.setAutoReverse(false);
	leaveScreenText.setNode(text);
	
	
	
	ParallelTransition pt = new ParallelTransition(nextPlaceInLineCircle, nextPlaceInLineText);
	ParallelTransition pt2 = new ParallelTransition(waitCircle, waitText);
	ParallelTransition pt3 = new ParallelTransition(leaveScreenCircle, leaveScreenText);
	
	SequentialTransition seqTransition = new SequentialTransition(pt, pt2, pt3);
	seqTransition.setCycleCount(30);

	
	//Button event that starts the queue
	
	ProcessCustomerQueue queueProcessor = new ProcessCustomerQueue();
	queueProcessor.readInFiles(queueProcessor.CustomerQueue);
	window = primaryStage;
	window.setTitle("Vend-O-matic 6000 in action!");
	
	startSimulationButton = new Button("Start Simulation");
	GridPane.setConstraints(startSimulationButton, 0, 0);
	startSimulationButton.setStyle("-fx-background-color: #3c7fb1, linear-gradient(#fafdfe, #e8f5fc), linear-gradient(#eaf6fd 0%, #d9f0fc 49%, #bee6fd 50%, #a7d9f5 100%);" +
			"-fx-background-insets: 0,1,2; -fx-background-radius: 3,2,1; -fx-padding: 3 30 3 30; -fx-text-fill: black; -fx-font-size: 14px;");
	startSimulationButton.setOnAction(e -> {
		window.setScene(animationScene);
		
		while(!queueProcessor.allCustomers.isEmpty()){
			for(int i = 0; i < queueProcessor.readInCustomers.length; i++){
		String name = "";
		String purchase = "";
		text.setText(queueProcessor.readInCustomers[i].getName());
		seqTransition.play();
		queueProcessor.attemptSale(name, purchase, queueProcessor.dispenser);
		purchasedLabel.setText(name + " " + purchase);
			}
		}
		customersPurchaseLabel.setText(queueProcessor.sb.toString());
		if(queueProcessor.allCustomers.isEmpty()){
			System.out.println(queueProcessor.sb.toString());
			
		}else
		customersPurchaseLabel.setText(queueProcessor.isEmpty());
		inventoryLabel.setText("Current Inventory: \n\n" + "Lays" + ": " + queueProcessor.dispenser.laysStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" + 
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.laysStock.size()) * .5) + "0\n"
					+ "Doritos" + ": " + queueProcessor.dispenser.doritosStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.doritosStock.size()) * .5) + "0\n"
					+ "Sun Chips" + ": " + queueProcessor.dispenser.sunChipsStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.sunChipsStock.size()) * .5) + "0\n"
					+ "Miss Vickie's" + ": " + queueProcessor.dispenser.missVickiesStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.missVickiesStock.size()) * .5) + "0\n"
					+ "Skittles" + ": " + queueProcessor.dispenser.skittlesStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.skittlesStock.size()) * .5) + "0\n"
					+ "Snickers" + ": " + queueProcessor.dispenser.snickersStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.snickersStock.size()) * .5) + "0\n"
					+ "M&M's" + ": " + queueProcessor.dispenser.mandMStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.mandMStock.size()) * .5) + "0\n"
					+ "Starburst" + ": " + queueProcessor.dispenser.starburstStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.starburstStock.size()) * .5) + "0\n"
					+ "Trident" + ": " + queueProcessor.dispenser.tridentStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.tridentStock.size()) * .5) + "0\n"
					+ "Big Red" + ": " + queueProcessor.dispenser.bigRedStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.bigRedStock.size()) * .5) + "0\n"
					+ "Extra" + ": " + queueProcessor.dispenser.extraStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.extraStock.size()) * .5) + "0\n"
					+ "Wrigleys" + ": " + queueProcessor.dispenser.wrigleysStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.wrigleysStock.size()) * .5) + "0\n"
					+ "Coca-Cola" + ": " + queueProcessor.dispenser.cocaColaStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.cocaColaStock.size()) * .5) + "0\n"
					+ "Sprite" + ": " + queueProcessor.dispenser.spriteStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.spriteStock.size()) * .5) + "0\n"
					+ "Minute Maid" + ": " + queueProcessor.dispenser.minuteMaidStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.minuteMaidStock.size()) * .5) + "0\n"
					+ "Dasani" + ": " + queueProcessor.dispenser.dasaniStock.size() + " Location: Vend-O-Matic 6000 Cost to order: $" +
						((queueProcessor.dispenser.slotMax - queueProcessor.dispenser.dasaniStock.size()) * .5) + "0\n");
		ReceiptBox.display(inventoryLabel);
		
	
	});

	
	customersPurchaseLabel = new TextField("Log: \n" + queueProcessor.sb.toString());
	GridPane.setConstraints(customersPurchaseLabel, 0, 0);
	customersPurchaseLabel.setAlignment(Pos.TOP_CENTER);
	
	purchasedLabel = new Label();
	GridPane.setConstraints(purchasedLabel, 0, 0);
	
	inventoryLabel = new Label("");
	GridPane.setConstraints(inventoryLabel, 1, 1);
	
	animationPane = new GridPane();
	animationPane.setPadding(new Insets(10, 10, 10, 10));
	animationPane.setVgap(10);
	animationPane.setHgap(8);
	animationPane.setAlignment(Pos.CENTER);
	animationPane.getChildren().add(purchasedLabel);
	
	startPane = new GridPane();
	startPane.setPadding(new Insets(10, 10, 10, 10));
	startPane.setVgap(10);
	startPane.setHgap(8);
	startPane.setAlignment(Pos.CENTER);
	startPane.getChildren().add(startSimulationButton);
	
	
	GridPane stack = new GridPane();
	stack.getChildren().addAll(customersPurchaseLabel, circle, text);
	stack.setLayoutX(0);
	stack.setLayoutY(0);
	
	Image backgroundImage = new Image(getClass().getResourceAsStream("vendingSceen.png"));
	
	BackgroundImage background = new BackgroundImage(backgroundImage, null, null, null, null);
	Background newBackground = new Background(background);
	
	
	
	stack.setBackground(newBackground);
	
	animationScene = new Scene(stack, 500, 500);
	startSimulationScene = new Scene(startPane, 500, 500);
	window.setScene(startSimulationScene);
	window.show();
	
	
	
	}




	
	public static void main(String[] args){
		launch(args);
	}
}
