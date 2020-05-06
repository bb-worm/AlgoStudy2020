package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_2636 {
	
	static int N, M;
	static int[][] map;
	
	static int remainCheese;
	
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
		
		//////////////////////////////////////
		
		int preCheese = 0;
		
		int time = 0;
		while (BFS()) {
			time++;
			preCheese = remainCheese;
			remainCheese = 0;
//			printAll();
		}
		
		System.out.println(time);
		System.out.println(preCheese);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static boolean BFS() {
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[N][M];
		
		q.add(0); q.add(0);
		visit[0][0] = 1;
		
		int a, b;
		while(!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			int na, nb;
			for (int i=0; i<4; i++) {
				na = a + da[i];
				nb = b + db[i];
				
				if (na<0||na>=N||nb<0||nb>=M||visit[na][nb]!=0)
					continue;
				
				if (map[na][nb] > 0) {
					map[na][nb] = 0;
					remainCheese++;
				} else {
					q.add(na); q.add(nb);
				}
				visit[na][nb] = 1;
			}
		}
		if (remainCheese == 0)
			return false;
		else 
			return true;
	}
	
	static void printAll() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
}
