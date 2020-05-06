package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1167 {
		
	static class Node {
		int idx;
		ArrayList<Node> next;
		ArrayList<Integer> length;
		
		boolean isVisit;
				
		public Node (int idx) {
			this.idx = idx;
			this.next = new ArrayList<>();
			this.length = new ArrayList<>();
			this.isVisit = false;
		}
	}
	
	static int V;
	static Node[] node;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		V = Integer.parseInt(br.readLine());
		node = new Node[V+1];
		
		for (int i=1; i<=V; i++)
			node[i] = new Node(i);
		
		for (int i=0; i<V; i++) {
			st = new StringTokenizer(br.readLine());
			
			int idx = Integer.parseInt(st.nextToken());
			
			int next, length;;
			while ((next = Integer.parseInt(st.nextToken())) != -1) {
				node[idx].next.add(node[next]);
				
				length = Integer.parseInt(st.nextToken());
				node[idx].length.add(length);
			}
		}
		
		node[1].isVisit = true;
		DFS(node[1]);
		System.out.println(ans);
	}
	
	static int DFS(Node n) {
		
		ArrayList<Integer> al = new ArrayList<>();
		
		Node next;
		int length;
		for (int i=0; i<n.next.size(); i++) {
			next = n.next.get(i);
			length = n.length.get(i);
			
			if (next.isVisit)
				continue;
			
			next.isVisit = true;
			al.add(length + DFS(next));
		}
		
		if (al.size() == 0) {
			return 0;
		}
		else if (al.size() == 1) {
			ans = Math.max(ans, al.get(0));
			return al.get(0);
		}
		else {
			al.sort(new Comparator<Integer>() {
				public int compare(Integer i, Integer j) {
					return j - i;
				}
			});
			ans = Math.max(ans, al.get(0) + al.get(1));
			return al.get(0);
		}
	}
}
