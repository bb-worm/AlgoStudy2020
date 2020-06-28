package week21;

import java.io.*;
import java.util.*;

public class Baekjoon_1445 {
	
	static int N, M;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int sa=0, sb=0;
		Queue<Integer> garbage = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				if (map[i][j] == 'S') {
					sa = i;
					sb = j;
				} else if (map[i][j] == 'g') {
					garbage.add(i);
					garbage.add(j);
				}
			}
		}
		
		// 쓰레기 인접 칸 전처리 
		int a, b;
		while (!garbage.isEmpty()) {
			a = garbage.poll();
			b = garbage.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				if (rangeCheck(na, nb) && map[na][nb] == '.') {
					map[na][nb] = 'n';
				}
			}
		}
		
		int[] ans = search(sa, sb);
		System.out.println(ans[0] + " " + ans[1]);
	}
	
	static class Move implements Comparable<Move>{
		int a, b;
		int passGarbage;
		int nearGarbage;
		
		public Move (int a, int b, int passGarbage, int nearGarbage) {
			this.a = a;
			this.b = b;
			this.passGarbage = passGarbage;
			this.nearGarbage = nearGarbage;
		}
		
		// 정렬 기준 설정 
		public int compareTo(Move m) {
			if (this.passGarbage == m.passGarbage) {
				return this.nearGarbage - m.nearGarbage;
			} else {
				return this.passGarbage - m.passGarbage;
			}
		}
	}
	
	static int[] search(int sa, int sb) {
		int[] result = new int[2];
		
		PriorityQueue<Move> pq = new PriorityQueue<>();
		boolean[][] visit = new boolean[N][M];
		
		pq.add(new Move(sa, sb, 0, 0));
		visit[sa][sb] = true;
		
		while (!pq.isEmpty()) {
			Move m = pq.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = m.a + da[k];
				nb = m.b + db[k];
				
				if (!rangeCheck(na, nb) || visit[na][nb])
					continue;
				if (map[na][nb] == 'F') { // 도착 지점 
					result[0] = m.passGarbage;
					result[1] = m.nearGarbage;
					pq.clear();
					break;
				} else if (map[na][nb] == '.') { // 빈 칸 
 					pq.add(new Move(na, nb, m.passGarbage, m.nearGarbage));
				} else if (map[na][nb] == 'n') { // 쓰레기 인접 칸 
					pq.add(new Move(na, nb, m.passGarbage, m.nearGarbage+1));
				} else if (map[na][nb] == 'g') { // 쓰레기 칸 
					pq.add(new Move(na, nb, m.passGarbage+1, m.nearGarbage));
				}
				visit[na][nb] = true;
			}
		}
		
		return result;
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static boolean rangeCheck(int i, int j) {
		if (i<0||i>=N||j<0||j>=M)
			return false;
		return true;
	}

}
