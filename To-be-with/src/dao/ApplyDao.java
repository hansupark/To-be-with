package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

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
	
	public ArrayList<ApplyVo> getApplyList_ByUserNum(ApplyVo vo)
	{
		ArrayList<ApplyVo> list = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		ApplyVo apply = null;
		
		try
		{
			list = new ArrayList<ApplyVo>();
			conn = connect();
			sql = String.format("select * from apply where userNum = %d",vo.getUserNum());
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				apply = new ApplyVo();
				apply.setApplyNum(rs.getInt("applyNum"));
				apply.setUserNum(rs.getInt("userNum"));
				apply.setTravelNum(rs.getInt("travelNum"));
				apply.setIsApproved(rs.getBoolean("isApproved"));
				list.add(apply);
			}
		}
		catch(Exception e)
		{
			System.out.println("ApplyDao : getApplyList_ByUserNum error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return list;
	}
	
	public int updateApply(ApplyVo vo)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try
		{
			conn = connect();
			sql = String.format("update apply set userNum = %d , travelNum = %d, isApproved = %d where applyNum = %d",vo.getUserNum(),vo.getApplyNum(),vo.getIsApproved());
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println("ApplyDao : updateApply error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
	
	public int deleteApply(ApplyVo vo)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		
		try
		{
			conn = connect();
			sql = String.format("delete from apply where applyNum = %d",vo.getApplyNum());
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();		
		}
		catch(Exception e)
		{
			System.out.println("ApplyDao : deleteApply error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}

	public ArrayList<ApplyVo> getApplyList_ByTravelNum(ApplyVo vo) {
		
		ArrayList<ApplyVo> list = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;
		ApplyVo apply = null;
		
		try
		{
			list = new ArrayList<ApplyVo>();
			conn = connect();
			sql = String.format("select * from apply where travelNum = %d",vo.getTravelNum());
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				apply = new ApplyVo();
				apply.setApplyNum(rs.getInt("applyNum"));
				apply.setUserNum(rs.getInt("userNum"));
				apply.setTravelNum(rs.getInt("travelNum"));
				apply.setIsApproved(rs.getBoolean("isApproved"));
				list.add(apply);
			}
		}
		catch(Exception e)
		{
			System.out.println("ApplyDao : getApplyList_ByTravelNum error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return list;
	}
	
}
