package vendingMachineGUIBoss;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	
	public StringBuilder currentPassword = new StringBuilder();
	public StringBuilder passwordAttempt = new StringBuilder();
	
	public void restoreDefaultPassword(){
		currentPassword.setLength(0);
		currentPassword.append("1");
		currentPassword.append("2");
		currentPassword.append("3");
		currentPassword.append("4");
	}
	
	public void resetPasswordAttempt(){
		passwordAttempt.setLength(0);
	}
	

	/**
	 * Create the panel.
	 */
	public Login() {
		
		currentPassword.append("1");
		currentPassword.append("2");
		currentPassword.append("3");
		currentPassword.append("4");

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
		cancelButton.setBounds(324, 11, 150, 38);
		add(cancelButton);
		
		JLabel lblEnterAdminPin = new JLabel("ENTER ADMIN PIN");
		lblEnterAdminPin.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterAdminPin.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEnterAdminPin.setBounds(123, 60, 243, 55);
		add(lblEnterAdminPin);
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				passwordAttempt.append("1");
			}
		});
		button_1.setFont(new Font("Dialog", Font.BOLD, 30));
		button_1.setBounds(123, 115, 60, 60);
		add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("2");
			}
		});
		button_2.setFont(new Font("Dialog", Font.BOLD, 30));
		button_2.setBounds(193, 115, 60, 60);
		add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("3");
			}
		});
		button_3.setFont(new Font("Dialog", Font.BOLD, 30));
		button_3.setBounds(263, 115, 60, 60);
		add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("4");
			}
		});
		button_4.setFont(new Font("Dialog", Font.BOLD, 30));
		button_4.setBounds(123, 186, 60, 60);
		add(button_4);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("7");
			}
		});
		button_7.setFont(new Font("Dialog", Font.BOLD, 30));
		button_7.setBounds(123, 257, 60, 60);
		add(button_7);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("5");
			}
		});
		button_5.setFont(new Font("Dialog", Font.BOLD, 30));
		button_5.setBounds(193, 186, 60, 60);
		add(button_5);
		
		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("8");
			}
		});
		button_8.setFont(new Font("Dialog", Font.BOLD, 30));
		button_8.setBounds(193, 257, 60, 60);
		add(button_8);
		
		JButton button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("0");
			}
		});
		button_0.setFont(new Font("Dialog", Font.BOLD, 30));
		button_0.setBounds(193, 328, 60, 60);
		add(button_0);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("6");
			}
		});
		button_6.setFont(new Font("Dialog", Font.BOLD, 30));
		button_6.setBounds(263, 186, 60, 60);
		add(button_6);
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordAttempt.append("9");
			}
		});
		button_9.setFont(new Font("Dialog", Font.BOLD, 30));
		button_9.setBounds(263, 257, 60, 60);
		add(button_9);
		
		JButton submitButton = new JButton("SUBMIT");
		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(currentPassword.toString().equals(passwordAttempt.toString())){
					MainFrame.INSTANCE.changeState(MainFrame.ViewState.BOSS_MAIN);
					passwordAttempt.setLength(0);
				}else{
				passwordAttempt.setLength(0);
				MainFrame.INSTANCE.changeState(MainFrame.ViewState.LOGIN);
				}
			}
		});
		submitButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		submitButton.setBounds(146, 415, 150, 49);
		add(submitButton);

	}

}
