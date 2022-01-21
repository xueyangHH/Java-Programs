
public class BinaryMax {

	public static int max(int[] a, int start, int end) {
		// the base case when the length of array is 1
		if (end == start) {
			// return the only element
			return a[start];
		}
		// calculate the middle index
		int mid = (start+end)/2;
		// call recursive methods (splitting the array into two halves)
		int max1 = max(a, start, mid);
		int max2 = max(a, mid+1, end);
		// compare which number is the bigger one and return the bigger one
		if (max1 >= max2)
			return max1;
		else
			return max2;
	}
	
	public static void main(String[] args) {
		int[] a = {3,6,1,34,7,2,8,14,32,56};
		System.out.println(max(a, 0, a.length-1));
	}
}
