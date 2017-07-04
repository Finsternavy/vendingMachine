package vendingMachineGUIBoss;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class AddChangeScreen extends JPanel {

	/**
	 * Create the panel.
	 */
	public AddChangeScreen() {
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
		
		JTextPane fundsToAddTextPane = new JTextPane();
		fundsToAddTextPane.setEditable(false);
		fundsToAddTextPane.setBounds(81, 71, 342, 46);
		add(fundsToAddTextPane);
		
		JLabel lblEnterAmountTo = new JLabel("ENTER AMOUNT TO ADD");
		lblEnterAmountTo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblEnterAmountTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAmountTo.setBounds(81, 117, 342, 46);
		add(lblEnterAmountTo);
		
		JButton button_0 = new JButton("0");
		button_0.setFont(new Font("Dialog", Font.BOLD, 30));
		button_0.setBounds(224, 378, 60, 60);
		add(button_0);
		
		JButton button_1 = new JButton("1");
		button_1.setFont(new Font("Dialog", Font.BOLD, 30));
		button_1.setBounds(154, 165, 60, 60);
		add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.setFont(new Font("Dialog", Font.BOLD, 30));
		button_2.setBounds(224, 165, 60, 60);
		add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.setFont(new Font("Dialog", Font.BOLD, 30));
		button_3.setBounds(294, 165, 60, 60);
		add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.setFont(new Font("Dialog", Font.BOLD, 30));
		button_4.setBounds(154, 236, 60, 60);
		add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.setFont(new Font("Dialog", Font.BOLD, 30));
		button_5.setBounds(224, 236, 60, 60);
		add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.setFont(new Font("Dialog", Font.BOLD, 30));
		button_6.setBounds(294, 236, 60, 60);
		add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.setFont(new Font("Dialog", Font.BOLD, 30));
		button_7.setBounds(154, 307, 60, 60);
		add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.setFont(new Font("Dialog", Font.BOLD, 30));
		button_8.setBounds(224, 307, 60, 60);
		add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.setFont(new Font("Dialog", Font.BOLD, 30));
		button_9.setBounds(294, 307, 60, 60);
		add(button_9);
		
		JButton confirmButton = new JButton("CONFIRM");
		confirmButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		confirmButton.setBounds(180, 449, 150, 40);
		add(confirmButton);

	}

}
