package vendingMachineGUIBoss;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ModifyProductsScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public ModifyProductsScreen() {
		setBackground(new Color(0, 153, 204));
		setLayout(null);
		
		JButton button = new JButton("CANCEL");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBackground(new Color(0, 153, 255));
		button.setBounds(340, 11, 150, 38);
		add(button);
		
		JButton adminHomeButton = new JButton("ADMIN HOME");
		adminHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adminHomeButton.setBackground(new Color(0, 153, 255));
		adminHomeButton.setBounds(10, 11, 150, 38);
		add(adminHomeButton);
		
		JTextPane currentPriceTextPane = new JTextPane();
		currentPriceTextPane.setBounds(239, 134, 203, 38);
		add(currentPriceTextPane);
		
		JTextPane currentStockTextPane = new JTextPane();
		currentStockTextPane.setBounds(239, 183, 203, 38);
		add(currentStockTextPane);
		
		JTextPane emptySlotsTextPain = new JTextPane();
		emptySlotsTextPain.setBounds(239, 232, 203, 38);
		add(emptySlotsTextPain);
		
		JLabel currentPriceJLabel = new JLabel("CURRENT PRICE");
		currentPriceJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		currentPriceJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentPriceJLabel.setBounds(10, 134, 219, 38);
		add(currentPriceJLabel);
		
		JLabel currentStockJLabel = new JLabel("CURRENT STOCK");
		currentStockJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		currentStockJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		currentStockJLabel.setBounds(10, 183, 219, 38);
		add(currentStockJLabel);
		
		JLabel emptySlotsJLabel = new JLabel("EMPTY SLOTS");
		emptySlotsJLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		emptySlotsJLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emptySlotsJLabel.setBounds(10, 232, 219, 38);
		add(emptySlotsJLabel);
		
		JButton changePriceButton = new JButton("CHANGE PRICE");
		changePriceButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		changePriceButton.setBounds(58, 292, 384, 52);
		add(changePriceButton);
		
		JButton restockButton = new JButton("RESTOCK");
		restockButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		restockButton.setBounds(58, 355, 384, 52);
		add(restockButton);
		
		JButton removeItemButton = new JButton("REMOVE ITEM");
		removeItemButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		removeItemButton.setBounds(58, 418, 384, 52);
		add(removeItemButton);

	}
}
