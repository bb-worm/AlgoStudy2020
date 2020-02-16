package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_9376 {
	
	public static int h, w;
	public static char[][] map;
	
	public static int[] pa = new int[3];
	public static int[] pb = new int[3];
	public static int[][][] cost;
	
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());
			h = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			map = new char[h+2][w+2];
			cost = new int[h+2][w+2][3];
			
			int pIdx = 0;
			
			for (int i=1; i<=h; i++) {
				char[] str = br.readLine().toCharArray();
				for (int j=1; j<=w; j++) {
					map[i][j] = str[j-1];
					
					if (map[i][j] == '$') {
						pa[pIdx] = i;
						pb[pIdx++] = j;
						map[i][j] = '.';
					}
				}
			}
			pa[2] = 0; pb[2] = 0;
			
			for (int i=0; i<h+2; i++) {
				for (int j=0; j<w+2; j++) {
					for (int k=0; k<3; k++) {
						cost[i][j][k] = -1;
					}
				}
			}
			ans = Integer.MAX_VALUE;
			
			BFS(0);
			BFS(1);
			BFS(2);
//			printCost();
			getAns();
			
			System.out.println(ans);
		}
	}
	
	public static void getAns() {
		int sum;
		for (int i=0; i<h+2; i++) {
			for (int j=0; j<w+2; j++) {
				if (map[i][j] == '*')
					continue;
				
				sum = 0;
				for (int k=0; k<3; k++) {
					sum += cost[i][j][k];
				}
				if (map[i][j] == '#')
					sum -= 2;
				
				ans = Math.min(ans, sum);
			}
		}
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void BFS(int type) {
		Queue<Integer> q = new LinkedList<>();

		q.add(pa[type]); q.add(pb[type]);
		cost[pa[type]][pb[type]][type]  = 0;
		
		int a, b;
		int nowCost;
		while (!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			nowCost = cost[a][b][type];
			
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0||na>=h+2||nb<0||nb>=w+2)
					continue;
				if (map[na][nb] == '*')
					continue;
				
				int nextCost = cost[na][nb][type];
				
				if (nextCost == -1) {
					if (map[na][nb] == '#') {
						cost[na][nb][type] = nowCost + 1;
					} else {
						cost[na][nb][type] = nowCost;
					}
				} else {
					if (map[na][nb] == '#') {
						if (nextCost <= nowCost+1)
							continue;
						cost[na][nb][type] = nowCost + 1;
					} else {
						if (nextCost <= nowCost)
							continue;
						cost[na][nb][type] = nowCost;
					}
				}
				q.add(na); q.add(nb);
			}
		}
	}
	
	public static void printCost() {
		for (int i=0; i<h+2; i++) {
			for (int k=0; k<3; k++) {
				for (int j=0; j<w+2; j++) {
					System.out.printf("%2d ", cost[i][j][k]);
				}System.out.print("      ");
			}System.out.println();
		}System.out.println();
	}
}
