package week8;

import java.io.*;
import java.util.*;

public class Baekjoon_9944 {
	
	static class Node {
		int a, b;
		int dir;
		
		public Node (int a, int b, int dir) {
			this.a = a;
			this.b = b;
			this.dir = dir;
		}
	}
	
	static int N, M;
	static char[][] map;
	static int[][] visit;
	
	static int total; 
	static int ans;
	
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int t=1;
		String input;
		while ((input = br.readLine()) != null && input.length() != 0) {
			st = new StringTokenizer (input);
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new char[N][M];
			visit = new int[N][M];
			
			total = 0;
			ans = Integer.MAX_VALUE;
			
			for (int i=0; i<N; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j=0; j<M; j++) {
					if (map[i][j] == '.')
						total++;
				}
			}
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					if (map[i][j] == '.') {
						visit[i][j] = 1;
						DFS(i, j, 1, 0, -1);
						resetVisit();
					}
				}
			}
			if (ans == Integer.MAX_VALUE)
				ans = -1;
			
			System.out.printf("Case %d: %d\n", t, ans);
			t++;
		}
	}
	
	static void resetVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				visit[i][j] = 0;
			}
		}
	}
	
	static void DFS(int a, int b, int visitNum, int move, int dir) {
//		System.out.println(a + " " + b);
//		System.out.println(visitNum + " " + move + " " + dir);
//		printVisit();
		
		if (!check(a, b, dir)) {
			return;
		}
		
		if (move >= ans)
			return;
		
		if (visitNum >= total) {
			ans = Math.min(ans, move);
			return;
		}
		
		int na, nb;
		int nVisitNum;
		for (int k=0; k<4; k++) {
			if (k==dir)
				continue;
			
			int[] tmp;
			if (k<=1)
				tmp = new int[N];
			else
				tmp = new int[M];
			copy(tmp, a, b, k);
			
			int[] nextInfo = next(a, b, visitNum, k);
			na = nextInfo[0];
			nb = nextInfo[1];
			nVisitNum = nextInfo[2];
			
			if (na==a && nb==b) {
				continue;
			}
				
			DFS(na, nb, nVisitNum, move+1, k);
			uncopy(tmp, a, b, k);
		}
	}
	
	static void copy(int[] tmp, int a, int b, int dir) {
		if (dir <= 1) {
			for (int i=0; i<N; i++) {
				tmp[i] = visit[i][b];
			}
		} else {
			for (int i=0; i<M; i++) {
				tmp[i] = visit[a][i];
			}
		}
	}
	
	static void uncopy(int[] tmp, int a, int b, int dir) {
		if (dir <= 1) {
			for (int i=0; i<N; i++) {
				visit[i][b] = tmp[i];
			}
		} else {
			for (int i=0; i<M; i++) {
				visit[a][i] = tmp[i];
			}
		}
	}
	
	static void printVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(visit[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static int[] next(int a, int b, int visitNum, int k) {
		int[] result = new int[3];

		int na = a+da[k], nb = b+db[k];
		while (na>=0 && na<N && nb>=0 && nb<M && visit[na][nb]==0 && map[na][nb]!='*') {
			a += da[k];
			b += db[k];
			visitNum++;
			visit[na][nb] = 1;
			
			na += da[k];
			nb += db[k];
		}
		
		result[0] = a;
		result[1] = b;
		result[2] = visitNum;
		
		return result;
	}
	
	static boolean check(int a, int b, int dir) {
		// up, down
		if (dir <= 1) {
			for (int i=0; i<N; i++) {
				if (map[i][b] == '.' && visit[i][b] == 0)
					return true;
			}
			
			if (b-1 >= 0 && b+1 < M) {
				int leftZero = 0;
				int rightZero = 0;
				for (int i=0; i<N; i++) {
					if (map[i][b-1]=='.' && visit[i][b-1]==0)
						leftZero = 1;
					if (map[i][b+1]=='.' && visit[i][b+1]==0)
						rightZero = 1;
				}
				if (leftZero == 1 && rightZero == 1)
					return false;
			}
		}
		// left, right
		else {
			for (int i=0; i<M; i++) {
				if (map[a][i] == '.' && visit[a][i] == 0)
					return true;
			}
			
			if (a-1 >= 0 && a+1 < N) {
				int upZero = 0;
				int downZero = 0;
				for (int i=0; i<N; i++) {
					if (map[a-1][i]=='.' && visit[a-1][i]==0)
						upZero = 1;
					if (map[a+1][i]=='.' && visit[a+1][i]==0)
						downZero = 1;
				}
				if (upZero == 1 && downZero == 1)
					return false;
			}
		}
		
		return true;
	}
	
}
