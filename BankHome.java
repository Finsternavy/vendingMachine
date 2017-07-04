package vendingMachineGUIBoss;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class BankHome extends JPanel {

	/**
	 * Create the panel.
	 */
	public BankHome() {
		setBackground(new Color(0, 153, 204));
		setLayout(null);
		
		JButton adminHomeButton = new JButton("ADMIN HOME");
		adminHomeButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adminHomeButton.setBackground(new Color(0, 153, 255));
		adminHomeButton.setBounds(10, 11, 150, 38);
		add(adminHomeButton);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cancelButton.setBackground(new Color(0, 153, 255));
		cancelButton.setBounds(340, 11, 150, 38);
		add(cancelButton);
		
		JTextPane profitsTextPane = new JTextPane();
		profitsTextPane.setEditable(false);
		profitsTextPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		profitsTextPane.setBounds(240, 87, 228, 52);
		add(profitsTextPane);
		
		JTextPane changeFundsTextPane = new JTextPane();
		changeFundsTextPane.setEditable(false);
		changeFundsTextPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		changeFundsTextPane.setBounds(240, 150, 228, 52);
		add(changeFundsTextPane);
		
		JLabel profitsLabel = new JLabel("PROFITS");
		profitsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		profitsLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		profitsLabel.setBounds(38, 87, 187, 52);
		add(profitsLabel);
		
		JLabel changeFundsLabel = new JLabel("CHANGE FUNDS");
		changeFundsLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		changeFundsLabel.setFont(new Font("Tahoma", Font.BOLD, 25));
		changeFundsLabel.setBounds(10, 150, 215, 52);
		add(changeFundsLabel);
		
		JButton withdrawProfitsButton = new JButton("WITHDRAW PROFITS");
		withdrawProfitsButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		withdrawProfitsButton.setBounds(45, 246, 413, 63);
		add(withdrawProfitsButton);
		
		JButton withdrawChangeFundsButton = new JButton("WITHDRAW CHANGE");
		withdrawChangeFundsButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		withdrawChangeFundsButton.setBounds(45, 320, 413, 63);
		add(withdrawChangeFundsButton);
		
		JButton addToChangeFundsButton = new JButton("ADD TO CHANGE FUNDS");
		addToChangeFundsButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		addToChangeFundsButton.setBounds(45, 394, 413, 63);
		add(addToChangeFundsButton);

	}

}
