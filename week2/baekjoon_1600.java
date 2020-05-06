package week2;

import java.io.*;
import java.util.*;

class Monkey {
	int a, b;
	int k;
	
	public Monkey(int a, int b, int k) {
		this.a = a;
		this.b = b;
		this.k = k;
	}
}

public class baekjoon_1600 {
	
	public static int K;
	public static int W, H;
	public static int[][] map;
	public static int[][][] visit;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		K = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		visit = new int[H][W][K+1];
		
		for (int i=0; i<H; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<W; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = -1;
		if (W==1 && H==1)
			ans = 0;
		else
			BFS();
		System.out.println(ans);
	}
	
	public static int[] da = {-1, 1, 0, 0, -1, -2, -2, -1, 1, 2, 2, 1};
	public static int[] db = {0, 0, -1, 1, -2, -1, 1, 2, -2, -1, 1, 2};
	
	public static void BFS() {
		Queue<Monkey> q = new LinkedList<Monkey>();
		
		visit[0][0][K] = 1;
		q.add(new Monkey(0, 0, K));
		
		Monkey m;
		while(!q.isEmpty()) {
			m  = q.poll();
			
			int na, nb;
			int nk;
			for (int i=0; i<12; i++) {
				na = m.a + da[i];
				nb = m.b + db[i];
				nk = m.k;
				
				if (i>=4) {
					nk--;
				}
				
				if (!check(na, nb, nk))
					continue;
				
				if (na == H-1 && nb == W-1) {
					ans = visit[m.a][m.b][m.k];
					q.clear();
					return;
				}
				
				q.add(new Monkey(na, nb, nk));
				visit[na][nb][nk] = visit[m.a][m.b][m.k] + 1;
//				System.out.println(nk);
//				printVisit();
//				printK();
			}
		}
	}
	
	public static boolean check(int a, int b, int k) {
		if (a<0||a>=H||b<0||b>=W)
			return false;
		if (map[a][b] == 1)
			return false;
		if (k<0)
			return false;
		if (visit[a][b][k] != 0)
			return false;
		return true;
	}
	
	public static void printVisit() {
		for (int i=0; i<H; i++) {
			for (int j=0; j<W; j++) {
				System.out.print(visit[i][j]+ " ");
			}System.out.println();
		}System.out.println();
	}
}
