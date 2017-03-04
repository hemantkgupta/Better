import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SubarraySumZero {

	public static void main(String[] args) {
		int[] ar = { 4, 2, -3, 1, 6 };
		System.out.println(testSubArray(ar));

	}

	public static boolean testSubArray(int[] ar) {
		Map<Integer, Integer> h = new HashMap<Integer, Integer>();
		for (int i = 0; i < ar.length; i++) {
			if (h.containsValue(-ar[i])) {
				return true;
			} else {
				for (Entry<Integer, Integer> entry : h.entrySet()) {
					entry.setValue(entry.getValue() + ar[i]);

				}
				h.put(i, ar[i]);
			}

		}
		return false;
	}

}
