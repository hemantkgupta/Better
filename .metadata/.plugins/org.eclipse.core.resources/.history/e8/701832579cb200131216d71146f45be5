
public class BubbleSort2 {
	public static void main(String[] args) {


		int a[] = {2,6,4,5,8,7,3,9,1};
		printData(a);
		BubbleSort2 is = new BubbleSort2();
		is.bubbleSort(a);
		printData(a);
	}
	public static void printData(int[] a){
		System.out.println();
		for (int x : a){
			{
				System.out.print(x +" ");	
			}

		}
	}	
	public void bubbleSort(int[] a ){
		for (int j = 1; j < a.length; j++) {
			for (int i = a.length-1; i >= j ;i--) {
				if( a[i] < a[i-1])
					swap(a,i,i-1);
				
			}			
		}
	}
public void swap(int[] a, int x, int y){
			int temp = a[x];
			a[x]=a[y];
			a[y]= temp;
			
		}
		
		
		
		
	}

