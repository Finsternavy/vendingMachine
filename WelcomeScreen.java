package vendingMachineGUIBoss;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import vendingMachine.*;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public WelcomeScreen() {

		setBackground(new Color(0, 153, 204));
		setLayout(null);
		setVisible(true);
		
		JButton adminLoginButton = new JButton("ADMIN LOGIN");
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.INSTANCE.changeState(MainFrame.ViewState.LOGIN);
			}
		});
		adminLoginButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		adminLoginButton.setBackground(new Color(0, 153, 255));
		adminLoginButton.setBounds(326, 11, 164, 34);
		add(adminLoginButton);
		
		JLabel WelcomeLabel = new JLabel("WELCOME");
		WelcomeLabel.setBackground(new Color(0, 153, 204));
		WelcomeLabel.setFont(new Font("Tahoma", Font.BOLD, 65));
		WelcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		WelcomeLabel.setBounds(67, 113, 343, 115);
		add(WelcomeLabel);
		
		JButton cashButton = new JButton("CASH");
		cashButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.INSTANCE.changeState(MainFrame.ViewState.PRODUCT_CATEGORY);
			}
		});
		cashButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cashButton.setBackground(new Color(0, 153, 255));
		cashButton.setBounds(82, 295, 150, 50);
		
		add(cashButton);
		
		JButton creditButton = new JButton("CREDIT");
		creditButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		creditButton.setBackground(new Color(0, 153, 255));
		creditButton.setBounds(254, 295, 150, 50);
		add(creditButton);
		
		JLabel lblSelectPaymentOption = new JLabel("SELECT PAYMENT OPTION");
		lblSelectPaymentOption.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectPaymentOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectPaymentOption.setBounds(97, 230, 291, 34);
		add(lblSelectPaymentOption);

	}
}
