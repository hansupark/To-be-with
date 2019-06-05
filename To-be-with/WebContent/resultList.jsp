<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "vo.*" %> <!-- /* 로그인 구현 완료시 다시 수정하기 */ -->
<%@ page import = "service.*" %>
<%@ page import = "java.util.ArrayList" %>

<%
	int LoginUserNum = (int) session.getAttribute("LoginUserNum");
	System.out.println("LoginUserNum : " + LoginUserNum);
	ApplyVo test = new ApplyVo(); /* 로그인 구현 완료시 다시 수정하기 */
	ReportVo test_2 = new ReportVo(); /* 로그인 구현 완료시 다시 수정하기 */
	test.setUserNum(LoginUserNum); /* 로그인 구현 완료시 다시 수정하기 */
	test_2.setReporterNum(LoginUserNum); /* 로그인 구현 완료시 다시 수정하기 */
	ArrayList<TravelVo> list = (ArrayList<TravelVo>) request.getAttribute("resultList");
	ArrayList<ApplyVo> list_Apply_user = (ArrayList<ApplyVo>) ApplyService.getService().getApplyList_ByUserNum(test);
	ArrayList<ReportVo> list_Report_user = (ArrayList<ReportVo>) ReportService.getService().selectReports_ByReporterNum(test_2);
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>boardList</title>
</head>
<body>
<div class="container">
    <div class="container-fluid" align = center>
       
            <div class="col-lg-12">
                <h1 class="page-header">동행 찾기</h1>
            </div>
            <div class="row">
                  <div class="col-lg-12">
                      <button type="button" onclick = "location.href = 'travelWrite.jsp'" class="btn btn-outline btn-primary pull-right">
                          <i class="fa fa-edit fa-fw"></i> 동행 만들기
                      </button>
                  </div>
              </div>
            <div class="panel panel-default">
                <div class="panel-heading">동행 찾기 </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>                               
                                <th>제목</th>
                                <th>작성자</th>
                                <th>신청</th>
                                <th>현재 신청/최대 신청</th>
                                <th>신고</th>                            
                            </tr>
                        </thead>
                        <tbody>
                        	
                        	<%
                        		for(TravelVo travel : list)
                        		{
                        			UserVo vou = new UserVo();
                        			vou.setUserNum(travel.getUserNum());
                        			vou = UserService.getInstance().selectUser_byUserNum(vou);
                        		%>
                        			<tr>
                        			<td><%=String.format("<a href =\"javascript:loadModal(%s,%s);\">%s</a>",
                        			"\'" + travel.getTitle() + "\'","\'" +travel.getContent() + "\'",travel.getTitle())%></td>
	                        		<td><%=vou.getName()%></td>
	                        		<td>
	                        		<%
	                        		if(list_Apply_user.size() != 0) //신청을 해놓은게 아예없을때
	                        		{
	                        			int x = 0;
	                        			System.out.println("해당 유저는 신청한 동행이 있습니다.");
	                        			for(x = 0 ; x < list_Apply_user.size() ; x++)
	                        			{
	                        				ApplyVo vo = list_Apply_user.get(x);
	                        				if(vo.getTravelNum() == travel.getTravelNum()) /* 이미 신청했는지를 검사 */
	                        				{
	                        					System.out.println("case 1");
	                        					out.println(String.format("<button disabled onclick = applyInsert(%d,%d);>신청</button>",travel.getTravelNum(),LoginUserNum));
	                        					//아직 login기능 구현 안되서 1로 대체
	                        					break;
	                        				}
	                        			}
	                        			if(x == list_Apply_user.size())
	                        			{
	                        				System.out.println("case 2");
	                        				out.println(String.format("<button onclick = applyInsert(%d,%d);>신청</button>",travel.getTravelNum(),LoginUserNum)); 
	                        				//아직 login기능 구현 안되서 1로 대체
	                        			}
	                        		}
	                        		else
	                        		{
	                        			System.out.println("case 3");
	                        			System.out.println("해당 유저는 신청한 동행이 없습니다.");
	                        			out.println(String.format("<button onclick = applyInsert(%d,%d);>신청</button>",travel.getTravelNum(),LoginUserNum));
	                        		}
	                        		%>
	                        		</td>
	                        		<td><%=travel.getCurrent_Count()%>/<%=travel.getMax_Count()%></td>
	                        		<td>
	                        		<%
	                        		if(list_Report_user.size() != 0) //신청을 해놓은게 아예없을때
	                        		{
	                        			int x = 0;
	                        			//System.out.println("해당 유저는 신청한 동행이 있습니다.");
	                        			for(x = 0 ; x < list_Report_user.size() ; x++)
	                        			{
	                        				ReportVo vo = list_Report_user.get(x);
	                        				if(vo.getObjectNum() == travel.getTravelNum()) /* 이미 신청했는지를 검사 */
	                        				{
	                        					System.out.println("report : case 1");
	                        					out.println(String.format("<button disabled onclick = reportModalLoad(%d);>신고</button><br>",travel.getTravelNum()));	
	                        					//아직 login기능 구현 안되서 1로 대체
	                        					break;
	                        				}
	                        			}
	                        			if(x == list_Report_user.size())
	                        			{
	                        				System.out.println("report : case 2");
	                        				out.println(String.format("<button onclick = reportModalLoad(%d);>신고</button><br>",travel.getTravelNum()));	
	                        				//아직 login기능 구현 안되서 1로 대체
	                        			}
	                        		}
	                        		else
	                        		{
	                        			System.out.println("report : case 3");
	                        			//System.out.println("해당 유저는 신청한 동행이 없습니다.");
	                        			out.println(String.format("<button onclick = reportModalLoad(%d);>신고</button><br>",travel.getTravelNum()));	
	                        		}
	                        		%>
	                        		</td>
	                        		</tr>
                        		<%}
                        	%>                    	
                        	
                        </tbody>           
					</table>
            	</div>
        	</div>
    </div>
</div>
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

<!-- 신고 modal -->
<div class="modal fade right" id="fullHeightModalRight_report" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">

  <!-- Add class .modal-full-height and then add class .modal-right (or other classes from list above) to set a position to the modal -->
  <div class="modal-dialog modal-full-height modal-top" role="document">


    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title w-100" id="myModalLabel">신고하기</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body" id = "modal-body">
      	<input type = hidden id = travelNum>
	     <div class="formgroup">
	       <label for="subject">제목</label>
	       <input type="text" class="form-control" id="reportTitle" name="reportTitle" placeholder="제목을 입력하세요.">
	     </div>	 
	     <div class="formgroup">
	       <label for=content">내용</label>
	       <textarea class="form-control" id="reportContent" name="reportContent" rows="3"></textarea>
	     </div>
	      <button onclick = "reportInsert_travel(<%=LoginUserNum%>)">신고하기</button> <!-- 로그인 기능 구현시 바꿔야함 -->
      </div>
      <div class="modal-footer justify-content-center">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

</body>
<script src="js/travel.js"></script>
<script src="js/apply.js"></script>
<script src="js/report.js"></script>
</html>
