/* CS101 HW2 FA19 - Pi Calculations
	Name: Xueyang Huang
	Date: 09/12
*/

public class Pi {
	public static void main(String[] args) {
		// Declare two double variables
		double piAppx1, piAppx2 = 0.0;
		// Assign values to the two double variables with calculation expressions
		piAppx1 = 4 * (1 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11);
		piAppx2 = 4 * (1 - 1.0/3 + 1.0/5 - 1.0/7 + 1.0/9 - 1.0/11 + 1.0/13);
		// Print out the approximate Pi values
		System.out.println("\n Pi approx 1: 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11) = " + piAppx1);
		System.out.println("\n Pi approx 2: 4 * (1 - 1/3 + 1/5 - 1/7 + 1/9 - 1/11 + 1/13) = " + piAppx2);
	}
}