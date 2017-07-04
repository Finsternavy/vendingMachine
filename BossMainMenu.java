package vendingMachineGUIBoss;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import vendingMachineGUIBoss.MainFrame.ViewState;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BossMainMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public BossMainMenu() {
		setBackground(new Color(0, 153, 204));
		setLayout(null);
		
		JButton cancelButton = new JButton("CANCEL");
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainFrame.INSTANCE.changeState(MainFrame.ViewState.WELCOME);
			}
		});
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cancelButton.setBackground(new Color(0, 153, 255));
		cancelButton.setBounds(340, 11, 150, 38);
		add(cancelButton);
		
		JButton manageInventoryButton = new JButton("MANAGE INVENTORY");
		manageInventoryButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		manageInventoryButton.setBounds(69, 141, 359, 78);
		add(manageInventoryButton);
		
		JButton manageBankButton = new JButton("MANAGE BANK");
		manageBankButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		manageBankButton.setBounds(69, 230, 359, 78);
		add(manageBankButton);
		
		JButton changePinButton = new JButton("CHANGE PIN");
		changePinButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		changePinButton.setBounds(69, 319, 359, 78);
		add(changePinButton);
		
		JLabel lblSelectAnOption = new JLabel("SELECT AN OPTION");
		lblSelectAnOption.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAnOption.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSelectAnOption.setBounds(47, 65, 391, 65);
		add(lblSelectAnOption);

	}

}
