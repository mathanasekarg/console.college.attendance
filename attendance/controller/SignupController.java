package attendance.controller;
import attendance.model.Staff;
import attendance.model.Student;
import attendance.model.Attendance;
import attendance.repository.HashmapDatabase;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
public class SignupController {
	protected static HashmapDatabase db = new HashmapDatabase();
	private static Attendance att = new Attendance();
    protected static Date date = new Date();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public static boolean isUserExists(String userName, String clgId){
		return (db.getStaffAttendance().containsKey(clgId) && db.getStaffAttendance().get(clgId).get("date").containsKey(userName)) ? true :
					(db.getStudentAttendance().containsKey(clgId) && db.getStudentAttendance().get(clgId).get("date").containsKey(userName)) ? true : false;
	}
	public static void addStaff(Staff staff){
		// Attendance att = Attendance(staff.getUserName(),true,dateFormat.format(new Date()));
		att.setUserName(staff.getUserName());
		att.setDate(dateFormat.format(new Date()));
		att.setAttendance(true);
		if(db.getStaffs().containsKey(staff.getClgId())){
			if(db.getStaffs().get(staff.getClgId()).containsKey(staff.getPermissionKey())) db.getStaffs().get(staff.getClgId()).get(staff.getPermissionKey()).put(staff.getUserName(),staff);
			else db.getStaffs().get(staff.getClgId()).put(staff.getPermissionKey(),new HashMap(){{put(staff.getUserName(),staff);}});
			db.getStaffAttendance().get(staff.getClgId()).get("date").put(staff.getUserName(),att);
		}
		else {
			db.getStaffs().put(staff.getClgId(),new HashMap(){{put(staff.getPermissionKey(),new HashMap(){{put(staff.getUserName(),staff);}});}});
			db.getStaffAttendance().put(staff.getClgId(),new HashMap(){{put("date",new HashMap(){{put(staff.getUserName(),att);}});}});
		}
		System.out.println("staff attendance : "+db.getStaffAttendance());
		System.out.println("staff attendance (check) : "+db.getStaffAttendance().get(staff.getClgId()));
	}
	public static void addStudent(Student student){
		// Attendance att = Attendance(student.getStudentName(),true,dateFormat.format(new Date()));
		att.setUserName(student.getStudentName());
		att.setDate(dateFormat.format(new Date()));
		att.setAttendance(true);
		if(db.getStudents().containsKey(student.getClgId())) {
			db.getStudents().get(student.getClgId()).put(student.getStudentName(),student);
			db.getStudentAttendance().get(student.getClgId()).get("date").put(student.getStudentName(),att);
		}
		else {
			db.getStudents().put(student.getClgId(),new HashMap(){{put(student.getStudentName(),student);}});
			db.getStudentAttendance().put(student.getClgId(),new HashMap(){{put("date",new HashMap(){{put(student.getStudentName(),att);}});}});
		}
		System.out.println("student : "+db.getStudents());
	}
	public static boolean isPermission(String permissionKey, String clgId, String userName, String userPutKey){
		System.out.println("permis key : "+permissionKey+", clgid : "+clgId+" ,userName : "+userName+", userPutKey : "+userPutKey);
		return  (db.getStaffs().containsKey(clgId) && db.getStaffs().get(clgId).containsKey("userPutKey") && db.getStaffs().get(clgId).get(userPutKey).containsKey(userName) && db.getStaffs().get(clgId).get(userPutKey).get(userName).getPermissionKey().equals(permissionKey)) ? true:
					(db.getColleges().containsKey(clgId) && db.getColleges().get(clgId).containsKey(userName) && db.getColleges().get(clgId).get(userName).getPermissionKey().equals(permissionKey)) ? true : false;
	}
}