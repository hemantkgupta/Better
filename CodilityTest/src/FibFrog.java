import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;


public class FibFrog {

	public static void main(String[] args) {
		int[] A = new int[11];
		 A[0] = 0;
				    A[1] = 0;
				    A[2] = 0;
				    A[3] = 1;
				    A[4] = 1;
				    A[5] = 0;
				    A[6] = 1;
				    A[7] = 0;
				    A[8] = 0;
				    A[9] = 0;
				    A[10] = 0;
	    System.out.println(solution(A));
	}
	
		public static int solution(int[] A) {
			// find all fib numbers for size of A
			ArrayList<Integer> fib = new ArrayList<Integer>();
			int a = 0;
			int b = 1;
			while (true) {
				int x = a + b;
				if (x > A.length + 1)
					break;
				fib.add(x);
				a = b;
				b = x;
			}
	 
			// maintain a queue of starting locations for jump, and do a BFS using
			// all fib numbers; number of fib numbers is O(logN)
	 
			Queue<Integer> next = new ArrayDeque<Integer>();
			next.add(-1); // add starting location on one side of river
	 
			int numJumps = 1;
			while (!next.isEmpty()) {
				int size = next.size();
				for (int i = 0; i < size; i++) {
					int from = next.remove();
					for (int f : fib) {
						int to = from + f;
						if (to == A.length) {
							// reached destination
							return numJumps;
						} else if (to > A.length || A[to] == 0) {
							// no leaf to land on, or exceeded target, or already
							// visited
						} else {
							next.add(to);
							// mark as visited
							A[to] = 0;
						}
					}
				}
				numJumps++;
			}
			// no more place to jump from and haven't reached other end.
	 
			return -1;
		}
	}


