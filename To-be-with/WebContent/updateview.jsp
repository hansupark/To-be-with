<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- jQuery -->
<script src="//code.jquery.com/jquery.min.js"></script>
<!-- 합쳐지고 최소화된 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>

    <script src="https://code.jquery.com/jquery-3.2.1.js"></script>

	<link rel="stylesheet" href="/css/jquery-ui.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css"/>

    <script src="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/js/bootstrap.min.js"></script>

    <script type='text/javascript' src='//code.jquery.com/jquery-1.8.3.js'></script>




 
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/css/bootstrap-datepicker3.min.css">

    <script type='text/javascript' src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.5.0/js/bootstrap-datepicker.min.js"></script>

    <script src="/js/bootstrap-datepicker.kr.js" charset="UTF-8"></script>



    <script type='text/javascript'>
    $(function(){
        $('.input-group.date').datepicker({
            calendarWeeks: false,
            todayHighlight: true,
            autoclose: true,
            format: "yyyy/mm/dd",
            language: "kr"
        });
    });
    </script>

</head>




<title>Insert Form</title>
<style>
h2{
text-align :center;
}
</style>
</head>
<body>
 
 <h2>게시글 수정 </h2>
 
<div class="container">
 
      <form action = "travelInsert.do" method = "POST">
	      	<div class="formgroup">
	        <label for="subject">제목</label>
	        <input type="text" class="form-control" id="subject" name="title" placeholder="제목을 입력하세요.">
	        </div>
	        <label for="subject">나라 입력</label>
		    <input list = "browsers" class="search_input search_input_1" placeholder="Country" id = "country" name = "country">
			<datalist id="browsers">
			    
		    </datalist>
			<input list = "browsers_2" class="search_input search_input_2" placeholder="Region" id = "region" name = "region" >
			<datalist id="browsers_2">
			    
		    </datalist>
		  
		   <label for = "count1">인원수 선택</label>
		   <input type = "text" placeholder = "최대 3명까지"  id = "count" name= "max_Count" > 
	 
	
	        <div class="input-group date">
	    
	        <input type="text" name = "date" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-calendar"></i></span>        
	        </div>
	        <label for=content">내용</label>
	        <textarea class="form-control" id="content" name="content" rows="3"></textarea>
	    
	      <button type="submit" class="btn btn-primary">수정하기</button>      </form>  </div>   

</body>
<script src = "js/travel.js"></script>
</html>