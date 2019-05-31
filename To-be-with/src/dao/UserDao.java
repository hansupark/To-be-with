package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public int InsertUser(UserVo user)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try
		{
			conn = connect();
			sql = "insert into user(email,password,name,gender,date_Of_Birth,kakao_Id) values(?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
		    result = psmt.executeUpdate();		    
		}
		catch(Exception e)
		{
			System.out.println("UserDao : insertUser error : " + e);
		}
		finally 
		{
			close(conn, psmt);
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
	
	public UserVo SelectUser(UserVo user)
	{		
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		UserVo result = null;		
		try
		{
			conn = connect();
			sql = String.format("select * from user where email = %s", "\"" +user.getEmail() + "\"");
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);		
			rs = psmt.executeQuery();			
			while(rs.next())
			{
				result = new UserVo();
				result.setUserNum(rs.getInt("userNum"));
				result.setEmail(rs.getString("email"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setGender(rs.getShort("gender"));
				result.setDate_Of_Birth(rs.getDate("date_Of_Birth"));
				result.setKakao_ID(rs.getString("kakao_Id"));
				result.setIsApproved(rs.getBoolean("isApproved"));
			}
		}
		catch(Exception e)
		{
			System.out.println("UserDao : selectUser error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
	
	public UserVo SelectUser_byUserNum(UserVo user)
	{		
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		UserVo result = null;		
		try
		{
			conn = connect();
			sql = String.format("select * from user where userNum = %d",user.getUserNum());
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();			
			while(rs.next())
			{
				result = new UserVo();
				result.setUserNum(rs.getInt("userNum"));
				result.setEmail(rs.getString("email"));
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setGender(rs.getShort("gender"));
				result.setDate_Of_Birth(rs.getDate("date_Of_Birth"));
				result.setKakao_ID(rs.getString("kakao_Id"));
				result.setIsApproved(rs.getBoolean("isApproved"));	
			}
		}
		catch(Exception e)
		{
			System.out.println("UserDao : selectUser_byUserNum error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
	
	public ArrayList<UserVo> selectUsers(UserVo vo) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;		
		ArrayList<UserVo> list = null;
		try
		{
			conn = connect();
			sql = String.format("select * from user");
			psmt = conn.prepareStatement(sql);			
			rs = psmt.executeQuery();
			list = new ArrayList<UserVo>();
			
			while(rs.next())
			{
				UserVo result = new UserVo();
				result.setUserNum(rs.getInt("userNum"));
				result.setEmail(rs.getString("email"));
				list.add(result);
			}
		}
		catch(Exception e)
		{
			System.out.println("UserDao : selectUsers error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		
		return list;
	}
	
	
}
