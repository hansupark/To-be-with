<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath"  value="${pageContext.request.contextPath}"  />
<%@page import="dao.UserDao"%> 
<%@page import="vo.*" %>
<%@page import="java.util.ArrayList"%>
<%@page import="service.UserService" %>
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
                      <button type="button" onclick="location.href='uploadstory.jsp'" class="btn btn-outline btn-primary pull-right">
                          <i class="fa fa-edit fa-fw"></i> 글쓰기
                      </button>
                  </div>
              </div>
            <div class="panel panel-default">
                <div class="panel-heading">User List </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>이름</th>
                                <th>E-mail</th> <!-- 게시물 들어갈 수 있는 태그 -->
                                <th>Password</th>
                                <th>성별</th>
                                <th>생일</th>
                                <th>전화번호</th>
                                <th>카카오톡 ID</th>
                            </tr>
                            <%
  						UserVo vo=new UserVo();
						UserService service = UserService.getInstance();
         				ArrayList<UserVo> list = service.selectUsers(vo);
         				for(UserVo dto:list){        
							%>       <tr>
                			<td><%=dto.getName() %></td>
                			<td><%=dto.getEmail() %></td>
                			<td><%=dto.getPassword() %></td>
              			    <td><%=dto.getGender() %></td>
            			    <td><%=dto.getDate_Of_Birth() %></td>
			                <td><%=dto.getPhone_Number() %></td>
        					<td><%=dto.getKakao_ID() %></td>
				        </tr>
				        <%
 
         					} //for 문의 끝
						%>
				        

                        </thead>
                 
					</table>

            </div>
        </div>
    </div>
</div>
</body>
</html>
