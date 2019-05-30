<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.TravelVo" %>
<%@ page import = "vo.ApplyVo" %> <!-- /* 로그인 구현 완료시 다시 수정하기 */ -->
<%@ page import = "service.ApplyService" %>
<%@ page import = "java.util.ArrayList" %>

<%
	ApplyVo test = new ApplyVo(); /* 로그인 구현 완료시 다시 수정하기 */
	test.setUserNum(1); /* 로그인 구현 완료시 다시 수정하기 */
	ArrayList<TravelVo> list = (ArrayList<TravelVo>) request.getAttribute("resultList");
	ArrayList<ApplyVo> list_user = (ArrayList<ApplyVo>) ApplyService.getService().getApplyList_ByUserNum(test);
	
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
				+ travel.getCurrent_Count() + "/" + travel.getMax_Count());
		if(list_user.size() != 0) //신청을 해놓은게 아예없을때
		{
			int x = 0;
			System.out.println("해당 유저는 신청한 동행이 있습니다.");
			for(x = 0 ; x < list_user.size() ; x++)
			{
				ApplyVo vo = list_user.get(x);
				if(vo.getTravelNum() == travel.getTravelNum()) /* 이미 신청했는지를 검사 */
				{
					System.out.println("case 1");
					out.println(String.format("<button disabled onclick = applyInsert(%d,%d);>신청</button><br>",travel.getTravelNum(),1));
					//아직 login기능 구현 안되서 1로 대체
					break;
				}
			}
			if(x == list_user.size())
			{
				System.out.println("case 2");
				out.println(String.format("<button onclick = applyInsert(%d,%d);>신청</button><br>",travel.getTravelNum(),1)); 
				//아직 login기능 구현 안되서 1로 대체
			}
				
		}
		else
		{
			System.out.println("case 3");
			System.out.println("해당 유저는 신청한 동행이 없습니다.");
			out.println(String.format("<button onclick = applyInsert(%d,%d);>신청</button><br>",travel.getTravelNum(),1));
		}
			
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
        <h4 class="modal-title w-100" id="myModalLabel"></h4>
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
<script src="js/travel.js"></script>
<script src="js/apply.js"></script>
</body>
</html>