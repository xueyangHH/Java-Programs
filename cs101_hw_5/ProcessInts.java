/***************************************************

  Program name:        ProcessInts

  Class: CS101 sec. 005
  Name:  Xueyang Huang
  Date:  09/28
 
****************************************************/

import java.util.Scanner;

public class ProcessInts {

	public static void main(String[] args) {

		// declare initial values
		int sum_ints = 0;
		int max_input = Integer.MAX_VALUE;
		int min_input = Integer.MIN_VALUE;
		// create the sentinel value
		int Sentinel_value = 1001;
		// declare the user input variable
		int user_input;

		// do...while loop with sentinel variable controlled
		do {
			// ask the user for integer input
			Scanner input = new Scanner(System.in);
			System.out.print("Enter an integer between 1 and 1000, inclusive: ");
			user_input = input.nextInt();
			// exampine the input with the range [1-1000]
			if (user_input < 1 || user_input > 1000) {
				if (user_input == Sentinel_value) {
					continue;
				}
				else {
					System.out.print("\nError: Input is out of range. Please try again - ");
					continue;
				}
			}
			else {
				// add up the numbers
				sum_ints += user_input;
				// assigning max value
				if (max_input == Integer.MAX_VALUE || user_input >= max_input) {
					max_input = user_input;
				}
				// assigning min value
				if (min_input == Integer.MIN_VALUE || user_input <= min_input) {
					min_input = user_input;
				}
			}
		} while (user_input != Sentinel_value);

		// print out the output
		System.out.println("\nSentinel entered, exiting.\n");
		System.out.println("Sum: " + sum_ints + ".");
		System.out.println("The largest value is: " + max_input + ".");
		System.out.println("The smallest value is: " + min_input + ".");

		// determine odd/even
		if (sum_ints % 2 == 0) {
			System.out.println("Sum is even.");
		}
		else {
			System.out.println("Sum is odd.");
		}
	}
}