<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="controller.HttpUtil"%>

<%@page import="dao.*" %> 
<%@page import="vo.*"  %>
<%@page import="service.*"  %>

<%@ page import = "java.util.ArrayList" %>
<%@ page import = "controller.HttpUtil.*" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>To be with Profile</title>
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
    <h1><a href = "index.jsp">To be with</a></h1>
    <div class="col-me-12"> 
        <div class="portlet light bordered">
            <div class="portlet-title tabbable-line">
                <div class="caption caption-md">
                    <i class="icon-globe theme-font hide"></i>
                    
                </div>
            </div>
            <div class="portlet-body">
                <div>
                
                    <!-- Nav tabs -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">업데이트</a></li>
                        <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">프로필</a></li>
                        <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">작성한글</a></li>
                        <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">나의일정</a></li>
                    </ul>
                	
                    <!-- Tab panes -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane active" id="home">
                        <br/>
                            <form action = "userUpdate.do" method = "post">
                              <div class="form-group">
                                <label for="inputName">Name</label>
                                <input type="text" class="form-control" id="inputName" name = "name" value = <%=vou.getName()%> placeholder="Name" >
                              </div>	                                
                              <div class="form-group">
                                <label for="exampleInputEmail1">Email address</label>
                                <input type="email" class="form-control" id="exampleInputEmail1" value = <%=vou.getEmail()%> name = "email" placeholder="Email">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputEmail1">birth_Of_Date</label>
                                <input type="date" class="form-control" id="birth_of_Date" value = <%=vou.getDate_Of_Birth()%> name = "birth_of_Date">
                              </div>
                              <div class="form-group">
                                <label for="exampleInputPassword1">Password</label>
                                <input type="password" class="form-control" id="exampleInputPassword1" value = <%=vou.getPassword()%> name = "password" placeholder="Password">
                              </div>                              
                              <button type="submit" class="btn btn-default">수정</button>
                            </form>
                        </div>
                        <div role="tabpanel" class="tab-pane" id="profile">                           
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
		                <!-- 테이블짜서 내가 작성한 게시물들 출연하게 -->
		                <br/>
                        <div role="tabpanel" class="tab-pane" id="messages">
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
                <div class="panel-heading"> </div>
                <div class="panel-body">
                <button id = "detail" onclick = "detail();">상세보기</button>     
                    <table class="table table-hover">
                        <thead>
                            <tr>                               
                                <th>제목</th>                                                                                                   
                                <th>나라</th>
                                <th>지역</th>
                                <th>날짜</th>               
                                <th>삭제</th>  
                            </tr>
                        </thead>
                        <tbody>
					      
                        	<%
                        		for(TravelVo travel : list_travel) //여기서도 바꿨고
                        		{
                        			ArrayList<ApplyVo> list_apply;
                        			vo_A.setTravelNum(travel.getTravelNum());
                        			list_apply = ApplyService.getService().getApplyList_ByTravelNum(vo_A);
                        			
                        		%>
                        			<tr id = "travel">
                        			<td><%=String.format("<a href =\"javascript:loadModal(%s,%s);\">%s</a>",
                        			"\'" + travel.getTitle() + "\'","\'" +travel.getContent() + "\'",travel.getTitle())%></td>	                        		
                        			<td><%=travel.getCountry() %></td>
                        			<td><%=travel.getRegion() %></td>
                        			<td><%=travel.getTravelDate()%></td>
	                        		<td>
	                        		<button onclick = "travelDelete(<%=travel.getTravelNum()%>)">삭제</button>                      		
	                        		</td>	                        			                        		
	                        		</tr>
	                        		<tr>
	                        			<td>
	                        				<table id = "applyList">
	                        					<thead>
						                           <tr>                               
						                               <th>유저이름</th>                                                                                                   
						                               <th>수락</th>						                             
						                           </tr>
						                       </thead>
						                       <tbody>
						                       		<%
						                       		for(ApplyVo apply : list_apply)
				                        			{
						                       			if(!apply.getIsApproved())
						                       			{
						                       				UserVo user = new UserVo(); 
						                       				user.setUserNum(apply.getUserNum());		
				                       						user = UserService.getInstance().selectUser_byUserNum(user);				                       						
						                       				out.println("<td>"+user.getName()+"</td> ");
					                        				out.println(String.format("<td><button onclick = \"applyAccept(%d,%d);\">수락</button></td>",apply.getApplyNum(),apply.getTravelNum()));
						                       			}
				                        			}
						                       		%>
						                       </tbody>
	                        				</table>
	                        			</td>
	                        		</tr>
	                        	
                        		<%} %>	
            	        		    </tbody>           
								</table>
    	        			</div>
       			</div>
    							</div>
							  </div>
						  
                        </div>
                      
                  		</div>
                  		<div role="tabpanel" class="tab-pane" id="settings">                                               
                       						          
							<br/>
							<!-- 날짜 테이블 -->
	
							<table class="table table-hover">
								<tr>
									<th>날 짜</th>
									<th>여 행 국 가</th>
									<th>도 시</th>
								</tr>
							<%
								for(ApplyVo apply : list_Apply)
								{
									TravelVo travel = new TravelVo();
									travel.setTravelNum(apply.getTravelNum());
									travel = TravelService.getService().getTravel(travel);
	
									String td = travel.getTravelDate(); //동행 날짜받고
		
									String country= travel.getCountry();
									String destination= travel.getRegion();
	
							%>
								<tr>
									<td><%=td %></td>
									<td><%=country %></td>
									<td><%=destination %></td>
								</tr>
	
	
							 <%}			
						
							 %>		
								<tr>
									<td align="center" colspan="3"><h3>Have a nice Trip with your Friends</h3></td>
								</tr>				
							</table>						
							<!-- 테이블로 만들기 끝!-->							
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
<script src = "js/apply.js"></script>
<script type = "text/javascript">

function detail()
{
	$("#applyList").attr("hidden","true");		
}
</script>
</html>
