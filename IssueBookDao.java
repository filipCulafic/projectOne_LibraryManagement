package portfolio;

import java.sql.*;

public class IssueBookDao {
	
	public static boolean checkBook(String bookCallno) {
		boolean status = false;
		try {
			Connection connection = Driver.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from books where callno=?");
			ps.setString(1, bookCallno);
			ResultSet rs = ps.executeQuery();
			status = rs.next();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int save(String bookCallno, int studentID, String studentName, String studentContact ) {
		int status = 0;
		try {
			Connection connection = Driver.getConnection();
		
			status = updateBook(bookCallno);
			
			PreparedStatement ps = connection.prepareStatement("insert into issue_books(bookCallno,studentID,studentName,studentContact) values(?,?,?,?)");
			ps.setString(1, bookCallno);
			ps.setInt(2, studentID);
			ps.setString(3, studentName);
			ps.setString(4, studentContact);
			status = ps.executeUpdate();
			connection.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	
	public static int updateBook(String bookCallno) {
		int status = 0;
		int quantity = 0;
		int issued = 0;
		
		try {
			Connection connection = Driver.getConnection();
			PreparedStatement ps = connection.prepareStatement("select quantity, issued from books where callno=?");
			ps.setString(1, bookCallno);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				quantity = rs.getInt("quantity");
				issued = rs.getInt("issued");
			}
			
			if (quantity > 0) {
				PreparedStatement ps2 = connection.prepareStatement("update books set quantity=?,issued=? where callno=?");
				ps2.setInt(1, quantity-1);
				ps2.setInt(2, issued+1);
				ps2.setString(3, bookCallno);
				status = ps2.executeUpdate();
			}
			connection.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
		
	}

}
