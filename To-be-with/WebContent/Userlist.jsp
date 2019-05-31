<%@page import="service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="dao.UserDao"%> 
<%@page import="vo.*" %>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE  >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User List</title>
</head>
<body>
 
<h2> UerList</h2>
 
<table border="1"> 
 
    <tr>
                <th>이름</th>    
                <th>이메일</th>
                <th>비밀번호</th>
                <th>성별</th>
                <th>생년월일</th>
    			<th>전화번호</th>
    			<th>카카오ID</th>
    </tr>
 
 
<%
        UserVo vo=new UserVo();

		UserService service = UserService.getInstance();
        //dao.dbConn();   db 연결 확인 작업
        
         ArrayList<UserVo> list = service.selectUsers_Admin(vo);
         for(UserVo dto:list){
                     
%>
 
        <tr>
                <td><%=vo.getName() %></td>
                <td><%=vo.getEmail() %></td>
                <td><%=vo.getPassword() %></td>
                <td><%=vo.getGender() %></td>
                <td><%=vo.getDate_Of_Birth() %></td>
                <td><%=vo.getPhone_Number() %></td>
        		<td><%=vo.getKakao_ID() %></td>
        </tr>
<%
 
         } //for 문의 끝
%>
 </table>
 
</body>
</html>
