package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baekjoon_2075 {

	static class Info implements Comparable<Info>{
		int a, b;
		int val;
		
		public Info(int a, int b, int val) {
			this.a = a;
			this.b = b;
			this.val = val;
		}
		
		public int compareTo(Info i) {
			return i.val - this.val;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		PriorityQueue<Info> pq = new PriorityQueue<Info>();
		for (int j=0; j<N; j++) {
			pq.add(new Info(N-1, j, map[N-1][j]));
		}
		
		Info max;
		int a, b;
		for (int i=0; i<N-1; i++) {
			
			max = pq.poll();
			a = max.a;
			b = max.b;
			
			if (a-1 >= 0) {
				pq.add(new Info(a-1, b, map[a-1][b]));
			}
		}
		
		int ans = pq.peek().val;
		pq.clear();
		
		System.out.println(ans);
	}
}
