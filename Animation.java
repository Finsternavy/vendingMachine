package vendingMachineGUIBoss;

import javafx.animation.*;
import javafx.scene.image.ImageView;
import javafx.util.Duration;


public class Animation {
	
	static TranslateTransition toCart = new TranslateTransition();
	static TranslateTransition toOrigin = new TranslateTransition();
	
	
	public static void animateStart(ImageView imageView){
		
		
		toCart.setDuration(Duration.seconds(1));
		toCart.setCycleCount(1);
		toCart.setAutoReverse(false);
		toCart.setToX(0);
		toCart.setToY(440);
		toCart.setNode(imageView);


		toOrigin.setDuration(Duration.seconds(1));
		toOrigin.setToX(0);
		toOrigin.setToY(0);
		toOrigin.setAutoReverse(false);
		toOrigin.setFromX(0);
		toOrigin.setFromY(0);
		toOrigin.setNode(imageView);
		
		SequentialTransition seqTransition = new SequentialTransition(toCart, toOrigin);
		seqTransition.play();
	}

	
}
