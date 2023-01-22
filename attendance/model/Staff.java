package attendance.model;
public class Staff {
	private String clgId,dept,permissionKey,phone,email,userName,password;
	public Staff(){}
	public Staff(String clgId, String dept, String permissionKey, String phone, String email, String userName, String password) {
		this.clgId = clgId;
		this.dept = dept;
		this.permissionKey = permissionKey;
		this.phone = phone;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	public void clear(){
		this.phone = null;
		this.email = null;
		this.userName = null;
		this.password = null;
	}
	public void setPermissionKey(String permissionKey) {
		this.permissionKey = permissionKey;
	}
	public String getPermissionKey() {
		return this.permissionKey;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getDept() {
		return this.dept;
	}
	public Staff(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}
	public void setClgId(String clgId) {
		this.clgId = clgId;
	}
	public String getClgId() {
		return this.clgId;
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
	// public void setCreated_by(String created_by) {
	// 	this.created_by = created_by;
	// }
	// public String getCreated_by(){
	// 	return this.created_by;
	// }
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