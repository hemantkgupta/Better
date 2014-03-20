package com.hkg.test.uf;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class QuickUnion_Find {

	private int[] id;
	private int count;

	public QuickUnion_Find(int N) {
		if (N < 0)
			throw new IllegalArgumentException();
		count = N;
		id = new int[N];

		for (int i = 0; i < N; i++) {
			id[i] = i;

		}
	}

	public int find(int p) {
		if (p < 0 || p >= id.length)
			throw new IndexOutOfBoundsException();
		  while (p != id[p])
	            p = id[p];
	        return p;

	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		 int i = find(p);
	        int j = find(q);
	        if (i == j) return;
	        id[i] = j; 
	        count--;
		System.out.println(p +" and "+ q +" Count in loop is "+count);
	}

	public int getCount() {
		return count;
	}

	public static void main(String[] args) {
		QuickUnion_Find uf = null;
		try {
			Scanner s = new Scanner(
					new File(
							"D:/WSs/Misc/MyAlg4-Chapter1/src/com/hkg/test/uf/tinyUF.txt"));
			int N = new Integer(s.nextLine());
			uf = new QuickUnion_Find(N);
			System.out.println(N);
			int times = 0;
			do {
				String line = s.nextLine();
				line = line.trim();
				String[] vers = line.split("\\p{javaWhitespace}+");
				int p = new Integer(vers[0]);
				int q = new Integer(vers[1]);
				if (uf.connected(p, q)){
					System.out.println("Connected " +p+ " and "+ q);
					continue;
				}
				uf.union(p, q);
				System.out.println(Arrays.toString(uf.getId()));
				System.out.println(++times);
				System.out.println(p + " " + q);
			} while (s.hasNextLine());
		} catch (IOException e) {
			System.err.println(e);
			System.exit(1);
		}
		System.out.println("No of connected components: "+uf.getCount());
	}

	public int[] getId() {
		return id;
	}

	public void setId(int[] id) {
		this.id = id;
	}
}
