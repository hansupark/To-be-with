package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import service.UserService;
import vo.UserVo;

public class UserDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  UserService service = UserService.getInstance();
		  req.setCharacterEncoding("utf-8");
	      res.setContentType("texxt/html;charset=utf-8");
	      
	      int userNum = Integer.parseInt(req.getParameter("userNum"));
	      int result = 0;
	      
	      UserVo user = new UserVo();
	      user.setUserNum(userNum);
	      result = service.userDelete(user);
	      
	      res.getWriter().write(""+result);
	      return;
	}

}
