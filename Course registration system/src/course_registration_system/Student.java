package course_registration_system;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Student extends User implements StudentItf, java.io.Serializable {
	private String username;
	private String password;
	private String fname = null;
	private String lname = null;
	//constructor that uses the super keyword
	public Student() {
		super();
	}
	
	//constructor that takes first and last names as parameters
	public Student(String f, String l) {
		fname = f;
		lname = l;
	}
	
	//getting student's username
	@Override
	public String getUserN() {
		return username;
	}
	
	//getting student's password
	@Override
	public String getPassW() {
		return password;
	}
	
	//getting student's first name
	@Override
	public String getFirst() {
		return fname;
	}
	
	//getting student's last name
	@Override
	public String getLast() {
		return lname;
	}
	
	//setting student's first name
	@Override
	public void setFirst(String f) {
		fname = f;
	}
	
	//setting student's last name
	@Override
	public void setLast(String l) {
		lname = l;
	}

	//setting student's username
	@Override
	public void setUserN(String u) {
		username = u;
	}

	//setting student's password
	@Override
	public void setPassW(String p) {
		password = p;
	}
	
	//verify if the student have been registered by taking names as parameters
	@Override
	public boolean veriName(String f, String l) {
		if (fname.equals(f) && lname.equals(l)) 
			return true;
		else
			return false;
	}
	
	//taking the username and password as parameters and verify the login info
	@Override
	public boolean veriLoginfo(String u, String p) {
		if (username.equals(u) && password.equals(p)) 
			return true;
		else
			return false;
	}
	
	//for searching a student in an ArrayList of student objects
	public Student search(String f, String l, ArrayList<Student> students){
		boolean exist = false;
		int retnum = 0;
		for (int x = 0; x < students.size(); x++) {
			if (f.equals(students.get(x).getFirst())) {
				if (l.equals(students.get(x).getLast())) {
					exist = true;
					retnum = x;
				}
				else continue;
			}
			else
				continue;
		}
		if (exist == true) {
			return students.get(retnum);
		} else {
			System.out.println("You have not been registered by the admin!");
			System.out.println();
			return null;
		}
	}
	
	//serializing the ArrayList of student objects
	public void serialization(ArrayList<Student> students) {
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("AllStudents.ser");
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//Writes the specific object to the OOS
			oos.writeObject(students);
			
			oos.close();
			fos.close();
			System.out.println("Serialization complete");
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	//deserializing the .ser file and read it into an ArrayList of student objects
	@SuppressWarnings("unchecked")
	public ArrayList<Student> deserialize() {
		ArrayList<Student> de = new ArrayList<Student>();
		try{
			  //FileInputSystem receives bytes from a file
		      FileInputStream fis = new FileInputStream("AllStudents.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      
		      //Cast as Employee. readObject will take the object from ObjectInputStream
		      de = (ArrayList<Student>)ois.readObject();
		      ois.close();
		      fis.close();
		    }
		    catch(IOException ioe) {
		       ioe.printStackTrace();
		       return null;
		    }
		 catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		       return null;
		     }
		return de;
	}
	
	//for displaying all courses
	@Override
	public void reportall(ArrayList<Course> courses) {
		Admin ad = new Admin();
		for (int a = 0; a < courses.size(); a++) {
			String id = courses.get(a).getID();
			String scn = courses.get(a).getSecN();
			System.out.print((int)(a+1)+". ");
			ad.display(id, scn, courses);
		}
	}

	//for displaying not full courses
	public void reportNofull(ArrayList<Course> courses) {
		Admin ad = new Admin();
		for (int a = 0; a < courses.size(); a++) {
			if (courses.get(a).getmaxN() != courses.get(a).getCurStudN()) {
				String id = courses.get(a).getID();
				String scn = courses.get(a).getSecN();
				System.out.print((int)(a+1)+". ");
				ad.display(id, scn, courses);
			} else {
				continue;
			}
		}
	}
	
	//for registering the student into a course
	public void register(String id, String scn, String n, ArrayList<Course> courses) {
		boolean exist = false;
		boolean regis = false;
		for (Course c: courses) {
			if (id.equals(c.getID())) {
				if (scn.equals(c.getSecN())) {
					exist = true;
					for (int i = 0; i < c.getStudName().length; i++) {
						if (n.equals(c.getStudName()[i])) {
							regis = true;
							System.out.println("You have already registered!");
							System.out.println();
							break;
						} else {
							continue;
						}
					}
					if (regis == false) {
						String[] studname = c.getStudName();
						studname[studname.length+1] = n;
						c.setStudName(studname);
						c.setCurStudN(c.getCurStudN()+1);
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
	
	//for withdrawing the student from a course
	public void withdraw(String id, String scn, String n, ArrayList<Course> courses) {
		boolean exist = false;
		boolean regis = false;
		for (Course c: courses) {
			if (id.equals(c.getID())) {
				if (scn.equals(c.getSecN())) {
					exist = true;
					for (int i = 0; i < c.getStudName().length; i++) {
						if (n.equals(c.getStudName()[i])) {
							regis = true;
							String[] studname = new String[c.getStudName().length-1];
							for (int a = 0, b = 0; a < c.getStudName().length; a++) {
								if (n.equals(c.getStudName()[a])) {
									continue;
								} else {
									studname[b++] = c.getStudName()[a];
								}
							}
							c.setStudName(studname);
							c.setCurStudN(c.getCurStudN()-1);
							break;
						} else {
							continue;
						}
					}
					if (regis == false) {
						System.out.println("You haven't registered for this course!");
						System.out.println();
						break;
					} else {
						break;
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
	
	//for displaying course(s) the student registered on
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
