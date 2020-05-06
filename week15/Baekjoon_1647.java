package week15;

import java.io.*;
import java.util.*;

public class Baekjoon_1647 {
	
	static class Node {
		Node parent;
		
		public Node() {
			this.parent = this;
		}
		
		public Node findParent() {
			if (this.parent == this) {
				return this;
			} else {
				return this.parent = this.parent.findParent();
			}
		}
	}
	
	static class Edge implements Comparable<Edge>{
		Node n1, n2;
		int weight;
		
		public Edge(Node idx1, Node idx2, int weight) {
			this.n1 = idx1;
			this.n2 = idx2;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return this.weight - e.weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		Node[] node = new Node[N+1];
		
		for (int i=1; i<=N; i++)
			node[i] = new Node();
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			Edge e = new Edge(node[A], node[B], W);
			pq.add(e);
		}
		
		int ans = 0;
		int max = 0;
		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			
			if (e.n1.findParent() != e.n2.findParent()) {
				e.n1.parent.findParent().parent = e.n2.findParent();
				ans += e.weight;
				max = Math.max(max, e.weight);
			}
		}
		
		ans -= max;
		System.out.println(ans);
	}
}
