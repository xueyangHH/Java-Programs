
public class bubblesort {
	
	public static void sort(int[] a) {
		// looping from the first element to the penultimate element
		for (int i = 0; i < a.length-1; i++) {
			// looping from the first element to wherever the element i is
			for (int j = 0; j < a.length-i-1;j++) {
				// compare the element j and the next element
				// swap them if they are not in ascending order
				if (a[j] > a[j+1]) {
					int t = a[j+1];
					a[j+1] = a[j];
					a[j] =  t;
				}
			}
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
