package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1389 {
	
	static int N;
	static int[][] relation;
	
	static int ans;
	static int minVal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		relation = new int[N][N];
		
		int a, b;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			
			relation[a][b] = relation[b][a] = 1;
		}
		
		minVal = Integer.MAX_VALUE;
		for (int i=0; i<N; i++) {
			BFS(i);
		}
		System.out.println(ans);
	}
	
	static void BFS(int idx) {
		int result = 0;
		
		Queue<Integer> q = new LinkedList<>();
		int[] visit = new int[N];
		
		q.add(idx);
		visit[idx] = 1;
		
		int now;
		while (!q.isEmpty()) {
			now = q.poll();
			
			for (int i=0; i<N; i++) {
				if (now==i || visit[i]!=0)
					continue;
				
				if (relation[now][i] == 1) {
					q.add(i);
					visit[i] = visit[now]+1;
					result += visit[now];
				}
			}
		}
		
		
		if (minVal > result) {
			minVal = result;
			ans = idx+1;
		}
	}
}
