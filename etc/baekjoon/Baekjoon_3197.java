package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_3197 {
	
	public static int R, C;
	public static int[][] map;
	public static int[][] visit;
	
	public static int[] start;
	public static int[] goal;
	
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new int[R][C];
		start = new int[2];
		goal = new int[2];
		
		int findStart = 0;
		for (int i=0; i<R; i++) {
			char[] in = br.readLine().toCharArray();
			for (int j=0; j<C; j++) {
				if (in[j] == '.') {
					map[i][j] = 0;
				} else if (in[j] == 'X') {
					map[i][j] = -1;
				} else {
					if (findStart == 0) {
						start[0] = i;
						start[1] = j;
						findStart = 1;
					} else {
						goal[0] = i;
						goal[1] = j;
					}
				}
				visit[i][j] = Integer.MAX_VALUE;
			}
		}
		
//		for (int i=0; i<R; i++) {
//			for (int j=0; j<C; j++) {
//				if (map[i][j] == 0 && visit[i][j] == Integer.MAX_VALUE) {
//					BFS(i, j);
//				}
//			}
//		}
		
		BFS2();
		
		System.out.println(ans);	
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	static class Move implements Comparable<Move>{
		int a, b;
		int val;
		
		public Move(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}

		@Override
		public int compareTo(Move o) {
			return this.val - o.val;
		}
	}
	
	public static void BFS2() {
		PriorityQueue<Move> pq = new PriorityQueue<>();
		int[][] check = new int[R][C];
		
		pq.add(new Move(start[0], start[1], 0));
		check[start[0]][start[1]] = 1;
		
		int a, b;
		int val;
		while (!pq.isEmpty()) {
			Move m = pq.poll();
			a = m.a; b = m.b;
			val = m.val;
			
			if (a==goal[0] && b==goal[1]) {
				ans = val;
				pq.clear();
				return;
			}
				
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0||na>=R||nb<0||nb>=C||check[na][nb] == 1)
					continue;
				
				pq.add(new Move(na, nb, Math.max(val, visit[na][nb])));
				check[na][nb] = 1;
			}
		}
	}
	
	public static void BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(i); q.add(j);
		visit[i][j] = 0;
		
		int a, b;
		while (!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=R||nb<0||nb>=C)
					continue;
				
				if (map[na][nb] == 0 && visit[na][nb] == Integer.MAX_VALUE) {
					q.add(na); q.add(nb);
					visit[na][nb] = 0;
				} else if (map[na][nb] == -1 && visit[na][nb] > visit[a][b] + 1) {
					q.add(na); q.add(nb);
					visit[na][nb] = visit[a][b] + 1;
				}
			}
			
		}
	}
	
	public static void printArr(int[][] arr) {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.printf("%2d ",arr[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	public static void printVisit() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.printf("%2d ",visit[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	public static void printAll() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.printf("%2d ",map[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
