
public class selectionSort {

	public static void sort(int[] a) {
		// create variables to store the smallest integer
		int min;
		// initialize the index of the smallest integer as -100
		int minind = -100;
		for (int i = 0; i < a.length; i++) {
			min = Integer.MAX_VALUE;
			// looping through the subarray from element i to the end
			for (int j = i; j < a.length; j++) {
				// compare the current element with the smallest element and store
				if (a[j] <= min) {
					minind = j;
					min = a[j];
				}
			}
			// swap the smallest with whatever the current element is
			int t = a[i];
			a[i] = a[minind];
			a[minind] = t;
		}
	}
	
	public static void main(String[] args) {
		int[] a = {4,77,98,30,20,50,77,22,49,2};
		sort(a); 
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		} 
	}

}
