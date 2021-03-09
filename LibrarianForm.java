package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianForm {

	private JFrame frame;
	private JTextField nameField;
	private JPasswordField passwordField;
	private JTextField emailField;
	private JTextField addressField;
	private JTextField cityField;
	private JTextField contactField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianForm window = new LibrarianForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LibrarianForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel addLibrarianLabel = new JLabel("Add Librarian");
		addLibrarianLabel.setForeground(Color.DARK_GRAY);
		addLibrarianLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addLibrarianLabel.setBounds(173, 11, 104, 50);
		frame.getContentPane().add(addLibrarianLabel);
		
		JLabel name = new JLabel("Name:");
		name.setBounds(30, 70, 110, 14);
		frame.getContentPane().add(name);
		
		JLabel password = new JLabel("Password:");
		password.setBounds(30, 104, 110, 14);
		frame.getContentPane().add(password);
		
		JLabel email = new JLabel("Email:");
		email.setBounds(30, 138, 110, 14);
		frame.getContentPane().add(email);
		
		JLabel address = new JLabel("Address:");
		address.setBounds(30, 172, 110, 14);
		frame.getContentPane().add(address);
		
		JLabel city = new JLabel("City:");
		city.setBounds(30, 206, 110, 14);
		frame.getContentPane().add(city);
		
		JLabel contactNumber = new JLabel("Contact No:");
		contactNumber.setBounds(30, 240, 110, 14);
		frame.getContentPane().add(contactNumber);
		
		nameField = new JTextField();
		nameField.setBounds(150, 67, 150, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(150, 101, 150, 20);
		frame.getContentPane().add(passwordField);
		
		emailField = new JTextField();
		emailField.setBounds(150, 135, 150, 20);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		addressField = new JTextField();
		addressField.setBounds(150, 169, 150, 20);
		frame.getContentPane().add(addressField);
		addressField.setColumns(10);
		
		cityField = new JTextField();
		cityField.setBounds(150, 203, 150, 20);
		frame.getContentPane().add(cityField);
		cityField.setColumns(10);
		
		contactField = new JTextField();
		contactField.setBounds(150, 237, 150, 20);
		frame.getContentPane().add(contactField);
		contactField.setColumns(10);
		
		JButton addLibrarianButton = new JButton("Add Librarian");
		addLibrarianButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = nameField.getText();
				String password = String.copyValueOf(passwordField.getPassword());
				String email = emailField.getText();
				String address = addressField.getText();
				String city = cityField.getText();
				String contact = contactField.getText();
				
				int i = LibrarianDao.save(name, password, email, address, city, contact);
				if (i>0) {
					JOptionPane.showMessageDialog(frame, "Librarian has been added successfully");
					AdminSuccess.main(new String[] {});
					frame.dispose();
				}
				
				
			}
		});
		addLibrarianButton.setBounds(150, 278, 150, 40);
		frame.getContentPane().add(addLibrarianButton);
		
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[] {});
				frame.dispose();
			}
		});
		backButton.setBounds(150, 360, 150, 23);
		frame.getContentPane().add(backButton);
	}
}
