/***************************************************

  Program name:        PiLooping
  Program description: Use a loop to approximate Pi.

  Class: CS101 sec. 005
  Name:  Xueyang Huang
  Date:  09/23
 
****************************************************/

public class PiLooping {

  public static void main(String[] args) {
		
    // Declare and initialize piAppx
    double piAppx = 1.0 - 1.0 / 3 + 1.0 / 5;
		
    // What is the max value for i
    // Use 407 in the first run, then use 100000000
    int MAX_I_VALUE = 100000000;
        
    for (int i = 7; i <= MAX_I_VALUE; i = i + 4) {
      piAppx =  piAppx - 1.0 / i + 1.0 / (i + 2);
    }
		
    double finalPi = 4.0 * piAppx;

    // Output the approximation you computed for Pi
    System.out.println("Pi approximation =\t" + finalPi);
		
    // Output the Math library value of Pi
    System.out.println("Math.PI =\t\t" + Math.PI);
		
    // Output the difference between Math.PI and the approximation 
    // for Pi that you computed
    System.out.println("Math.PI - piAppx =\t" + (Math.PI - finalPi));
  }
}
