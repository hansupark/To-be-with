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
		HttpUtil.Login(request, response);
		int LoginUserNum = (int) session.getAttribute("LoginUserNum");

		TravelVo vo = new TravelVo(); 
		ApplyVo vo_A = new ApplyVo();
		UserVo vou=new UserVo();
		ReportVo vor=new ReportVo();

		vo.setUserNum(LoginUserNum); /**/

		vo_A.setUserNum(LoginUserNum);
		vou.setUserNum(LoginUserNum);
		vou = UserService.getInstance().selectUser_byUserNum(vou);
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
                        <div role="tabpanel" class="tab-pane" id="messages">
                           <!-- 테이블짜서 내가 작성한 게시물들 출연하게 -->
                        <!-- resultList.jsp -->
                    <div class="page-wrapper">
                            <div class="container-fluid" align = center>
        						<div class="col-lg-8"><!--게시판 넓이 -->
            					<div class="col-lg-12">
               						 <h1 class="page-header">동행 찾기</h1>
            					</div>
            					<div class="row">
                  						
              					</div>
           			<div class="panel panel-default">
                <div class="panel-heading">동행 찾기 </div>
                <div class="panel-body">
                    <table class="table table-hover">
                        <thead>
                            <tr>                               
                                <th>제목</th>                                                           
                                <th>삭제</th>                         
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
	                        		<button onclick = "travelDelete(<%=travel.getTravelNum()%>)">삭제</button>                      		
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
						  
                        </div>
                      
                  		</div>
                  		<div role="tabpanel" class="tab-pane" id="settings">동행신청현황                                               
                       		<h1>작성된 동행들</h1>
							<% 
							for(ApplyVo apply : list_Apply)
							{
								TravelVo travel = new TravelVo();
								travel.setTravelNum(apply.getTravelNum());
								travel = TravelService.getService().getTravel(travel);
							%>
								나라 : <%=travel.getCountry()%> 지역 : <%=travel.getRegion() %> 날짜 : <%=travel.getTravelDate()%> <br>	
							<%	
							}
							%>                  
                        </div> 
    				</div>
			    </div>
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
        									 <h4 class="modal-title w-100" id="myModalLabel_2"></h4>
        									 <button type="button" class="close" data-dismiss="modal" aria-label="Close">
         										 <span aria-hidden="true">&times;</span>
       										 </button>
      									 </div>
     									 <div class="modal-body" id = "modal-body_2">
      
      									 </div>
    								     <div class="modal-footer justify-content-center">
    									     <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
   										     <button type="button" class="btn btn-primary">Save changes</button>
     									 </div>
   									</div>
 								 </div>
							  </div>             
</body>
<script src = "js/profile.js"></script>
<script src = "js/travel.js"></script>
</html>
