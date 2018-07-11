package mybean.data;

import javax.servlet.http.HttpServlet;

public class uploadFileBean extends HttpServlet {
	String fileName,savedFileName,backMessage="";
	public String getFileName() {
		return fileName;
	}
    public void setFileName(String fileName) {
    	this.fileName = fileName;
    }
    public String getSavedFileName() {
		return savedFileName;
	}
    public void setsavedFileName(String savedFileName) {
    	this.savedFileName = savedFileName;
    }
    public String getbackMessage() {
		return backMessage;
	}
    public void setbackMessage(String backMessage) {
    	this.backMessage = backMessage;
    }
}
