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
		int result = 0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		
		String name= req.getParameter("name");
		String email = req.getParameter("email");
		String password=req.getParameter("password");
		String kakao=req.getParameter("kakao");
		String gender= req.getParameter("gender");
		String birth=req.getParameter("birth"); 
		String phone_Number = req.getParameter("phone_Number");
		
		UserVo user=new UserVo();
	    user.setName(name);
	    user.setEmail(email);
	    user.setPassword(password);
	    user.setKakao_ID(kakao);
	    user.setGender(Integer.parseInt(gender)); 
	    user.setDate_Of_Birth(birth);
	    user.setPhone_Number(phone_Number); 
	     if(service.selectUser(user) == null)
	     {    	 
	    	 if(service.selectUser_byPhone_Number(user) == null)
	    	 {
	    		 service.userCreate(user);
	        	 HttpUtil.forward(req, res,"login.jsp");
	        	 return;
	    	 }
	    	 else
	    	 {
	    		 System.out.println("동일한 회원 핸드폰 번호 존재");
	    		 HttpUtil.forward(req, res,"register.jsp");
	    	 }
	     }
	     
	     else {
	    	 System.out.println("동일한 이메일 존재");
	    	 HttpUtil.forward(req, res,"register.jsp");
	     }
	     return;
	}
}
