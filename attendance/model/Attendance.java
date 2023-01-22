package attendance.model;
public class Attendance {
	private String userName,date;
	private boolean attendance;
	public Attendance(){
	}
	public Attendance(String userName){
		this.userName = userName;
	}
	public Attendance(String userName, boolean attendance, String date) {
		this.userName = userName;
		this.attendance = attendance;
		this.date = date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDate() {
		return this.date;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return this.userName;
	}
	public void setAttendance(boolean attendance) {
		this.attendance = attendance;
	}
	public boolean getAttendance() {
		return this.attendance;
	}
}