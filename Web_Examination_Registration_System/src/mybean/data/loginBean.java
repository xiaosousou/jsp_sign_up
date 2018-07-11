package mybean.data;

public class loginBean {
	String loginName,password,backMessage;
	boolean success=false;
	
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getBackMessage() {
		return backMessage;
	}

	public void setBackMessage(String backMessage) {
		this.backMessage = backMessage;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}
}
