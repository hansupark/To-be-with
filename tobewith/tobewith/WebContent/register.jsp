<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>To be with Register</title>

<link type="text/css" rel="stylesheet" href="css/register.css"/>
<link type="text/css" rel="stylesheet" href="css/all.css"/>
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>


<script type="text/javascript">
    
        // �ʼ� �Է������� ���̵�, ��й�ȣ�� �ԷµǾ����� Ȯ���ϴ� �Լ�
        function checkValue()
        {
            if(!document.signup.id.value){
                alert("���̵� �Է��ϼ���.");
                return false;
            }
            
            if(!document.signup.password.value){
                alert("��й�ȣ�� �Է��ϼ���.");
                return false;
            }
            
            // ��й�ȣ�� ��й�ȣ Ȯ�ο� �Էµ� ���� �������� Ȯ��
            if(document.signup.password.value != document.signup.passwordcheck.value ){
                alert("��й�ȣ�� �����ϰ� �Է��ϼ���.");
                return false;
            }
            
            if(!document.signup.kakaoid.value){
            	alert("īī���� ID�� �Է��ϼ���.");
            	return false;
            }
        }
        
        // ��� ��ư Ŭ���� �α��� ȭ������ �̵�
        function goLoginForm() {
            location.href="login.jsp";
        }
    </script>


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
            <form class="form-signin" name="signup">
              <div class="form-label-group">
                <input type="text" id="inputUserame" class="form-control" placeholder="Username" required autofocus>
                <label for="inputUserame">Username</label>
              </div>

              <div class="form-label-group">
                <input type="email" id="inputEmail" class="form-control" placeholder="Email address" required>
                <label for="inputEmail">Email address</label>
              </div>
              
              <hr>

              <div class="form-label-group">
                <input type="password" id="Password" name="password"class="form-control" placeholder="Password" required>
                <label for="inputPassword">Password</label>
              </div>
              
              <div class="form-label-group">
                <input type="password" id="passwordcheck" class="form-control" placeholder="Password" required>
                <label for="inputConfirmPassword">Password Check</label>
              </div>

			  <hr>
			  
			  <div class="form-label-group">
                <input type="text" name="Kakaoid" id="kakao_Id" class="form-control" placeholder="KaKaoId" required>
                <label for="phonenumber">KaKao ID</label>
              </div>
			  
			  <div class="form-label-group">
                <input type="radio" name="gender" id="male" class="form-control" placeholder="male" required>
                <label for="male">Male</label>
              </div>
			  
			  <div class="form-label-group">
                <input type="radio" name="gender" id="female" class="form-control" placeholder="female" required>
                <label for="female">Female</label>
              </div>
			  
			  <div class="form-label-group">
                <input type="date" id="birh" class="form-control" placeholder="birth" required>
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
