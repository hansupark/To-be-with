package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.ApplyVo;
import vo.signUpImageVo;

public class singUpImageDao {

	private static singUpImageDao dao = new singUpImageDao();
	private singUpImageDao() {}
	
	public static singUpImageDao getInstance() 
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
	
	public ArrayList<signUpImageVo> getSignUpImages(signUpImageVo image)
	{
		ArrayList<signUpImageVo> list = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		signUpImageVo vo = null;
		
		try
		{
			list = new ArrayList<signUpImageVo>();
			conn = connect();
			sql = String.format("select * from apply");
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				vo = new signUpImageVo();
				vo.setImageNum(rs.getInt("imageNum"));
				vo.setUserNum(rs.getInt("userNum"));
				vo.setImage(rs.getString("imageSource"));
				list.add(vo);
			}
		}
		catch(Exception e)
		{
			System.out.println("SignUpImageDao : getSignUpImages : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return list;
	}
	
	public int insertSignUpImage(signUpImageVo image)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try
		{
			conn = connect();
			sql = String.format("insert into signUpImage(image) value(?)");
			psmt = conn.prepareStatement(sql);
			psmt.setString(1,image.getImage());
			result = psmt.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println("ApplyDao : insertImage error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
}
