package sort.advanced;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

public class MergeOverlappingIntervals {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(6, 8));
		// intervals.add(new Interval(1,9));
		intervals.add(new Interval(2, 4));
		intervals.add(new Interval(4, 7));
		mergeIntervals(intervals);

	}

	public static void mergeIntervals(List<Interval> intervals) {
		if (intervals.size() <= 0)
			return;

		Deque<Interval> stack = new ArrayDeque<Interval>();
		// sort the intervals based on start time
		Collections.sort(intervals);

		// push the first interval to stack
		stack.push(intervals.get(0));

		// Start from the next interval and merge if necessary
		for (int i = 1; i < intervals.size(); i++) {
			Interval top = stack.peek();

			// current not overlapping with top, push it to the stack
			if (top.end < intervals.get(i).start) {
				stack.push(intervals.get(i));
			}
			// Otherwise update the ending time of top if more
			else if (top.end < intervals.get(i).end) {
				top.end = intervals.get(i).end;
				stack.pop();
				stack.push(top);
			}
		}
		System.out.println("\n The Merged Intervals are: ");
		while (!stack.isEmpty()) {
			Interval t = stack.peek();
			System.out.print("[" + t.start + "," + t.end + "]" + " ");
			stack.pop();
		}

		return;
	}

}

class Interval implements Comparable<Interval> {
	int start;
	int end;

	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Interval o) {
		return this.start - o.start;
	}

}
