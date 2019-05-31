<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>To be with login</title>
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
              <h3 class="login-heading mb-4">Upload your image for Approve</h3>              
                <div class="form-label-group">               
                  <form method="post" enctype="multipart/form-data" action="uploadimage.do"> <!-- miltipart/form-data servlet에 피일을 준다는 신호줌 -->
					<input type="file" name="file" id="passport" class="form-control" placeholder="image" required autofocus>				
				  </form>
                </div>

       
                <button class="btn btn-lg btn-primary btn-block btn-login text-uppercase font-weight-bold mb-2" type="submit">Upload</button>
       
                <div class="text-center">
                  <a class="small" href="login.jsp">Go Sign In</a>
                  <br>
                  </div>
               	  
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
