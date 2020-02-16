package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class baekjoon_2206 {
		
	public static int N, M;
	public static int[][] map;
	public static int[][][] visit;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visit = new int[N][M][2];
		
		for (int i=0; i<N; i++) {
			char[] ch = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = ch[j] - '0';
			}
		}
		
		ans = 0;
		BFS();
		if (ans == 0)
			ans = -1;
		System.out.println(ans);
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};

	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(0); q.add(0); q.add(0);
		visit[0][0][0] = 1;
		
		int a, b;
		int use;
		int val;
		while (!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			use = q.poll();
			val = visit[a][b][use];
			
			if (a == N-1 && b == M-1) {
				ans = val;
				q.clear();
				return;
			}
			
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0||na>=N||nb<0||nb>=M)
					continue;
				if (visit[na][nb][use] != 0)
					continue;
				
				// meet wall
				if (map[na][nb] == 1) {
					// can break
					if (use == 0) {
						q.add(na); q.add(nb); q.add(1);
						visit[na][nb][1] = val + 1;
					}
					continue;
				}
				
				// can go
				q.add(na); q.add(nb); q.add(use);
				visit[na][nb][use] = val + 1;
			}
		}
	}
}
