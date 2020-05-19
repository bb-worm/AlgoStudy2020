package week17;

import java.io.*;
import java.util.*;

public class Baekjoon_17070 {
	
	static int N;
	static int[][] map;
	static int[][][] dp;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		dp = new int[N][N][3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				for (int k=0; k<3; k++)
					dp[i][j][k] = -1;
			}
		}
		
		ans = DFS(0, 1, 0);
		System.out.println(ans);
	}
	
	static int[] da = {0, 1, 1};
	static int[] db = {1, 1, 0};
	
	static int DFS(int a, int b, int dir) {

		if (a<0||a>=N||b<0||b>=N||map[a][b]==1)
			return 0;
		if (dir==1 && (map[a-1][b]==1 || map[a][b-1]==1))
			return 0;
		
		if (dp[a][b][dir] != -1)
			return dp[a][b][dir];
		
		if (a==N-1 && b==N-1) {
			return 1;
		}
		
		// dir - 0:가로, 1:대각, 2:세로 
		
		int sum = 0;
		for (int i=0; i<3; i++) {
			if (!canGo(dir, i))
				continue;
			
			sum += DFS(a+da[i], b+db[i], i);
		}
		
		return dp[a][b][dir] = sum;
	}
	
	static boolean canGo(int dir, int i) {
		if (i==0 && dir==2)
			return false;
		
		if (i==2 && dir==0)
			return false;
		
		return true;
	}
}
