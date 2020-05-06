package week15;

import java.io.*;
import java.util.*;

public class Baekjoon_1976 {
	
	static class Node {
		Node parent;
		int idx;
		
		public Node(int idx) {
			this.parent = this;
			this.idx = idx;
		}
		
		public Node find() {
			if (this.parent == this)
				return this;
			else
				return this.parent = this.parent.find();
		}
		
		public void union(Node n) {
			this.find().parent = n.find();
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		Node[] node = new Node[N];
		for (int i=0; i<N; i++) {
			node[i] = new Node(i);
		}
		int[][] connect = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				
				connect[i][j] = Integer.parseInt(st.nextToken());
				
				if (i==j)
					continue;
				
				if (connect[i][j] == 1 && node[i].find() != node[j].find()) {
					node[i].union(node[j]);
				}
			}
		}
		
		boolean canGo = true;
		st = new StringTokenizer(br.readLine());
		
		Node root = node[Integer.parseInt(st.nextToken())-1].find();
		for (int i=1; i<M; i++) {
			int next = Integer.parseInt(st.nextToken()) - 1;
			if (root!=node[next].find()) {
				canGo = false;
				break;
			}
		}
		
		if (canGo)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	
	static void printNode(Node node[]) {
		for (Node n : node)
			System.out.print(n.find().idx + " ");
		System.out.println();
	}
}
