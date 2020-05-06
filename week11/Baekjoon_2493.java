package week11;

import java.io.*;
import java.util.*;

public class Baekjoon_2493 {
	
	static class Tower implements Comparable<Tower>{
		int height;
		int preTowerNum;
		
		public Tower(int height) {
			this.height = height;
		}
		
		public int compareTo(Tower t) {
			return this.height - t.height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Tower[] tower = new Tower[N+1];
		
		// create tower
		st = new StringTokenizer(br.readLine());
		int h;
		for (int i=1; i<=N; i++) {
			h = Integer.parseInt(st.nextToken());
			tower[i] = new Tower(h);
		}
		
		// find receiving tower
		PriorityQueue<Tower> pq = new PriorityQueue<>();
		for (int i=N; i>=1; i--) {
			
			h = tower[i].height;
			
			while (!pq.isEmpty() && h >= pq.peek().height) {
				pq.poll().preTowerNum = i;
			}
			
			pq.add(tower[i]);
			
		}
		
		// no receiver
		while (!pq.isEmpty()) {
			pq.poll().preTowerNum = 0;
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		for (int i=1; i<=N; i++) {
			sb.append(tower[i].preTowerNum).append(' ');
		}
		System.out.println(sb);
	}
}
