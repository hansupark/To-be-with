<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>To be with login for Admin</title>
<link type="text/css" rel="stylesheet" href="css/login.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
<div class="container-fluid">
  <div class="row no-gutter">
    <div class="d-none d-md-flex col-md-4 col-lg-6 bg-image"></div>
    <div class="col-md-8 col-lg-6">
      <div class="login d-flex align-items-center py-5">
        <div class="container">
          <div class="row">
            <div class="col-md-9 col-lg-8 mx-auto">
              <h3 class="login-heading mb-4">Welcome Admin User!</h3>
              <form method="post" action="adminLogin.do"> <!-- adminLogin.do? LoginAdmin.do? adminLogin 안먹히면 LoginAdmin.do로 -->
                <div class="form-label-group">
                  <input type="text" id="adminId" name="adminId" class="form-control" placeholder="Admin ID" required autofocus>
                  <label for="Admin ID">Admin ID</label>
                </div>

                <div class="form-label-group">
                  <input type="password" name="adminPw" id="adminPw" class="form-control" placeholder="Password" required>
                  <label for="inputPassword">Password</label>
                </div>

                <div class="custom-control custom-checkbox mb-3">
                  <input type="checkbox" class="custom-control-input" id="customCheck1">
                  <label class="custom-control-label" for="customCheck1">Remember password</label>
                </div>
                
                  
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Sign In</button>
                 <br>
                  <a class="samll" href="login.jsp">Go UserLogin page</a>
               	  
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
