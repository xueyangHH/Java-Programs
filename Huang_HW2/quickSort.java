
public class quickSort {

	public static void sort(int[] a, int start, int end) {
		// base case when the substring length equals 1; ignore it
		if (start >= end) {
			return;
		} else {
			// partitioning the array and indicate the pivot index
			System.out.println("The start and end indices are " + start + " " + end);
			int pi_ind = partition(a, start, end);
			System.out.println("The index of the pivot is " + pi_ind);
			// call the recursive quicksort method and split it by the pivot
			System.out.println("The start and end indices of the left array are " + start + " " + (pi_ind-1));
			sort(a, start, pi_ind - 1);
			System.out.println("The start and end indices of the right array are " + (pi_ind+1) + " " + end);
			sort(a, pi_ind + 1, end);
		}
	}
	
	public static int partition(int[] a, int start, int end) {
		// create the pivot; it is set to be the left-most element in the (sub)array
		int pivot = a[start];
		System.out.println("The pivot selected is " + pivot);
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
				System.out.println("Swapping " + t + " and " + a[right]);
			}
		}
		// swap the pivot with the largest element among the smaller ones on the left
		// so that the pivot would be relatively in the middle
		int t = a[left];
		a[left] = a[start];
		a[start] = t;
		System.out.println("Swapping " + t + " and the pivot " + a[left]);
		// return the current index of the pivot
		return left;
	}
	
	public static void main(String[] args) {
		int[] a = {4,77,98,30,20,50,77,22,49,2};
		sort(a, 0, a.length - 1); 
		System.out.println("\n/////Below is the output/////\n");
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		} 
	}

}
