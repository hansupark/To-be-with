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


public class UserUpdateController implements Controller {

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
		String birth=req.getParameter("birth_of_Date"); 
		int userNum = (int) req.getSession().getAttribute("LoginUserNum");
		
		UserVo user=new UserVo();
		user.setUserNum(userNum);
		user = service.selectUser_byUserNum(user);
	    user.setName(name);
	    user.setEmail(email);
	    user.setPassword(password);
	    user.setDate_Of_Birth(birth);
	    result = service.userUpdate(user);	     
	    
	    HttpUtil.forward(req, res,"test2.jsp");
        return;
	}
}
