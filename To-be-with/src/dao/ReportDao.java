package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import vo.ReportVo;

public class ReportDao {

	private static ReportDao dao = new ReportDao();
	private ReportDao() {}
	
	public static ReportDao getInstance() 
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
	
	public int insertReport(ReportVo vo)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		try
		{
			System.out.println(vo.toString());
			sql = String.format("insert into report(reporterNum,reportedUserNum,title,content,type,objectNum)"
					+ " values(%d,%d,%s,%s,%d,%d)",vo.getReporterNum(),vo.getReportedUserNum(),
					"\"" +vo.getTitle() + "\"","\"" +vo.getContent() + "\"",vo.getType(),vo.getObjectNum());
			System.out.println(sql);
			conn = connect();
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("reportDao : insertReport error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
	
	public ReportVo selectReport(ReportVo vo)
	{
		ReportVo report = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		try
		{
			sql = String.format("select * from report where reportNum = %d",vo.getReportNum());
			conn = connect();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			report = new ReportVo();
			report.setReportNum(rs.getInt("reportNum"));
			report.setReporterNum(rs.getInt("reporterNum"));
			report.setReportedUserNum(rs.getInt("reportedUserNum"));
			report.setTitle(rs.getString("title"));
			report.setContent(rs.getString("content"));
			report.setType(rs.getShort("type"));
			report.setApproved(rs.getBoolean("isApproved"));
			report.setObjectNum(rs.getInt("obejctNum"));
		}
		catch(Exception e)
		{
			System.out.println("reportDao : selectReport error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return report;
	}
	
	public ArrayList<ReportVo> selectReports_ByReporterNum(ReportVo vo)
	{
		ArrayList<ReportVo> list = null;
		ReportVo report = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		try
		{
			list = new ArrayList<ReportVo>();
			sql = String.format("select * from report where reporterNum = %d",vo.getReporterNum());
			conn = connect();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				report = new ReportVo();
				report.setReportNum(rs.getInt("reportNum"));
				report.setReporterNum(rs.getInt("reporterNum"));
				report.setReportedUserNum(rs.getInt("reportedUserNum"));
				report.setTitle(rs.getString("title"));
				report.setContent(rs.getString("content"));
				report.setType(rs.getShort("type"));
				report.setObjectNum(rs.getInt("objectNum"));
				list.add(report);
			}
		
		}
		catch(Exception e)
		{
			System.out.println("reportDao : selectReports_ByReporterNum error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return list;
	}
	
	public ArrayList<ReportVo> selectReports(ReportVo vo)
	{
		ArrayList<ReportVo> list = null;
		ReportVo report = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		ResultSet rs = null;
		try
		{
			list = new ArrayList<ReportVo>();
			sql = String.format("select * from report");
			conn = connect();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				report = new ReportVo();
				report.setReportNum(rs.getInt("reportNum"));
				report.setReporterNum(rs.getInt("reporterNum"));
				report.setReportedUserNum(rs.getInt("reportedUserNum"));
				report.setTitle(rs.getString("title"));
				report.setContent(rs.getString("content"));
				report.setType(rs.getShort("type"));
				report.setObjectNum(rs.getInt("objectNum"));
				list.add(report);
			}
		
		}
		catch(Exception e)
		{
			System.out.println("reportDao : selectReports error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return list;
	}
	
	public int updateReport(ReportVo vo)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		try
		{
			sql = String.format("update set reporterNum = %d,reportedUserNum = %d"
					+ ",title = %s,content = %s,type = %d,objectNum = %d where reportNum = %d",vo.getReporterNum(),vo.getReportedUserNum(),
					vo.getTitle(),vo.getContent(),vo.getType(),vo.getObjectNum(),vo.getReportNum());
			conn = connect();
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("reportDao : updateReport error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
	
	public int deleteReport(ReportVo vo)
	{
		int result = 0;
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		try
		{
			sql = String.format("delete from report where reportNum = %d",vo.getReportNum());
			conn = connect();
			psmt = conn.prepareStatement(sql);
			result = psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("reportDao : deleteReport error : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
}
