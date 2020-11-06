package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	static private String conString="jdbc:mysql://"
			+ "localhost:33006/javacb9?seUnicode=true&characterEncoding=UTF-8\r\n" + 
			"\r\n" + 
			"";
	static  private Connection connection;
	public String getConString() {
		return conString;
	}
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection= DriverManager.getConnection(conString,"root","123456");
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	public static Connection getConnection() {
		return connection;
	}
	public static void setConnection(Connection connection) {
		DBConnection.connection = connection;
	}
	public void reInitConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		if(connection==null||connection.isClosed()) {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection= DriverManager.getConnection(conString,"root","123456");
		}
	}
	public void closeConnection() {
		try {
			connection.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
