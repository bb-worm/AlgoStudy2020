package week21;

import java.io.*;
import java.util.*;

public class Baekjoon_14466 {
	
	static int N, K, R;
	static int[][] map;
	static int[][][] cost;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		cost = new int[N][N][4];
		
		for (int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			int r1 = Integer.parseInt(st.nextToken())-1;
			int c1 = Integer.parseInt(st.nextToken())-1;
			int r2 = Integer.parseInt(st.nextToken())-1;
			int c2 = Integer.parseInt(st.nextToken())-1;
			
			int dir = getDir(r1, c1, r2, c2);
			cost[r1][c1][dir] = 1;
			cost[r2][c2][(dir+2)%4] = 1;
		}
		
		Queue<Integer> q = new LinkedList<>();
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			map[a][b] = 1;
			q.add(a); q.add(b);
		}
		
		int ans = 0;
		while (!q.isEmpty()) {
			int a = q.poll();
			int b = q.poll();
			ans += BFS(a, b);
		}
		
		System.out.println(ans / 2);
	}
	
	static int[] da = {-1, 0, 1, 0};
	static int[] db = {0, 1, 0, -1};
	
	static int BFS(int i, int j) {
		int result = 0;
		
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		
		q.add(i); q.add(j);
		visit[i][j] = true;
		
		while (!q.isEmpty()) {
			int a = q.poll();
			int b = q.poll();
			
			if (map[a][b] == 1)
				result++;
			
			for (int k=0; k<4; k++) {
				int na = a + da[k];
				int nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=N||visit[na][nb])
					continue;
				if (cost[a][b][k] > 0)
					continue;
				
				q.add(na); q.add(nb);
				visit[na][nb] = true;
			}
		}
		return K - result;
	}
	
	static int getDir(int r1, int c1, int r2, int c2) {
		if (r1 > r2) // north
			return 0; 
		else if (c2 > c1) // east
			return 1;
		else if (r1 < r2) // south
			return 2;
		else // west
			return 3;
	}
}
