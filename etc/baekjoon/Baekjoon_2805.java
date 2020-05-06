package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2805 {
	
	static long ans;
	
	static int N, M;
	static int[] tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		int max = 0;
		tree = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, tree[i]);
		}
		
		ans = 0;
		BinarySearch(0, max);
		System.out.println(ans);
	}
	
	static void BinarySearch(int start, int end){
		
		if (start > end) {
			return;
		}
		
		int mid = (start+end) / 2;
		
		long sum = 0;
		for (int i=0; i<N; i++) {
			if (tree[i] - mid > 0)
				sum += tree[i] - mid;
		}
		if (sum < M) {
			BinarySearch(start, mid-1);
		} else {
			ans = Math.max(ans, mid);
			BinarySearch(mid+1, end);
		}
	}

}
