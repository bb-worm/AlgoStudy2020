package week15;

import java.io.*;
import java.util.*;

public class Baekjoon_2468 {
	
	static int N;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int[] height = new int[101];
		
		N = Integer.parseInt(br.readLine());
		map = new int[N+2][N+2];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				height[map[i][j]] = 1;
			}
		}
		
		int ans = 1;
		
		for (int i=1; i<=100; i++) {
			if (height[i] == 1) {
				int result = BFS(i);
				if (result == 0) {
					break;
				}
				ans = Math.max(ans, result);
			}
		}
		System.out.println(ans);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static int BFS(int limit) {
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[N+2][N+2];
		
		int areaNum = 0;
		
		for (int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				if (map[i][j] > limit && visit[i][j]==0) {
					areaNum++;
					
					q.add(i); q.add(j);
					visit[i][j] = 1;
					
					int a, b;
					while (!q.isEmpty()) {
						a = q.poll();
						b = q.poll();
						
						int na, nb;
						for (int k=0; k<4; k++) {
							na = a + da[k];
							nb = b + db[k];
							
							if (map[na][nb]<=limit||visit[na][nb]==1)
								continue;
							
							q.add(na); q.add(nb);
							visit[na][nb] = 1;
						}
					}
				}
			}
		}
		
		return areaNum;
	}

}
