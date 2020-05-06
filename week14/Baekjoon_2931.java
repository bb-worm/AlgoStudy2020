package week14;

import java.io.*;
import java.util.*;

public class Baekjoon_2931 {
	
	static int R, C;
	static char[][] map;
	
	static int ga, gb;
	static char block;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		
		int ma=0, mb=0;
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j=0; j<C; j++) {
				if (map[i][j] == 'M') {
					ma = i;
					mb = j;
				}
			}
		}
		
		BFS(ma, mb);
		System.out.println(ga + " " + gb + " " + block);
	}
	
	static int[] da = {-1, 0, 1, 0};
	static int[] db = {0, 1, 0, -1};
	
	static void BFS(int ma, int mb) {
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[R][C];
		
		int a, b;
		for (int i=0; i<4; i++) {
			a = ma + da[i];
			b = mb + db[i];
			
			if (valCheck(a, b, (i+2)%4)) {
				q.add(a); q.add(b);
				visit[a][b] = 1;
			}
		}
		
		while (!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			int na, nb;
			for (int i=0; i<4; i++) {
				
				// 해당 지점에서 갈 수 있는 방향인지 체크 
				if (!valCheck(a, b, i))
					continue;
				
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0||na>=R||nb<0||nb>=C||visit[na][nb]==1)
					continue;
				
				// answer point
				// 갈 수 있는 지점인데 빈 칸 -> 정답 지점 
				if (map[na][nb] == '.') {
					getAns(na, nb);
					q.clear();
					return;
				}
				
				q.add(na); q.add(nb);
				visit[na][nb] = 1;
			}
		}
	}
	
	static void getAns(int a, int b) {
		
		ga = a+1;
		gb = b+1;
		
		boolean[] dir = {false, false, false, false};
		
		int na, nb;
		for (int i=0; i<4; i++) {
			na = a + da[i];
			nb = b + db[i];
			
			if (valCheck(na, nb, (i+2)%4)) {
				dir[i] = true;
			}
		}
		
		if (dir[0] && dir[1] && dir[2] && dir[3])
			block = '+';
		else if (dir[0] && dir[2])
			block = '|';
		else if (dir[1] && dir[3])
			block = '-';
		else if (dir[1] && dir[2])
			block = '1';
		else if (dir[0] && dir[1])
			block = '2';
		else if (dir[0] && dir[3])
			block = '3';
		else if (dir[2] && dir[3])
			block = '4';
	}
	
	static boolean valCheck(int a, int b, int dir) {
		if (a<0||a>=R||b<0||b>=C)
			return false;
		
		char val = map[a][b];
		
		// up
		if (dir == 0) {
			if (val=='|' || val=='+' || val=='2' || val=='3')
				return true;
			else
				return false;
		} else if (dir == 2) { // down
			if (val=='|' || val=='+' || val=='1' || val=='4')
				return true;
			else
				return false;
		} else if (dir == 3) { // left
			if (val=='-' || val=='+' || val=='3' || val=='4')
				return true;
			else
				return false;
		} else { // right
			if (val=='-' || val=='+' || val=='1' || val=='2')
				return true;
			else
				return false;
		}
	}
}
