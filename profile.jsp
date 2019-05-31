<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>To be with login</title>
<link type="text/css" rel="stylesheet" href="login.css">
<link type="text/css" rel="stylesheet" href="bootstrap.min.css">
<style>



</style>
</head>
<body>
<br>
<div class="form-group">


   <div class="container" >
    <div class="col-me-12"> 
   
        <div class="portlet light bordered">
            <div class="portlet-title tabbable-line">
                <div class="caption caption-md">
                    <i class="icon-globe theme-font hide"></i>
                    <span class="caption-subject font-blue-madison bold uppercase">작성자 정보</span>
                </div>
            </div>
            <div class="portlet-body">
                <div>
                
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">업데이트</a></li>
                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">프로필</a></li>
                        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">작성한글</a></li>
                        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">동행 신청 현황</a></li>
                    </ul>
                
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                            <form>
                              <div class="form-group">
                                <label for="inputName">Name</label>
                                <input type="text" class="form-control" id="inputName" placeholder="Name" >
                              </div>
                                <div class="form-group">
                                <label for="inputLastName">Last Name</label>
                                <input type="text" class="form-control" rows="5" id="inputLastName" placeholder="Last Name">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" placeholder="Password">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputFile">File input</label>
                                <input type="file" id="exampleInputFile">
                                <p class="help-block">Example block-level help text here.</p>
                              </div>
                              <div class="checkbox">
                                <label>
                                  <input type="checkbox"> Check me out
                                </label>
                              </div>
                              <button type="submit" class="btn btn-default">Submit</button>
                            </form>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="profile">Profile</div>
                        <div role="tabpanel" class="tab-pane" id="messages">Messages</div>
                        <div role="tabpanel" class="tab-pane" id="settings">Settings</div>
                    </div>
                </div>
            </div>
            </div></div></div>
            </div>
        </div>


</body>
</html>
