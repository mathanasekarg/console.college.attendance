package attendance.controller;
import java.util.HashMap;
import attendance.repository.HashmapDatabase;
import attendance.model.Attendance;
public class AttendanceController extends SignupController{
	public static HashMap<String,HashMap<String,Attendance>> getStaffAttendance(String clgId){
		return db.getStaffAttendance().containsKey(clgId) ? db.getStaffAttendance().get(clgId) : null;
	}
	public static HashMap<String,HashMap<String,Attendance>> getStudentAttendance(String clgId){
		return db.getStudentAttendance().containsKey(clgId) ? db.getStudentAttendance().get(clgId) : null;
	}
	public static void setStaffAttendance(String clgId, Attendance attendance){
		if(db.getStaffAttendance().get(clgId).containsKey(attendance.getDate())) db.getStaffAttendance().get(clgId).get(attendance.getDate()).put(attendance.getUserName(),attendance);
		else db.getStaffAttendance().get(clgId).put(attendance.getDate(),new HashMap(){{put(attendance.getUserName(),attendance);}});
	}
	public static void setStudentAttendance(String clgId, Attendance attendance){
		if(db.getStudentAttendance().get(clgId).containsKey(attendance.getDate())) db.getStudentAttendance().get(clgId).get(attendance.getDate()).put(attendance.getUserName(),attendance);
		else db.getStudentAttendance().get(clgId).put(attendance.getDate(),new HashMap(){{put(attendance.getUserName(),attendance);}});
	}
	public static HashMap<String,HashMap<String,Attendance>> getShowStaffAttendance(String clgId){
		return db.getStaffAttendance().get(clgId);
	}
	public static HashMap<String,HashMap<String,Attendance>> getShowStudentAttendance(String clgId){
		return db.getStudentAttendance().get(clgId);
	}
}