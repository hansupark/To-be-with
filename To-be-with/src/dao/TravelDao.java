package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import vo.TravelVo;

public class TravelDao {

	private static TravelDao dao = new TravelDao();
	private TravelDao() {}
	
	public static TravelDao getInstance() 
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
	
	public ArrayList<TravelVo> getTravelList(TravelVo vo)
	{
		ArrayList<TravelVo> list = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;		
		String country = vo.getCountry();
		String region = vo.getRegion();
		String travelDate = vo.getTravelDate();
		try
		{
			list = new ArrayList<TravelVo>();			
			conn = connect();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			if(country == "" && region == "" && travelDate == "")
			{
				sql = "select * from travel";
			}
			else if(region == "" && travelDate == "")
			{
				sql = String.format("select * from travel where country = %s", "\"" + country + "\"");				
			}
			else if(country == "" && region == "")
			{				
				sql = String.format("select * from travel where travelDate = %s", "\"" + travelDate + "\"");
			}
			else if(travelDate == "")
			{
				sql = String.format("select * from travel where country = %s and region = %s", "\"" + country +  "\"", "\"" + region +  "\"");
			}
			else if(region == "")
			{				
				//현재 Date값 이상하게 불러와짐			
				sql = String.format("select * from travel where country = %s and travelDate = %s", "\"" + country +  "\"", "\"" + travelDate + "\"");
			}
			else 
			{				
				sql = String.format("select * from travel where country = %s and region = %s and travelDate = %s",  "\"" +country 
						+  "\"" , "\"" + region +  "\"", "\"" + travelDate + "\"" );
			}
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			while(rs.next())
			{
				TravelVo travel = new TravelVo();
				travel.setTravelNum(rs.getInt("travelNum"));
				travel.setCountry(rs.getString("country"));
				travel.setRegion(rs.getString("region"));		
				travel.setTravelDate(format.format(rs.getDate("travelDate")));		
				travel.setTitle(rs.getString("title"));
				travel.setContent(rs.getString("content"));
				travel.setMax_Count(rs.getInt("maxCount"));
				travel.setCurrent_Count(rs.getInt("currentCount"));
				list.add(travel);
			}				
		}
		catch(Exception e)
		{
			System.out.println("TravelDao : getTravelList -> exception 발생 : " + e);
		}
		finally
		{
			close(conn, psmt);			
		}						
		return list;
	}
	
	public TravelVo getTravel(TravelVo vo)
	{
		TravelVo travel = null;
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		String sql = null;		
		try
		{
			int travelNum = vo.getTravelNum();
			travel = new TravelVo();
			conn = connect();
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			sql = String.format("select * from travel where travelNum = %d", travelNum);
			System.out.println(sql);
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			rs.next();
			travel.setTravelNum(rs.getInt("travelNum"));
			travel.setCountry(rs.getString("country"));
			travel.setRegion(rs.getString("region"));		
			travel.setTravelDate(format.format(rs.getDate("travelDate")));		
			travel.setTitle(rs.getString("title"));
			travel.setContent(rs.getString("content"));	
			travel.setMax_Count(rs.getInt("maxCount"));
			travel.setCurrent_Count(rs.getInt("currentCount"));
		}
		catch(Exception e)
		{
			System.out.println("TravelDao : getTravel -> exception 발생 : " + e);
		}
		finally
		{
			close(conn, psmt);			
		}						
		return travel;
	}
	
	public int insertTravel(TravelVo vo)
	{
		Connection conn = null;
		PreparedStatement psmt = null;
		String sql = null;
		int result = 0;
		
		try
		{
			conn = connect();
			sql = "insert into travel(userNum,travelDate,country,region) values(?,?,?,?)";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(0,vo.getUserNum());
			psmt.setString(1,vo.getTravelDate());
			psmt.setString(2,vo.getCountry());
			psmt.setString(3,vo.getRegion());
			result = psmt.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println("TravelDao : insertTravel -> exception 발생 : " + e);
		}
		finally
		{
			close(conn, psmt);
		}
		return result;
	}
	
}
