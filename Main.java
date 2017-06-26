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
		
		HBox chbox = getHBox();
		pane.setBottom(chbox);
		
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
		grid.add(category, 4, 0);
		
		ImageView imageDorito = new ImageView(new Image("https://vignette1.wikia.nocookie.net/plantsvszombies/images/c/ce/Doritos-nacho-cheese.png/revision/latest?cb=20150624130919"));
		imageDorito.setFitHeight(150);
		imageDorito.setFitWidth(100);
		grid.add(imageDorito, 1, 1, 2, 1);
		
		ImageView imageLay = new ImageView(new Image("https://vignette4.wikia.nocookie.net/fantendo/images/4/48/Lays_Chips.png/revision/latest?cb=20140225153527"));
		imageLay.setFitHeight(150);
		imageLay.setFitWidth(100);
		grid.add(imageLay, 3, 1, 2, 1);

		ImageView imageSunChip = new ImageView(new Image("http://www.fritolay.com/images/default-source/blue-bag-image/sunchips-harvest-cheddar772e41e0cc54631c95cbff00000d71c6.png?sfvrsn=2"));
		imageSunChip.setFitHeight(150);
		imageSunChip.setFitWidth(100);
		grid.add(imageSunChip, 5, 1, 2, 1);
		
		ImageView imageMissVickie = new ImageView(new Image("http://www.fritolay.com/images/default-source/blue-bag-image/miss-vickies-jalapeno.png?sfvrsn=4"));
		imageMissVickie.setFitHeight(150);
		imageMissVickie.setFitWidth(100);
		grid.add(imageMissVickie, 7, 1, 2, 1);
		
		ImageView imageCoke = new ImageView(new Image("http://www.freepngimg.com/thumb/coca%20cola/15-coca-cola-can-png-image-thumb.png"));
		imageCoke.setFitHeight(150);
		imageCoke.setFitWidth(100);
		grid.add(imageCoke, 1, 2, 2, 1);
		
		ImageView imageSprite = new ImageView(new Image("http://3.bp.blogspot.com/-qyKvkc8tP1Q/T-6qacpvZDI/AAAAAAAABOs/rr6uurTdgd0/s1600/sprite.jpg"));
		imageSprite.setFitHeight(150);
		imageSprite.setFitWidth(100);
		grid.add(imageSprite, 3, 2, 2, 1);
		
		ImageView imageJuice = new ImageView(new Image("http://www.bemidjicoke.com/_assets/img/juice-tea/minute%20maid.png"));
		imageJuice.setFitHeight(150);
		imageJuice.setFitWidth(100);
		grid.add(imageJuice, 5, 2, 2, 1);
		
		ImageView imageWater = new ImageView(new Image("http://www.coca-colaproductfacts.com/content/dam/productfacts/us/productDetails/ProductImages/PDP_DASANI_1L_bottle.png"));
		imageWater.setFitHeight(150);
		imageWater.setFitWidth(100);
		grid.add(imageWater, 7, 2, 2, 1);
		
		ImageView imageMM = new ImageView(new Image("https://target.scene7.com/is/image/Target/13055555?wid=520&hei=520&fmt=pjpeg"));
		imageMM.setFitHeight(75);
		imageMM.setFitWidth(100);
		grid.add(imageMM, 1, 3, 2, 1);
		
		ImageView imageStarburst = new ImageView(new Image("http://prod-cdn.thekrazycouponlady.com/wp-content/uploads/2012/10/Screen-Shot-2012-10-25-at-12.36.17-PM.png"));
		imageStarburst.setFitHeight(75);
		imageStarburst.setFitWidth(100);
		grid.add(imageStarburst, 3, 3, 2, 1);
		
		ImageView imageSkittles = new ImageView(new Image("http://florencemarkoferpto.org/wp-content/uploads/2016/08/skittles.png"));
		imageSkittles.setFitHeight(75);
		imageSkittles.setFitWidth(100);
		grid.add(imageSkittles, 5, 3, 2, 1);
		
		ImageView imageSnicker = new ImageView(new Image("http://vignette3.wikia.nocookie.net/officialinanimations/images/a/a8/Snickers.png/revision/latest?cb=20140418143336"));
		imageSnicker.setFitHeight(50);
		imageSnicker.setFitWidth(150);
		grid.add(imageSnicker, 7, 3, 2, 1);
		
		ImageView imageTrident= new ImageView(new Image("https://cdn.shopify.com/s/files/1/0972/7116/products/trident-tropical-twist-18-stick-pack.png?v=1459344968"));
		imageTrident.setFitHeight(75);
		imageTrident.setFitWidth(75);
		grid.add(imageTrident, 1, 4, 2, 1);
		
		ImageView imageExtra = new ImageView(new Image("http://www.extragum.com/img/site/spearmint_bigpack2.png"));
		imageExtra.setFitHeight(50);
		imageExtra.setFitWidth(75);
		grid.add(imageExtra, 3, 4, 2, 1);
		
		ImageView imageMint = new ImageView(new Image("https://s3.amazonaws.com/user-media.venngage.com/504792-167414292e19e303c90e4bd7a8532a5d.png"));
		imageMint.setFitHeight(75);
		imageMint.setFitWidth(75);
		grid.add(imageMint, 5, 4, 2, 1);
		
		ImageView imageRed = new ImageView(new Image("https://www.sciencenews.org/sites/default/files/4096"));
		imageRed.setFitHeight(50);
		imageRed.setFitWidth(75);
		grid.add(imageRed, 7, 4, 2, 1);
		
		return grid;
	}

	private HBox getHBox() {
		// TODO Auto-generated method stub
		HBox hBox = new HBox(15);
		hBox.setPadding(new Insets(15, 12, 15, 12));
		hBox.setStyle("-fx-background-color: green");
		
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









