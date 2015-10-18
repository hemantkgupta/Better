package advanced;

import advanced.BNode;

import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class VerticalOrderPrinting {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		printVerticalOrder(root);
	}
	
	public static void printVerticalOrder(BNode root) {
		Map<Integer, ArrayList<Integer>> map = new TreeMap<Integer, ArrayList<Integer>>();
		
		getVerticalOrder(root, 0, map);

		for (Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getValue());
		}

	}

	public static void getVerticalOrder(BNode root, int hd,
			Map<Integer, ArrayList<Integer>> map) {
		
		if (root == null)
			return;

		if (map.containsKey(hd)) {
			map.get(hd).add(root.data);
		} else {
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(root.data);
			map.put(hd, list);
		}

		getVerticalOrder(root.left, hd - 1, map);

		getVerticalOrder(root.right, hd + 1, map);
	}

	
}
