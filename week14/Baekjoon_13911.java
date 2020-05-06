package week14;

import java.io.*;
import java.util.*;

public class Baekjoon_13911 {
	
	static final int MAX = 100000001;
	
	static class Node implements Comparable<Node>{
		int idx;
		ArrayList<Node> next;
		ArrayList<Integer> weight;
		
		int distance;
		
		public Node (int idx) {
			this.idx = idx;
			this.next = new ArrayList<>();
			this.weight = new ArrayList<>();
		}
		
		public int compareTo(Node n) {
			return this.distance - n.distance;
		}
	}
	
	static int V, E;
	static Node[] node;
	
	static int M, x;
	static int S, y;
	
	static int[] distanceM;
	static int[] distanceS;
	static int[] notHouse;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		node = new Node[V+1];
		
		distanceM = new int[V+1];
		distanceS = new int[V+1];
		notHouse = new int[V+1];
		
		for (int i=1; i<=V; i++) {
			node[i] = new Node(i);
		}
		
		int u, v, w;
		for (int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			node[u].next.add(node[v]);
			node[u].weight.add(w);
			node[v].next.add(node[u]);
			node[v].weight.add(w);
		}
		
		// MMMMM
		Node tmpM = new Node(0);
		tmpM.distance = 0;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			int idx = Integer.parseInt(st.nextToken());
			notHouse[idx] = 1;
			tmpM.next.add(node[idx]);
			tmpM.weight.add(0);
		}
		dijkstra(tmpM, x, 0);
		
		// SSSS
		Node tmpS = new Node(0);
		tmpS.distance = 0;
		
		st = new StringTokenizer(br.readLine());
		S = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<S; i++) {
			int idx = Integer.parseInt(st.nextToken());
			notHouse[idx] = 1;
			tmpS.next.add(node[idx]);
			tmpS.weight.add(0);
		}
		dijkstra(tmpS, y, 1);
		
		///////////////////////////
		
		ans = Integer.MAX_VALUE;
		
		for (int i=1; i<=V; i++) {
			if (notHouse[i]==0 && distanceM[i]!=0 && distanceS[i]!=0)
				ans = Math.min(ans, distanceM[i] + distanceS[i]);
		}
		
//		printDistance();
		
		if (ans == Integer.MAX_VALUE)
			ans = -1;
		System.out.println(ans);
	}
	
	static void dijkstra(Node tmp, int limit, int type) {
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		int[] visit = new int[V+1];
		
		for (int i=1; i<=V; i++)
			node[i].distance = MAX;
		
		pq.add(tmp);
		
		while (!pq.isEmpty()) {
			Node n = pq.poll();
			
			if (visit[n.idx]==1)
				continue;
			
			visit[n.idx] = 1;
			
			if (n.distance > limit) {
				pq.clear();
				return;
			}
			
			if (type==0)
				distanceM[n.idx] = n.distance;
			else
				distanceS[n.idx] = n.distance;
			
			for (int i=0; i<n.next.size(); i++) {
				Node next = n.next.get(i);
				int weight = n.weight.get(i);

				if (visit[next.idx]==0 && next.distance > n.distance+weight) {
					next.distance = n.distance+weight;
//					pq.remove(next);
					pq.add(next);
				}
			}
		}
//		printDistance();
	}
	
	static void printDistance() {
		for (int i=1; i<=V; i++) {
			System.out.print(i + " ");
		}System.out.println();
		for (int i=1; i<=V; i++) {
			System.out.print(distanceM[i] + " ");
		}System.out.println();
		for (int i=1; i<=V; i++) {
			System.out.print(distanceS[i] + " ");
		}System.out.println();
	}
}
