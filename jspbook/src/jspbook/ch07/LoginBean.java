package jspbook.ch07;

public class LoginBean {
	
	private String userid;
	private String passwd;
	private String email;
	
	final String _userid="12345";
	final String _passwd="12345";
	final String _email="fffff@naver.com";
	
	public boolean CheckUser() {
		if(userid.equals(_userid) && passwd.equals(_passwd)&&email.equals(_email))
			return true;
		else
			return false;
	}
	
	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static void main(String[] args) {
	
	}

	
	
}
