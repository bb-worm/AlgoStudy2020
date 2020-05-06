package week11;

import java.io.*;
import java.util.*;

public class Baekjoon_1967 {
	
	static class Node {
		int idx;
		ArrayList<Node> next;
		ArrayList<Integer> weight;
		
		public Node(int idx) {
			this.idx = idx;
			this.next = new ArrayList<>();
			this.weight = new ArrayList<>();
		}
	}
	
	static int n;
	static Node[] node;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		node = new Node[n+1];
		for (int i=1; i<=n; i++) {
			node[i] = new Node(i);
		}
		
		int nowIdx, nextIdx, weight;
		for (int i=0; i<n-1; i++) {
			st = new StringTokenizer(br.readLine());
			nowIdx = Integer.parseInt(st.nextToken());
			nextIdx = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			
			node[nowIdx].next.add(node[nextIdx]);
			node[nowIdx].weight.add(weight);
		}
		
		ans = 0;
		DFS(1);
//		ans = Math.max(ans, DFS(1));
		System.out.println(ans);
	}
	
	static int DFS(int now) {
		
		if (node[now].next.size() == 0) {
			return 0;
		}
		
		ArrayList<Integer> al = new ArrayList<>();
		
		for (int i=0; i<node[now].next.size(); i++) {
			al.add(node[now].weight.get(i) + DFS(node[now].next.get(i).idx));
		}
		
		if (al.size() == 1) {
			ans = Math.max(ans, al.get(0));
			return al.get(0);
		} else {
			al.sort(null);
			
			int size = al.size();
			
			ans = Math.max(ans, al.get(size-1) + al.get(size-2));
			
			return al.get(size-1);
		}		
	}
}
