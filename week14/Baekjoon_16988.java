package week14;

import java.io.*;
import java.util.*;

public class Baekjoon_16988 {
	
	static int N, M;
	static int[][] map;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		ans = 0;
		putStone(0, 0, 0);
		System.out.println(ans);
	}

	static void putStone(int a, int b, int total) {
		if (total >= 2) {
			ans = Math.max(ans, BFS());
			return;
		}
		
		if (a >= N)
			return;
		
		if (b >= M) {
			putStone(a+1, 0, total);
			return;
		}
		
		if (map[a][b] == 0) {
			map[a][b] = 1;
			putStone(a, b+1, total+1);
			map[a][b] = 0;
		}
		putStone(a, b+1, total);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static int BFS() {
		int result = 0;
		
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[N][M];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (map[i][j] == 2 && visit[i][j] == 0) {
					q.add(i); q.add(j);
					visit[i][j] = 1;
					
					boolean getPoint = true;
					int a, b;
					int total = 0;
					while (!q.isEmpty()) {
						a = q.poll(); b = q.poll();
						total++;
						
						int na, nb;
						for (int k=0; k<4; k++) {
							na = a + da[k];
							nb = b + db[k];
							
							if (na<0||na>=N||nb<0||nb>=M||map[na][nb]==1||visit[na][nb]==1)
								continue;
							
							// 빈 칸 
							if (map[na][nb] == 0) {
								getPoint = false;
								continue;
							}
							
							// 2
							q.add(na); q.add(nb);
							visit[na][nb] = 1;
						}
					}
					
					if (getPoint) {
						result += total;
					}
				}
			}
		}
		
		return result;
	}
}
