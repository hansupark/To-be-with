package controller.signUpImage;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.util.ArrayList;
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

public class SignUpImageInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int userNum = (int) req.getSession().getAttribute("LoginUserNum");
		System.out.println(userNum);
		
		ServletContext context = req.getServletContext();
		SignUpImageService service = SignUpImageService.getService();
		signUpImageVo image = new signUpImageVo();
		
		req.setCharacterEncoding("UTF-8");
		String saveDir = "C:\\Users\\soo98\\git\\repository\\To-be-with\\WebContent\\images_UserCertification";
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
		
		image.setImage(saveDir + "\\" + fileName); 
		image.setUserNum(userNum);
		
		service.InsertSignUpImage(image);
		HttpUtil.forward(req, res, "login.jsp");
	}

}
