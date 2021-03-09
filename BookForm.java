package portfolio;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BookForm {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookForm window = new BookForm();
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
	public BookForm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel addBookLabel = new JLabel("Add a Book");
		addBookLabel.setForeground(Color.DARK_GRAY);
		addBookLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addBookLabel.setBounds(179, 11, 92, 14);
		frame.getContentPane().add(addBookLabel);
		
		JLabel callNoLabel = new JLabel("Call No:");
		callNoLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		callNoLabel.setBounds(25, 50, 48, 14);
		frame.getContentPane().add(callNoLabel);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setBounds(25, 80, 48, 14);
		frame.getContentPane().add(nameLabel);
		
		JLabel authorLabel = new JLabel("Author:");
		authorLabel.setBounds(25, 110, 48, 14);
		frame.getContentPane().add(authorLabel);
		
		JLabel publisherLabel = new JLabel("Publisher:");
		publisherLabel.setBounds(25, 140, 65, 14);
		frame.getContentPane().add(publisherLabel);
		
		JLabel quantityLabel = new JLabel("Quantity:");
		quantityLabel.setBounds(25, 170, 65, 14);
		frame.getContentPane().add(quantityLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 47, 156, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 77, 156, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(150, 107, 156, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(150, 137, 156, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(150, 167, 156, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Add a Book");
		btnNewButton.setBounds(150, 208, 156, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Go Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[] {});
				frame.dispose();
			}
		});
		btnNewButton_1.setBounds(150, 295, 156, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
