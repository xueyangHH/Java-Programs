package course_registration_system;

import java.io.IOException;
import java.util.ArrayList;

public interface AdminItf {
	public static final String username = "Admin";
	public static final String password = "Admin001";
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
	
	public void create(String cn, String id, int m, int csn, String[] sn, String i, String snum, String l, ArrayList<Course> courses);
	
	public void delete(String id, String sn, ArrayList<Course> courses);
	
	public void edit(String id, String sn, String s, String i, ArrayList<Course> courses);

	public void display(String n, String s, ArrayList<Course> courses);

	public Student register(String f, String l);
	
	public void reportall(ArrayList<Course> courses);
	
	public void reportfull(ArrayList<Course> courses);
	
	public void reportnames(String cn, String scn, ArrayList<Course> courses);
	
	public void reportrgcourse(String n, ArrayList<Course> courses);
}
