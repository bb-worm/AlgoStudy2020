package week12;

import java.io.*;
import java.util.*;

public class Baekjoon_2352 {
	
	static int n;
	static int[] num;
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		al.add(num[1]);
		for (int i=2; i<=n; i++) {
			if (num[i] > al.get(al.size()-1)) {
				al.add(num[i]);
			} else {
				lower_bound(0, al.size(), num[i]);
			}
		}
		
		System.out.println(al.size());
	}
	
	static void lower_bound(int left, int right, int num) {
		
		if (left == right) {
			al.set(right, num);
			return;
		}
		
		int mid = (left+right) / 2;
		
		if (al.get(mid) < num) {
			lower_bound(mid+1, right, num);
		} else {
			lower_bound(left, mid, num);
		}
	}
}
