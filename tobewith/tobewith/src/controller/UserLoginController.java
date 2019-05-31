import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import controller.Controller;
import vo.*;
import dao.*;


public class UserLoginController  implements Controller {
	

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	    // 로그인 화면에 입력된 아이디와 비밀번호를 가져온다
	    
		UserVo uservo=new UserVo();
		UserDao dao= new UserDao();
		
		String email= req.getParameter("email");
		String pw = req.getParameter("password");
		
		uservo.setEmail(email);	    	
		uservo.setPassword(pw);
		
	    // DB에서 아이디, 비밀번호 확인
	    UserDao dao = dao.getInstance();
	    UserVo check = dao.SelectUser(uservo);
	    
	    // URL 및 로그인관련 전달 메시지
	    String msg = "";
	    
	    if(check.getEmail()==email)    // 로그인 성공
	    { 
	    	if(check.getPassword()==pw) {
	        // 세션에 현재 아이디 세팅
	        //session.setAttribute("sessionId", email);
	        msg = "../../index.jsp";
	    	}
	    	msg = "../view/login.jsp?msg=0";
	    }
	    
	    else    // 아이디가 틀릴경우
	    {
	        msg = "../view/login.jsp?msg=-1";
	    }
		
	}
     
   // sendRedirect(String URL) : 해당 URL로 이동
   // URL뒤에 get방식 처럼 데이터를 전달가능
   //res.sendRedirect(msg);

}
