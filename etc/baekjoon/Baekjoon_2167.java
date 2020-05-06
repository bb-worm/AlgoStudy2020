package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2167 {
	
	static int N, M;
	static int[][] map;
	
	static int K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (j!=0)
					map[i][j] += map[i][j-1];
			}
		}
		
		K = Integer.parseInt(br.readLine());
		int i, j, x, y;
		for (int k=0; k<K; k++) {
			st = new StringTokenizer(br.readLine());
			i = Integer.parseInt(st.nextToken())-1;
			j = Integer.parseInt(st.nextToken())-1;
			x = Integer.parseInt(st.nextToken())-1;
			y = Integer.parseInt(st.nextToken())-1;
			
			sb.append(getSum(i,j,x,y)).append('\n');
		}
		System.out.println(sb);
	}
	
	static int getSum(int i, int j, int x, int y) {
		int sum = 0;
		for (int a=i; a<=x; a++) {
			sum += map[a][y];
		}
		
		if (j > 0) {
			for (int a=i; a<=x; a++) {
				sum -= map[a][j-1];
			}
		}
		
		return sum;
	}

}
