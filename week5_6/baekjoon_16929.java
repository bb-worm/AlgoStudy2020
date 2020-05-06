package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_16929 {
	
	public static int N, M;
	public static char[][] map;
	public static int[][] visit;
	
	public static int ans;
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		visit = new int[N][M];
		
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		ans = 0;
		for (int i=0; i<N-1 && ans==0; i++) {
			for (int j=0; j<M-1 && ans==0; j++) {	
				find(i, j+1, map[i][j], i, j, 0);
				resetVisit();
			}
		}
		if (ans == 0)
			System.out.println("No");
		else 
			System.out.println("Yes");
	}
	
	public static void find(int a, int b, char val, int oriA, int oriB, int dir) {
		if (a<oriA || a>=N || b<0 || b>=M || ans==1)
			return;
		
		if (map[a][b] != val || visit[a][b] == 1) {
			return;
		}
		
		if (a == oriA && b == oriB) {
			ans = 1;
			return;
		}
		
		visit[a][b] = 1;
		
		// not right -> can go left
		if (dir != 0) {
			find(a, b-1, val, oriA, oriB, 2);
		}
		
		// not down -> can go up
		if (dir != 1) {
			find(a-1, b, val, oriA, oriB, 3);
		}
		
		// not left -> can go right
		if (dir != 2) {
			find(a, b+1, val, oriA, oriB, 0);
		}
		
		// not up -> can go down
		if (dir != 3) {
			find(a+1, b, val, oriA, oriB, 1);
		}
	}
	
	public static void resetVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				visit[i][j] = 0;
			}
		}
	}
}
