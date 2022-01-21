package course_registration_system;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.ObjectInputStream;

@SuppressWarnings("serial")
public class Course extends ArrayList<Course> implements java.io.Serializable {
	private String courseName;
	private String courseID;
	private int maxStudN;
	private int currentStudN;
	private String[] studNames;
	private String instructor;
	private String secNum;
	private String location;
	public Course() {}
	public Course(String cn, String id, int m, int csn, String[] sn, String i, String snum, String l) {
	//a constructor which takes the parameters read from the csv file and obtain the data into this data field
		courseName = cn;
		courseID = id;
		maxStudN = m;
		currentStudN  = csn;
		studNames = sn;
		instructor = i;
		secNum = snum;
		location = l;
	}
	
	public void setCName(String cn) {
		courseName = cn;
	}
	public void setID(String id) {
		courseID = id;
	}
	public void setmaxN(int m) {
		maxStudN = m;
	}
	public void setCurStudN(int csn) {
		currentStudN  = csn;
	}
	public void setStudName(String[] sn) {
		studNames = sn;
	}
	public void setInstr(String i) {
		instructor = i;
	}
	public void setSecN(String snum) {
		secNum = snum;
	}
	public void setLoc(String l) {
		location = l;
	}  	
	public String getCName() {
		return courseName;
	}
	public String getID() {
		return courseID;
	}
	public int getmaxN() {
		return maxStudN;
	}
	public int getCurStudN() {
		return currentStudN;
	}
	public String[] getStudName() {
		return studNames;
	}
	public String getInstr() {
		return instructor;
	}
	public String getSecN() {
		return secNum;
	}
	public String getLoc() {
		return location;
	}
	
	//reading from the MyUniversityCourses.csv file into an ArrayList of courses
	public ArrayList<Course> csvreader() throws IOException, FileNotFoundException {
		ArrayList<Course> se = new ArrayList<Course>();
		BufferedReader reader = new BufferedReader(new FileReader("MyUniversityCourses.csv"));
        
		String line = null;
		Scanner scanner = null;
         
        //Get all tokens and store them in some data structure
        int index = 0;
        while ((line = reader.readLine()) != null) 
        {
        	if (line.split(",")[0].equals("Course_Name")) {
        		continue; }
        	else {
	        	Course course = new Course();
	        	scanner = new Scanner(line);
	        	//Set the delimiter used in file
	        	scanner.useDelimiter(",");
	        	while (scanner.hasNext()) {
	        		String data = scanner.next();
	        		if (index == 0) 
	        			course.setCName(data);
	        		else if (index == 1)
	        			course.setID(data);
	        		else if (index == 2)
	        			course.setmaxN(Integer.parseInt(data));
	        		else if (index == 3)
	        			course.setCurStudN(Integer.parseInt(data));
	        		else if (index == 4)
	        			if (data != null) {
	        				String[] newData = data.split(",");
	        				course.setStudName(newData);
	        				}
	        			else {
	        				course.setStudName(null);
	        			}
	        		else if (index == 5)
	        			course.setInstr(data);
	        		else if (index == 6)
	        			course.setSecN(data);
	        		else if (index == 7) 
	        			course.setLoc(data);
	        		else
	        			System.out.println("Invalid data" + data);
	        		index++;
	        	}
	        	index = 0;
	        	se.add(course);
        	}
        }
        reader.close();
        return se;
    }
	
