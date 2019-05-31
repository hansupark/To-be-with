package controller.signUpImage;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import controller.Controller;

public class SignUpImageInsertController implements Controller{

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = req.getServletContext();
		req.setCharacterEncoding("UTF-8");
		String saveDir = context.getRealPath("Upload");
		int maxSize = 3 * 1024 * 1024;
		String encoding = "UTF-8";
		MultipartRequest multi = new MultipartRequest(req, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
	}

}
