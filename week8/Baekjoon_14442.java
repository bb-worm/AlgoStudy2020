package week8;

import java.io.*;
import java.util.*;

public class Baekjoon_14442 {
	
	static int N, M;
	static int K;
	static int[][] map;
	static int[][][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M][K+1];
		
		char[] ch;
		for (int i=0; i<N; i++) {
			ch = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = ch[j] - '0';
			}
		}
		
		int ans = BFS();
		System.out.println(ans);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};

	static int BFS() {
		
		Queue<Integer> q = new LinkedList<>();
		q.add(0); q.add(0); q.add(0);
		visit[0][0][0] = 1;
		
		int a, b, k;
		while (!q.isEmpty()) {
			a = q.poll();
			b = q.poll();
			k = q.poll();
			
			if (a==N-1 && b==M-1) {
				
				return visit[a][b][k];
			}
			
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0||na>=N||nb<0||nb>=M)
					continue;
				
				// no wall
				if (map[na][nb] == 0) {
					if (visit[na][nb][k] != 0)
						continue;
					
					q.add(na); q.add(nb); q.add(k);
					visit[na][nb][k] = visit[a][b][k]+1;
				} 
				// wall
				else {
					if (k+1 > K || visit[na][nb][k+1] != 0)
						continue;
					
					q.add(na); q.add(nb); q.add(k+1);
					visit[na][nb][k+1] = visit[a][b][k] + 1;
				}
			}
		}
		return -1;
	}
}
