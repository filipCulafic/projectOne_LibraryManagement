package portfolio;

import java.sql.*;

public class Driver {
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/books","root","Password");
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
