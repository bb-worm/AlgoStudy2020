package week3;

import java.io.*;
import java.util.*;

public class baekjoon_1726 {
	
	public static int M, N;
	public static int[][] map;
	public static int[][][] visit;
	
	public static int r, c, dir;
	
	public static int goalR, goalC, goalDir;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][N];
		visit = new int[M][N][5];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken()) - 1;
		c = Integer.parseInt(st.nextToken()) - 1;
		dir = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		goalR = Integer.parseInt(st.nextToken()) - 1;
		goalC = Integer.parseInt(st.nextToken()) - 1;
		goalDir = Integer.parseInt(st.nextToken());
		
		ans = 0;
		BFS();
		System.out.println(ans);
	}
	
	public static int[] da = {0, 0, 0, 1, -1};
	public static int[] db = {0, 1, -1, 0, 0};
	
	public static void BFS() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(r); q.add(c); q.add(dir);
		visit[r][c][dir] = 1;
		
		int a, b, d;
		int move;
		while(!q.isEmpty()) {
			a = q.poll(); b = q.poll(); d = q.poll();
			move = visit[a][b][d];
			
			if (a==goalR && b==goalC && d==goalDir) {
				ans = move - 1;
//				printVisit();
				q.clear();
				return;
			}
			
//			회전 
			int nd;
			nd = turnLeft(d);
			if (visit[a][b][nd] == 0) {
				q.add(a); q.add(b); q.add(nd);
				visit[a][b][nd] = move + 1;
//				System.out.println(a + " " + b);
//				System.out.println("left");
//				printVisit();
			}
			nd = turnRight(d);
			if (visit[a][b][nd] == 0) {
				q.add(a); q.add(b); q.add(nd);
				visit[a][b][nd] = move + 1;
//				System.out.println(a + " " + b);
//				System.out.println("right");
//				printVisit();
			}
			
//			전진 
			int na = a, nb = b;
			for (int i=0; i<3; i++) {
				
				na+=da[d];
				nb+=db[d];
				
				if (!canGo(na, nb, d)) {
					break;
				}
				
				if (visit[na][nb][d] == 0) {
					q.add(na); q.add(nb); q.add(d);
					visit[na][nb][d] = move + 1;
				}
			}
		}
	}
	
	public static boolean canGo(int a, int b, int d) {
		return a>=0 && a<M && b>=0 && b<N && map[a][b] == 0;
	}
	
	public static void printVisit() {
		
		for (int i=0; i<M; i++) {
			for (int k=1; k<=4; k++) {
				for (int j=0; j<N; j++) {
					System.out.printf("%2d ",visit[i][j][k]);
				}
				System.out.print("     ");
			}
			System.out.println();
		}System.out.println();
	}
	
	public static int turnRight(int d) {
		switch(d) {
		case 1:
			return 3;
		case 2:
			return 4;
		case 3:
			return 2;
		default:
			return 1;
		}
	}
	
	public static int turnLeft(int d) {
		switch(d) {
		case 1:
			return 4;
		case 2:
			return 3;
		case 3:
			return 1;
		default:
			return 2;
		}
	}
}
