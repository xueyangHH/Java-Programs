package course_registration_system;

import java.util.Comparator;

public class StudNumSorter implements Comparator<Course> {

	@Override
	public int compare(Course o1, Course o2) {
		Integer Num1 = o1.getCurStudN();
		Integer Num2 = o2.getCurStudN();
		return  Num1.compareTo(Num2);
	}
}
