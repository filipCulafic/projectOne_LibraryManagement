package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LibrarianSuccess {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LibrarianSuccess window = new LibrarianSuccess();
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
	public LibrarianSuccess() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 430);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel librarianSection = new JLabel("Librarian Section");
		librarianSection.setForeground(Color.DARK_GRAY);
		librarianSection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		librarianSection.setBounds(160, 11, 130, 14);
		frame.getContentPane().add(librarianSection);
		
		JButton addBooks = new JButton("Add a Book");
		addBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookForm.main(new String[] {});
				frame.dispose();
			}
		});
		addBooks.setBounds(150, 50, 150, 30);
		frame.getContentPane().add(addBooks);
		
		JButton viewBooks = new JButton("View Books");
		viewBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewBooks.main(new String[] {});
			}
		});
		viewBooks.setBounds(150, 91, 150, 30);
		frame.getContentPane().add(viewBooks);
		
		JButton IssueABook = new JButton("Issue a Book");
		IssueABook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IssueBookForm.main(new String[] {});
				frame.dispose();
			}
		});
		IssueABook.setBounds(150, 132, 150, 30);
		frame.getContentPane().add(IssueABook);
		
		JButton viewIssuedBooks = new JButton("View Issued Books");
		viewIssuedBooks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewIssuedBooks.main(new String[] {});
				
			}
		});
		viewIssuedBooks.setBounds(150, 173, 150, 30);
		frame.getContentPane().add(viewIssuedBooks);
		
		JButton returnBook = new JButton("Return a Book");
		returnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReturnBook.main(new String[] {});
				frame.dispose();
			}
		});
		returnBook.setBounds(150, 214, 150, 30);
		frame.getContentPane().add(returnBook);
		
		JButton logout = new JButton("Logout");
		logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianLogin.main(new String[] {});
				frame.dispose();
			}
		});
		logout.setBounds(150, 320, 150, 30);
		frame.getContentPane().add(logout);
	}

}
