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

public class UserLoginController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charSet = UTF-8");
		UserService service = UserService.getInstance();
		int result;
		String email = req.getParameter("email");
		String pw = req.getParameter("password");
		
		UserVo user = new UserVo();
		user.setEmail(email);
		user.setPassword(pw);
			
		result = service.userLogin(user);		
		if(result == -1)
		{
			res.getWriter().println("<script>alert('비밀번호가 맞지않습니다.'); location.href='login.jsp';</script>");
		}
		else if(result == 0)
		{
			res.getWriter().println("<script>alert('아이디가 존재하지 않습니다.'); location.href='login.jsp';</script>");
		}
		else //회원가입 성공
		{
			HttpSession session = req.getSession();
			UserVo certificate = new UserVo(); //사용자 인증 확인 여부
			certificate.setUserNum(result);
			certificate = service.selectUser_byUserNum(certificate);
			session.setAttribute("LoginUserNum",result);
			if(certificate.getIsApproved())
			{
				HttpUtil.forward(req,res,"index.jsp");
			}
			else
			{
				HttpUtil.forward(req,res,"certificate.jsp");
			}
			return;
			
		}
	}

}
