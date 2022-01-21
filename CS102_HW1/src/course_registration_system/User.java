package course_registration_system;

import java.util.ArrayList;

public abstract class User {
	private String username;
	private String password;
	private String fname;
	private String lname;
	
	public User() {}
	public abstract String getUserN();
	public abstract String getPassW();
	public abstract void setUserN(String u);
	public abstract void setPassW(String p);
	public abstract String getFirst();
	public abstract String getLast();
	public abstract void setFirst(String f);
	public abstract void setLast(String l);
	public abstract void reportall(ArrayList<Course> courses);
	public abstract void reportrgcourse(String n, ArrayList<Course> courses);
}
