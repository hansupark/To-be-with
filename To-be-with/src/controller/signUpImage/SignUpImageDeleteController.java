package controller.signUpImage;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;
import controller.HttpUtil;
import service.SignUpImageService;
import vo.signUpImageVo;

public class SignUpImageDeleteController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		req.setCharacterEncoding("UTF-8");	
		SignUpImageService service = SignUpImageService.getService();
		int userNum = Integer.parseInt(req.getParameter("userNum"));
		signUpImageVo vo = new signUpImageVo();
		vo.setUserNum(userNum);
		int result = service.DeleteSignUpImage(vo);		
		return;
	}

}
