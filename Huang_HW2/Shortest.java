public class Shortest {

	public static String find(String s) {
		// splitting the array by the white spaces
		String[] arrays = s.split(" ");
		// create a string to store the shortest strings
		String shortest = "";
		// cut the string off into chunks of three substrings
		for (int i = 0; i < arrays.length; i += 3) {
			int minleng = Integer.MAX_VALUE;
			// store the three substrings in an array
			String[] temp = new String[3];
			temp[0] = arrays[i];
			temp[1] = arrays[i+1];
			temp[2] = arrays[i+2];
			// create a string the store the shortest one in those three
			String shortstr = "";
			for (int j = 0; j < 3; j++) {
				// compare the length of the three arrays and store the shortest
				if (temp[j].length() <= minleng) {
					minleng = temp[j].length();
					shortstr = temp[j];
				}
			}
			// add the shortest string into the super string
			shortest += shortstr + " ";
		}
		return shortest;
	}
	
	public static void main(String[] args) {
		String s = "Other entries include a historic district in Charlottesville Virginia cut-flower greenhouse complex";
		System.out.println(find(s));
	}

}
