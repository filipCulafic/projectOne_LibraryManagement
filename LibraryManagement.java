package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class LibraryManagement {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibraryManagement window = new LibraryManagement();
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
	public LibraryManagement() {
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
		
		JLabel libraryManagementLabel = new JLabel("Library Management");
		libraryManagementLabel.setForeground(Color.DARK_GRAY);
		libraryManagementLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		libraryManagementLabel.setBounds(145, 10, 160, 25);
		frame.getContentPane().add(libraryManagementLabel);
		

		
		JButton adminLoginButton = new JButton("Admin Login");
		adminLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminLogin.main(new String[] {});
				frame.dispose();
			}
		});
		adminLoginButton.setBounds(145, 74, 160, 50);
		frame.getContentPane().add(adminLoginButton);
		
		JButton librarianLoginButton = new JButton("Librarian Login");
		librarianLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		librarianLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianLogin.main(new String[] {});
				frame.dispose();
			}
		});
		librarianLoginButton.setBounds(145, 144, 160, 50);
		frame.getContentPane().add(librarianLoginButton);
		
	}
}
