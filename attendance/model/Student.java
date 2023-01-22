package attendance.model;
public class Student {
	private String clgId,studentName,dept,phone,email,fatherName,area;
	public Student (){}
	public Student(String clgId, String studentName, String dept, String phone, String email, String fatherName, String area) {
		this.clgId = clgId;
		this.studentName = studentName;
		this.dept = dept;
		this.phone = phone;
		this.email = email;
		this.fatherName = fatherName;
		this.area = area;
	}
	public Student(String fatherName, String area) {
		this.fatherName = fatherName;
		this.area = area;
	}
	
	public void clear(){
		this.phone = null;
		this.email = null;
		this.fatherName = null;
		this.area = null;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return this.dept;
	}
	public void setClgId(String clgId) {
		this.clgId = clgId;
	}
	public String getClgId() {
		return this.clgId;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentName() {
		return this.studentName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhone() {
		return this.phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEmail(){
		return this.email;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public String getFatherName() {
		return this.fatherName;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getArea() {
		return this.area;
	}
	// public void setCreated_by(String created_by) {
	// 	this.created_by = created_by;
	// }
	// public String getCreated_by(){
	// 	return this.created_by;
	// }
}