package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminSuccess {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminSuccess window = new AdminSuccess();
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
	public AdminSuccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 370);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel adminSection = new JLabel("Admin Section");
		adminSection.setForeground(Color.DARK_GRAY);
		adminSection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		adminSection.setBounds(168, 11, 113, 14);
		frame.getContentPane().add(adminSection);
		
		JButton addLibrarian = new JButton("Add Librarian");
		addLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianForm.main(new String[] {});
				frame.dispose();
			}
		});
		addLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addLibrarian.setForeground(Color.BLACK);
		addLibrarian.setBounds(154, 57, 138, 40);
		frame.getContentPane().add(addLibrarian);
		
		JButton viewLibrarian = new JButton("View Librarian");
		viewLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewLibrarian.main(new String[] {});
			}
		});
		viewLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		viewLibrarian.setForeground(Color.BLACK);
		viewLibrarian.setBounds(154, 108, 138, 40);
		frame.getContentPane().add(viewLibrarian);
		
		JButton deleteLibrarian = new JButton("Delete Librarian");
		deleteLibrarian.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteLibrarian.main(new String[] {});
				frame.dispose();
			}
		});
		deleteLibrarian.setForeground(Color.BLACK);
		deleteLibrarian.setFont(new Font("Tahoma", Font.PLAIN, 15));
		deleteLibrarian.setBounds(154, 159, 138, 40);
		frame.getContentPane().add(deleteLibrarian);
		
		JButton logoutButton = new JButton("Logout");
		logoutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibraryManagement.main(new String[] {});
				frame.dispose();
			}
		});
		logoutButton.setForeground(Color.BLACK);
		logoutButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logoutButton.setBounds(154, 261, 138, 40);
		frame.getContentPane().add(logoutButton);
		
		JButton logbookButton = new JButton("View Logbook");
		logbookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Logbook.main(new String[] {});
			}
		});
		logbookButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		logbookButton.setBounds(154, 210, 138, 40);
		frame.getContentPane().add(logbookButton);
	}
}
