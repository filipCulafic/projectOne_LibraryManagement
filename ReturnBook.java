package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnBook {

	private JFrame frame;
	private JTextField bookCallnoField;
	private JTextField studentIDField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReturnBook window = new ReturnBook();
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
	public ReturnBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 278);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel returnBookLabel = new JLabel("Return A Book");
		returnBookLabel.setForeground(Color.DARK_GRAY);
		returnBookLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		returnBookLabel.setBounds(167, 11, 115, 14);
		frame.getContentPane().add(returnBookLabel);
		
		JLabel bookCallnoLabel = new JLabel("Book Callno:");
		bookCallnoLabel.setBounds(20, 50, 90, 15);
		frame.getContentPane().add(bookCallnoLabel);
		
		JLabel studentIDLabel = new JLabel("Student ID:");
		studentIDLabel.setBounds(20, 85, 90, 15);
		frame.getContentPane().add(studentIDLabel);
		
		bookCallnoField = new JTextField();
		bookCallnoField.setBounds(152, 47, 146, 20);
		frame.getContentPane().add(bookCallnoField);
		bookCallnoField.setColumns(10);
		
		studentIDField = new JTextField();
		studentIDField.setBounds(152, 82, 146, 20);
		frame.getContentPane().add(studentIDField);
		studentIDField.setColumns(10);
		
		JButton returnBookButton = new JButton("Return The Book");
		returnBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookCallno = bookCallnoField.getText();
				int studentID = Integer.parseInt(studentIDField.getText());
				int i = ReturnBookDao.delete(bookCallno, studentID);
				if (i>0) {
					JOptionPane.showMessageDialog(frame, "Book returned successfully!");
					LibrarianSuccess.main(new String[]{});
					frame.dispose();
				} else {
					JOptionPane.showMessageDialog(frame, "Sorry, unable to return the book");
				}
			}
		});
		returnBookButton.setBounds(152, 134, 146, 30);
		frame.getContentPane().add(returnBookButton);
		
		JButton goBackButton = new JButton("Go Back");
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[] {});
				frame.dispose();
			}
		});
		goBackButton.setBounds(152, 195, 146, 23);
		frame.getContentPane().add(goBackButton);
	}

}
