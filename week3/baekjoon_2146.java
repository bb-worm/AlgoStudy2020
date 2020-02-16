package week3;

import java.io.*;
import java.util.*;

public class baekjoon_2146 {
	
	public static int N;
	public static int[][] map;
	public static int[][] visit;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int k = 2;
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (map[i][j] == 1) {
					BFS(i, j, k);
					k++;
				}
			}
		}
		
		ans = Integer.MAX_VALUE;
		for (int nk=2; nk<k; nk++) {
			for (int y=0; y<N; y++) {
				for (int x=0; x<N; x++) {
					if (map[y][x] == nk) {
						BFS2(y, x, nk);
						resetVisit();
					}
				}
			}
		}
		System.out.println(ans);
	}
	
	public static void BFS2(int i, int j, int val) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(i); q.add(j);
		visit[i][j] = 1;
		
		int a, b;
		while (!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			if (visit[a][b]-1 >= ans) {
				q.clear();
				return;
			}
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=N)
					continue;
				if (visit[na][nb] != 0)
					continue;
				if (map[na][nb] == val)
					continue;
				
				// make land
				if (map[na][nb] == 0) {
					q.add(na); q.add(nb);
					visit[na][nb] = visit[a][b] + 1;
				}
				// new land
				else if (map[na][nb] != val) {
					q.clear();
					ans = Math.min(ans, visit[a][b]-1);
//					printVisit();
					return;
				}
			}
		}
	}
	
	public static void resetVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				visit[i][j] = 0;
			}
		}
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void BFS(int i, int j, int val) {
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(i); q.add(j);
		map[i][j] = val;
		
		int a, b;
		while(!q.isEmpty()) {
			a = q.poll();
			b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=N)
					continue;
				if (map[na][nb] != 1)
					continue;
				
				q.add(na); q.add(nb);
				map[na][nb] = val;
			}
		}
	}
	
	public static void printVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(visit[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	public static void printAll() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}System.out.println();
	}
}

