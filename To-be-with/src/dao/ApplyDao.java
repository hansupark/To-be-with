package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import vo.ApplyVo;

public class ApplyDao {

	private static ApplyDao dao = new ApplyDao();
	private ApplyDao() {}
	
	public static ApplyDao getInstance() 
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
	
	public int insertApply(ApplyVo vo)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try
		{
			conn = connect();
			sql = String.format("insert into apply(userNum,travelNum) values(%d,%d)",vo.getUserNum(),vo.getTravelNum());
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println("ApplyDao : insertApply error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
}
