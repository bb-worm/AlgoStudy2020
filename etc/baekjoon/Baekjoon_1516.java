package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1516 {
	
	static class Node{
		int idx;
		int time;
		int pretime;
		int isVisit;
		int indegree;
		ArrayList<Node> next;
		
		public Node(int idx) {
			this.idx = idx;
			this.isVisit = 0;
			this.indegree = 0;
			next = new ArrayList<>();
		}
		public void setTime(int time) {
			this.time = time;
			this.pretime = 0;
		}
	}
	
	public static Node[] node;
	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		node = new Node[N];
		for (int i=0; i<N; i++) {
			node[i] = new Node(i);
		}
		
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			node[i].setTime(time);
			
			while (st.hasMoreTokens()) {
				int val = Integer.parseInt(st.nextToken());
				if (val == -1)
					break;
				
				node[val-1].next.add(node[i]);
				node[i].indegree++;
			}
		}
		
		int visit = 0;
		while (visit < N) {
			
			for (int i=0; i<N; i++) {
				if (node[i].indegree==0 && node[i].isVisit==0) {
					visit++;
					node[i].isVisit = 1;
					
					for (Node n : node[i].next) {
						n.indegree--;
						n.pretime = Math.max(n.pretime, node[i].pretime+node[i].time);
					}
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.println(node[i].pretime + node[i].time);
		}
		
	}
}
