package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1780 {

	static int N;
	static int[][] map;
	
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = new int[3];
		DFS(0, 0, N);
		
		for (int i=0; i<3; i++)
			System.out.println(ans[i]);
	}
	
	static void DFS(int a, int b, int size) {
				
		if (size == 1) {
			ans[map[a][b]+1]++;
			return;
		}
		
		int val = map[a][b];
		for (int i=a; i<a+size; i++) {
			for (int j=b; j<b+size; j++) {
				
				if (val != map[i][j]) {
					for (int n=a; n<a+size; n+=size/3) {
						for (int m=b; m<b+size; m+=size/3) {
							DFS(n, m, size/3);
						}
					}
					
					return;
				}
			}
		}
		ans[val+1]++;
	}

}
