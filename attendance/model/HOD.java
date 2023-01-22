package attendance.model;
public class HOD {
	private String phone,email,userName,password,created_by;

	public HOD(String phone, String email, String created_by, String userName, String password) {
		this.phone = phone;
		this.email = email;
		this.created_by = created_by;
		this.userName = userName;
		this.password = password;
	}
	public HOD(String userName, String password) {
		this.userName = userName;
		this.password = password;
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
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreated_by(){
		return this.created_by;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
}