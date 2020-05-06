package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_17836 {
	
	public static int N, M;
	public static int T;
	public static int[][] map;
	public static int[][][] visit;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M][2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = Integer.MAX_VALUE;
		BFS();
		if (ans == Integer.MAX_VALUE)
			System.out.println("Fail");
		else
			System.out.println(ans);
	}
	
	static class Move{
		int a, b;
		int hasGram;
		
		public Move(int a, int b, int hasGram) {
			this.a = a;
			this.b = b;
			this.hasGram = hasGram;
		}
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void BFS() {
		Queue<Move> q = new LinkedList<>();
		
		q.add(new Move(0,0,0));
		visit[0][0][0] = 1;
		
		int a, b;
		int hasGram;
		while(!q.isEmpty()) {
			Move m = q.poll();
			a = m.a; b = m.b; hasGram = m.hasGram;
			
			if (a==N-1 && b==M-1) {
				q.clear();
				ans = visit[a][b][hasGram]-1;
				return;
			}
			
			if (visit[a][b][hasGram]-1 >= T) {
				continue;
			}
			
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0||na>=N||nb<0||nb>=M||visit[na][nb][hasGram]!=0)
					continue;
				if (hasGram==0 && map[na][nb]==1)
					continue;
				
				if (map[na][nb] == 2) {
					q.add(new Move(na, nb, 1));
					visit[na][nb][0] = visit[na][nb][1] = visit[a][b][hasGram] + 1;
				} else {
					q.add(new Move(na, nb, hasGram));
					visit[na][nb][hasGram] = visit[a][b][hasGram] + 1;
				}
				
			}
			
		}
	}

}
