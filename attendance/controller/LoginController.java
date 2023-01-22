package attendance.controller;
public class LoginController extends SignupController {
	public LoginController() {}
	public boolean isIduserNamePassword(String clgId, String userName, String password, String permissionKey){
		return db.getColleges().containsKey(clgId) && db.getColleges().get(clgId).containsKey(userName) && db.getColleges().get(clgId).get(userName).getPassword().equals(password) ? true : 
				db.getStaffs().containsKey(clgId) && db.getStaffs().get(clgId).containsKey(permissionKey) && db.getStaffs().get(clgId).get(permissionKey).containsKey(userName) && db.getStaffs().get(clgId).get(permissionKey).get(userName).getPassword().equals(password) ? true:false;
	}
}