<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="controller.HttpUtil"%>

<%@page import="dao.*" %> 
<%@page import="vo.*"  %>
<%@page import="service.*"  %>

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "controller.HttpUtil.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To be with login</title>
<link type="text/css" rel="stylesheet" href="css/login.css">
<link type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<%
		HttpUtil.Login(reqest, response);
		int LoginUserNum = (int) session.getAttribute("LoginUserNum");

		TravelVo vo = new TravelVo(); 
		ApplyVo vo_A = new ApplyVo();
		UserVo vou=new UserVo();
		ReportVo vor=new ReportVo();

		vo.setUserNum(LoginUserNum); /**/

		vo_A.setUserNum(LoginUserNum);
		vou.setUserNum(LoginUserNum);
		vor.setReporterNum(LoginUserNum);



		ArrayList<TravelVo> list_travel = TravelService.getService().getTravelLists_ByUserNum(vo);
                               		

		ArrayList<ApplyVo> list_Apply=ApplyService.getService().getApplyList_ByUserNum(vo_A);

		ArrayList<ReportVo> list_report=ReportService.getService().selectReports_ByReporterNum(vor);
   
%> 
                        
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
                        <div role="tabpanel" class="tab-pane" id="profile">Profile                           
		                <div class="panel-body">
		                    <table class="table table-hover">
		                        <thead>
		                        <!-- 테이블 css 정리하고 -->
		                           <!-- 아이디 맞게 재설정하고 -->
		                        
		                        <!-- 세션에 들어갈 코드  세션과 일치시킨 후 -->
		                            
		                            <tr>
		                                <th>이름</th>
		                                <td><%=vou.getName() %>   </td>
		                            </tr> 
		                            <tr>
		                                <th>이메일</th>
		                                <td><%=vou.getEmail() %>   </td>
		                            </tr>
		                            <tr>
		                                <th>생년월일</th>
		                                <td><%=vou.getDate_Of_Birth() %>   </td>
		                            </tr>
		                            <tr>
		                                <th>Gender</th>
		                                <td><%=(vou.getGender() == 1) ? "남자" : "여자"%></td>
		                            </tr>                            
		                            <tr>
		                                <th>KaKaoID</th>
		                                <td><%=vou.getKakao_ID() %>     </td>
		                            </tr>                   
		                            <tr>
		                                <th>Phone Number</th>
		                                <td><%=vou.getPhone_Number() %>     </td>
		                            </tr>
		                            </thead>
		                       </table>	                                             
		                     </div>
		                </div>
                        <div role="tabpanel" class="tab-pane" id="messages">작성한글
                           <!-- 테이블짜서 내가 작성한 게시물들 출연하게 -->
                        <!-- resultList.jsp -->
                    <div class="page-wrapper">
    <div class="container-fluid" align = center>
        <div class="col-lg-8"><!--게시판 넓이 -->
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
                        		for(TravelVo travel : list_travel) //여기서도 바꿨고
                        		{%>
                        			<tr>
                        			<td><%=String.format("<a href =\"javascript:loadModal(%s,%s);\">%s</a>",
                        			"\'" + travel.getTitle() + "\'","\'" +travel.getContent() + "\'",travel.getTitle())%></td>
	                        		<td><%=travel.getUserNum()%></td>
	                        		<td>
	                        		<%
	                        		if(list_Apply.size() != 0) //신청을 해놓은게 아예없을때 여기도 수정했고
	                        		{
	                        			int x = 0;
	                        			System.out.println("해당 유저는 신청한 동행이 있습니다.");
	                        			for(x = 0 ; x < list_Apply.size() ; x++) //여기도 수정
	                        			{
	                        				vo_A = list_Apply.get(x); //원래는 Apply vo
	                        				if(vo.getTravelNum() == travel.getTravelNum()) /* 이미 신청했는지를 검사 */
	                        				{
	                        					System.out.println("case 1");
	                        					out.println(String.format("<button disabled onclick = applyInsert(%d,%d);>신청</button>",travel.getTravelNum(),LoginUserNum));
	                        					//아직 login기능 구현 안되서 1로 대체
	                        					break;
	                        				}
	                        			}
	                        			if(x == list_Apply.size())
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
	                        		if(list_report.size() != 0) //신청을 해놓은게 아예없을때 바꿨고
	                        		{
	                        			int x = 0;
	                        			//System.out.println("해당 유저는 신청한 동행이 있습니다.");
	                        			for(x = 0 ; x < list_report.size() ; x++) //바꾸고
	                        			{
	                        				vor = list_report.get(x); //바꾸고
	                        				if(vo_A.getApplyNum() == travel.getTravelNum()) /* 이미 신청했는지를 검사  변수도 바꿨고*/
	                        				{
	                        					System.out.println("report : case 1");
	                        					out.println(String.format("<button disabled onclick = reportModalLoad(%d);>신고</button><br>",travel.getTravelNum()));	
	                        					//아직 login기능 구현 안되서 1로 대체
	                        					break;
	                        				}
	                        			}
	                        			if(x == list_report.size())
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
                      
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        
                        </div>
                        <div role="tabpanel" class="tab-pane" id="settings">동행신청현황                                               
                       
                       
                       
                        </div> 
                  </div>
    		</div>
		</div>
      </div>                              
     </div>
  </div>
</div>                    

</body>
<script src = "js/profile.js"></script>
</html>
