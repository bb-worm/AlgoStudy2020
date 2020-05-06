package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11660 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[n][n];
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (j != 0)
					map[i][j] += map[i][j-1];
			}
		}
		
		for (int k=0; k<m; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken())-1;
			int y1 = Integer.parseInt(st.nextToken())-1;
			int x2 = Integer.parseInt(st.nextToken())-1;
			int y2 = Integer.parseInt(st.nextToken())-1;
			
			int sum = 0;
			for (int i=x1; i<=x2; i++) {
				sum += map[i][y2];
				if (y1 != 0)
					sum -= map[i][y1-1];
			}
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
	}

}
