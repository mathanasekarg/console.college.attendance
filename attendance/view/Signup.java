package attendance.view;
import java.util.Scanner;
import attendance.model.Staff;
import attendance.model.Student;
import attendance.controller.SignupController;
import java.util.regex.Pattern;
public class Signup {
	// private static Staff staff = new Staff();
	// private static Student student = new Student();
	// private static Scanner sc = new Scanner(System.in);
	// public static void signup(){
	// 	System.out.print("\n\tEnter your id : ");
	// 	String clgId = sc.nextLine();
	// 	if (SignupController.isClgId(clgId)) newStaff(clgId); else System.out.print("\n\tWrong College Id -----> ");
	// }
	// public static void signup(String clgId) {
	// 	while(true){
	// 		System.out.println("\n\t<------ Welcome College Attendance Signup -------->");
	// 		System.out.println("\n\t1.Staff --->\n\t2.student --->\n\t0.Exit --->");
	// 		System.out.print("\n\tEnter your input : ");
	// 		short option = stringToShort(sc.nextLine());
	// 		switch (option) {
	// 			case 1 : newStaff(clgId);break;
	// 			case 2 : newStudent(clgId);break;
	// 			case 0 : System.out.println("\n\t<-------- Thank you for your Time -------->");break;
	// 			default : wrongInput();
	// 		}
	// 		if (option == 0) break;
	// 		else if(option > 2){
	// 			System.out.print("\n\t1.Try again --->\n\t0.Back --->\n\tEnter Your input : ");
	// 			if (stringToShort(sc.nextLine()) == 0) break;
	// 			else System.out.println("\n\t<------- ERROR : Enter valid input --------> ");
	// 		}
	// 	}
	// }
	// public static void newStaff(String clgId){
	// 	System.out.print("\n\tEnter your permission id : ");
	// 	String permissionId = sc.nextLine();
	// 	if (SignupController.isPermissionId(permissionId)) newStaff(clgId,permissionId); else System.out.print("\n\tWrong permission Id -----> ");
	// }
	// private static void newStaff(String clgId, String permissionId){
	// 	while(true){
	// 		System.out.println("\n\t<------- new Staff -------->");
	// 		System.out.print("\n\tEnter staff's Phone number (min length : 10 numbers) : ");
	// 		staff.setPhone(sc.nextLine());
	// 		System.out.print("\tEnter staff's E-mail (use @) : ");
	// 		staff.setEmail(sc.nextLine());
	// 		System.out.print("\tEnter staff's dept (EX : CSE,EEE) : ");
	// 		staff.setDept(sc.nextLine());
	// 		System.out.print("\tEnter staff's Name (min length : 3 letters) : ");
	// 		staff.setUserName(sc.nextLine());
	// 		System.out.print("\tEnter staff's Password (min length : 6 letters) : ");
	// 		staff.setPassword(sc.nextLine());
	// 		if(staff.getPhone().length() < 10 || staff.getEmail().length() < 5 || staff.getUserName().length() < 3 || staff.getPassword().length() < 6){
	// 			System.out.println("\n\t<------- ERROR : input length is required...! --------> ");
	// 			staff.clear();
	// 		}
	// 		else if(Pattern.matches("^[0-9]{10}$",staff.getPhone()) && Pattern.matches("^(.+)@(\\S+)$",staff.getEmail())){
	// 			if(SignupController.isUserExists(staff.getUserName())) {
	// 				System.out.println("\n\t<------- ERROR : User name already exists...! --------> ");
	// 				staff.clear();
	// 			}
	// 			else {
	// 				staff.setClgId(clgId);
	// 				SignupController.addStaff(staff);
	// 				System.out.println("\n\t<------- Staff created ...! --------> ");
	// 				break;
	// 			}
	// 		}
	// 		else {
	// 			System.out.println("\n\t<------- ERROR : Email or phone number is invalid ...! --------> ");
	// 			staff.clear();
	// 		}
	// 		System.out.print("\n\t1.Try again --->\n\t0.Back --->\n\tEnter Your input : ");
	// 		if (stringToShort(sc.nextLine()) == 0) break;
	// 		else System.out.println("\n\t<------- ERROR : Enter valid input --------> ");
	// 	}//End loop
	// }
	// private static void newStudent(String clgId){
	// 	while(true){
	// 		System.out.println("\n\t<------- new Student -------->");
	// 		System.out.print("\n\tEnter Student name (min length : 3 numbers) : ");
	// 		student.setStudentName(sc.nextLine());
	// 		System.out.print("\n\tEnter student Department (EX : CSE,EEE) : ");
	// 		student.setPhone(sc.nextLine());
	// 		System.out.print("\n\tEnter student Phone number (min length : 10 numbers) : ");
	// 		student.setPhone(sc.nextLine());
	// 		System.out.print("\tEnter student E-mail (use @) : ");
	// 		student.setEmail(sc.nextLine());
	// 		System.out.print("\tEnter student Father Name (min length : 3 letters) : ");
	// 		student.setFatherName(sc.nextLine());
	// 		System.out.print("\tEnter student Area (min length : 6 letters) : ");
	// 		student.setArea(sc.nextLine());
	// 		if(student.getPhone().length() < 10 || student.getEmail().length() < 5 || student.getFatherName().length() < 3 || student.getArea().length() < 6){
	// 			System.out.println("\n\t<------- ERROR : input length is required...! --------> ");
	// 			student.clear();
	// 		}
	// 		else if(Pattern.matches("^[0-9]{10}$",student.getPhone()) && Pattern.matches("^(.+)@(\\S+)$",student.getEmail())){
	// 			if(SignupController.isUserExists(student.getEmail())) {
	// 				System.out.println("\n\t<------- ERROR : E-mail already exists...! --------> ");
	// 				student.clear();
	// 			}
	// 			else {
	// 				student.setClgId(clgId);
	// 				SignupController.addStudent(student);
	// 				System.out.println("\n\t<------- Student created ...! --------> ");
	// 				break;
	// 			}
	// 		}
	// 		else {
	// 			System.out.println("\n\t<------- ERROR : Email or phone number is invalid ...! --------> ");
	// 			student.clear();
	// 		}
	// 		System.out.print("\n\t1.Try again --->\n\t0.Back --->\n\tEnter Your input : ");
	// 		if (stringToShort(sc.nextLine()) == 0) break;
	// 		else System.out.println("\n\t<------- ERROR : Enter valid input --------> ");
	// 	}//End loop
	// }
	
	// public static void wrongInput(){
	// 	System.out.println("\n\t<------ Input Miss match Try Again -------->");
	// }
	// public static short stringToShort(String option){
	// 	return (option.length() == 1) ? Short.parseShort(option.substring(0,1)) : 11;
	// }
}