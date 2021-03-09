package portfolio;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LibrarianLogin {

	private JFrame frame;
	private JTextField nameField;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianLogin window = new LibrarianLogin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**A
	 * Create the application.
	 */
	public LibrarianLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel loginForm = new JLabel("Librarian Login Form");
		loginForm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		loginForm.setBounds(144, 10, 162, 25);
		frame.getContentPane().add(loginForm);
		
		JLabel nameLabel = new JLabel("Enter Name:");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameLabel.setBounds(95, 62, 106, 14);
		frame.getContentPane().add(nameLabel);
		
		JLabel passwordLabel = new JLabel("Enter Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(95, 108, 106, 14);
		frame.getContentPane().add(passwordLabel);
		
		nameField = new JTextField();
		nameField.setBounds(235, 61, 130, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(235, 107, 130, 20);
		frame.getContentPane().add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String name = nameField.getText();
				 String password = String.valueOf(passwordField.getPassword());
	             if (LibrarianDao.validate(name, password) ) {
	            	 LibrarianDao.updateLogbook(name, password);
	            	 LibrarianSuccess.main(new String[] {});
	            	 frame.dispose();
	             } else {
	            	 JOptionPane.showMessageDialog(frame, "Sorry, Username or Password you have entered is incorrect", "Login Error", JOptionPane.ERROR_MESSAGE);
	            	 nameField.setText("");
	            	 passwordField.setText("");
	             }
	             
			
				
			}
		});
		loginButton.setBounds(150, 151, 138, 50);
		frame.getContentPane().add(loginButton);
		
		JButton backButton = new JButton("Go Back");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryManagement.main(new String[] {});
				frame.dispose();
			}
		});
		backButton.setBounds(150, 227, 138, 23);
		frame.getContentPane().add(backButton);
		
		
		
		
		
	}

}
