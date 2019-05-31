<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%@page import="dao.ReportDao"%> 
<%@page import="vo.ReportVo" %>
<%@page import="java.util.ArrayList"%>
<%@page import="service.ReportService" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Story</title>
</head>

<body>
<div class="page-wrapper">
    <div class="container-fluid">
        <div class="col-lg-8"><!--게시판 넓이 -->
            <div class="col-lg-12">
                <h1 class="page-header">User List</h1>
            </div>
            <div class="row">
                  <div class="col-lg-12">
                      
                  </div>
              </div>
            <div class="panel panel-default">
                <div class="panel-heading">User List </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>고유번호</th>
                                <th>신고자회원번호</th> 
                                <th>신고대상유전</th>
                                <th>제목</th>
                                <th>내용</th>
                                <th>신고 Type</th>
                                <th>게시물번호</th>
                            </tr>
                            <%
  						//신고자 List 배열 가져온 후에 vo 및 Dao에 맞는 배열 쓰기
                        ReportVo vo=new ReportVo();
						            ReportService service = ReportService.getService();
         				        ArrayList<ReportVo> list = service.selectReports(vo);
         				        for(ReportVo dto:list){        
							              %>       
							<tr>
                			<td><%=dto.getReportNum() %></td>
                			<td><%=dto.getReporterNum() %></td>
                			<td><%=dto.getReportedUserNum() %></td>
              			  <td><%=dto.getTitle() %></td>
            			    <td><%=dto.getContent() %></td>
			                <td><%=dto.getType() %></td>
        					    <td><%=dto.getObjectNum() %></td>
				        </tr>
				        
				        <%
 
         					} //for 문의 끝
						%>
				        

                        </thead>
                 
					</table>
					<p>[신고Type] 0:후기공유  1:동행찾기</p>
            </div>
        </div>
    </div>
</div>
</body>
</html>