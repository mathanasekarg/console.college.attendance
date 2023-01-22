package attendance.view;
import java.util.Scanner;
import attendance.view.Login;
// javac -d . view\*.java model\*.java repository\*.java controller\*.java
// java attendance.view.Home

// javac -cp . view\*.java model\*.java repository\*.java controller\*.java
// javac -d . attendance.view\*.java attendance.model\*.java attendance.repository\*.java attendance.controller\*.java
// java -cp . view\Home.java

public class Home {
	public static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		while(true) {
			System.out.println("\n\t<------ Welcome College Attendance -------->");
			System.out.println("\n\t1.Login --->\n\t0.Exit --->");
			System.out.print("\n\tEnter your input : ");
			switch (stringToShort(sc.nextLine())) {
				case 1 : Login.login();break;
				// case 2 : Signup.signup();break;
				case 0 : System.out.println("\n\t<-------- Thank you for your Time -------->");System.exit(0);
				default : wrongInput();
			}
		} // End Loop
	}
	public static void wrongInput(){
		System.out.println("\n\t<------ Input Miss match Try Again -------->");
	}
	public static short stringToShort(String option){
		return (option.length() == 1) ? Short.parseShort(option.charAt(0)+"") : 11;
	}
}