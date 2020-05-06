package week9;

import java.io.*;
import java.util.*;

public class Baekjoon_1525 {
	
	static int[][] goal = {{1,2,3}, {4,5,6}, {7,8,0}};
	static int[][] map = new int[3][3];
	
	static class Step {
		int a, b;
		int val;
		int[][] tmp;
		
		public Step(int a, int b, int val, int[][] tmp) {
			this.a = a;
			this.b = b;
			this.val = val;
			this.tmp = new int[3][3];
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					this.tmp[i][j] = tmp[i][j];
				}
			}
		}
	}
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int a=0, b=0;
		for (int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					a = i;
					b = j;
				}
			}
		}
		
		ans = -1;
		BFS(a, b);		
		System.out.println(ans);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void BFS(int i, int j) {
		Queue<Step> q = new LinkedList<>();
		Set<String> visit = new HashSet<>();
		
		q.add(new Step(i, j, 0, map));
		visit.add(makeStr(map));
		
		int a, b;
		while (!q.isEmpty()) {
			Step s = q.poll();
			a = s.a; b = s.b;
			
//			printAll(s.tmp);
			
			if (ansCheck(s.tmp)) {
				ans = s.val;
				return;
			}
			
			int na, nb;
			
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=3||nb<0||nb>=3)
					continue;
				
				s.tmp[a][b] = s.tmp[na][nb];
				s.tmp[na][nb] = 0;
				
				// already visit
				if (visit.contains(makeStr(s.tmp))) {
					s.tmp[na][nb] = s.tmp[a][b];
					s.tmp[a][b] = 0;
					continue;
				}
				
				q.add(new Step(na, nb, s.val+1, s.tmp));
				visit.add(makeStr(s.tmp));
				
				s.tmp[na][nb] = s.tmp[a][b];
				s.tmp[a][b] = 0;
			}
		}
	}
	
	static void printAll(int[][] tmp) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++)
				System.out.print(tmp[i][j]);
			System.out.println();
		}System.out.println();
	}
	
	static void copyArr(int[][] tmp, int[][] tmp2) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				tmp[i][j] = tmp2[i][j];
			}
		}
	}
	
	static String makeStr(int[][] tmp) {
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				sb.append(tmp[i][j]);
			}
		}
		
		return sb.toString();
	}
	
	static boolean visitCheck(int[][] visit, int[][] tmp) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (visit[i][j] != tmp[i][j])
					return false;
			}
		}
		return true;
	}
	
	static boolean ansCheck(int[][] tmp) {
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (goal[i][j] != tmp[i][j])
					return false;
			}
		}
		return true;
	}
}
