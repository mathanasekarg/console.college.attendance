package attendance.view;
import java.util.Scanner;
import attendance.controller.LoginController;
public class Login extends Home {
	public static void login() {
		LoginController loginController = new LoginController();
		while (true) {
			System.out.println("\n\t<------ Welcome College Attendance Login -------->");
			System.out.print("\n\tEnter Your College id : ");
			String clgId = sc.nextLine();
			System.out.print("\n\tEnter Your User Name : ");
			String userName = sc.nextLine();
			System.out.print("\n\tEnter Your Password : ");
			String password = sc.nextLine();
			System.out.print("\n\tEnter Your permission key : ");
			String permissionKey = sc.nextLine();
			if(loginController.isIduserNamePassword(clgId,userName,password,permissionKey)) {
				System.out.print("usernam : "+userName);
				Dashboard.dashboard(clgId,userName);
				break;
			}
			else System.out.println("\n\t<--------- ERROR : E-mail or Password is Wrong ----------> ");
			System.out.print("\n\t1.Try again --->\n\t0.Exit --->\n\tEnter Your input : ");
			if (stringToShort(sc.nextLine()) == 0) break;
			else System.out.println("\n\t<------- ERROR : Enter valid input --------> ");
		}// End loop
	}
}