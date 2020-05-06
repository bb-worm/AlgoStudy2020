package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1753 {
	
	static class Node implements Comparable<Node>{
		int idx;
		int distance;
		
		ArrayList<Node> next;
		ArrayList<Integer> weight;
		
		public Node(int idx) {
			this.idx = idx;
			this.next = new ArrayList<>();
			this.weight = new ArrayList<>();
			this.distance = Integer.MAX_VALUE;
		}
		
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
	
	static int V, E;
	static int K;
	
	static Node[] node;

 	public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st;
 		
 		st = new StringTokenizer(br.readLine());
 		V = Integer.parseInt(st.nextToken());
 		E = Integer.parseInt(st.nextToken());
 		
 		node = new Node[V+1];
 		for (int i=1; i<=V; i++)
 			node[i] = new Node(i);
 		
 		K = Integer.parseInt(br.readLine());
 		
 		int u, v, w;
 		for (int i=0; i<E; i++) {
 			st = new StringTokenizer(br.readLine());
 			u = Integer.parseInt(st.nextToken());
 			v = Integer.parseInt(st.nextToken());
 			w = Integer.parseInt(st.nextToken());
 			
 			node[u].next.add(node[v]);
 			node[u].weight.add(w);
 		}
 		
 		dijkstra();
 		
 		StringBuilder sb = new StringBuilder();
 		for (int i=1; i<=V; i++) {
 			if (node[i].distance == Integer.MAX_VALUE)
 				sb.append("INF").append('\n');
 			else
 				sb.append(node[i].distance).append('\n');
 		}
 		System.out.println(sb);
	}
 	
 	static void dijkstra() {
 		
 		PriorityQueue<Node> pq = new PriorityQueue<>();
 		int[] visit = new int[V+1];
 		
 		node[K].distance = 0;
 		
 		for (int i=1; i<=V; i++)
 			pq.add(node[i]);
 		
 		while (!pq.isEmpty()) {
 			Node now = pq.poll();
 			visit[now.idx] = 1;
 			
 			if (now.distance == Integer.MAX_VALUE)
 				continue;
 			
 			Node next;
 			int weight;
 			for (int i=0; i<now.next.size(); i++) {
 				next = now.next.get(i);
 				weight = now.weight.get(i);
 				
 				if (visit[next.idx] == 1)
 					continue;
 				
 				// relaxation
 				if (now.distance + weight < next.distance) {
 					next.distance = now.distance + weight;
 					pq.remove(next);
 					pq.add(next);
 				}
 			}
 		}
 	}
}
