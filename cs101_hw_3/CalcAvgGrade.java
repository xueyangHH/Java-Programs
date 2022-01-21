/* CS101 HW2 FA19 - Calculate Average Grade
	Name: Xueyang Huang
	Date: 09/19
*/

import java.util.Scanner;

public class CalcAvgGrade {
	public static void main(String[] args) {
	// Create a Scanner object
	Scanner input = new Scanner(System.in);
	// Print out the prompt
	System.out.print("Please enter grade 1: ");
	// Declare the grade variable
	int g1 = input.nextInt();

	// Print out the prompt
	System.out.print("Please enter grade 2: ");
	// Declare the grade variable
	int g2 = input.nextInt();

	// Print out the prompt
	System.out.print("Please enter grade 3: ");
	// Declare the grade variable
	int g3 = input.nextInt();

	// Declare the average and perform the calculation
	double avg = (double) (g1 + g2 + g3) / 3;
	// Print out the result
	System.out.println("The average of " + g1 + ", " + g2 + ", and " + g3 + " is: " + avg + ".");
	}
}