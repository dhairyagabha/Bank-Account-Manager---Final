import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AccountInfo {
	static JTextArea txtAccountInfo = new JTextArea();
	static JFrame AccountInfo;

	/**
	 * Create the application.
	 */
	public AccountInfo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AccountInfo = new JFrame();
		AccountInfo.setTitle("Bank of Programmers - Account Information");
		AccountInfo.getContentPane().setFont(new Font("Silom", Font.PLAIN, 13));
		AccountInfo.getContentPane().setBackground(new Color(30, 144, 255));
		AccountInfo.getContentPane().setLayout(null);
		AccountInfo.setBounds(100, 100, 520, 500);
		AccountInfo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblBankName = new JLabel("BANK OF PROGRAMMERS");
		lblBankName.setHorizontalAlignment(SwingConstants.CENTER);
		lblBankName.setForeground(Color.WHITE);
		lblBankName.setFont(new Font("Silom", Font.PLAIN, 40));
		lblBankName.setBounds(0, 0, 520, 52);
		AccountInfo.getContentPane().add(lblBankName);
		
		JLabel lblAccountInfo = new JLabel("Account Info");
		lblAccountInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccountInfo.setForeground(Color.WHITE);
		lblAccountInfo.setFont(new Font("Silom", Font.PLAIN, 30));
		lblAccountInfo.setBounds(0, 46, 520, 52);
		AccountInfo.getContentPane().add(lblAccountInfo);
		
		txtAccountInfo.setForeground(new Color(30, 144, 255));
		txtAccountInfo.setFont(new Font("Silom", Font.PLAIN, 20));
		txtAccountInfo.setEditable(false);
		txtAccountInfo.setBounds(31, 98, 458, 276);
		AccountInfo.getContentPane().add(txtAccountInfo);
		
		final JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnExit.setEnabled(false);
		btnExit.setForeground(new Color(30, 144, 255));
		btnExit.setFont(new Font("Silom", Font.PLAIN, 20));
		btnExit.setBounds(250, 437, 130, 35);
		AccountInfo.getContentPane().add(btnExit);
		
		JLabel lblTransact = new JLabel("Would you like to make a transaction?");
		lblTransact.setForeground(new Color(255, 255, 255));
		lblTransact.setFont(new Font("Silom", Font.PLAIN, 16));
		lblTransact.setBounds(31, 378, 355, 22);
		AccountInfo.getContentPane().add(lblTransact);
		
		final JRadioButton rdbNo = new JRadioButton("No");
		rdbNo.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				btnExit.setEnabled(true);
			}
		});
		rdbNo.setBounds(140, 397, 70, 23);
		AccountInfo.getContentPane().add(rdbNo);
		
		final JButton btnNext = new JButton("NEXT");
		btnNext.setEnabled(false);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AccountInfo.dispose();
				ATM newTrans = new ATM();
				newTrans.ATMLogIn.setVisible(true);
				if(rdbNo.isSelected() == true)
					System.exit(0);
			}
		});
		btnNext.setForeground(new Color(30, 144, 255));
		btnNext.setFont(new Font("Silom", Font.PLAIN, 20));
		btnNext.setBounds(120, 437, 130, 35);
		AccountInfo.getContentPane().add(btnNext);
		
		JRadioButton rdbYes = new JRadioButton("Yes");
		rdbYes.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				btnNext.setEnabled(true);
			}
		});
		rdbYes.setBounds(31, 397, 70, 23);
		AccountInfo.getContentPane().add(rdbYes);
		
		ButtonGroup choice = new ButtonGroup();
		choice.add(rdbYes);
		choice.add(rdbNo);
		
	}
}
