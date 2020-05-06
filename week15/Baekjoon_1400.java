package week15;

import java.io.*;
import java.util.*;

public class Baekjoon_1400 {
	
	static class Light {
		int dir; // 0: 동서, 1: 남북 
		int a, b;
		
		public Light (int dir, int a, int b) {
			this.dir = dir;
			this.a = a;
			this.b = b;
		}
	}
	
	static int m, n;
	static char[][] map;
	
	static Light[] light;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			
			if (m+n == 0) // 종료 조건 
				break;
			
			map = new char[m][n];
			int lightNum = 0;
			
			int startA=0, startB=0;
			
			for (int i=0; i<m; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j=0; j<n; j++) {
					if (Character.isDigit(map[i][j])) {
						lightNum++;
					} else if (map[i][j] == 'A') {
						startA = i; startB = j;
					}
				}
			}
			
			light = new Light[lightNum];
			for (int i=0; i<lightNum; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // idx
				int dir = st.nextToken().equals("-") ? 0 : 1;
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				light[i] = new Light(dir, a, b);
			}
			
			/////////// 입력 끝 //////////
			String ans = BFS(startA, startB); // BFS
			
			sb.append(ans).append('\n');
			br.readLine();
		}
		System.out.println(sb);
	}
	
	static int[] da = {0, 0, -1, 1};
	static int[] db = {-1, 1, 0, 0};
	
	static String BFS(int sa, int sb) {
		String result = "impossible";
		
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[m][n];
		int[][] time = new int[m][n];
		
		q.add(sa); q.add(sb);
		visit[sa][sb] = 1;
		time[sa][sb] = 0;
		
		int a, b, nowTime;
		while (!q.isEmpty()) {
			a = q.poll();
			b = q.poll();
			nowTime = time[a][b];
			
			if (map[a][b] == 'B') {
				result = Integer.toString(nowTime);
				q.clear();
				break;
			}
			
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (!canGo(na, nb))
					continue;
				if (visit[na][nb] != 0)
					continue;
				
				if (Character.isDigit(map[na][nb])) {
					int idx = map[na][nb] - '0';
					
					if (lightCheck(idx, nowTime+1, i)) {
						// 해당 방향으로 갈 수 있는 경우 
						q.add(na); q.add(nb);
						visit[na][nb] = 1;
						time[na][nb] = nowTime+1;
					} else {
						// 해당 방향으로 갈 수 없는 경우
						// 현재 위치 그대로 시간만 추가함 
						q.add(a); q.add(b);
						visit[a][b] = 1;
						time[a][b] = nowTime+1;
					}
				} else {
					// 방문하지 않은 # 
					q.add(na); q.add(nb);
					visit[na][nb] = 1;
					time[na][nb] = nowTime+1;
				}
			}
		}
		return result;
	}
	
	// 해당 교차로에서 특정 시간에 특정 방향으로 갈 수 있는지 
	static boolean lightCheck(int idx, int time, int i) {
		
		Light now = light[idx];
		
		int a = now.a;
		int b = now.b;
		time = (time-1)%(a + b) + 1;
		
		if (now.dir == 0) { // 초기에 동서 
			if (time<=a && i<=1) // 동서로 열림 && 동서로 가려고 함 
				return true;
			else if (time>a && i>=2) // 남북으로 열림 && 남북으로 가려고 함 
				return true;
			else
				return false;
		} else { // 초기에 남북 
			if (time<=b && i>=2) // 남북으로 열림 && 남북으로 가려고 함 
				return true;
			else if (time>b && i<=1) // 동서로 열림 && 동서로 가려고 함 
				return true;
			else
				return false;
		}
	}
	
	static boolean canGo(int a, int b) {
		if (a<0||a>=m||b<0||b>=n||map[a][b]=='.')
			return false;
		
		return true;
	}
}
