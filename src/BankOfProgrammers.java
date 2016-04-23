import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Window.Type;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dimension;

public class BankOfProgrammers {

	private JFrame ChoiceScreen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankOfProgrammers window = new BankOfProgrammers();
					window.ChoiceScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BankOfProgrammers() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ChoiceScreen = new JFrame();
		ChoiceScreen.setFont(new Font("Silom", Font.PLAIN, 12));
		ChoiceScreen.setType(Type.POPUP);
		ChoiceScreen.setTitle("Bank of Programmers - Services");
		ChoiceScreen.getContentPane().setBackground(new Color(30, 144, 255));
		ChoiceScreen.getContentPane().setLayout(null);
		
		
		JLabel lblBankNameLabel = new JLabel("BANK OF PROGRAMMERS");
		lblBankNameLabel.setBounds(0, 0, 517, 52);
		lblBankNameLabel.setForeground(new Color(255, 255, 255));
		lblBankNameLabel.setFont(new Font("Silom", Font.PLAIN, 40));
		lblBankNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ChoiceScreen.getContentPane().add(lblBankNameLabel);
		
		JButton btnAtm = new JButton("ATM");
		btnAtm.setForeground(new Color(30, 144, 255));
		btnAtm.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChoiceScreen.dispose();
				ATM atm = new ATM();
				atm.ATMLogIn.setVisible(true);
			}
		});
		btnAtm.setFont(new Font("Silom", Font.PLAIN, 22));
		btnAtm.setBounds(89, 129, 337, 92);
		ChoiceScreen.getContentPane().add(btnAtm);
		
		JButton btnBank = new JButton("BANK (Create an Account!)");
		btnBank.setForeground(new Color(30, 144, 255));
		btnBank.setFont(new Font("Silom", Font.PLAIN, 22));
		btnBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoiceScreen.dispose();
				AccountTypes acty = new AccountTypes();
				acty.AccountType.setVisible(true);
			}
		});
		btnBank.setBounds(89, 270, 337, 92);
		ChoiceScreen.getContentPane().add(btnBank);
		ChoiceScreen.getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblBankNameLabel, btnAtm, btnBank}));
		ChoiceScreen.setBounds(100, 100, 517, 475);
		ChoiceScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		ChoiceScreen.setLocation(dim.width/2-ChoiceScreen.getSize().width/2, dim.height/2-ChoiceScreen.getSize().height/2);
		
	}
}
