package service;

import java.util.ArrayList;

import dao.singUpImageDao;
import vo.signUpImageVo;

public class SignUpImageService {

	private static SignUpImageService service = new SignUpImageService();
	
	private SignUpImageService() {};
	
	public static SignUpImageService getService()
	{
		return service;
	}
	
	private singUpImageDao dao = singUpImageDao.getInstance();
	
	public ArrayList<signUpImageVo> getSignUpImages(signUpImageVo image)
	{
		return dao.getSignUpImages(image);
	}
	
	public int InsertSignUpImage(signUpImageVo image)
	{
		return dao.insertSignUpImage(image);
	}
}
