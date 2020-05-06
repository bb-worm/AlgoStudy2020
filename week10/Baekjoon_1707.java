package week10;

import java.io.*;
import java.util.*;

public class Baekjoon_1707 {
	
	static class Node {
		int idx;
		int set;
		ArrayList<Node> next;
		
		public Node (int idx) {
			this.idx = idx;
			this.set = -1;
			this.next = new ArrayList<>();
		}
	}
	
	static int V, E;
	static Node[] node;
	static int[] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			node = new Node[V+1];
			visit = new int[V+1];
			
			for (int i=1; i<=V; i++) {
				node[i] = new Node(i);
			}
			
			int a, b;
			for (int i=0; i<E; i++) {
				st = new StringTokenizer(br.readLine());
				
				a = Integer.parseInt(st.nextToken());
				b = Integer.parseInt(st.nextToken());
				
				node[a].next.add(node[b]);
				node[b].next.add(node[a]);
			}
			
			boolean canMake = true;
			for (int i=1; i<=V; i++) {
				if (visit[i] == 0) {
					visit[i] = 1;
					node[i].set = 0;
					if(!DFS(node[i])) {
						canMake = false;
						break;
					}
				}
			}
			if (canMake)
				sb.append("YES").append('\n');
			else
				sb.append("NO").append('\n');
			
//			for (int i=1; i<=V; i++) {
//				System.out.println(i + " " + node[i].set);
//			}
			
		}
		System.out.println(sb);
	}
	
	static boolean DFS(Node now) {
		Node next;
		for (int i=0; i<now.next.size(); i++) {
			next = now.next.get(i);
			
			if (visit[next.idx] == 1) {
				if (next.set == now.set)
					return false;
				else
					continue;
			}
			
			visit[next.idx] = 1;
			next.set = (now.set + 1) % 2;
			if (!DFS(next)) {
				return false;
			}
		}
		
		return true;
	}
}
