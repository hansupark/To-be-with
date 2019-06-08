<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "controller.HttpUtil" %>
<%HttpUtil.AdminLogin(request, response);%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main for Admin</title>

<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="js/jquery.slim.min.js">
<link type="text/css" rel="stylesheet" href="js/bootstrap.bundle.min.js">

</head>
<body>
<!-- Page Content -->
    <div class="container">
	  <a href = "login.jsp">로그인으로</a>
      <!-- Page Heading -->
      <h1 class="my-4">Main
        <small>for Admin</small>
      </h1>

      <!-- Project One -->
      <div class="row">
        <div class="col-md-7">
          <a href="userlist.jsp">
            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
          </a>
        </div>
        <div class="col-md-5">
          <h3>User List</h3>
          <p>You can watch User List</p>
          <a class="btn btn-primary" href="Userlist.jsp">Go</a>
        </div>
      </div>
      <!-- /.row -->

      <hr>

      <!-- Project Two -->
      <div class="row">
        <div class="col-md-7">
          <a href="siren.jsp">
            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
          </a>
        </div>
        <div class="col-md-5">
          <h3>Declaration</h3>
          <p>You can watch and control Declaration List. </p>
          <a class="btn btn-primary" href="siren.jsp">Go</a>
        </div>
      </div>
      <!-- /.row -->

      <hr>

      <!-- Project Three -->
      <div class="row">
        <div class="col-md-7">
          <a href="certificatemanage.jsp">
            <img class="img-fluid rounded mb-3 mb-md-0" src="http://placehold.it/700x300" alt="">
          </a>
        </div>
        <div class="col-md-5">
          <h3>Certificate</h3>
          <p>You can accept User's Register.</p>
          <a class="btn btn-primary" href="certificatemanage.jsp">Go</a>
        </div>
      </div>
      <!-- /.row -->

      <hr>
    </div>
    <!-- /.container -->
</body>
</html>
