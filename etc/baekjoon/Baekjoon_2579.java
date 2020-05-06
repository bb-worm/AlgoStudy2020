package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2579 {
	
	static class Node {
		int val;
		int left, right;
		
		public Node (int val) {
			this.val = val;
		}
	}
	
	static int N;
	static Node[] stair;
	static int ans;
	
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		stair = new Node[N+1];
		dp = new int[N+1][3];
		
		stair[0] = new Node(0);
		stair[0].left = stair[0].right = 0;
		for (int i=1; i<=N; i++) {
			stair[i] = new Node(Integer.parseInt(br.readLine()));
		}
		stair[1].left = stair[1].right = stair[1].val;
		
		for (int i=2; i<=N; i++) {
			stair[i].left = Math.max(stair[i-2].left, stair[i-2].right) + stair[i].val;
			stair[i].right = stair[i-1].left + stair[i].val;
		}
		
		int ans = Math.max(stair[N].left, stair[N].right);
		System.out.println(ans);
	}
}
