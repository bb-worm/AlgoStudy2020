package week8;

import java.io.*;
import java.util.*;

public class Baekjoon_6087  {
	
	static int R, C;
	static char[][] map;
	
	static int sa, sb;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
		C = sc.nextInt();
		R = sc.nextInt();
		
		map = new char[R][C];
		for (int i=0; i<R; i++) {
			map[i] = sc.next().toCharArray();
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'C') {
					sa = i;
					sb = j;
				}
			}
		}
//		printMap();
		
		int ans = BFS();
		System.out.println(ans);
	}
	
	static void printMap() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.printf("%2c ",map[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	static class Move {
		int a, b;
		int dir;
		int rotate;
		
		public Move(int a, int b, int dir, int rotate) {
			this.a = a;
			this.b = b;
			this.dir = dir;
			this.rotate = rotate;
		}
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static int BFS() {
		int result = Integer.MAX_VALUE;
		
		Queue<Move> q = new LinkedList<>();
		int[][][] visit = new int[R][C][4];
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				for (int k=0; k<4; k++)
					visit[i][j][k] = Integer.MAX_VALUE;
			}
		}
		
		q.add(new Move(sa, sb, -1, -1));
		visit[sa][sb][0] = 0;
		visit[sa][sb][1] = 0;
		visit[sa][sb][2] = 0;
		visit[sa][sb][3] = 0;
		
		int a, b, dir, rotate;
		while (!q.isEmpty()) {
			Move m = q.poll();
			a = m.a; b = m.b;
			dir = m.dir;
			rotate = m.rotate;
			
//			System.out.println(a + " " + b);
//			System.out.println(map[a][b]);
//			System.out.println(rotate);
//			printVisit(visit);
//			printMap();
//			
//			System.out.println(a + " " + b);
//			System.out.println(dir);
//			System.out.println(rotate);
//			System.out.println();
			
			if (map[a][b] == 'C' && (a!=sa || b!=sb)) {
				result = Math.min(result, rotate);
			}
			
			int na, nb;
			int nrotate;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				nrotate = rotate;
				if (dir != i)
					nrotate++;
				
				if (na<0||na>=R||nb<0||nb>=C||map[na][nb]=='*')
					continue;
				
				if (visit[na][nb][i] <= nrotate)
					continue;
				
				q.add(new Move(na, nb, i, nrotate));
				visit[na][nb][i] = nrotate;
			}
		}
		
		if (result == Integer.MAX_VALUE) {
			result = 0;
		}
		return result;
	}
	
	static void printVisit(int[][][] visit) {
		for (int i=0; i<visit.length; i++) {
			for (int k=0; k<4; k++) {
				for (int j=0; j<visit[0].length; j++) {
					if (visit[i][j][k] == Integer.MAX_VALUE)
						System.out.printf("%2d ", -1);
					else
						System.out.printf("%2d ",visit[i][j][k]);	
				}System.out.print("    ");
			}System.out.println();
		}System.out.println();
	}
}
