import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountTypes {

	static JFrame AccountType;


	/**
	 * Create the application.
	 */
	public AccountTypes() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AccountType = new JFrame();
		AccountType.getContentPane().setBackground(new Color(30, 144, 255));
		AccountType.getContentPane().setLayout(null);
		AccountType.setTitle("Bank of Programmers");
		AccountType.setBounds(100, 100, 520, 500);
		AccountType.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel("BANK OF PROGRAMMERS");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Silom", Font.PLAIN, 40));
		label.setBounds(0, 0, 520, 52);
		AccountType.getContentPane().add(label);
		
		JButton btnSving = new JButton("Saving");
		btnSving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountType.dispose();
				Savings save = new Savings();
				save.SAVINGACCOUNT.setVisible(true);
			}
		});
		btnSving.setForeground(new Color(30, 144, 255));
		btnSving.setFont(new Font("Silom", Font.PLAIN, 22));
		btnSving.setBounds(85, 113, 337, 92);
		AccountType.getContentPane().add(btnSving);
		
		JButton btnChecking = new JButton("Checking");
		btnChecking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountType.dispose();
				Checking check = new Checking();
				check.checking.setVisible(true);
			}
		});
		btnChecking.setForeground(new Color(30, 144, 255));
		btnChecking.setFont(new Font("Silom", Font.PLAIN, 22));
		btnChecking.setBounds(85, 218, 337, 92);
		AccountType.getContentPane().add(btnChecking);
		
		JButton btnBusiness = new JButton("Business");
		btnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountType.dispose();
				Business business = new Business();
				business.business.setVisible(true);
			}
		});
		btnBusiness.setForeground(new Color(30, 144, 255));
		btnBusiness.setFont(new Font("Silom", Font.PLAIN, 22));
		btnBusiness.setBounds(85, 322, 337, 92);
		AccountType.getContentPane().add(btnBusiness);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		AccountType.setLocation(dim.width/2-AccountType.getSize().width/2, dim.height/2-AccountType.getSize().height/2);
	
	}

}
