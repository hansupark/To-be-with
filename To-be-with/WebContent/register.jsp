<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To be with Register</title>

<link type="text/css" rel="stylesheet" href="css/register.css"/>
<link type="text/css" rel="stylesheet" href="css/all.css"/>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>


</head>
<body>
  <div class="container">
    <div class="row">
      <div class="col-lg-10 col-xl-9 mx-auto">
        <div class="card card-signin flex-row my-5">
          <div class="card-img-left d-none d-md-flex">
             <!-- Background image for card set in CSS! -->
          </div>
          <div class="card-body">
            <h5 class="card-title text-center">Register</h5>
            <form class="form-signin" method="post" action="UserRegisterController.do">
              <div class="form-label-group">
                <input type="text" name="name"id="inputUserame" class="form-control" placeholder="Username" required autofocus>
                <label for="inputUserame">Username</label>
              </div>

              <div class="form-label-group">
                <input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required>
                <label for="inputEmail">Email address</label>
              </div>
              
              <hr>

              <div class="form-label-group">
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
              
              <div class="form-label-group">
                <input type="password" id="inputConfirmPassword" class="form-control" placeholder="Password" required>
                <label for="inputConfirmPassword">Confirm password</label>
              </div>

           <hr>
           
           <div class="form-label-group">
                <input type="text" name="kakao" id="kakao" class="form-control" placeholder="kakaoid" required>
                <label for="kakao">KaKao ID</label>
              </div>
           
           
           <div class="form-label-group">
                <input type="text" name="phone_Number" id="phonenumber" class="form-control" placeholder="Phonenumber" required>
                <label for="phonenumber">Phonenumber</label>
              </div>
           
           <div class="form-label-group">
                  Male<input type="radio" name="gender" value="1"  placeholder="male" required>
              
                Female<input type="radio" name="gender" value="0" placeholder="female" required>
              </div>
           
           <div class="form-label-group">
                <input type="date" name="birth" id="birh" class="form-control" placeholder="birth" required>
                <label for="birth">Birth</label>
              </div>
           
              <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Register</button>
              <a class="d-block text-center mt-2 small" href="login.jsp">Sign In</a>
              <hr class="my-4">
            </form>
          </div>
        </div>
      </div>
    </div>
  </div>
</body>
</html>