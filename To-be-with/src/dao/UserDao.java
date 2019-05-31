package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			conn = connect();
			sql = "insert into user(email,password,name,gender,date_Of_Birth,kakao_Id,phone_Number) values(?,?,?,?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,user.getEmail());
			psmt.setString(2,user.getPassword());
			psmt.setString(3,user.getName());
			psmt.setInt(4,user.getGender());
			java.sql.Date date = java.sql.Date.valueOf(user.getDate_Of_Birth());
			psmt.setDate(5, date);
			psmt.setString(6,user.getKakao_ID());
			psmt.setString(7, user.getPhone_Number());
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
	
	public int UpdateUser(UserVo user)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try
		{
			conn = connect();
			sql = "update user set email = ?,password = ?,name = ?,gender = ?,date_Of_Birth = ?,kakao_Id"
					+ " = ?,  phone_Number = ?, isApproved = ? where userNum = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,user.getEmail());
			psmt.setString(2,user.getPassword());
			psmt.setString(3,user.getName());
			psmt.setInt(4,user.getGender());
			java.sql.Date date = java.sql.Date.valueOf(user.getDate_Of_Birth());
			psmt.setDate(5, date);
			psmt.setString(6,user.getKakao_ID());
			psmt.setString(7, user.getPhone_Number());
			psmt.setBoolean(8,user.getIsApproved());
			psmt.setInt(9, user.getUserNum());
		    result = psmt.executeUpdate();		    
		}
		catch(Exception e)
		{
			System.out.println("UserDao : updateUser error : " + e);
		}
		finally 
		{
			close(conn, psmt);
		}
		
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
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
				result.setDate_Of_Birth(format.format(rs.getDate("date_Of_Birth")));
				result.setKakao_ID(rs.getString("kakao_Id"));
				result.setIsApproved(rs.getBoolean("isApproved"));
				result.setPhone_Number(rs.getString("phone_Number"));
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
	
	public UserVo SelectUser_byPhoneNumber(UserVo user)
	{		
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		UserVo result = null;		
		try
		{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			conn = connect();
			sql = String.format("select * from user where phone_Number = %s", "\"" +user.getPhone_Number() + "\"");
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);		
			rs = psmt.executeQuery();			
			while(rs.next())
			{
				result = new UserVo();
				result.setUserNum(rs.getInt("userNum"));			
			}
		}
		catch(Exception e)
		{
			System.out.println("UserDao : selectUser_byphone_Number error : " + e);
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
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
				result.setDate_Of_Birth(format.format(rs.getDate("date_Of_Birth")));
				result.setKakao_ID(rs.getString("kakao_Id"));
				result.setIsApproved(rs.getBoolean("isApproved"));
				result.setPhone_Number(rs.getString("phone_Number"));
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
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
				result.setPassword(rs.getString("password"));
				result.setName(rs.getString("name"));
				result.setGender(rs.getShort("gender"));
				result.setDate_Of_Birth(format.format(rs.getDate("date_Of_Birth")));
				result.setKakao_ID(rs.getString("kakao_Id"));
				result.setIsApproved(rs.getBoolean("isApproved"));
				result.setPhone_Number(rs.getString("phone_Number"));
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

	public int deleteUser(UserVo user) {

		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try
		{
			conn = connect();
			sql = "delete from user where userNum = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1,user.getUserNum());
		    result = psmt.executeUpdate();		    
		}
		catch(Exception e)
		{
			System.out.println("UserDao : deleteUser error : " + e);
		}
		finally 
		{
			close(conn, psmt);
		}
		
		return result;
	}
	
	
}
