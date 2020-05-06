package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9465 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[2][N];
			for (int i=0; i<2; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			map[0][1] += map[1][0];
			map[1][1] += map[0][0];
			
			int ans = 0;
			for (int i=2; i<N; i++) {
				
				map[0][i] += Math.max(map[0][i-2], Math.max(map[1][i-2], map[1][i-1]));
				map[1][i] += Math.max(map[1][i-2], Math.max(map[0][i-2], map[0][i-1]));
				
				ans = Math.max(ans, Math.max(map[0][i], map[1][i]));
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
}
