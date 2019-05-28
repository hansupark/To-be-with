<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.TravelVo" %>
<%@ page import = "java.util.ArrayList" %>

<%
	ArrayList<TravelVo> list = (ArrayList<TravelVo>) request.getAttribute("resultList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>
	<%
	for(TravelVo travel : list)
	{
		out.println(String.format("<a href =\"javascript:loadModal(%s,%s);\">%s</a>","\'" + travel.getTitle() + "\'", "\'" +travel.getContent() + "\'",travel.getTitle())
				+ " " + travel.getCountry() + " " + travel.getRegion() + " " + travel.getTravelDate() + " " 
				+ travel.getCurrent_Count() + "/" + travel.getMax_Count() + "<br>");
	}
	%>
	<!-- modal -->
<!-- Full Height Modal Right -->
<div class="modal fade right" id="fullHeightModalRight" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">

  <!-- Add class .modal-full-height and then add class .modal-right (or other classes from list above) to set a position to the modal -->
  <div class="modal-dialog modal-full-height modal-top" role="document">


    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title w-100" id="myModalLabel">Modal title</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id = "modal-body">
      
      </div>
      <div class="modal-footer justify-content-center">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<!-- Full Height Modal Right -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="js/travelSearch.js"></script>
</body>
</html>