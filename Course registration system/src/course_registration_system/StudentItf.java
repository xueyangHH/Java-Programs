package course_registration_system;

import java.util.ArrayList;

public interface StudentItf {
	public static final String username = "";
	public static final String password = "";
	public static final String fname = "";
	public static final String lname = "";
	
	public String getUserN();
	
	public String getPassW();
	
	public String getFirst();
	
	public String getLast();
	
	public void setFirst(String f);
	
	public void setLast(String l);

	public void setUserN(String u);

	public void setPassW(String p);
	
	public boolean veriLoginfo(String u, String p);
	
	public boolean veriName(String f, String l);
	
	public void reportall(ArrayList<Course> courses);

	public void reportNofull(ArrayList<Course> courses);
	
	public void register(String id, String scn, String n, ArrayList<Course> courses);
	
	public void withdraw(String id, String scn, String n, ArrayList<Course> courses);
	
	public void reportrgcourse(String n, ArrayList<Course> courses);
}
