package mybean.data;

import java.util.ArrayList;

import myclass.bol.examinee;

public class showExamineeByPage {
	ArrayList<examinee> list=null;
	String backMessage="";
	int pageSize=10;
	int pageAllCount=0;
	int showPage=1;
	StringBuffer presentPageResult;
	public ArrayList<examinee> getList() {
		return list;
	}
	public void setList(ArrayList<examinee> list) {
		this.list = list;
	}
	public String getBackMessage() {
		return backMessage;
	}
	public void setBackMessage(String backMessage) {
		this.backMessage = backMessage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageAllCount() {
		return pageAllCount;
	}
	public void setPageAllCount(int pageAllCount) {
		this.pageAllCount = pageAllCount;
	}
	public int getShowPage() {
		return showPage;
	}
	public void setShowPage(int showPage) {
		this.showPage = showPage;
	}
	public StringBuffer getPresentPageResult() {
		return presentPageResult;
	}
	public void setPresentPageResult(StringBuffer presentPageResult) {
		this.presentPageResult = presentPageResult;
	}
	
}
