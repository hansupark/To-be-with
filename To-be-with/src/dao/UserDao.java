package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import vo.UserVo;



public class UserDao {
	
	private static UserDao dao = new UserDao();
	private UserDao() {}
	
	public static UserDao getInstance() 
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
	
	public boolean InsertUser(UserVo user)
	{
		boolean result = false;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try
		{
			conn = connect();
			sql = "insert into user(email,password,name,gender,date_Of_Birth,kakao_Id) values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
		
		}
		catch(Exception e)
		{
			
		}
		
		
		return result;
	}
	
	public boolean UpdateUser(UserVo user)
	{
		boolean result = false;
		
		return result;
	}
	
	public boolean DeleteUser(UserVo user)
	{
		boolean result = false;
		
		return result;
	}
	
	public boolean SelectUser(UserVo user)
	{
		boolean result = false;
		
		return result;
	}
	
	
}
