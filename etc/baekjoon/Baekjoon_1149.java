package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1149 {
	
	static int N;
	static int[][] cost;
	static int[][] DP;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		cost = new int[N][3];
		DP = new int[N][3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}
				
		ans = DFS(3, 0);
		
		System.out.println(ans);
	}
	
	static int DFS(int pre, int idx) {
		
		if (idx >= N)
			return 0;
		
		if (pre!=3 && DP[idx][pre]!=0)
			return DP[idx][pre];
		
		int min = Integer.MAX_VALUE;
		for (int i=0; i<3; i++) {
			if (i==pre)
				continue;
			
			min = Math.min(min, cost[idx][i] + DFS(i, idx+1));
		}
		
		if (pre!=3)
			DP[idx][pre] = min;

		return min;
	}
	
	static void printDP() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(DP[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
}
