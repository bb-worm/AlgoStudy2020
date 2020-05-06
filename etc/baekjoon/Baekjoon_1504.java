package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1504 {
	
	static final int MAX_VAL = 200000001; 
	
	static class Node implements Comparable<Node> {
		int idx;
		int distance;
		
		ArrayList<Node> next;
		ArrayList<Integer> weight;
		
		public Node(int idx) {
			this.idx = idx;
			this.next = new ArrayList<>();
			this.weight = new ArrayList<>();
		}
		
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
	
	static int N, E;
	static Node[] node;
	
	static int v1, v2;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		node = new Node[N];
		
		for (int i=0; i<N; i++)
			node[i] = new Node(i);
		
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken());
			
			node[a].next.add(node[b]);
			node[a].weight.add(c);
			node[b].next.add(node[a]);
			node[b].weight.add(c);
		}
		
		st = new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken()) - 1;
		v2 = Integer.parseInt(st.nextToken()) - 1;
		
		int ans = Math.min(dijkstra(0, v1, 0), dijkstra(0, v2, 0));
		System.out.println(ans);
	}

	static int dijkstra(int start, int goal, int depth) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] visit = new int[N];
		
		for (int i=0; i<N; i++) {
			if (i==start)
				node[i].distance = 0;
			else
				node[i].distance = MAX_VAL;
			
			pq.add(node[i]);
		}
		
		while (!pq.isEmpty()) {
			Node now = pq.poll();
			visit[now.idx] = 1;
			
			if (now.distance == MAX_VAL) {
				pq.clear();
				break;
			}
			
			if (now.idx == goal) {
				pq.clear();
				
				if (depth == 0) {
					if (goal == v1)
						return now.distance + dijkstra(v1, v2, 1);
					else
						return now.distance + dijkstra(v2, v1, 1);
				} else if (depth == 1) {
					return now.distance + dijkstra(goal, N-1, 2);
				} else {
					return now.distance;
				}
			}
			
			for (int i=0; i<now.next.size(); i++) {
				Node next = now.next.get(i);
				int weight = now.weight.get(i);
				
				// relaxation
				if (visit[next.idx]==0 && next.distance > now.distance + weight) {
					next.distance = now.distance + weight;
					pq.remove(next);
					pq.add(next);
				}
			}
		}
		return -1;
	}
	
	static void printDistance() {
		for (int i=0; i<N; i++) {
			System.out.println(i + " " + node[i].distance);
		}System.out.println();
	}
}
