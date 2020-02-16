package week4;

import java.io.*;

public class baekjoon_2156 {
	
	public static int N;
	public static int[] wine;
	
	public static int[][] dp;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		wine = new int[N];
		dp = new int[N][3];
		
		for (int i=0; i<N; i++) {
			wine[i] = Integer.parseInt(br.readLine());
			for (int j=0; j<3; j++) {
				dp[i][j] = -1;
			}
		}
		
		ans = 0;
		dp[0][0] = 0;
		dp[0][1] = dp[0][2] = wine[0];
		drink(1);

		System.out.println(ans);
//		printDP();
	}
	
	public static void drink(int idx) {
		int pre = idx-1;
		
		if (idx >= N) {
			ans = Math.max(dp[pre][0], Math.max(dp[pre][1], dp[pre][2]));
			return;
		}
		
		dp[idx][0] = Math.max(dp[pre][0], Math.max(dp[pre][1], dp[pre][2]));
		dp[idx][1] = dp[pre][0] + wine[idx];
		dp[idx][2] = dp[pre][1] + wine[idx];
		drink(idx+1);
	}
	
	public static void printDP() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<3; j++) {
				System.out.print(dp[i][j]+ " " );
			}System.out.println();
		}System.out.println();
	}
}
