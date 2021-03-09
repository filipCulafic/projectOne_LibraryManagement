package portfolio;

import java.sql.*;

public class LibrarianDao {
	
	public static int save(String name, String password, String email, String address, String city, String contact){
		int status = 0;
		
		try {
			Connection connection = Driver.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into librarians(name,password,email,address,city,contact) values(?,?,?,?,?,?)");
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, address);
			ps.setString(5, city);
			ps.setString(6, contact);
			
			status = ps.executeUpdate();
			connection.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;	
	}
	
	public static int delete(int id) {
		int status = 0;
		try {
			Connection connection = Driver.getConnection();
			PreparedStatement ps = connection.prepareStatement("delete from librarians where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			connection.close();
		}
		catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static int updateLogbook(String name, String password) {
		int status = 0;
		try {
			Connection connection = Driver.getConnection();
			PreparedStatement ps = connection.prepareStatement("insert into logbook (name, email, address, contact) select name, email, address, contact from librarians where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			status = ps.executeUpdate();
			connection.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	public static boolean validate(String name, String password) {
		boolean status = false;
		
		try {
			Connection connection = Driver.getConnection();
			PreparedStatement ps = connection.prepareStatement("select * from librarians where name=? and password=?");
			ps.setString(1, name);
			ps.setString(2, password);
			ResultSet resultSet = ps.executeQuery();

			
			status = resultSet.next();
			connection.close();
			
			
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
		
	}
	
	
	

}
