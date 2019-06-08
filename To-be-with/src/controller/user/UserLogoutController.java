package controller.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.HttpUtil;
import service.UserService;
import vo.UserVo;

public class UserLogoutController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(req.getSession().getAttribute("LoginUserNum") != null)
		{
			req.getSession().removeAttribute("LoginUserNum");
		}
		
		HttpUtil.forward(req, res,"login.jsp");
		return;
	}

}
