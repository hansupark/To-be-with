package controller.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controller.Controller;
import controller.HttpUtil;
import service.AdminService;
import service.UserService;
import vo.AdminVo;
import vo.UserVo;

public class AdminLoginController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charSet = UTF-8");
		
		AdminService service = AdminService.getService();
		int result;
		String id = req.getParameter("adminId");
		String pw = req.getParameter("adminPw");
		
		AdminVo admin = new AdminVo();
		admin.setId(id);
		admin.setPw(pw);
		
		result = service.LoginAdmin(admin);
		
		if(result == -1)
		{
			res.getWriter().println("<script>alert('��й�ȣ�� �����ʽ��ϴ�.'); location.href='loginadmin.jsp';</script>");
		}
		else if(result == 0)
		{
			res.getWriter().println("<script>alert('���̵� �������� �ʽ��ϴ�.'); location.href='loginadmin.jsp';</script>");
		}
		else //ȸ������ ����
		{
			HttpSession session = req.getSession();
			session.setAttribute("LoginAdmin",admin);
			HttpUtil.forward(req, res,"mainadmin.jsp");
			return;
			
		}
	}

}
