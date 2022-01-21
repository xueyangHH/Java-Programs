public class Course {
	private String courseName;
	private Professor professor;
	private Student[] students;
	private int numberOfStudents;

	public Course(String name, Professor prof) {
		courseName = name;
		professor = prof;
		students = new Student[60];
		numberOfStudents = 0;
	}

	public void add(Student student) {
		students[numberOfStudents] = student;
		++numberOfStudents;
	}
	public void remove(Student student) {
		Student[] newStudents = new Student[60];
		for (int i = 0; i < students.length; i++) {
			if (students[i] == student) {
				--numberOfStudents;
				continue;
			}
			else {
				newStudents[i] = students[i];
			}
		}
		students = newStudents;
	}
}

class Student {
	private String name;
	private String netID;

	public Student(String name, String netID) {
		this.name = name;
		this.netID = netID;
	}
}

class Professor {
	private String name;

	public Professor(String name) {
		this.name = name;
	}
}