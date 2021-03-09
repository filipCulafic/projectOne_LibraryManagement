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

public class DeleteLibrarian {

	private JFrame frame;
	private JTextField enterIDField;

	/**
	 * Launch the application.
	 *
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteLibrarian window = new DeleteLibrarian();
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
	public DeleteLibrarian() {
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
		
		JLabel enterLibrarianID = new JLabel("Enter Librarian ID");
		enterLibrarianID.setForeground(Color.DARK_GRAY);
		enterLibrarianID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		enterLibrarianID.setBounds(155, 31, 139, 14);
		frame.getContentPane().add(enterLibrarianID);
		
		enterIDField = new JTextField();
		enterIDField.setBounds(155, 62, 139, 20);
		frame.getContentPane().add(enterIDField);
		enterIDField.setColumns(10);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sid = enterIDField.getText();
				if (sid == null || sid.trim().equals("")) {
					JOptionPane.showMessageDialog(frame, "ID cannot be blank.");
				} else {
					int id = Integer.parseInt(sid);
					int i = LibrarianDao.delete(id);
					if (i>0) {
						JOptionPane.showMessageDialog(frame, "Record has ben deleted successfully");
					} else {
						JOptionPane.showMessageDialog(frame, "Unable to delete given ID!");
					}
				}
				
				
			}
		});
		delete.setFont(new Font("Tahoma", Font.BOLD, 11));
		delete.setBounds(155, 103, 139, 23);
		frame.getContentPane().add(delete);
		
		JButton goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AdminSuccess.main(new String[] {});
				frame.dispose();
			}
		});
		goBack.setBounds(155, 185, 139, 23);
		frame.getContentPane().add(goBack);
	}

}
