package week13;

import java.io.*;
import java.util.*;

public class Baekjoon_10216 {
	
	static class Camp{
		int x, y;
		int r;
		
		public Camp(int x, int y, int r) {
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	
	static int N;
	static int[][] connect;
	static Camp[] camp;
	static int[] visit;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			N = Integer.parseInt(br.readLine());
			connect = new int[N][N];
			camp = new Camp[N];
			visit = new int[N];
			
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				camp[i] = new Camp(x, y, r);
				
				// 직접 통신 체크 
				for (int j=i-1; j>=0; j--) {
					if (connectCheck(i, j)) {
						connect[i][j] = connect[j][i] = 1;
					}
				}
			}
//			printConnect();
			int ans = 0;
			
			for (int i=0; i<N; i++) {
				if (visit[i] == 0) {
					ans++;
					BFS(i);
				}
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void BFS(int idx) {
		Queue<Integer> q = new LinkedList<>();
		q.add(idx);
		visit[idx] = 1;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			for (int i=0; i<N; i++) {
				if (now==i)
					continue;
				
				if (visit[i]==0 && connect[now][i]==1) {
					q.add(i);
					visit[i] = 1;
				}
			}
		}
	}
	
	static boolean connectCheck(int i, int j) {
		int a1 = camp[i].x;
		int b1 = camp[i].y;
		int r1 = camp[i].r;
		
		int a2 = camp[j].x;
		int b2 = camp[j].y;
		int r2 = camp[j].r;
		
		if (distance(a1, b1, a2, b2) <= Math.pow(r1+r2, 2)) {
			return true;
		} else {
			return false;
		}
	}
	
	static double distance(int a1, int b1, int a2, int b2) {
		return Math.pow(a1-a2, 2) + Math.pow(b1-b2, 2);
	}
	
	static void printConnect() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(connect[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
}
