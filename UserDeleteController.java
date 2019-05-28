package controller.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controller.Controller;
import dao.UserDao;
import vo.UserVo;

public class UserDeleteController implements Controller{

	@Override/**한수야 내가 짜려한 코드는 userdelete.do를 불러왔을 때 삭제한다 였는데
	혹시 회원정보 수정도 되게 하고 할 거면 따로 짜놓은 거 보낼게 말해죠 **/
	/**내가 그지 같이 짜놨다면 갈아 엎어도 돼..미안..**/
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nextpage = null;
		req.setCharacterEncoding("utf-8");
		res.setContentType("texxt/html;charset=utf-8");
		String action = req.getPathInfo();
		
		// 회원 이메일을 sql문으로 전달해 테이블의 회원 정보를 삭제할 것임.
		if (action== null || action.equals("/DeleteUser.do")) { 
			String email  = req.getParameter("email"); //삭제할 회원 이메일을 받아온다
		   UserVo Vo = new UserVo();
			UserDao.DeleteUser(email); //dao 부분이 아직 구현이 안 된 거 같아 !!!!!!!!!!!! 그거에 따라 이 코드를 바꾸자 
			req.setAttribute("msg","deleted"); // 추후 구현될 회원 목록창으로 삭제 작업 완료 메세지 전달
			nextpage= "/member/listMembers.do"; // 아직 구현 안된 회원 목록창을 띄운다.
		}else
		{
			ArrayList memberList = UserDao.listMembers(); // userdao에 회원 list를 따로 만들어야 할 거같아 회원 목록창.. 말하는 거지 뭐,,
			req.Attribute("memberList",memberList);
			nextPage= "/아직 미정";
		}
		RequestDispatcher dispatch = req.getRequestDispatcher(nextpage);
		dispatch.forward(req, res);
	}

}

