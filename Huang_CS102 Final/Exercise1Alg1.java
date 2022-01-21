public class Exercise1Alg1 {
	// mergesort
	
	public static void merge(int[] a, int start, int mid, int end)
    {
		// store the length of the two halves of the array
        int l1 = mid - start + 1;
        int l2 = end - mid;
        // create two subarrays with the lengths above
        int fir[] = new int[l1];
        int sec[] = new int[l2];
        // copy the values into the subarrays
        for (int i = 0; i < l1; ++i) {
            fir[i] = a[start + i]; 
        }
        for (int j = 0; j < l2; ++j) {
            sec[j] = a[mid + 1 + j]; 
        }
        int i = 0;
        int j = 0;
        // loop through the array
        for (int s = start; s < a.length; s++) {
        	// whenever the subarrays are not went through
        	if (i < l1 && j < l2) {
        		// if the element in the first array is smaller than that in the second one
        		if (fir[i] <= sec[j]) {
        			// put the ele in the first array into the main array
                    a[s] = fir[i];
                    i++;
                // if element in the second array is larger than that in the first one
                } else {
                	// put the ele in the second array into the main array
                    a[s] = sec[j];
                    j++;
                }
        	// when the elements in the first arrays is not copied through, copy rest of them
        	} else if (i < l1) {
        		a[s] = fir[i];
        		i++;
            // when the elements in the second arrays is not copied through, copy rest of them
        	} else if (j < l2) {
        		a[s] = sec[j];
        		j++;
        	}
        }
    }
 
    public static void sort(int[] a, int start, int end)
    {
    	if (start == end) {
    		return;
    	} else {
    		// calculate the middle element
            int mid = start + (end - start)/2;
            // call the recursive merge sort method and split it in half
            sort(a, start, mid);
            sort(a, mid + 1, end);
            // merge the two halves together by calling the recursive merge method
            merge(a, start, mid, end);
        }
    }
    public static void main(String[] args) {
    	int[] a = {7,75,102,45,24,53,75,31,49,2};
		sort(a,0,a.length-1); 
		System.out.println("/////Below is the output/////");
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+ " ");
		} 
	}

}
