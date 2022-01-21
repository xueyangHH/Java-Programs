public class CheckReverse {

	public static int check(String a, String b) {
		// turn two strings into lower case
		a = a.toLowerCase();
		b = b.toLowerCase();
		// create two empty strings to hold the original strings
		String tempa = "";
		String tempb = "";
		// get rid of white spaces
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) == ' ') {
				continue;
			} else {
				tempa += a.charAt(i);
			}
		}
		for (int i = 0; i < b.length(); i++) {
			if (b.charAt(i) == ' ') {
				continue;
			} else {
				tempb += b.charAt(i);
			}
		}
		// create two arrays to store all the characters
		char[] arra = new char[tempa.length()];
		char[] arrb = new char[tempb.length()];
		for (int i = 0; i < tempa.length(); i++) {
			arra[i] = tempa.charAt(i);
		}
		for (int i = 0; i < tempb.length(); i++) {
			arrb[i] = tempb.charAt(i);
		}
		boolean equal = true;
		// compare the characters inside each array to see if they are reversed
		if (arra.length == arrb.length) {
			for (int i = 0; i < arra.length; i++) {
				if (Character.compare(arra[i],arrb[arrb.length-1-i]) == 0) {
					continue;
				} else {
					equal = false;
					break;
				}
			}
			if (equal == true) {
				return 1;
			} else {
				return 0;
			}
		} else {
			return 0;
		}
	}
	public static void main(String[] args) {
		String s1 = "Goo gle";
		String s2 = "el Goog";
		System.out.println(check(s1, s2));
	}

}
