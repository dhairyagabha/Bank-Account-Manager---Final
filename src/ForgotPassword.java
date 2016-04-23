

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalityType;
import javax.swing.SwingConstants;

public class ForgotPassword extends JDialog {

	static  JPanel contentPanel = new JPanel();
	static JLabel lblRetrievedPassword = new JLabel();
	private JTextField txtAccountNumber;
	private JTextField txtUsername;

	/**
	 * Create the dialog.
	 */
	public ForgotPassword() {
		setFont(new Font("Silom", Font.PLAIN, 12));
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setTitle("Bank of Programmers - Forgot Password");
		setBounds(100, 100, 421, 220);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(30, 144, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

			JLabel lblForgotPassword = new JLabel("Enter following information to retrieve your password:");
			lblForgotPassword.setForeground(new Color(255, 255, 255));
			lblForgotPassword.setFont(new Font("Silom", Font.PLAIN, 12));
			lblForgotPassword.setBounds(6, 6, 438, 16);
			contentPanel.add(lblForgotPassword);

			final JLabel lblUsername = new JLabel("Username:");
			lblUsername.setForeground(new Color(255, 255, 255));
			lblUsername.setFont(new Font("Silom", Font.PLAIN, 12));
			lblUsername.setBounds(29, 34, 116, 16);
			contentPanel.add(lblUsername);

			final JLabel lblAccountNumber = new JLabel("Account Number:");
			lblAccountNumber.setForeground(new Color(255, 255, 255));
			lblAccountNumber.setFont(new Font("Silom", Font.PLAIN, 12));
			lblAccountNumber.setBounds(29, 60, 116, 16);
			contentPanel.add(lblAccountNumber);

			final JLabel lblAccountType = new JLabel("Account Type:");
			lblAccountType.setForeground(new Color(255, 255, 255));
			lblAccountType.setFont(new Font("Silom", Font.PLAIN, 12));
			lblAccountType.setBounds(29, 88, 116, 16);
			contentPanel.add(lblAccountType);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.setForeground(new Color(30, 144, 255));
		txtAccountNumber.setFont(new Font("Silom", Font.PLAIN, 12));
		txtAccountNumber.setBounds(157, 54, 237, 26);
		contentPanel.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		txtUsername = new JTextField();
		txtUsername.setForeground(new Color(30, 144, 255));
		txtUsername.setFont(new Font("Silom", Font.PLAIN, 12));
		txtUsername.setColumns(10);
		txtUsername.setBounds(157, 28, 237, 26);
		contentPanel.add(txtUsername);
		
		final JComboBox cbAccountType = new JComboBox();
		cbAccountType.setForeground(new Color(30, 144, 255));
		cbAccountType.setModel(new DefaultComboBoxModel(new String[] {"SELECT", "SAVING ACCOUNT", "CHECKING ACCOUNT", "BUSINESS ACCOUNT"}));
		cbAccountType.setFont(new Font("Silom", Font.PLAIN, 12));
		cbAccountType.setBounds(157, 83, 237, 27);
		contentPanel.add(cbAccountType);
		lblRetrievedPassword.setForeground(new Color(255, 255, 255));
		lblRetrievedPassword.setHorizontalAlignment(SwingConstants.CENTER);
		
		lblRetrievedPassword.setFont(new Font("Silom", Font.PLAIN, 12));
		lblRetrievedPassword.setBounds(29, 124, 365, 16);
		contentPanel.add(lblRetrievedPassword);
		
			final JButton okButton = new JButton("OK");
			okButton.setEnabled(false);
			okButton.setForeground(new Color(30, 144, 255));
			okButton.setFont(new Font("Silom", Font.PLAIN, 12));
			okButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPanel.removeAll();
				}
			});
			okButton.setBounds(221, 152, 75, 29);
			contentPanel.add(okButton);
			okButton.setActionCommand("OK");
			
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setForeground(new Color(30, 144, 255));
			cancelButton.setFont(new Font("Silom", Font.PLAIN, 12));
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPanel.removeAll();
				}
			});
			cancelButton.setBounds(308, 152, 86, 29);
			contentPanel.add(cancelButton);
			cancelButton.setActionCommand("Cancel");
			getRootPane().setDefaultButton(cancelButton);
			
			JButton Retrieve = new JButton("Retrieve Password");
			Retrieve.setEnabled(true);
			Retrieve.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (txtUsername.getText().equals(""))
						lblUsername.setForeground(Color.red);
					if (txtAccountNumber.getText().equals(""))
						lblAccountNumber.setForeground(Color.red);
					if (cbAccountType.getSelectedItem().equals("SELECT"))
						lblAccountType.setForeground(Color.red);
					if(txtUsername.getText().equals("") && txtAccountNumber.getText().equals("") && cbAccountType.getSelectedItem().equals("SELECT")){
						lblUsername.setForeground(Color.red);
						lblAccountNumber.setForeground(Color.red);
						lblAccountType.setForeground(Color.red);
					}else{
						BankAccount.forgotPassword(Long.parseLong(txtAccountNumber.getText()), txtUsername.getText(), (String)cbAccountType.getSelectedItem());
						okButton.setEnabled(true);
					}
				}
			});
			Retrieve.setForeground(new Color(30, 144, 255));
			Retrieve.setFont(new Font("Silom", Font.PLAIN, 12));
			Retrieve.setActionCommand("OK");
			Retrieve.setBounds(55, 152, 154, 29);
			contentPanel.add(Retrieve);
			
			Dimension dim = ATM.ATMLogIn.getSize();
			contentPanel.setLocation(dim.width/2-Retrieve.getSize().width/2, dim.height/2-Retrieve.getSize().height/2);
	}
}
