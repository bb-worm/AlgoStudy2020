package week9;

import java.io.*;
import java.util.*;

public class Baekjoon_2665 {
	
	static int N;
	static int[][] map;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				map[i][j] = input[j] - '0';
			}
		}
		
		BFS();
		System.out.println(ans);
	}
	
	static class Move implements Comparable<Move>{
		int a, b;
		int breakNum;
		
		public Move(int a, int b, int breakNum) {
			this.a = a;
			this.b = b;
			this.breakNum = breakNum;
		}
		
		public int compareTo(Move m) {
			return this.breakNum - m.breakNum;
		}
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void BFS() {
		PriorityQueue<Move> pq = new PriorityQueue<>();
		int[][] visit = new int[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++)
				visit[i][j] = Integer.MAX_VALUE;
		}
		
		pq.add(new Move(0, 0, 0));
		visit[0][0] = 0;
		
		int a, b;
		int breakNum;
		while (!pq.isEmpty()) {
			Move m = pq.poll();
			a = m.a;
			b = m.b;
			breakNum = m.breakNum;
			
			if (a == N-1 && b == N-1) {
				ans = breakNum;
				pq.clear();
				return;
			}
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=N)
					continue;
				
				if (map[na][nb] == 1) {
					if (visit[na][nb] <= breakNum)
						continue;
					
					pq.add(new Move(na, nb, breakNum));
					visit[na][nb] = breakNum;
				} else {
					if (visit[na][nb] <= breakNum+1)
						continue;
					
					pq.add(new Move(na, nb, breakNum+1));
					visit[na][nb] = breakNum + 1;
				}
			}
		}
	}
}
