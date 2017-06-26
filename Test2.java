package application;

import java.awt.GridLayout;
import java.util.Locale.Category;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;


public class Test2 extends Application {
	
	Stage primaryStage;
	Scene welcome, drinks, chips, candy, gum;
		
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Label home = new Label("welcome");
		Button drinkBtn = new Button("Drinks");
		drinkBtn.setOnAction(e -> primaryStage.setScene(drinks));
		
		VBox layout1 = new VBox(20);
		layout1.getChildren().addAll(home, drinkBtn);
		welcome = new Scene(layout1, 200, 200);
		
		Button chipsBtn = new Button("Chips");
		chipsBtn.setOnAction (e -> primaryStage.setScene(welcome));
		
		StackPane layout2 = new StackPane();
		layout2.getChildren().add(chipsBtn);
		drinks = new Scene(layout2, 200, 200);
		
		primaryStage.setScene(welcome);
		primaryStage.setTitle("Dispencer");
		primaryStage.show();
		
		
	}

}
	