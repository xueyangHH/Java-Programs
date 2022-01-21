package course_registration_system;
import java.io.IOException;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class Admin extends User implements AdminItf {
	private String username = "Admin";
	private String password = "Admin001";
	private String fname;
	private String lname;

	//constructor that uses the super keyword
	public Admin() {
		super();
	}
	
	//getting admin's username
	@Override
	public String getUserN() {
		return username;
	}
	
	//getting admin's password
	@Override
	public String getPassW() {
		return password;
	}
	
	//getting admin's first name (though not used)
	@Override
	public String getFirst() {
		return fname;
	}
	
	//getting admin's last name (though not used)
	@Override
	public String getLast() {
		return lname;
	}
	
	//setting admin's first name (though not used)
	@Override
	public void setFirst(String f) {
		fname = f;
	}
	
	//setting admin's last name (though not used)
	@Override
	public void setLast(String l) {
		lname = l;
	}

	//setting admin's username
	@Override
	public void setUserN(String u) {
		return;
	}

	//getting admin's password
	@Override
	public void setPassW(String p) {
		return;
	}
	
	//taking the username and password as parameters and verify the login info
	@Override
	public boolean veriLoginfo(String u, String p) {
		if (username.equals(u) && password.equals(p)) 
			return true;
		else
			return false;
	}
	
	//for searching a course, taking course id and section name
	public Course search(String id, String sn, ArrayList<Course> courses) {
		boolean exist = false;
		int retnum = 0;
		for (int x = 0; x < courses.size(); x++) {
			if (id.equals(courses.get(x).getID())) {
				if (sn.equals(courses.get(x).getSecN())) {
					exist = true;
					retnum = x;
				}
				else continue;
			}
			else
				continue;
		}
		if (exist == true) {
			return courses.get(retnum);
		} else {
			System.out.println("The course does not exist!");
			System.out.println();
			return null;
		}
	}
	
	//for creating a course, taking every piece of info about a course from the admin
	@Override
	public void create(String cn, String id, int m, int csn, String[] sn, String i, String snum, String l, ArrayList<Course> courses) {
		Course course = new Course(cn, id, m, csn, sn, i, snum, l);
		boolean exist = false;
		for (Course c: courses) {
			if (id.equals(c.getID())) {
				if (snum.equals(c.getSecN())) {
					exist = true;
					System.out.println("The course already exists!");
					System.out.println();
					break;
				}
				else continue;
			}
			else
				continue;
		}
		if (exist == false) {
			courses.add(course);
		}
	}
	
	//for deleting a course, taking course id and section name
	@Override
	public void delete(String id, String sn, ArrayList<Course> courses) {
		boolean exist = false;
		ArrayList<Course> repcourses = courses;
		for (Course c: repcourses) {
			if (id.equals(c.getID())) {
				if (sn.equals(c.getSecN())) {
					exist = true;
					repcourses.remove(c);
				}
				else continue;
			}
			else
				continue;
		}
		if (exist == true) {
			courses = repcourses;
		}
		else {
			System.out.println("The course does not exist!");
			System.out.println(); }
	}
	
	//for editing a course, taking course id and section name
	// besides course name and id that are prohibited for editing, section number is also disabled
	// for editing because that would confuse one course object with another
	// editing student names would be considered by default as adding a name to the list
	@Override
	//                    which to edit, the edited info
	public void edit(String id, String sn, String s, String i, ArrayList<Course> courses) {
		boolean exist = false;
		for (Course c: courses) {
			if (id.equals(c.getID())) {
				if (sn.equals(c.getSecN())) {
					exist = true;
					if (s.equals("max num")) {
						c.setmaxN(Integer.parseInt(i));
					} else if (s.equals("current num")) {
						c.setCurStudN(Integer.parseInt(i));
					} else if (s.equals("student names")) {
						String[] studname = c.getStudName();
						studname[studname.length+1] = i;
						c.setStudName(studname);
						c.setCurStudN(c.getCurStudN()+1);
					} else if (s.equals("instructor")) {
						c.setInstr(i);
					} else if (s.equals("location")) {
						c.setLoc(i);
					}
				}
				else continue;
			}
			else
				continue;
		}
		if (exist == false) {
			System.out.println("The course does not exist!");
			System.out.println();
		}
	}
	
	//for displaying a course, taking course id and section name
	@Override
	public void display(String n, String s, ArrayList<Course> courses) {
		Course c = search(n,s,courses);
		System.out.println(c.getCName()+", "+c.getID()+", "+c.getmaxN()+", "+c.getCurStudN()+", "+c.getSecN()+", "+c.getInstr()+", "+c.getLoc());
		for(int i = 0; i < c.getStudName().length; i++) {
			System.out.print(c.getStudName()[i]+" ");
		}
		System.out.println();
	}

	//for registering a student, first and last name taken from the admin
	public Student register(String f, String l) {
		Student student = new Student(f, l);
		return student;
	}
	
	//for displaying all courses
	@Override
	public void reportall(ArrayList<Course> courses) {
		for (int a = 0; a < courses.size(); a++) {
			String id = courses.get(a).getID();
			String scn = courses.get(a).getSecN();
			System.out.print((int)(a+1)+". ");
			display(id, scn, courses);
		}
	}
	
	//for displaying only full course(s)
	public void reportfull(ArrayList<Course> courses) {
		for (int a = 0; a < courses.size(); a++) {
			if (courses.get(a).getmaxN() == courses.get(a).getCurStudN()) {
				String id = courses.get(a).getID();
				String scn = courses.get(a).getSecN();
				System.out.print((int)(a+1)+". ");
				display(id, scn, courses);
			} else {
				continue;
			}
		}
	}
	
	//for writing full course(s) into a .txt file
	public void writefull(ArrayList<Course> courses) {
		String fileName = "FullCourses.txt";
		String full = "";
		for (Course c: courses) {
			if (c.getmaxN() == c.getCurStudN()) {
				full += c.getCName()+"\n";
			} else {
				continue;
			}
		}
		Scanner scan = new Scanner(full);
		
		try{
			FileWriter fileWriter = new FileWriter(fileName);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			String text = scan.nextLine();
			bufferedWriter.write(text);

			//bufferedWriter.write(".write or .append will also write to the file");
			bufferedWriter.newLine();

			
			//Always close writer
			bufferedWriter.close();
			scan.close();
		}

		//Always close files
		catch (IOException exk) {
			System.out.println( "Error writing file '" + fileName + "'");
			exk.printStackTrace();
		}
	}
	
	//for displaying student names in a given course
	public void reportnames(String id, String scn, ArrayList<Course> courses) {
		Course c = search(id,scn,courses);
		for(int i = 0; i < c.getStudName().length; i++) {
			System.out.print(c.getStudName()[i]+" ");
		}
		System.out.println();
	}
	
	//for displaying course(s) a given student registered on
	@Override
	public void reportrgcourse(String n, ArrayList<Course> courses) {
		String course = "";
		for (Course c: courses) {
			for (int i = 0; i < c.getStudName().length; i++) {
				if (n.equals(c.getStudName()[i])) {
					course += c.getCName() + " ";
				}
			}
		}
		System.out.println(course);
	}

}
