package week16;

import java.io.*;
import java.util.*;

public class Baekjoon_16918 {
	
	static int R, C, N;
	static char[][] map;
	static int[][] time;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		time = new int[R][C];
		
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'O')
					time[i][j] = 0;
			}
		}
		
		if (N%2 == 0) {
			StringBuilder sb = new StringBuilder();
			for (int i=0; i<R; i++) {
				for (int j=0; j<C; j++) {
					sb.append('O');
				}sb.append('\n');
			}sb.append('\n');
			System.out.println(sb);
		} else {
			int t = 2;
			while (t <= N) {
				
				// 폭탄 설치 
				if (t%2 == 0) {
					setBomb(t);
				} else { // 폭탄 폭파  
					explode(t);
				}
				
				t++;
			}
			printMap();
		}
	}
	
	static void printMap() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				sb.append(map[i][j]);
			}sb.append('\n');
		}sb.append('\n');
		System.out.println(sb);
	}
	
	static void setBomb(int t) {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (map[i][j] == '.') {
					map[i][j] = 'O';
					time[i][j] = t;
				}
			}
		}
	}

	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void explode(int t) {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (t-time[i][j] == 3) {
					map[i][j] = '.';
					time[i][j] = 0;
					
					int na, nb;
					for (int k=0; k<4; k++) {
						na = i + da[k];
						nb = j + db[k];
						
						if (na<0||na>=R||nb<0||nb>=C)
							continue;
						
						if (map[na][nb] == 'O' && t-time[na][nb] != 3) {
							map[na][nb] = '.';
							time[i][j] = 0;
						}
					}
				}
			}
		}
	}
}
