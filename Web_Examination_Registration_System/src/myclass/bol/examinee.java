package myclass.bol;

public class examinee {
	private String examID=null;
	private String examName=null;
	private String sex=null;
	private String password=null;
	private String examType=null;
	private String school=null;
	private String memo=null;
	private String backmessage=null;
	private String pic=null;
	
	public examinee() {
		super();
	}
	public examinee(String examID, String examName, String sex, String password, String examType, String school,String memo,String pic) {
		super();
		this.examID = examID;
		this.examName = examName;
		this.sex = sex;
		this.password = password;
		this.examType = examType;
		this.school = school;
		this.memo = memo;
		this.pic=pic;
	}
	
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getExamID() {
		return examID;
	}
	public void setExamID(String examID) {
		this.examID = examID;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getExamType() {
		return examType;
	}
	public void setExamType(String examType) {
		this.examType = examType;
	}
	public String getSchool() {
		return school;
	}
	public void setSchool(String school) {
		this.school = school;
	}
	public String getBackmessage() {
		return backmessage;
	}
	public void setBackmessage(String backmessage) {
		this.backmessage = backmessage;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
}
