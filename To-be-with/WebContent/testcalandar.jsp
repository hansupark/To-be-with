<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*" %>
<%@page import="controller.HttpUtil"%>

<%@page import="dao.*" %> 
<%@page import="vo.*"  %>
<%@page import="service.*"  %>
    
<%@ page import = "java.util.ArrayList" %>
<%@ page import = "controller.HttpUtil.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

<%
		HttpUtil.Login(request, response);
		int LoginUserNum = (int) session.getAttribute("LoginUserNum");

		TravelVo vo = new TravelVo(); 
		ApplyVo vo_A = new ApplyVo();
		UserVo vou=new UserVo();
		ReportVo vor=new ReportVo();

		vo.setUserNum(LoginUserNum); /**/

		vo_A.setUserNum(LoginUserNum);
		vou.setUserNum(LoginUserNum);
		vou = UserService.getInstance().selectUser_byUserNum(vou);
		vor.setReporterNum(LoginUserNum);
		
		ArrayList<TravelVo> list_travel = TravelService.getService().getTravelLists_ByUserNum(vo);                               		
		ArrayList<ApplyVo> list_Apply=ApplyService.getService().getApplyList_ByUserNum(vo_A);
		ArrayList<ReportVo> list_report=ReportService.getService().selectReports_ByReporterNum(vor);
   
%> 

                		
	      


	<% 

	ArrayList<Calendar> dates = new ArrayList<Calendar>();	
	for(ApplyVo apply : list_Apply)
	{
		
	Calendar cr = Calendar.getInstance(); //날짜 클래스 사용위해 선언필요
	TravelVo travel = new TravelVo();
	travel.setTravelNum(apply.getTravelNum());
	travel = TravelService.getService().getTravel(travel);
	
	String td = travel.getTravelDate(); //동행 날짜받고
	System.out.println("td = " + td);
	
	//날짜 세팅	
	//DB 의 0000-00-00 형식을 분할하여 설정하고
	cr.set(Calendar.YEAR,Integer.parseInt(td.substring(0,4)));
	cr.set(Calendar.MONTH,Integer.parseInt(td.substring(5,7)));
	cr.set(Calendar.DATE,Integer.parseInt(td.substring(8,10)));
	dates.add(cr);
	}
	%>
<table width="400" cellpadding="2" cellspacing="0" border="1" align="center">
 	<tr height="30">
  	<td><font size="2">일</font></td>
  	<td><font size="2">월</font></td>
  	<td><font size="2">화</font></td>
  	<td><font size="2">수</font></td>
  	<td><font size="2">목</font></td>
  	<td><font size="2">금</font></td>
  	<td><font size="2">토</font></td>
 	</tr>
 	<tr height="30">
	<%

	for(int x = 1 ; x <= 12 ; x++) // x는 month
	{
		ArrayList<Calendar> crs = new ArrayList<Calendar>();
		ArrayList<String> dayOnMonth = new ArrayList<String>();
		for(Calendar cr : dates)
		{
			if(cr.get(Calendar.MONTH) == x)
			{
				crs.add(cr);
			}
		}		
			//분할한것을 설정한 변수에 집어넣고
		int startDate = 1;
	 
		// 해당 월의 마지막 날을 구함
		int endDate = 31;
	 
		// 1일의 요일을 구함
		int startDay = 1;
		
		for(Calendar cr : crs)
		{
			int year = cr.get(Calendar.YEAR);
			int month = cr.get(Calendar.MONTH);
			int date = cr.get(Calendar.DATE);
			
			String today = year + "-" + ((month<10)?"0":"") +(month)+ "-"+((date<10)?"0":"") +date; // 오늘 날짜 세팅하는 것을 동행날짜로 세팅하는 거로 변경
			System.out.println(today);
			dayOnMonth.add(today);
			startDate = cr.getMinimum(Calendar.DATE);
			endDate = cr.getActualMaximum(Calendar.DATE);
			startDay = cr.get(Calendar.DAY_OF_WEEK);
		}
		
		
		
		// 1일부터 시작하는 달력을 만들기 위해 오늘의 연도,월을 셋팅하고 일부분은 1을 셋팅한다.
		
		//cr.set(year, month, 1);
	 
		// 셋팅한 날짜로 부터 아래 내용을 구함
	 
		// 해당 월의 첫날를 구함
		
		int count = 0;
			
		for (int i=1;i<startDay;i++){
	 	count++;
		%>
	    	    <td>&nbsp;</td>
		<%
		}
			for (int i=startDate;i<=endDate;i++){
	 		//오늘 날짜를 받는 함수이기에 여기에 추가한다.
	 		String bgcolor =  "#FFFFFF";
	 		for(String today : dayOnMonth)
	 		{	 			
	 			System.out.println("day : " + today.substring(8,10));
	 			if(today.substring(8,10).equals("" +i) || today.substring(8,10).equals("0" +i))
	 			{
	 				System.out.println("Colored day : " + today.substring(8,10));
	 				bgcolor = "#CCCCCC";
	 				break;
	 			}
	 			 
	 		}
			//String bgcolor = (today.equals(year+"-"+(month)+"-"+i))? "#CCCCCC" : "#FFFFFF";
	 		//System.out.println("today = " + today);
	 		
	 		String color = (count%7 == 0 || count%7 == 6)? "red" : "black";
	 		count++;
		%>
	  	<td bgcolor="<%=bgcolor%>"><font size="2" color=<%=color%>><%=i %></font></td>
		<%
	  	if(count%7 == 0 && i < endDate){
		%>
	 	</tr>
	 	<tr height="30">
		<%
	 		 }
		}
		while(count%7 != 0){
		%>
	       <td>&nbsp;</td>
	<%
			count++;
	 	}
		}
%>
</tr> 
</table>

</body>
</html>
