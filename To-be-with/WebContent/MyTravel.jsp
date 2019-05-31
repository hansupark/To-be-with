<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import = "vo.*" %> <!-- /* 로그인 구현 완료시 다시 수정하기 */ -->
<%@ page import = "service.*" %>
<%@ page import = "dao.*" %> <!-- /* 로그인 구현 완료시 다시 수정하기 */ -->
<%@ page import = "java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	TravelVo vo = new TravelVo(); /* 로그인 구현 완료시 다시 수정 */
	ApplyVo vo_A = new ApplyVo();
	vo.setUserNum(1); /* 로그인 구현 완료시 다시 수정 */
	ArrayList<TravelVo> list_travel = TravelDao.getInstance().getTravels_ByUserNum(vo);
	ArrayList<ApplyVo> list_apply;
%>
<body>
	<h1>작성된 동행들</h1>
	<% 
		for(TravelVo travel : list_travel)
		{
			out.println(travel.getTitle() + "<br>");
			vo_A.setTravelNum(travel.getTravelNum());
			list_apply = ApplyService.getService().getApplyList_ByTravelNum(vo_A);
			for(ApplyVo apply : list_apply)
			{
				out.println("신청한 회원 넘버 : " + apply.getUserNum() + "<br>");
			}
		}
	%>
</body>
</html>