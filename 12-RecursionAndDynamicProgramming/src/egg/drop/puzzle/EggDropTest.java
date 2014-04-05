package egg.drop.puzzle;

public class EggDropTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//System.out.println(eggDropRec(2,3));
		System.out.println(eggDropDP(2,4));
	}
	
	/* Function to get minimum number of trails needed in worst
	  case with n eggs and k floors */
	public static int eggDropRec(int n, int k)
	{
	    // If there are no floors, then no trials needed. OR if there is
	    // one floor, one trial needed.
	    if (k == 1 || k == 0)
	        return k;
	 
	    // We need k trials for one egg and k floors
	    if (n == 1)
	        return k;
	 
	    int min = Integer.MAX_VALUE, x, res;
	 
	    // Consider all droppings from 1st floor to kth floor and
	    // return the minimum of these values plus 1.
	    for (x = 1; x <= k; x++)
	    {
	        res = Math.max(eggDropRec(n-1, x-1), eggDropRec(n, k-x));
	        if (res < min)
	            min = res;
	    }
	 
	    return min + 1;
	}
	
	/* Function to get minimum number of trails needed in worst
	  case with n eggs and k floors */
	public static int eggDropDP(int n, int k)
	{
	    /* A 2D table where entery eggFloor[i][j] will represent minimum
	       number of trials needed for i eggs and j floors. */
	    int[][]  eggFloor= new int [n+1][k+1];
	    int res;
	    int i, j, x;
	 
	    // We need one trial for one floor and0 trials for 0 floors
	    for (i = 1; i <= n; i++)
	    {
	        eggFloor[i][1] = 1;
	        eggFloor[i][0] = 0;
	    }
	 
	    // We always need j trials for one egg and j floors.
	    for (j = 1; j <= k; j++)
	        eggFloor[1][j] = j;
	 
	    // Fill rest of the entries in table using optimal substructure
	    // property
	    for (i = 2; i <= n; i++)
	    {
	        for (j = 2; j <= k; j++)
	        {
	            eggFloor[i][j] = Integer.MAX_VALUE; // For each value if i, initialize eggFloor[i][j] 
	            for (x = 1; x <= j; x++)
	            {	System.out.println("Before assignment: ");
	            	printMatrix(eggFloor);
	            	int temp1 = eggFloor[i-1][x-1];
	            	int temp2 = eggFloor[i][j-x];
	                res = 1 + Math.max(temp1, temp2);
	                System.out.println("i: "+i+" j: "+j+" x: "+x+" egg[i][j]: "+eggFloor[i][j]);
	                System.out.println("res is: "+res+" which is 1 + max of eggFloor[i-1][x-1]: "+temp1+" and eggFloor[i][j-x]: "+temp2);
	                
	                if (res < eggFloor[i][j])
	                    eggFloor[i][j] = res;
	            	System.out.println("After assignment: ");
	            	printMatrix(eggFloor);
	            }
	        }
	    }
	    //printMatrix(eggFloor);
	    // eggFloor[n][k] holds the result
	    return eggFloor[n][k];
	}
	
	public static void printMatrix(int[][] table){
		
	    for (int i = 0; i < table.length ; i++)
	    {
	        for (int j = 0; j < table[0].length; j++)
	        {
	        	System.out.print(table[i][j]+" ");
	        }
	        System.out.println();
	    }    
	    
		}

}