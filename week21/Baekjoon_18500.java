package week21;

import java.io.*;
import java.util.*;

public class Baekjoon_18500 {
	
	static int R, C;
	static char[][] map;
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int height = R - Integer.parseInt(st.nextToken());
			
			// 막대기 던지기 
			throwStick(i%2, height);
		}
		
		printAll();
	}
	
	static void throwStick(int dir, int height) {
		if (dir == 0) { // left to right
			for (int i=0; i<C; i++) {
				if (map[height][i] == 'x') {
					drop(height, i);
					return;
				}
			}
		} else { // right to left
			for (int i=C-1; i>=0; i--) {
				if (map[height][i] == 'x') {
					drop(height, i);
					return;
				}
			}
		}
	}
	
	static void drop(int i, int j) {
		map[i][j] = '.'; // 미네랄 파괴 
		
		for (int k=0; k<4; k++) {
			int a = i + da[k];
			int b = j + db[k];
			
			if (a<0||a>=R||b<0||b>=C||map[a][b]=='.')
				continue;
			
			// 미네랄 존재하면 BFS
			// 두 개 이상 클러스터가 동시에 떨어지지 않으므로 만약 떠있는 거면 break 
			if (BFS(a, b))
				break;
		}
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static boolean BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		boolean[][] visit = new boolean[R][C];
		
		q.add(i); q.add(j);
		visit[i][j] = true;
		
		while (!q.isEmpty()) {
			int a = q.poll();
			int b = q.poll();
			
			if (a == R-1) { // 공중에 떠있지 않은 클러스터 
				q.clear();
				return false;
			}
			
			for (int k=0; k<4; k++) {
				int na = a + da[k];
				int nb = b + db[k];
				
				if (na<0||na>=R||nb<0||nb>=C||visit[na][nb]||map[na][nb]=='.')
					continue;
				
				q.add(na); q.add(nb);
				visit[na][nb] = true;
			}
		}
		
		// 공중에 떠있으면 아래 코드 실행 
		int minDiff = Integer.MAX_VALUE;
		
		for (int y=0; y<R; y++) {
			for (int x=0; x<C; x++) {
				if (visit[y][x]) {
					int diff = 0;
					boolean isFloor = true;
					
					for (int k=y+1; k<R; k++) {
						if (visit[k][x]) { // 같은 클러스터 
							isFloor = false;
							break;
						} else if (map[k][x] == '.')
							diff++;
						else
							break;
					}
						
					if (isFloor)
						minDiff = Math.min(minDiff, diff);
				}
			}
		}

		// 이동할 수 있는 최소 거리만큼 수직 이동 
		for (int y=R-1; y>=0; y--) {
			for (int x=0; x<C; x++) {
				if (visit[y][x]) {
					map[y][x] = '.';
					map[y+minDiff][x] = 'x';
				}
			}
		}
		
		return true;
	}
	
	static void printAll() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				sb.append(map[i][j]);
			}sb.append('\n');
		}
		System.out.println(sb);
	}
}
