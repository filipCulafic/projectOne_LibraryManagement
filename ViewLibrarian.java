package portfolio;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewLibrarian {

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
					ViewLibrarian window = new ViewLibrarian();
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
	public ViewLibrarian() {
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
			PreparedStatement ps = connection.prepareStatement("select * from librarians",ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
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
				frame.dispose();
			}
		});
		contentPane.add(goBack, BorderLayout.SOUTH);
		
	
	}

}
