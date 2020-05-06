package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9205 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int[][] store = new int[n][2]; 
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				store[i][0] = Integer.parseInt(st.nextToken());
				store[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int ga = Integer.parseInt(st.nextToken());
			int gb = Integer.parseInt(st.nextToken());
			
			boolean canGo = false;
			
			if (distance(a, b, ga, gb) <= 1000) {
				canGo = true;
			}
			
			// BFS
			Queue<Integer> q = new LinkedList<>();
			int[] visit = new int[n];
			
			q.add(a); q.add(b);
			
			while (!q.isEmpty()) {
				a = q.poll(); b = q.poll();
				
				if (distance(a, b, ga, gb) <= 1000) {
					canGo = true;
					q.clear();
					break;
				}
				
				int na, nb;
				for (int i=0; i<n; i++) {
					if (visit[i] == 1)
						continue;
					
					na = store[i][0];
					nb = store[i][1];
					
					if (distance(a, b, na, nb) <= 1000) {
						q.add(na); q.add(nb);
						visit[i] = 1;
					}
				}
			}
			
			if (canGo) {
				sb.append("happy").append('\n');
			} else {
				sb.append("sad").append('\n');
			}
		}
		
		System.out.println(sb);
	}
	
	static int distance (int a1, int b1, int a2, int b2) {
		return Math.abs(a1-a2) + Math.abs(b1-b2);
	}

}
