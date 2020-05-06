package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2178 {
	
	public static int N, M;
	public static int[][] map;
	public static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		
		char[] str;
		for (int i=0; i<N; i++) {
			str = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = str[j] - '0';
			}
		}
		
		BFS();
		System.out.println(visit[N-1][M-1]);
	}
	
	public static Queue<Integer> q = new LinkedList<Integer>();
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void BFS() {
		q.add(0); q.add(0);
		visit[0][0] = 1;
		
		int a, b;
		while(!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			if (a == N-1 && b == M-1) {
				q.clear();
				return;
			}
			
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0|| na>=N || nb<0 || nb>=M)
					continue;
				if (visit[na][nb] != 0)
					continue;
				if (map[na][nb] == 0)
					continue;
				
				q.add(na); q.add(nb);
				visit[na][nb] = visit[a][b] + 1;
			}
		}
	}
}
