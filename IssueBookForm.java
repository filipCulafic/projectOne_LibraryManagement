package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class IssueBookForm {

	private JFrame frame;
	private JTextField bookCallnoField;
	private JTextField studentIDField;
	private JTextField studentNameField;
	private JTextField studentContactField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IssueBookForm window = new IssueBookForm();
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
	public IssueBookForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel issueBookLabel = new JLabel("Issue A Book");
		issueBookLabel.setForeground(Color.DARK_GRAY);
		issueBookLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		issueBookLabel.setBounds(172, 11, 105, 14);
		frame.getContentPane().add(issueBookLabel);
		
		JLabel bookCallnoLabel = new JLabel("Book Callno:");
		bookCallnoLabel.setBounds(20, 50, 122, 15);
		frame.getContentPane().add(bookCallnoLabel);
		
		JLabel studentIDLabel = new JLabel("Student ID:");
		studentIDLabel.setBounds(20, 85, 122, 15);
		frame.getContentPane().add(studentIDLabel);
		
		JLabel studentNameLabel = new JLabel("Student Name:");
		studentNameLabel.setBounds(20, 120, 122, 15);
		frame.getContentPane().add(studentNameLabel);
		
		JLabel studentContactLabel = new JLabel("Student Contact:");
		studentContactLabel.setBounds(22, 155, 120, 15);
		frame.getContentPane().add(studentContactLabel);
		
		bookCallnoField = new JTextField();
		bookCallnoField.setBounds(152, 47, 136, 20);
		frame.getContentPane().add(bookCallnoField);
		bookCallnoField.setColumns(10);
		
		studentIDField = new JTextField();
		studentIDField.setBounds(152, 82, 136, 20);
		frame.getContentPane().add(studentIDField);
		studentIDField.setColumns(10);
		
		studentNameField = new JTextField();
		studentNameField.setBounds(152, 117, 136, 20);
		frame.getContentPane().add(studentNameField);
		studentNameField.setColumns(10);
		
		studentContactField = new JTextField();
		studentContactField.setBounds(152, 152, 136, 20);
		frame.getContentPane().add(studentContactField);
		studentContactField.setColumns(10);
		
		JButton issueBookButton = new JButton("Issue A Book");
		issueBookButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String bookCallno = bookCallnoField.getText();
				int studentID = Integer.parseInt(studentIDField.getText());
				String studentName = studentNameField.getText();
				String studentContact = studentContactField.getText();
				
				if (IssueBookDao.checkBook(bookCallno)) {
					int i = IssueBookDao.save(bookCallno, studentID, studentName, studentContact);
					
					if (i>0) {
						JOptionPane.showMessageDialog(frame, "Book issued successfully");
						LibrarianSuccess.main(new String[] {});
						frame.dispose();
					}
					else {
						JOptionPane.showMessageDialog(frame, "Sorry, unable to issue the book");
					}
				}
				
				
				
			}
		});
		issueBookButton.setBounds(152, 183, 136, 23);
		frame.getContentPane().add(issueBookButton);
		
		JButton goBackButton = new JButton("Go Back");
		goBackButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main( new String[] {});
				frame.dispose();
			}
		});
		goBackButton.setBounds(152, 247, 136, 23);
		frame.getContentPane().add(goBackButton);
	}
}
