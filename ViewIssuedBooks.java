package portfolio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;


public class ViewIssuedBooks {

	private JFrame frame;
	private JPanel contentPane;
	private JTable table;
	private JButton goBack;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewIssuedBooks window = new ViewIssuedBooks();
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
	public ViewIssuedBooks() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		contentPane.setLayout(new BorderLayout(0,0));
		frame.setContentPane(contentPane);
		
		String data[][] = null;
		String column[] = null;
		
		try {
			Connection connection = Driver.getConnection();
			PreparedStatement ps = connection.prepareStatement("select bookCallno,studentID,studentName,studentContact,issuedDate from issue_books",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			ResultSet rs = ps.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			column = new String[cols];
			for (int i = 1; i<=cols; i++) {
				column[i-1] = rsmd.getColumnName(i);
			}
			
			rs.last();
			int rows = rs.getRow();
			rs.beforeFirst();
			
			data = new String[rows][cols];
			int count = 0;
			while(rs.next()) {
				for (int i = 1; i<=cols; i++) {
					data[count][i-1] = rs.getString(i);
				}
				count++;
			}
			connection.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		table = new JTable(data, column);
		JScrollPane sp = new JScrollPane(table);
		
		contentPane.add(sp, BorderLayout.CENTER);
		
		goBack = new JButton("Go Back");
		goBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LibrarianSuccess.main(new String[] {});
				frame.dispose();
			}
		});
		contentPane.add(goBack, BorderLayout.SOUTH);
	}

}
