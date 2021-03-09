package portfolio;


import java.sql.*;

public class ReturnBookDao {
	
	public static int delete(String bookCallno, int studentID) {
		int status = 0;
		
		try {
			Connection connection = Driver.getConnection();
			
			status = updateBook(bookCallno);
			
			if (status > 0 ) {
			PreparedStatement ps = connection.prepareStatement("delete from issue_books where bookCallno=? and studentID=?");
			ps.setString(1, bookCallno);
			ps.setInt(2, studentID);
			status = ps.executeUpdate();
			}
			connection.close();
			
		} catch (Exception e) {
			System.out.println();
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
			
			if (issued > 0) {
				PreparedStatement ps2 = connection.prepareStatement("update books set quantity=?,issued=? where callno=?");
				ps2.setInt(1, quantity+1);
				ps2.setInt(2, issued-1);
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
