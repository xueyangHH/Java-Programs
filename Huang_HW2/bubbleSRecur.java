
public class bubbleSRecur {

	public static void sort(int[] a, int start, int end) {
		// base case; ignore it
		if (end == start) {
			return;
		} 
		// call the recursive swap method
		recswap(a, start, end);
		// call the recursive bubble swap method
		sort(a, start, end - 1);
	}
	public static void recswap(int[]a, int s, int e) {
		// base case; ignore it
		if (s == e) {
			return;
		}
		// swap the elements next to each other if not in ascending order
		if (a[s] > a[s+1]) {
			int t = a[s+1];
			a[s+1] = a[s];
			a[s] =  t;
		}
		// call the recursive swap method
		recswap(a, s + 1, e);
	}
	public static void main(String[] args) {
		int[] a = {4,77,98,30,20,50,77,22,49,2};
		sort(a, 0, a.length - 1);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}

}
