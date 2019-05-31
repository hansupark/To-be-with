package controller.user;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.HttpUtil;
import service.UserService;
import vo.UserVo;


public class UserRegisterController implements Controller {

	@Override
	public void execute(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub

	req.setCharacterEncoding("UTF-8");
	res.setContentType("text/html; charSet = UTF-8");
	
	
	UserService service = UserService.getInstance();
	int result;
	SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
	
	String name= req.getParameter("name");
	String email = req.getParameter("email");
	String password=req.getParameter("password");
	String kakao=req.getParameter("kakao");
	String gender= req.getParameter("gender");
	String birth=req.getParameter("birth"); //DAte라는 변수?
	
	
	
	
	UserVo user=new UserVo();
	 user.setName(name);
     user.setEmail(email);
     user.setPassword(password);
     user.setKakao_ID(kakao);
     user.setGender(Integer.parseInt(gender)); //변수땜에 오류
     //user.getDate_Of_Birth(format.); //변수땜에 오류
     
     if(service.selectUser(user) == null)
     {
    	 service.userCreate(user);
    	 HttpUtil.forward(req, res,"login.jsp");
    	 return;
     }
     
     else {
    	 //회원 이미 존재
     }
     
 

	}
}
