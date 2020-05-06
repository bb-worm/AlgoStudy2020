package etc.baekjoon;

import java.io.*;
import java.util.*;

class Info {
	int i, j;
	int val;
	
	public Info(int i, int j, int val) {
		this.i = i;
		this.j = j;
		this.val = val;
	}

}

public class Baekjoon_1937 {
	
	public static int n;
	public static int[][] map;
	public static int[][] visit;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		map = new int[n][n];
		visit = new int[n][n];
		
		Info[] info = new Info[n*n];
		
		for (int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				info[i*n + j] = new Info(i, j, map[i][j]);
			}
		}
		
//		Arrays.sort(info, new Comparator<Info>() {
//			@Override
//			public int compare(Info o1, Info o2) {
//				return o1.val - o2.val;
//			}
//		});
		
		ans = 0;
		for (int i=0; i<n*n; i++) {
			int a = info[i].i;
			int b = info[i].j;
			if (visit[a][b] == 0) {
				ans = Math.max(ans, DFS(a, b, 1));
//				printVisit();
			}
		}
		
//		ans = 0;
//		for (int i=0; i<n; i++) {
//			for (int j=0; j<n; j++) {
//				if (visit[i][j] == 0) {
//					BFS(i, j);
////					printVisit();
//				}
//			}
//		}
		System.out.println(ans);
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static int DFS(int a, int b, int now) {
//		printVisit();
		
		int max = 1;
		
		int na, nb;
		for (int i=0; i<4; i++) {
			na = a + da[i];
			nb = b + db[i];
			
			if (na<0||na>=n||nb<0||nb>=n)
				continue;
			if (map[na][nb] <= map[a][b])
				continue;
			
			if (visit[na][nb] == 0) {
				visit[na][nb] = DFS(na, nb, now+1);
			}
			max = Math.max(max, visit[na][nb]+1);
		}
		
		visit[a][b] = max;
		
		return visit[a][b];
	}
	
	public static void printVisit() {
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				System.out.print(visit[i][j]);
			} System.out.println();
		} System.out.println();
	}
}
