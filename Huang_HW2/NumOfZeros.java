public class NumOfZeros {

	public static int count(int a, int z) {
		// calculate the quotient of a/2
		int quo = a/2;
		// whenever the remainder of a divided by 2 is 0, that means there is another 
		// zero in the binary rpt of a
		if (a%2 == 0) {
			++z;
		}
		// divided the number (quotient) again until the quotient is 0
		if (quo != 0) {
			z = count(quo, z);
		} else {
			return z;
		}
		return z;
	}
	
	public static void main(String[] args) {
		System.out.println(count(256,0));
	}

}
