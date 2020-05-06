package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1916 {
	
	static class Node implements Comparable<Node>{
		int idx;
		long val;
		ArrayList<Node> next;
		ArrayList<Integer> weight;
		
		public Node (int idx) {
			this.idx = idx;
			this.val = (long)Math.pow(10, 10);
			this.next = new ArrayList<>();
			this.weight = new ArrayList<>();
		}
		
		public int compareTo(Node n) {
			if (this.val < n.val)
				return -1;
			else if (this.val > n.val)
				return 1;
			else
				return 0;
		}
	}
	
	static int N, M;
	
	static int start, end;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		Node[] node = new Node[N];
		int[] visit = new int[N];
		
		for (int i=0; i<N; i++)
			node[i] = new Node(i);
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken())-1;
			int e = Integer.parseInt(st.nextToken())-1;
			int weight = Integer.parseInt(st.nextToken());
			node[s].next.add(node[e]);
			node[s].weight.add(weight);
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken())-1;
		end = Integer.parseInt(st.nextToken())-1;
		
		node[start].val = 0;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			pq.add(node[i]);
		}
		long ans = Long.MAX_VALUE;
		while (!pq.isEmpty()) {
			
			Node n = pq.poll();
			visit[n.idx] = 1;
			
			if (n.idx == end) {
				ans = n.val;
				pq.clear();
				break;
			}
			
			for (int i=0; i<n.next.size(); i++) {
				Node next = n.next.get(i);
				int weight = n.weight.get(i);
				
				if (visit[next.idx] == 1)
					continue;
				
				if (next.val > n.val+weight) {
					next.val = n.val+weight;
					pq.remove(next);
					pq.add(next);
				}
			}
		}
		System.out.println(ans);
	}
}
