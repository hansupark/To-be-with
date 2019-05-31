package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vo.AdminVo;
import vo.ReportVo;

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

	public AdminVo selectAdmin(AdminVo vo) {
		
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		AdminVo admin = null;
		try
		{
			admin = new AdminVo();
			sql = String.format("select * from admin where id = %s","\"" +vo.getId() + "\"");
			System.out.println(sql);
			conn = connect();	
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			admin.setAdminNum(rs.getInt("adminNum"));
			admin.setId(rs.getString("id"));
			admin.setPw(rs.getString("password"));
			admin.setName(rs.getString("name"));			
		}
		
		catch(Exception e)
		{
			System.out.println("AdminDao : selectAdmin error : " + e);
		}
		
		finally
		{
			close(conn, psmt);
		}
		
		return admin;
	}
}
