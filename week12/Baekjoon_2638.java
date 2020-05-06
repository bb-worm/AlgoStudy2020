package week12;

import java.io.*;
import java.util.*;

public class Baekjoon_2638 {
	
	static class Cheese{
		int a, b;
		
		public Cheese(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static int N, M;
	static int[][] map;
	static int cheeseNum;
	static int[][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		
		ArrayList<Cheese> al = new ArrayList<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if (map[i][j] == 1)
					al.add(new Cheese(i, j));
			}
		}
		
		BFS(0, 0);
//		printVisit();
		
		Queue<Integer> q = new LinkedList<>();
		int time = 0;
		while (al.size() > 0) {
			time++;
			
			// 녹을 치즈 조사 
			int a, b;
			for (int i=al.size()-1; i>=0; i--) {
				a = al.get(i).a;
				b = al.get(i).b;
				
				int visitNum = 0;
				int na, nb;
				for (int k=0; k<4; k++) {
					na = a + da[k];
					nb = b + db[k];
					
					if (visit[na][nb] == 1)
						visitNum++;
				}
				
				if (visitNum >= 2){
					q.add(i);
				}
			}
			
			// 치즈 녹임
			// 녹였을 때 갇혀있던 공기가 외부와 연결되면 BFS
			while (!q.isEmpty()) {
				int idx = q.poll();
				
				a = al.get(idx).a;
				b = al.get(idx).b;
				
				int na, nb;
				for (int k=0; k<4; k++) {
					na = a + da[k];
					nb = b + db[k];
					
					// 외부와 연결 
					if (visit[na][nb]==0 && map[na][nb]==0)
						BFS(na, nb);
				}
				
				visit[a][b] = 1;
				al.remove(idx);
			}
//			printVisit();
		}
		System.out.println(time);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static void BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<>();
		q.add(i); q.add(j);
		visit[i][j] = 1;
		
		int a, b;
		while (!q.isEmpty()) {
			a = q.poll();
			b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=N||nb<0||nb>=M)
					continue;
				if (visit[na][nb]==1)
					continue;
				
				if (map[na][nb] == 0) {
					q.add(na); q.add(nb);
					visit[na][nb] = 1;
				}
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
}
