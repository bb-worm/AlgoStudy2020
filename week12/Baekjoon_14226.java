package week12;

import java.io.*;
import java.util.*;

public class Baekjoon_14226 {
	
	static class Board implements Comparable<Board>{
		int length;
		int copy;
		int time;
		
		public Board(int length, int copy, int time) {
			this.length = length;
			this.copy = copy;
			this.time = time;
		}
		
		public int compareTo(Board b) {
			return this.time - b.time;
		}
	}
	
	static int S;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		S = Integer.parseInt(br.readLine());
		BFS();
		System.out.println(ans);
	}
	
	static void BFS() {
		PriorityQueue<Board> pq = new PriorityQueue<>();
		int[][] visit = new int[S*2][S*2];
		
		pq.add(new Board(1, 0, 0));
		visit[1][0] = 1;

		int length, copy, time;
		while(!pq.isEmpty()) {
			Board b = pq.poll();
			length = b.length;
			copy = b.copy;
			time = b.time;
			
//			System.out.println(length + " " + copy + " " + time);
			
			if (length == S) {
				ans = time;
				pq.clear();
				return;
			}
			
			// copy & paste
			if (length*2 < S*2 && visit[length*2][length]==0) {
				pq.add(new Board(length*2, length, time+2));
				visit[length*2][length] = 1;
			}
			
			// paste
			if (length+copy < S*2 && copy > 0 && visit[length+copy][copy]==0) {
				pq.add(new Board(length+copy, copy, time+1));
				visit[length+copy][copy] = 1;
			}
			
			// delete
			if (length > 1 && visit[length-1][copy]==0) {
				pq.add(new Board(length-1, copy, time+1));
				visit[length-1][copy] = 1;
			}
		}
	}
}
