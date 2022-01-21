import java.util.*;

public class Exercise1Alg2 {
	// a randomized quicksort
	
	public static void random(int[]a, int start, int end) {
		Random r = new Random();
		// randomly select one number from the array
		int pivot = r.nextInt(end-start) + start;
		int t = a[pivot];
		// place the random pivot on the left tend
		a[pivot] = a[start];
		a[start] = t;
	}
	
	public static void sort(int[] a, int start, int end) {
		// base case when the substring length equals 1; ignore it
		if (start >= end) {
			return;
		} else {
			// partitioning the array and indicate the pivot index
			int pi_ind = partition(a, start, end);
			// call the recursive quicksort method and split it by the pivot
			sort(a, start, pi_ind - 1);
			sort(a, pi_ind + 1, end);
		}
	}
	
	public static int partition(int[] a, int start, int end) {
		// create the pivot; it is set to be the left-most element in the (sub)array
		random(a,start,end);
		int pivot = a[start];
		// store the smaller element index which should be on the left side of the array
		int left = start;
		// loop through the array from the element right to the pivot to the end
		for (int right = start + 1; right < end + 1; right++) {
			if (a[right] < pivot) {
				left++;
				// use a temporary variable to store the smaller element on the right
				// swap the smaller element with the leftmost variable next to the pivot
				int t = a[right];
				a[right] = a[left];
				a[left] = t;
			}
		}
		// swap the pivot with the largest element among the smallest ones on the left
		// so that the pivot would be relatively in the middle
		int t = a[left];
		a[left] = a[start];
		a[start] = t;
		// return the current index of the pivot
		return left;
	}
	
	public static void main(String[] args) {
		int[] a = {7,75,102,45,24,53,75,31,49,2};
		sort(a, 0, a.length - 1); 
		System.out.println("/////Below is the output/////");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ " ");
		} 
	}

}
