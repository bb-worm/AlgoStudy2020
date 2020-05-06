package week13;

import java.io.*;
import java.util.*;

public class Baekjoon_4179 {
	
	static class Point {
		int a, b;
		int type;
		
		public Point(int a, int b, int type) {
			this.a = a;
			this.b = b;
			this.type = type;
		}
	}
	
	static int R, C;
	static char[][] map;
	static int[][] visit;
	
	static Point start;
	static ArrayList<Point> fire = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new int[R][C];
		for (int i=0; i<R; i++)
			Arrays.fill(visit[i], Integer.MAX_VALUE);
		
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'J') {
					start = new Point(i, j, 1);
				} else if (map[i][j] == 'F') {
					fire.add(new Point(i, j, 0));
				}
			}
		}
		
		int ans = BFS();
		
		if (ans == -1)
			System.out.println("IMPOSSIBLE");
		else
			System.out.println(ans);
//		printVisit();
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static int BFS() {
		Queue<Point> q = new LinkedList<>();
		
		
		for (int i=0; i<fire.size(); i++) {
			q.add(fire.get(i));
			visit[fire.get(i).a][fire.get(i).b] = 1;
		}
		q.add(start);
		visit[start.a][start.b] = 1;
		
		while (!q.isEmpty()) {
			Point p = q.poll();
			int a = p.a;
			int b = p.b;
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=R||nb<0||nb>=C) {
					if (p.type == 1) {
						q.clear();
						return visit[a][b];
					} else continue;
				}
				
				if (map[na][nb]!='.' || visit[na][nb]<=visit[a][b]+1)
					continue;
				
				q.add(new Point(na, nb, p.type));
				visit[na][nb] = visit[a][b] + 1;
			}
		}
		return -1;
	}
	
	static void printVisit() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				if (visit[i][j] == Integer.MAX_VALUE)
					System.out.print(0 + " ");
				else
					System.out.print(visit[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
}
