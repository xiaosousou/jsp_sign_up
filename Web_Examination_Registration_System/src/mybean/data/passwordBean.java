package mybean.data;

public class passwordBean {
	String oldPassword,newPassword,backMessage="";
	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getBackMessage() {
		return backMessage;
	}

	public void setBackMessage(String backMessage) {
		this.backMessage = backMessage;
	}
	
	
}
