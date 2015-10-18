package sort.advanced;

import java.util.Arrays;


public class MyRadixSort {

	public static void main(String[] args) {
		int[] arr = {40, 12, 45, 32, 33, 1, 22};//, 18, 34, 65, 26, 83};
		 sort(arr);
	}
	
	public static void sort( int arr[])
    {
		int n = arr.length;
		int[] output = new int[n];
		int[] count = new int[n];
		
		int j, m = arr[0], exp = 1 ;
		for (j = 1; j < n; j++)
            if (arr[j] > m)
                m = arr[j];
       for (exp = 1; exp < 8; exp=exp*n){
		
		int i;
		for (i = 0; i < n; i++)
			count[i] = 0;

		for (i = 0; i < n; i++)
			count[(arr[i] / exp) % n]++;
		for (i = 1; i < n; i++)
			count[i] += count[i - 1];
		for (i = n - 1; i >= 0; i--) {
			output[count[(arr[i] / exp) % n] - 1] = arr[i];
			count[(arr[i] / exp) % n]--;
		}

		for (i = 0; i < n; i++)
			arr[i] = output[i];
		
		
    }
    }    
	

}
