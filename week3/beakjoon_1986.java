package week3;

import java.io.*;
import java.util.*;

public class beakjoon_1986 {
	
	public static int n, m;
	public static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		
		int a, b;
		for (int k=1; k<=3; k++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			for (int i=0; i<num; i++) {
				a = Integer.parseInt(st.nextToken())-1;
				b = Integer.parseInt(st.nextToken())-1;
				map[a][b] = k;
			}
		}
		
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j] == 1 || map[i][j] == 2)
					fill(i, j);
			}
		}
		int ans = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				if (map[i][j] == 0)
					ans++;
			}
		}
//		printAll();
		System.out.println(ans);
	}
	
	public static int[] qa = {-1, 1, 0, 0, -1, -1, 1, 1};
	public static int[] qb = {0, 0, -1, 1, -1, 1, -1 ,1};
	
	public static int[] ka = {-1, -2, -2, -1, 1, 2, 2, 1};
	public static int[] kb = {-2, -1, 1, 2, -2, -1, 1, 2};
	
	public static void fill(int a, int b) {
		// queen
		if (map[a][b] == 1) {
			
			int na, nb;
			for (int i=0; i<8; i++) {
				na = a + qa[i];
				nb = b + qb[i];
				
				while (na>=0 && na<n && nb>=0 && nb<m) {
					if (map[na][nb] == 0) {
						map[na][nb] = -1;
					}
					else if (map[na][nb] >= 1) {
						break;
					}
					na += qa[i];
					nb += qb[i];
				}
			}
		}
		// knight
		else if (map[a][b] == 2) {
			int na, nb;
			for (int i=0; i<8; i++) {
				na = a + ka[i];
				nb = b + kb[i];
				
				if (na<0||na>=n||nb<0||nb>=m)
					continue;
				if (map[na][nb] == 0)
					map[na][nb] = -1;
			}
		}
	}
	
	public static void printAll() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<m; j++) {
				System.out.printf("%2d",map[i][j]);
			}System.out.println();
		}System.out.println();
	}

}
