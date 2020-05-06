package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11403 {
	
	static int N;
	static int[][] connect;
	static int[][] ans;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		connect = new int[N][N];
		ans = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				connect[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (connect[i][j] == 1) {
					ans[i][j] = 1;
				} else {
					ans[i][j] = BFS(i, j);
					if (ans[i][j] == 1)
						connect[i][j] = 1;
				}
				sb.append(ans[i][j]).append(" ");
			}sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	
	static int BFS(int start, int goal) {
		Queue<Integer> q = new LinkedList<>();
		int[] visit = new int[N];
		
		q.add(start);
		
		int a;
		while (!q.isEmpty()) {
			a = q.poll();
			
			for (int i=0; i<N; i++) {
				if (visit[i]==1 || connect[a][i]==0)
					continue;
				
				if (i == goal) {
					q.clear();
					return 1;
				}
				
				q.add(i);
				visit[i] = 1;
			}
		}
		
		return 0;
	}
}
