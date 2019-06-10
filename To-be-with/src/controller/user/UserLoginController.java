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
			res.getWriter().println("<script>alert('��й�ȣ�� �����ʽ��ϴ�.'); location.href='login.jsp';</script>");
		}
		else if(result == 0)
		{
			res.getWriter().println("<script>alert('���̵� �������� �ʽ��ϴ�.'); location.href='login.jsp';</script>");
		}
		else //ȸ������ ����
		{
			HttpSession session = req.getSession();
			UserVo certificate = new UserVo(); //����� ���� Ȯ�� ����
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
