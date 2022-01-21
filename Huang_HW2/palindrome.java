
public class palindrome {

	public static int check(String s, int start, int end) {
		// 0 meaning not palindrom; 1 meaning true palindrome
		// because the palindrome always has an odd length
		// strings with even length are eliminated
		if (s.length()%2 == 0) {
			return 0;
		}
		// base case; if the base case is reached, meaning the string must be a palindrome
		if (end == start) {
			return 1;
		}
		// comparing the string at the beginning with that at the end
		if (s.charAt(start) == s.charAt(end)) {
			// split the string by its first element and call the recursive method
			check(s, start+1, end -1);
		} else {
			return 0;
		}
		return 1;
	}
	
	// get rid of all the white spaces and punctuations in the string
	public static String replace(String s) {
		s = s.toLowerCase();
		String temps = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				continue;
			} else if (s.charAt(i) < 'a' || s.charAt(i) > 'z') {
				continue;
			} else {
				temps += s.charAt(i);
			}
		}
		return temps;
	}
	
	public static void main(String[] args) {
		String s = "D  a321###d---+=/";
		s = replace(s);
		if (check(s, 0, s.length()-1) == 1)
			System.out.println("yes");
		else
			System.out.println("no");
	}

}
