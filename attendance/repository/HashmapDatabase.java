package attendance.repository;
import attendance.model.Staff;
import attendance.model.Student;
import attendance.model.Attendance;
import attendance.model.Owner;
import java.util.HashMap;
public class HashmapDatabase {
	private static HashmapDatabase hashmapDatabase;
	private HashMap<String,HashMap<String,Owner>> owners;
	private HashMap<String,HashMap<String,HashMap<String,Staff>>> staffs;
	private HashMap<String,HashMap<String,Student>> students;
	private HashMap<String,HashMap<String,HashMap<String,Attendance>>> staffsAttendance;
	private HashMap<String,HashMap<String,HashMap<String,Attendance>>> studentsAttendance;
	public HashmapDatabase () {
		if(hashmapDatabase == null){
			System.out.println("created.........................");
			this.setStaff(new HashMap<String,HashMap<String,HashMap<String,Staff>>>());
			this.setStudent(new HashMap<String,HashMap<String,Student>>());
			this.setStaffsAttendance(new HashMap<String,HashMap<String,HashMap<String,Attendance>>>());
			this.setStudentsAttendance(new HashMap<String,HashMap<String,HashMap<String,Attendance>>>());
			this.setColleges(new HashMap<String,HashMap<String,Owner>>());
		}
	}
	public static HashmapDatabase database(){
		return (hashmapDatabase == null) ? new HashmapDatabase():hashmapDatabase;
	}
	public HashMap<String,HashMap<String,HashMap<String,Staff>>> getStaffs(){
		return this.staffs;
	}
	public void setStaff(HashMap<String,HashMap<String,HashMap<String,Staff>>> staff){
		this.staffs = staff;
	}
	public HashMap<String,HashMap<String,Student>> getStudents(){
		return this.students;
	}
	public void setStudent(HashMap<String,HashMap<String,Student>> student){
		this.students = student;
	}
	public HashMap<String,HashMap<String,HashMap<String,Attendance>>> getStaffAttendance(){
		return this.staffsAttendance;
	}
	public void setStaffsAttendance(HashMap<String,HashMap<String,HashMap<String,Attendance>>> staffAttendance){
		this.staffsAttendance = staffAttendance;
	}
	public HashMap<String,HashMap<String,HashMap<String,Attendance>>> getStudentAttendance(){
		return this.studentsAttendance;
	}
	public void setStudentsAttendance(HashMap<String,HashMap<String,HashMap<String,Attendance>>> studentAttendance){
		this.studentsAttendance = studentAttendance;
	}
	public void setColleges(HashMap<String,HashMap<String,Owner>> owner){
		this.owners = owner;
	}
	public HashMap<String,HashMap<String,Owner>> getColleges(){
		Owner owner1 = new Owner("one","123456");// one = userame, 123456 = password
		Owner owner2 = new Owner("two","123456");// two = userame, 123456 = password
		owner1.setPermissionKey("owner");
		owner2.setPermissionKey("owner");
		HashMap<String,Owner> ownerMap = new HashMap();
		ownerMap.put("one",owner1);//one = username
		ownerMap.put("two",owner2);//two = username
		this.owners.put("1234",ownerMap);//1234 = college id
		this.owners.put("4321",ownerMap);//4321 = college id
		return this.owners;
	}
}