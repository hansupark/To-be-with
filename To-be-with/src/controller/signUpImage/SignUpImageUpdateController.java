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

public class SignUpImageUpdateController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SignUpImageService service = SignUpImageService.getService();
		int userNum = (int) req.getSession().getAttribute("LoginUserNum");
		req.setCharacterEncoding("UTF-8");		
		ServletContext context = req.getServletContext();
		String saveDir = context.getRealPath("images_UserCertification");
		System.out.println(saveDir);
		int maxSize = 3 * 1024 * 1024;
		String encoding = "UTF-8";
		
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		String formname = "";
		String fileName = "";		
		Enumeration form = multi.getFileNames();
		while(form.hasMoreElements())
		{
			formname = (String) form.nextElement();
			fileName = multi.getFilesystemName(formname);			
		}
		
		signUpImageVo image = new signUpImageVo();
		image.setImage(saveDir + "\\" + fileName); 
		image.setUserNum(userNum);
		
		service.updateSignUpImage(image);
		HttpUtil.forward(req, res,"login.jsp");
		return;
	}

}
