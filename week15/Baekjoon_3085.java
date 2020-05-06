package week15;

import java.io.*;

public class Baekjoon_3085 {
	
	static char[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new char[N][N];
		
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int ans = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N-1; j++) {
				// right
				if (map[i][j] != map[i][j+1]) {
					swap(i, j, i, j+1);
					ans = Math.max(ans, getPoint());
					swap(i, j, i, j+1);
				}
				
				// down
				if (i+1<N && map[i][j]!=map[i+1][j]) {
					swap(i, j, i+1, j);
					ans = Math.max(ans, getPoint());
					swap(i, j, i+1, j);
				}
			}
		}
		System.out.println(ans);
	}
	
	static int getPoint() {
		
		int max = 1;
		
		char tmp1, tmp2;
		int len1, len2;
		
		for (int k=0; k<N; k++) {
			tmp1 = 'x';
			tmp2 = 'x';
			len1 = 0;
			len2 = 0;
			for (int i=0; i<N; i++) {
				if (tmp1 == map[i][k]) {
					len1++;
				} else {
					max = Math.max(max, len1);
					len1 = 1;
					tmp1 = map[i][k];
				}
			}
			for (int j=0; j<N; j++) {
				if (tmp2 == map[k][j]) {
					len2++;
				} else {
					max = Math.max(max, len2);
					len2 = 1;
					tmp2 = map[k][j];
				}
			}
			max = Math.max(max, Math.max(len1, len2));
		}
		
		return max;
	}
	
	static void printMap() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	static void swap(int a1, int b1, int a2, int b2) {
		char tmp = map[a1][b1];
		map[a1][b1] = map[a2][b2];
		map[a2][b2] = tmp;
	}
}
