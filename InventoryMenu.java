package vendingMachineGUIBoss;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;

public class InventoryMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public InventoryMenu() {
		setBackground(new Color(0, 153, 204));
		setLayout(null);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBackground(new Color(0, 153, 255));
		cancelButton.setBounds(340, 11, 150, 38);
		add(cancelButton);
		
		JButton coffeeInventoryButton = new JButton("COFFEE");
		coffeeInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		coffeeInventoryButton.setBounds(74, 107, 150, 50);
		add(coffeeInventoryButton);
		
		JButton teaInventoryButton = new JButton("TEA");
		teaInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		teaInventoryButton.setBounds(74, 168, 150, 50);
		add(teaInventoryButton);
		
		JButton monsterInventoryButton = new JButton("MONSTER");
		monsterInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		monsterInventoryButton.setBounds(74, 229, 150, 50);
		add(monsterInventoryButton);
		
		JButton waterInventoryButton = new JButton("WATER");
		waterInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		waterInventoryButton.setBounds(74, 290, 150, 50);
		add(waterInventoryButton);
		
		JButton colaInventoryButton = new JButton("COLA");
		colaInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		colaInventoryButton.setBounds(74, 351, 150, 50);
		add(colaInventoryButton);
		
		JButton redbullInvetoryButton = new JButton("REDBULL");
		redbullInvetoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		redbullInvetoryButton.setBounds(74, 412, 150, 50);
		add(redbullInvetoryButton);
		
		JButton chipsInventoryButton = new JButton("CHIPS");
		chipsInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		chipsInventoryButton.setBounds(280, 107, 150, 50);
		add(chipsInventoryButton);
		
		JButton pretzelsInventoryButton = new JButton("PRETZELS");
		pretzelsInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		pretzelsInventoryButton.setBounds(280, 168, 150, 50);
		add(pretzelsInventoryButton);
		
		JButton beefJerkyInventoryButton = new JButton("BEEF JERKY");
		beefJerkyInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		beefJerkyInventoryButton.setBounds(280, 229, 150, 50);
		add(beefJerkyInventoryButton);
		
		JButton peanutsInventoryButton = new JButton("PEANUTS");
		peanutsInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		peanutsInventoryButton.setBounds(280, 290, 150, 50);
		add(peanutsInventoryButton);
		
		JButton gumInventoryButton = new JButton("GUM");
		gumInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		gumInventoryButton.setBounds(280, 351, 150, 50);
		add(gumInventoryButton);
		
		JButton mintsInventoryButton = new JButton("MINTS");
		mintsInventoryButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		mintsInventoryButton.setBounds(280, 412, 150, 50);
		add(mintsInventoryButton);

	}

}
