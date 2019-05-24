package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class AdminDao {

	private static AdminDao dao = new AdminDao();
	private AdminDao() {}
	
	public static AdminDao getInstance() 
	{
		return dao;
	}
	
	public Connection connect()
	{
		Connection conn = null;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/tobewith";
			String user = "root";
			String pwd = "cs1234";
			conn = DriverManager.getConnection(url,user,pwd);
		}
		catch(Exception e)
		{
			System.out.println("Connenction error : " + e);
		}
		return conn;
	}
	public void close(Connection conn, PreparedStatement psmt)
	{
		if(psmt != null)
		{
			try
			{
				psmt.close();
			}
			catch(Exception e)
			{
				System.out.println("close : psmt error : " + e);
			}
		}
		
		if(conn != null)
		{
			try
			{
				conn.close();
			}
			catch(Exception e)
			{
				System.out.println("close : conn error : " + e);
			}
		}
	}
}
