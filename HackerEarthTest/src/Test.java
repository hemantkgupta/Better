import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		System.out.println(test());
	}
	
	public static int test(){
		int [] arr = {-6, 4, 2, 8};
		Arrays.sort(arr);
	      if (arr.length <= 3){
	        return -1;
	      }
	      if (arr.length == 4){
	    	  if (arr[1] == arr[0]+arr[2]+arr[3]){
	    		  return arr[1];
	    	  }else if (arr[2] == arr[0]+arr[1]+arr[3]){
	    		  return arr[2];	    		  
	    	  }else if (arr[3] == arr[0]+arr[1]+arr[2]){
	    		  return arr[3];	   
	    	  }
	      }
	        for (int i = arr.length-1; i > 2 ; i--) {
	          if (findNumbers(arr,arr[i])){
	            return arr[i];
	          }
	        }
	       return -1;
		
	}

	public static boolean findNumbers(int arr[], int sum) {
		int l, r;
		  boolean isFound = false;
	      int len = arr.length;
	      for (int i = 0; i < len - 2; i++) {
	        l = i + 1;
	        r= len -1;
	        while (l < r) {
					if (arr[i] + arr[l] + arr[r] == sum) {
	                  isFound = true;
						break;
	                }   else if (arr[i] + arr[l] + arr[r] < sum)
						l++;
					else
						r--;
				}
	       
	    }
	    return isFound;
	}

}