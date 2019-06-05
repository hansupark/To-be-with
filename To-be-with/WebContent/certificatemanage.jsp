<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@page import="dao.singUpImageDao"%> 
<%@page import="vo.signUpImageVo" %>
<%@page import="java.util.ArrayList"%>
<%@page import="service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title></title>
</head>

<body>
<div class="page-wrapper">
    <div class="container-fluid">
        <div class="col-lg-8"><!--게시판 넓이 -->
            <div class="col-lg-12">
                <h1 class="page-header">Certificate Manage</h1>
            </div>
            <div class="row">
                  <div class="col-lg-12">
                      
                  </div>
              </div>
            <div class="panel panel-default">
                <div class="panel-heading">Certificate Manage </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>
                                <th>유저 넘버</th>
                                <th>image</th> 
                                <th>승인</th>                               
                            </tr>
                            <%
                        signUpImageVo vo=new signUpImageVo();
						SignUpImageService service = SignUpImageService.getService(); //signUpImageService 추가하시오
         				ArrayList<signUpImageVo> list = service.getSignUpImages(vo); //서비스함수
         				for(signUpImageVo dto:list){        
							
							%>       
							<tr>
                			<td><%=dto.getUserNum() %></td>
                			<td><img src = <%=dto.getImage()%>/></td>
                			<td><button onclick = "userApprove(<%=dto.getUserNum()%>)">승인</button></td>                			
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
<script src = "js/user.js"></script>
</html>
