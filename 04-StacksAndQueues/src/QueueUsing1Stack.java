
public class QueueUsing1Stack {
	LinkedListStack stack1;
	
	public QueueUsing1Stack(){
		stack1 = new LinkedListStack();
	}
	
	/* Function to enqueue an item to queue */
	public void enqueue(int x)
	{
		this.stack1.push(x);
	}
	
	/* Function to dequeue an item from queue */
	public int dequeue()
	{
	   int x, res; 
	  
	   /* If stack are empty then error */
	   if(this.stack1.isEmpty() )
	   {
	      System.out.printf("Q is empty");
	      return Integer.MIN_VALUE;
	   }else if(this.stack1.top.next == null){
		   return this.stack1.pop();
	   }else{
		   x = this.stack1.pop();
		   res = dequeue();
		   this.stack1.push(x);
		   return res;
	   }
	 
	   
	}

}