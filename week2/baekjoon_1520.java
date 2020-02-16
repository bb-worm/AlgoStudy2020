package week2;

import java.io.*;
import java.util.*;

public class baekjoon_1520 {
	
	public static int M, N;
	public static int[][] map;
	public static int[][] visit;
	
	public static int ans;
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		for (int i=100; i>=0; i--) {
//			for (int j=0; j<100; j++) {
//				System.out.printf("%d ",i-j);
//			}System.out.println();
//		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visit = new int[M][N];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j] = -1;
			}
		}
		
		System.out.println(DFS(0, 0));
	}
	
	public static int DFS(int a, int b) {
		if (a==M-1 && b == N-1) {
			return 1;
		}
		
		int na, nb;
		int sum = 0;
		
		for (int i=0; i<4; i++) {
			na = a + da[i];
			nb = b + db[i];
			
			if (na<0||na>=M||nb<0||nb>=N)
				continue;
			
			if (map[na][nb] >= map[a][b])
				continue;
			
			if (visit[na][nb] != -1) {
				sum += visit[na][nb];
			}
			else {
				sum += DFS(na, nb);
			}
		}
		visit[a][b] = sum;
//		printVisit();
		return sum;
	}
	
	public static void printVisit() {
		for (int i=0; i<M; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(visit[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
