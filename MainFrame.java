package vendingMachineGUIBoss;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import vendingMachine.Dispenser;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static JPanel MAIN_PANEL = new JPanel();
	public static final MainFrame INSTANCE = new MainFrame();
	public static final Dispenser DISPENSER = new Dispenser();
	
	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 525, 525);
		MAIN_PANEL = new JPanel();
		MAIN_PANEL.setBorder(new EmptyBorder(5, 5, 5, 5));
		MAIN_PANEL.setLayout(new BorderLayout(0, 0));
		setContentPane(MAIN_PANEL);
		this.setVisible(false);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DISPENSER.createVendingMachine();
					INSTANCE.setContentPane(MAIN_PANEL);
					INSTANCE.changeState(ViewState.WELCOME);
					INSTANCE.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public enum ViewState {
		WELCOME,
		NEW_PIN,
		MODIFY_PRODUCT,
		INVENTORY_MENU,
		LOGIN,
		CHANGE_PRICE,
		BOSS_MAIN,
		BANK_HOME,
		ADD_CHANGE,
		PRODUCT_CATEGORY,
		CHIPS,
		CANDY,
		GUM,
		DRINK
	}

	public void changeState(ViewState state){
		switch (state) {
		case WELCOME:
			this.changePanel(new WelcomeScreen());
			break;
		case NEW_PIN:
			this.changePanel(new NewPinScreen());
			break;
		case MODIFY_PRODUCT:
			this.changePanel(new ModifyProductsScreen());
			break;
		case INVENTORY_MENU:
			this.changePanel(new InventoryMenu());
			break;
		case LOGIN:
			this.changePanel(new Login());
			break;
		case CHANGE_PRICE:
			this.changePanel(new ChangePriceScreen());
			break;
		case BOSS_MAIN:
			this.changePanel(new BossMainMenu());
			break;
		case BANK_HOME:
			this.changePanel(new BankHome());
			break;
		case ADD_CHANGE:
			this.changePanel(new AddChangeScreen());
		case PRODUCT_CATEGORY:
			this.changePanel(new ProductCategorySelectionScreen());
		}
	}
	
	private void changePanel(JPanel panel){
		MAIN_PANEL.removeAll();
		MAIN_PANEL.add(panel);
		MAIN_PANEL.revalidate();
		MAIN_PANEL.repaint();
	}
	
}
