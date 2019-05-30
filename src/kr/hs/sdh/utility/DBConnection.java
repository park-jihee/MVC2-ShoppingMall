package kr.hs.sdh.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() throws Exception{
		Connection conn = null;
		
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe");
		return conn;
	}
	
	public static void close(PreparedStatement stmt, Connection conn)  throws Exception{
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
	
	public static void close(ResultSet rs, PreparedStatement stmt, Connection conn)  throws Exception{
		if(stmt != null) stmt.close();
		if(conn != null) conn.close();
	}
}
