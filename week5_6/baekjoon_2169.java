package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_2169 {
	
	public static int N, M;
	public static int[][] map;
	public static int[][] visit;
	public static int[][][] dp;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M];
		dp = new int[N][M][3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				for (int k=0; k<3; k++)
					dp[i][j][k] = Integer.MIN_VALUE;
			}
		}
		ans = Integer.MIN_VALUE;
		visit[0][0] = 1;
		
		DFS(0, 0, 0);
		
//		printDP();
		
		System.out.println(dp[0][0][0]);
	}
	
	public static int[] da = {1, 0, 0};
	public static int[] db = {0, -1, 1};
	
	public static int DFS(int a, int b, int dir) {
		
		if (a==N-1 && b==M-1) {
			dp[N-1][M-1][dir] = map[N-1][M-1];
			return map[N-1][M-1];
		}
		
		int max = Integer.MIN_VALUE;
		int na, nb;
		for (int i=0; i<3; i++) {
			
			na = a + da[i];
			nb = b + db[i];
			
			if (na<0||na>=N||nb<0||nb>=M)
				continue;
			if (visit[na][nb] != 0)
				continue;
			
			if (dp[na][nb][i] != Integer.MIN_VALUE) {
				max = Math.max(max, dp[na][nb][i]);
			} else {
				visit[na][nb] = 1;
				DFS(na, nb, i);
				max = Math.max(max, dp[na][nb][i]);
				visit[na][nb] = 0;
			}
		}
		if (max == Integer.MIN_VALUE)
			return 0;
		
		dp[a][b][dir] = max + map[a][b];
		
//		System.out.println(a + " " + b + " " + dir);
//		System.out.println(max + " " + map[a][b]);
//		printDP();
		return dp[a][b][dir];
	}
	
	public static void printDP() {
		for (int i=0; i<N; i++) {
			for (int k=0; k<3; k++) {
				for (int j=0; j<M; j++) {			
					if (dp[i][j][k] == Integer.MIN_VALUE)
						System.out.printf("%4d ",0);
					else
						System.out.printf("%4d ",dp[i][j][k]);
				}System.out.print("     ");
			}System.out.println();
		}System.out.println();
	}

}
