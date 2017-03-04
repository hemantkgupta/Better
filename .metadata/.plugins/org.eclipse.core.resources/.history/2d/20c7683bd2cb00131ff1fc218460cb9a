
public class StockBuySellTest {

	public static void main(String[] args) {
		int price[] = {100, 180, 260, 310, 40, 535, 695};
		stockBuySell(price, price.length);
	}
	
	// This function finds the buy sell schedule for maximum profit
	public static void stockBuySell(int price[], int n)
	{
	    // Prices must be given for at least two days
	    if (n == 1)
	        return;
	 
	    int count = 0; // count of solution pairs
	 
	    // solution vector
	    int len = (n/2) + 1;
	    Range[]  sol = new Range[len];
	 
	    // Traverse through given price array
	    int i = 0;
	    while (i < n-1)
	    {
	        Range one = new Range();
	    	// Find Local Minima. Note that the limit is (n-2) as we are
	        // comparing present element to the next element. 
	        while ((i < n-1) && (price[i+1] <= price[i]))
	            i++;
	 
	        // If we reached the end, break as no further solution possible
	        if (i == n-1)
	            break;
	 
	        // Store the index of minima
	        one.buy = i++;
	        //sol[count] = one;
	 
	        // Find Local Maxima.  Note that the limit is (n-1) as we are
	        // comparing to previous element
	        while ((i < n) && (price[i] >= price[i-1]))
	            i++;
	 
	        // Store the index of maxima
	        one.sell = i-1;
	        sol[count]= one;
	 
	        // Increment count of buy/sell pairs
	        count++;
	    }
	 
	    // print solution
	    if (count == 0)
	        System.out.printf("There is no day when buying the stock will make profit\n");
	    else
	    {
	       for ( i = 0; i < count; i++)
	          System.out.printf("Buy on day: %d\t Sell on day: %d\n", sol[i].buy, sol[i].sell);
	    }	 
	    return;
	}
	
	

}
class Range
{
    int buy;
    int sell;
    
    public Range(){	    	
    }
}
