package attendance.view;
import java.util.Scanner;
import attendance.model.Staff;
import attendance.model.Student;
import attendance.model.Attendance;
import java.util.regex.Pattern;
import attendance.controller.SignupController;
import attendance.controller.AttendanceController;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Date;
import java.text.SimpleDateFormat;
public class Dashboard extends Home {
	private static Staff staff = new Staff();
	private static Student student = new Student();
	private static Scanner sc = new Scanner(System.in);
	private static SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	public static void dashboard(String clgId, String userName){
		System.out.println("\n\t<------ Welcome College Attendance Dasshboard -------->");

		while(true){
			// System.out.println("\n\t<------ Welcome College Attendance Signup -------->");
			System.out.println("\n\t1.New Staff --->\n\t2.new student --->\n\t3.Staff attendance --->\n\t4.student attendance\n\t5.show staff attendance\n\t6.show student attendance --->\n\t0.Exit --->");
			System.out.print("\n\tEnter your input : ");
			
			short option = stringToShort(sc.nextLine());
			
			switch (option) {
				case 1 : checkNewStaffPermission(clgId,userName);break;
				case 2 : checkNewStudentPermission(clgId,userName);break;
				case 3 : checkStaffAttendancePermission(clgId,userName);break;
				case 4 : checkStudentAttendancePermission(clgId,userName);break;
				case 5 : checkStaffAttendanceShowPermission(clgId,userName);break;
				case 6 : checkStudentAttendanceShowPermission(clgId,userName);break;
				case 0 : System.out.println("\n\t<-------- Thank you for your Time -------->");break;
				default : wrongInput();
			}
			if (option == 0) break;
			else if(option > 6){
				System.out.print("\n\t1.Try again --->\n\t0.Back --->\n\tEnter Your input : ");
				if (stringToShort(sc.nextLine()) == 0) break;
				else System.out.println("\n\t<------- ERROR : Enter valid input --------> ");
			}
		}
	}
	public static void checkNewStaffPermission(String clgId,String userName){
		System.out.print("usernam : "+userName);
		System.out.print("\n\tEnter your permission key : ");
		if (SignupController.isPermission(sc.nextLine(),clgId,userName,"staff")) newStaff(clgId); else System.out.println("\n\t<------- ERROR : permission Denied -----> ");
	}
	public static void checkNewStudentPermission(String clgId,String userName){
		System.out.print("\n\tEnter your permission key : ");
		if (SignupController.isPermission(sc.nextLine(),clgId,userName,"staff")) newStudent(clgId); else System.out.println("\n\t<------- ERROR : permission Denied -----> ");
	}
	public static void checkStaffAttendancePermission(String clgId,String userName){
		System.out.print("\n\tEnter your permission key : ");
		if (SignupController.isPermission(sc.nextLine(),clgId,userName,"staff")) staffAttendance(clgId); else System.out.println("\n\t<------- ERROR : permission Denied -----> ");
	}
	public static void checkStudentAttendancePermission(String clgId,String userName){
		System.out.print("\n\tEnter your permission key : ");
		if (SignupController.isPermission(sc.nextLine(),clgId,userName,"staff")) studentAttendance(clgId); else System.out.println("\n\t<------- ERROR : permission Denied -----> ");
	}
	public static void checkStaffAttendanceShowPermission(String clgId,String userName){
		System.out.print("\n\tEnter your permission key : ");
		if (SignupController.isPermission(sc.nextLine(),clgId,userName,"staff")) showStaffAttendance(clgId); else System.out.println("\n\t<------- ERROR : permission Denied -----> ");
	}
	public static void checkStudentAttendanceShowPermission(String clgId,String userName){
		System.out.print("\n\tEnter your permission key : ");
		if (SignupController.isPermission(sc.nextLine(),clgId,userName,"staff")) showStudentAttendance(clgId); else System.out.println("\n\t<------- ERROR : permission Denied -----> ");
	}
	private static void newStaff(String clgId){
		while(true){
			System.out.println("\n\t<------- new Staff -------->");
			System.out.print("\n\tEnter staff's Phone number (min length : 10 numbers) : ");
			staff.setPhone(sc.nextLine());
			System.out.print("\tEnter staff's E-mail (use @) : ");
			staff.setEmail(sc.nextLine());
			System.out.print("\tEnter staff's Permission key (EX:HOD&CSE,HOD_EEE,staff@cse) : ");
			staff.setPermissionKey(sc.nextLine());
			System.out.print("\tEnter staff's dept (EX : CSE,EEE) : ");
			staff.setDept(sc.nextLine());
			System.out.print("\tEnter staff's Name (min length : 3 letters) : ");
			staff.setUserName(sc.nextLine());
			System.out.print("\tEnter staff's Password (min length : 6 letters) : ");
			staff.setPassword(sc.nextLine());
			if(staff.getPhone().length() < 10 || staff.getEmail().length() < 5 || staff.getUserName().length() < 3 || staff.getPassword().length() < 6){
				System.out.println("\n\t<------- ERROR : input length is required...! --------> ");
				staff.clear();
			}
			else if(Pattern.matches("^[0-9]{10}$",staff.getPhone()) && Pattern.matches("^(.+)@(\\S+)$",staff.getEmail())){
				if(SignupController.isUserExists(staff.getUserName(),clgId)) {
					System.out.println("\n\t<------- ERROR : User name already exists...! --------> ");
					staff.clear();
				}
				else {
					staff.setClgId(clgId);
					SignupController.addStaff(staff);
					System.out.println("\n\t<------- Staff created ...! --------> ");
					break;
				}
			}
			else {
				System.out.println("\n\t<------- ERROR : Email or phone number is invalid ...! --------> ");
				staff.clear();
			}
			System.out.print("\n\t1.Try again --->\n\t0.Back --->\n\tEnter Your input : ");
			if (stringToShort(sc.nextLine()) == 0) break;
			else System.out.println("\n\t<------- ERROR : Enter valid input --------> ");
		}//End loop
	}
	private static void newStudent(String clgId){
		while(true){
			System.out.println("\n\t<------- new Student -------->");
			System.out.print("\n\tEnter Student name (min length : 3 numbers) : ");
			student.setStudentName(sc.nextLine());
			System.out.print("\n\tEnter student Department (EX : CSE,EEE) : ");
			student.setPhone(sc.nextLine());
			System.out.print("\n\tEnter student Phone number (min length : 10 numbers) : ");
			student.setPhone(sc.nextLine());
			System.out.print("\tEnter student E-mail (use @) : ");
			student.setEmail(sc.nextLine());
			System.out.print("\tEnter student Father Name (min length : 3 letters) : ");
			student.setFatherName(sc.nextLine());
			System.out.print("\tEnter student Area (min length : 6 letters) : ");
			student.setArea(sc.nextLine());
			if(student.getPhone().length() < 10 || student.getEmail().length() < 5 || student.getFatherName().length() < 3 || student.getArea().length() < 6){
				System.out.println("\n\t<------- ERROR : input length is required...! --------> ");
				student.clear();
			}
			else if(Pattern.matches("^[0-9]{10}$",student.getPhone()) && Pattern.matches("^(.+)@(\\S+)$",student.getEmail())){
				if(SignupController.isUserExists(student.getEmail(),clgId)) {
					System.out.println("\n\t<------- ERROR : E-mail already exists...! --------> ");
					student.clear();
				}
				else {
					student.setClgId(clgId);
					SignupController.addStudent(student);
					System.out.println("\n\t<------- Student created ...! --------> ");
					break;
				}
			}
			else {
				System.out.println("\n\t<------- ERROR : Email or phone number is invalid ...! --------> ");
				student.clear();
			}
			System.out.print("\n\t1.Try again --->\n\t0.Back --->\n\tEnter Your input : ");
			if (stringToShort(sc.nextLine()) == 0) break;
			else System.out.println("\n\t<------- ERROR : Enter valid input --------> ");
		}//End loop
	}
	private static void staffAttendance(String clgId){
		int i =0;
		System.out.println("\n\t<------- Staff Attendance --------> ");
		HashMap<String,HashMap<String,Attendance>> staffs = AttendanceController.getStaffAttendance(clgId);
		HashMap<String,Attendance> totalStaffs = staffs.get("date");
		if(staffs == null || totalStaffs == null)System.out.println("\n\t<------- No staffs not yet start --------> ");
		else{
			System.out.println("\n\t<------- NOTE : if only present (p), Absent (a) otherwise (a) --------> ");
			for(Entry<String,Attendance> entry : totalStaffs.entrySet()){
				Attendance clientAtt = new Attendance();
				clientAtt.setUserName(entry.getKey());
				clientAtt.setDate(dateFormat.format(new Date()));
				System.out.print("\n\t"+(++i)+"."+entry.getKey()+" : ");
				clientAtt.setAttendance(getAttendance(sc.nextLine()));
				AttendanceController.setStaffAttendance(clgId,clientAtt);
			}
		}
	}
	private static void studentAttendance(String clgId){
		int i =0;
		System.out.println("\n\t<------- Student Attendance --------> ");
		HashMap<String,HashMap<String,Attendance>> students = AttendanceController.getStudentAttendance(clgId);
		if(students == null)System.out.println("\n\t<------- No students not yet start --------> ");
		else{
			HashMap<String,Attendance> totalStudents = students.get("date");
			System.out.println("\n\t<------- NOTE : if only present (p), Absent (a) otherwise (a) --------> ");
			for(Entry<String,Attendance> entry : totalStudents.entrySet()){
				Attendance clientAtt = new Attendance();
				clientAtt.setDate(dateFormat.format(new Date()));
				clientAtt.setUserName(entry.getKey());
				System.out.print("\n\t"+(++i)+"."+entry.getKey()+" : ");
				clientAtt.setAttendance(getAttendance(sc.nextLine()));
				AttendanceController.setStudentAttendance(clgId,clientAtt);
			}
		}
	}
	private static void showStaffAttendance(String clgId){
		int i =0,j=0;
		System.out.println("\n\t<------- Staff Attendance --------> ");
		HashMap<String,HashMap<String,Attendance>> staffs = AttendanceController.getShowStaffAttendance(clgId);
		if(staffs == null)System.out.println("\n\t<------- No staff's attendance not yet start --------> ");
		else{
			System.out.println("\n\t<------- college staff attendance --------> ");
			for(Entry<String,HashMap<String,Attendance>> entry : staffs.entrySet()){
				System.out.println("\n\t"+(++j)+".DATE : " + entry.getKey());
				if(j!=0)
					for(Entry<String,Attendance> innerEntry : entry.getValue().entrySet())
						System.out.println("\t"+(++i)+".|NAME : "+innerEntry.getKey()+"|,| ATTENDANCE :  "+innerEntry.getValue().getAttendance()+"|");
				i=0;
			}
		}
	}
	private static void showStudentAttendance(String clgId){
		int i =0,j=0;
		System.out.println("\n\t<------- student Attendance --------> ");
		HashMap<String,HashMap<String,Attendance>> staffs = AttendanceController.getShowStudentAttendance(clgId);
		if(staffs == null)System.out.println("\n\t<------- No student's attendance not yet start --------> ");
		else{
			System.out.println("\n\t<------- college student attendance --------> ");
			for(Entry<String,HashMap<String,Attendance>> entry : staffs.entrySet()){
				System.out.println("\n\t"+(++j)+".DATE : " + entry.getKey());
				if(j!=0)
					for(Entry<String,Attendance> innerEntry : entry.getValue().entrySet())
						System.out.println("\t"+(++i)+".|NAME : "+innerEntry.getKey()+"|,| ATTENDANCE :  "+innerEntry.getValue().getAttendance()+"|");
				i=0;
			}
		}
	}
	protected static boolean getAttendance(String attendance){
		return attendance.equals("p") || attendance.equals("P") ? true:false;
	}
}