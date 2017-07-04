package vendingMachineGUIBoss;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class ChangePriceScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public ChangePriceScreen() {
		setBackground(new Color(0, 153, 204));
		setLayout(null);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBackground(new Color(0, 153, 255));
		cancelButton.setBounds(340, 11, 150, 38);
		add(cancelButton);
		
		JButton adminHomeButton = new JButton("ADMIN HOME");
		adminHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adminHomeButton.setBackground(new Color(0, 153, 255));
		adminHomeButton.setBounds(10, 11, 150, 38);
		add(adminHomeButton);
		
		JLabel productNameLabel = new JLabel("PRODUCT NAME");
		productNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		productNameLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		productNameLabel.setBounds(146, 80, 200, 31);
		add(productNameLabel);
		
		JTextPane newPriceTextPane = new JTextPane();
		newPriceTextPane.setFont(new Font("Tahoma", Font.PLAIN, 25));
		newPriceTextPane.setBounds(146, 122, 200, 38);
		add(newPriceTextPane);
		
		JLabel enterNewPriceLabel = new JLabel("ENTER NEW PRICE");
		enterNewPriceLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		enterNewPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
		enterNewPriceLabel.setBounds(146, 171, 200, 31);
		add(enterNewPriceLabel);
		
		JButton button_0 = new JButton("0");
		button_0.setFont(new Font("Dialog", Font.BOLD, 30));
		button_0.setBounds(216, 422, 60, 60);
		add(button_0);
		
		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Dialog", Font.BOLD, 30));
		button_1.setBounds(146, 209, 60, 60);
		add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Dialog", Font.BOLD, 30));
		button_2.setBounds(216, 209, 60, 60);
		add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Dialog", Font.BOLD, 30));
		button_3.setBounds(286, 209, 60, 60);
		add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Dialog", Font.BOLD, 30));
		button_4.setBounds(146, 280, 60, 60);
		add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Dialog", Font.BOLD, 30));
		button_5.setBounds(216, 280, 60, 60);
		add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Dialog", Font.BOLD, 30));
		button_6.setBounds(286, 280, 60, 60);
		add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Dialog", Font.BOLD, 30));
		button_7.setBounds(146, 351, 60, 60);
		add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Dialog", Font.BOLD, 30));
		button_8.setBounds(216, 351, 60, 60);
		add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Dialog", Font.BOLD, 30));
		button_9.setBounds(286, 351, 60, 60);
		add(button_9);

	}

}