	//serializing the ArrayList of course objects
	public void serialization(ArrayList<Course> courses) {
		try {
			//FileOutput Stream writes data to a file
			FileOutputStream fos = new FileOutputStream("Courses.ser");
			//ObjectOutputStream writes objects to a stream (A sequence of data)
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			//Writes the specific object to the OOS
			oos.writeObject(courses);
			
			oos.close();
			fos.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	//deserializing the .ser file and read it into an ArrayList of course objects
	@SuppressWarnings("unchecked")
	public ArrayList<Course> deserialize() throws FileNotFoundException {
		ArrayList<Course> de = new ArrayList<Course>();
		try{
			  //FileInputSystem receives bytes from a file
		      FileInputStream fis = new FileInputStream("Courses.ser");
		      
		      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
		      ObjectInputStream ois = new ObjectInputStream(fis);
		      
		      //Cast as Employee. readObject will take the object from ObjectInputStream
		      de = (ArrayList<Course>)ois.readObject();
		      ois.close();
		      fis.close();
		      /*
		      for(int i=0;i<de.size();i++){
		            System.out.println(de.get(i).getCName());
		        }*/
		    }
		    catch(IOException ioe) {
		       ioe.printStackTrace();
		    }
		 catch(ClassNotFoundException cnfe) {
		       cnfe.printStackTrace();
		     }
		return de;
	}

	public static void main(String[] args) throws FileNotFoundException, IOException {
		ArrayList<Course> courses = new ArrayList<Course>();
		ArrayList<Student> students = new ArrayList<Student>();
		Course newcourse = new Course();
		Student student = new Student();
		boolean looping = true;
		while (looping) {
			boolean firsttime = false;
			Scanner firsttimeinp = new Scanner(System.in);
			System.out.println("Are you the first time log into the system? (\"y\" for yes and \"n\" for no) ");
			String firsttimeS = firsttimeinp.nextLine();
			if (firsttimeS.equals("y")) {
				courses = newcourse.csvreader();
			} else if (firsttimeS.equals("n")) {
				courses = newcourse.deserialize();
				students = student.deserialize();
			} else {
				System.out.println("Please enter a valid input!");
				continue;
			}
			while (true) {
				Scanner firstinp = new Scanner(System.in);
				System.out.println("Please indicate if you are an Admin or a Student or to end this program: (\"A\" for Admin and \"S\" for Student and \"E\" for exiting) ");
				String firstinpS = firstinp.nextLine();
				if (firstinpS.equals("A")) {
					// the try catch block for verifying first-time login won't work
					// so I have to comment it out
					/*try {
						courses = newcourse.deserialize();
					} catch(FileNotFoundException fe) {
						firsttime = true;
						System.out.println("Welcome to the system for the first time!");
						courses = newcourse.csvreader();
					} */
					Admin admin = new Admin();
					boolean login = false;
					do {
						Scanner uninput = new Scanner(System.in);
						System.out.println("Please enter your username: ");
						String uninputS = uninput.nextLine();
						Scanner pwinput = new Scanner(System.in);
						System.out.println("Please enter your password: ");
						String pwinputS = pwinput.nextLine();
						login = admin.veriLoginfo(uninputS, pwinputS);
						if (login == false) {
							System.out.println("Username or Password incorrect!");
						}
					} while (login == false);
					System.out.println("Login successfully!");
					boolean adexit = false;
					while (adexit == false) {
						Scanner menu1input = new Scanner(System.in);
						System.out.println("Course Management(C) or Report(R) or Exit(E)? ");
						String menu1inputS = menu1input.nextLine();
						if (menu1inputS.equals("C")) {
							while (true) {
								Scanner menu2input = new Scanner(System.in);
								System.out.println("Enter 1-6 for the following functions:\n"
										+ "1. Create a course\n"
										+ "2. Delete a course\n"
										+ "3. Edit a course\n"
										+ "4. Display information of a course\n"
										+ "5. Register a student\n"
										+ "6. Exit ");
								String menu2inputS = menu2input.nextLine();
								if (menu2inputS.equals("1")) {
									Scanner cn = new Scanner(System.in);
									System.out.println("Enter course name: ");
									String cnS = cn.nextLine();
									
									Scanner id = new Scanner(System.in);
									System.out.println("Enter course ID: ");
									String idS = id.nextLine();
									
									Scanner m = new Scanner(System.in);
									System.out.println("Enter maximum student number: ");
									int mI = m.nextInt();
									
									Scanner csn = new Scanner(System.in);
									System.out.println("Enter current student number (max 1): ");
									int csnI = csn.nextInt();
									
									Scanner sn = new Scanner(System.in);
									System.out.println("Enter the student name (only one student at this point): ");
									String snS = sn.nextLine();
									String[] snA = new String[1];
									snA[0] = snS;
									
									Scanner i = new Scanner(System.in);
									System.out.println("Enter course instructor: ");
									String iS = i.nextLine();
									
									Scanner snum = new Scanner(System.in);
									System.out.println("Enter course section number: ");
									String snumS = snum.nextLine();
									
									Scanner l = new Scanner(System.in);
									System.out.println("Enter course location: ");
									String lS = l.nextLine();
									
									admin.create(cnS, idS, mI, csnI, snA, iS, snumS,lS, courses);
								} else if (menu2inputS.equals("2")) {
									Scanner id = new Scanner(System.in);
									System.out.println("Enter course ID to delete: ");
									String idS = id.nextLine();
									
									Scanner snum = new Scanner(System.in);
									System.out.println("Enter course section number to delete: ");
									String snumS = snum.nextLine();
									
									admin.delete(idS, snumS, courses);
								} else if (menu2inputS.equals("3")) {
									Scanner id = new Scanner(System.in);
									System.out.println("Enter course ID to edit: ");
									String idS = id.nextLine();
									
									Scanner snum = new Scanner(System.in);
									System.out.println("Enter course section number to edit: ");
									String snumS = snum.nextLine();
									
									Scanner s = new Scanner(System.in);
									System.out.println("Enter which part to edit: "
											+ "\"max num\" for editing maximum student number "
											+ "\"current num\" for editing current student number "
											+ "\"student names\" for editing the student names "
											+ "\"instructor\" for editing the course instructor "
											+ "\"location\" for editing the course location ");
									String sS = s.nextLine();
									
									Scanner i = new Scanner(System.in);
									System.out.println("Enter the content to edit: ");
									String iS = i.nextLine();
									
									admin.edit(idS, snumS, sS, iS, courses);
								} else if (menu2inputS.equals("4")) {
									Scanner id = new Scanner(System.in);
									System.out.println("Enter course ID to display: ");
									String idS = id.nextLine();
									
									Scanner snum = new Scanner(System.in);
									System.out.println("Enter course section number to display: ");
									String snumS = snum.nextLine();
									
									admin.display(idS, snumS, courses);
								} else if (menu2inputS.equals("5")) {
									Scanner fn = new Scanner(System.in);
									System.out.println("Enter student's first name: ");
									String fnS = fn.nextLine();
									
									Scanner ln = new Scanner(System.in);
									System.out.println("Enter student's last name: ");
									String lnS = ln.nextLine();
									
									Student newstud = admin.register(fnS, lnS);
									students.add(newstud);
								} else if (menu2inputS.equals("6")) {
									newcourse.serialization(courses);
									break;
								} else {
									System.out.println("Please enter a valid input!");
									continue;
								}
							}
						} else if (menu1inputS.equals("R")) {
							while (true) {
								Scanner menu2input = new Scanner(System.in);
								System.out.println("Enter 1-7 for the following functions:\n"
										+ "1. Report all courses\n"
										+ "2. Report full courses\n"
										+ "3. Write full courses into txt file\n"
										+ "4. Display list of students names of a course\n"
										+ "5. Courses that a given student is registered on\n"
										+ "6. Sort the courses by number of student registered\n"
										+ "7. Exit ");
								String menu2inputS = menu2input.nextLine();
								if (menu2inputS.equals("1")) {
									admin.reportall(courses);
								} else if (menu2inputS.equals("2")) {
									admin.reportfull(courses);
								} else if (menu2inputS.equals("3")) {
									admin.writefull(courses);
								} else if (menu2inputS.equals("4")) {
									Scanner id = new Scanner(System.in);
									System.out.println("Enter course ID to display: ");
									String idS = id.nextLine();
									
									Scanner snum = new Scanner(System.in);
									System.out.println("Enter course section number to display: ");
									String snumS = snum.nextLine();
									
									admin.reportnames(idS, snumS, courses);
								} else if (menu2inputS.equals("5")) {
									Scanner n = new Scanner(System.in);
									System.out.println("Enter student name to display(format: \"First Last\"): ");
									String nS = n.nextLine();
									
									admin.reportrgcourse(nS, courses);
								} else if (menu2inputS.equals("6")) {
									courses.sort(new StudNumSorter());
								} else if (menu2inputS.equals("7")) {
									break;
								} else {
									System.out.println("Please enter a valid input!");
									continue;
								}
							}
						} else if (menu1inputS.equals("E")) {
							adexit = true;
						} else {
							System.out.println("Please enter a valid input!");
							continue;
						}
					}
					
				} else if (firstinpS.equals("S")) {
					// this try catch block does not work either
					/*try {
						student.deserialize();
					} catch {
						System.out.println("You have not been registered by your Admin yet");
					} */
					boolean loginF = false;
					boolean loginS = false;
					while (loginS == false) {
						Scanner fninput = new Scanner(System.in);
						System.out.println("Please enter your first name: ");
						String fninputS = fninput.nextLine();
						Scanner lninput = new Scanner(System.in);
						System.out.println("Please enter your last name: ");
						String lninputS = lninput.nextLine();
						loginF = student.veriName(fninputS, lninputS);
						if (loginF == false) {
							System.out.println("You have not been registered by your Admin yet");
							break;
						} else {
							student = student.search(fninputS, lninputS, students);
							if (student.getUserN() == null) {
								System.out.println("You must register your account first.");
								Scanner uninput = new Scanner(System.in);
								System.out.println("Please enter your username: ");
								String uninputS = uninput.nextLine();
								Scanner pwinput = new Scanner(System.in);
								System.out.println("Please enter your password: ");
								String pwinputS = pwinput.nextLine();
								student.setUserN(uninputS);
								student.setPassW(pwinputS);
								break;
							} else {
								do {
									Scanner uninput = new Scanner(System.in);
									System.out.println("Please enter your username: ");
									String uninputS = uninput.nextLine();
									Scanner pwinput = new Scanner(System.in);
									System.out.println("Please enter your password: ");
									String pwinputS = pwinput.nextLine();
									loginS = student.veriLoginfo(uninputS, pwinputS);
									if (loginS == false) {
										System.out.println("Username or Password incorrect!");
									}
								} while (loginS == false);
								break;
							}
						}
					} 
					System.out.println("Login successfully!");
					boolean stexit = false;
					while (stexit == false) {
						Scanner menu2input = new Scanner(System.in);
						System.out.println("Enter 1-6 for the following functions:\n"
								+ "1. View all courses\n"
								+ "2. View NOT full course(s)\n"
								+ "3. Register a course\n"
								+ "4. Withdraw from a course\n"
								+ "5. View registered course(s)\n"
								+ "6. Exit ");
						String menu2inputS = menu2input.nextLine();
						if (menu2inputS.equals("1")) {
							student.reportall(courses);
						} else if (menu2inputS.equals("2")) {
							student.reportNofull(courses);
						} else if (menu2inputS.equals("3")) {
							Scanner id = new Scanner(System.in);
							System.out.println("Enter course ID: ");
							String idS = id.nextLine();
							
							Scanner snum = new Scanner(System.in);
							System.out.println("Enter course section number: ");
							String snumS = snum.nextLine();
	
							Scanner n = new Scanner(System.in);
							System.out.println("Enter your name to register(format: \"First Last\"): ");
							String nS = n.nextLine();
							
							student.register(idS, snumS, nS, courses);
						} else if (menu2inputS.equals("4")) {
							Scanner id = new Scanner(System.in);
							System.out.println("Enter course ID: ");
							String idS = id.nextLine();
							
							Scanner snum = new Scanner(System.in);
							System.out.println("Enter course section number: ");
							String snumS = snum.nextLine();
	
							Scanner n = new Scanner(System.in);
							System.out.println("Enter your name to register(format: \"First Last\"): ");
							String nS = n.nextLine();
							
							student.withdraw(idS, snumS, nS, courses);
						} else if (menu2inputS.equals("5")) {
							Scanner n = new Scanner(System.in);
							System.out.println("Enter your name to display(format: \"First Last\"): ");
							String nS = n.nextLine();
							
							student.reportrgcourse(nS, courses);
						} else if (menu2inputS.equals("6")) {
							stexit = true;
						} else {
							System.out.println("Please enter a valid input!");
							continue;
						}
					}
					student.serialization(students);
				} else if (firstinpS.equals("E")) {
					System.out.println("Program ending...");
					break;
				} else {
					System.out.println("Please enter a valid input!");
					continue;
				}
			}
		}
	}
	
}
