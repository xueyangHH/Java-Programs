
public class insertionSort {

	public static void sort(int[] a) {
		// initiate a variable that store the index at which the element should be inserted
		int k = 0;
		// looping through the array
		for (int i = 1; i < a.length; i++) {
			// create another integer variable to store the value
			int t = a[i];
			// looping backward from the element i to the beginning
			for (int j = i - 1; j >= 0; j--) { 
				// whenever the element j is greater than element i, move it rightward
				if (a[j] >= t) { 
					a[j+1] = a[j]; 
					k = j;
				} else {
					k = ++j;
					break; 
				}
			}
			// insert element i
			a[k] = t;
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
