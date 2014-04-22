
public class QueueUsingStack {
	ArrayStackInt stack1;
	ArrayStackInt stack2;
	
	public QueueUsingStack(int capacity){
		stack1 = new ArrayStackInt(capacity);
		stack2 = new ArrayStackInt(capacity);
	}
	
	/* Function to enqueue an item to queue */
	public void enqueue(int x)
	{
		this.stack1.push(x);
	}
	
	/* Function to dequeue an item from queue */
	public int dequeue()
	{
	   int x; 
	  
	   /* If both stacks are empty then error */
	   if(this.stack1.isEmpty() && this.stack2.isEmpty())
	   {
	      System.out.printf("Q is empty");
	      return Integer.MIN_VALUE;
	   }
	 
	   /* Move elements from satck1 to stack 2 only if 
	       stack2 is empty */
	   if(this.stack2.isEmpty())
	   {
	     while(!this.stack1.isEmpty())
	     {
	        x = this.stack1.pop();
	        this.stack2.push(x);
	     }
	   } 
	 
	   x = this.stack2.pop();
	   return x;
	}
}