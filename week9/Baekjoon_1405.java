package week9;

import java.io.*;
import java.util.*;

public class Baekjoon_1405 {
	
	static int N;
	static double[] p = new double[4];
	
	static int[][] visit;
	
	static double ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i=0; i<4; i++)
			p[i] = (double)Integer.parseInt(st.nextToken())/100;
		
		visit = new int[N*2+1][N*2+1];
		
		ans = 0;
		visit[N][N] = 1;
		DFS(N, N, 1, 0);
		System.out.println(ans);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void DFS(int a, int b, double now, int move) {
		
		if (move >= N) {
			ans += now;
//			System.out.println(now);
			return;
		}
		
		int na, nb;
		for (int i=0; i<4; i++) {
			na = a + da[i];
			nb = b + db[i];
			
			if (visit[na][nb] == 1 || p[i] == 0)
				continue;
			
			visit[na][nb] = 1;
			DFS(na, nb, now*p[i], move+1);
			visit[na][nb] = 0;
		}
	}
}
