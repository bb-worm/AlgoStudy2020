package week18;

import java.io.*;
import java.util.*;

public class Baekjoon_14500 {
	
	static int N, M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//////////////////////////////////////
		
		int ans = 0;
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				for (int k=0; k<19; k++) {
					if (check(i, j, k)) {
						ans = Math.max(ans, getSum(i, j, k));
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	static int getSum(int i, int j, int k) {
		int sum = 0;
		
		int a, b;
		for (int d=0; d<4; d++) {
			a = i + da[k][d];
			b = j + db[k][d];
			
			sum += map[a][b];
		}
		
		return sum;
	}
	
	static boolean check(int i, int j, int k) {
		int a=i, b=j;
		
		if (k==0) {
			a++;
			b++;
		} else if (k==1) {
			b+=3;
		} else if (k==2) {
			a+=3;
		} else if (k<=10) {
			a+=2;
			b+=1;
		} else {
			a+=1;
			b+=2;
		}
		
		if (a>=N||b>=M)
			return false;
		else
			return true;
	}
	
	static int[][] da = {
			{0, 0, 1, 1}, // 0 : 2*2
			{0, 0, 0, 0}, // 1 : 1*4
			{0, 1, 2, 3}, // 2 : 4*1
			{0, 1, 2, 2}, // 3 ~ 10 : 3*2
			{0, 0, 1, 2},
			{0, 1, 1, 2},
			{0, 1, 1, 2},
			{0, 1, 2, 2},
			{0, 0, 1, 2},
			{0, 1, 1, 2},
			{0, 1, 1, 2},
			{0, 0, 0, 1}, // 11 ~ 18 : 2*3
			{0, 1, 1, 1},
			{0, 0, 1, 1},
			{0, 0, 1, 1},
			{0, 0, 0, 1},
			{0, 1, 1, 1},
			{0, 0, 0, 1},
			{0, 1, 1, 1}
	};
	static int[][] db = {
			{0, 1, 0, 1}, // 0 : 2*2
			{0, 1, 2, 3}, // 1 : 1*4
			{0, 0, 0, 0}, // 2 : 4*1
			{0, 0, 0, 1}, // 3 ~ 10 : 3*2
			{0, 1, 1, 1},
			{0, 0, 1, 1},
			{1, 0, 1, 0},
			{1, 1, 0, 1},
			{0, 1, 0, 0},
			{1, 0, 1, 1},
			{0, 0, 1, 0},
			{0, 1, 2, 0}, // 11 ~ 18 : 2*3
			{2, 0, 1, 2},
			{1, 2, 0, 1},
			{0, 1, 1, 2},
			{0, 1, 2, 2},
			{0, 0, 1, 2},
			{0, 1, 2, 1},
			{1, 0, 1, 2}
	};
}
