package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11725 {
	
	static class Node {
		int idx;
		int depth;
		int parent;
		ArrayList<Node> connect;
		
		public Node (int idx){
			this.idx = idx;
			this.connect = new ArrayList<>();
		}
	}
	
	static Node[] node;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		node = new Node[N+1];
		for (int i=1; i<=N; i++) {
			node[i] = new Node(i);
		}
		
		int a, b;
		for (int i=1; i<=N-1; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			node[a].connect.add(node[b]);
			node[b].connect.add(node[a]);
		}
		
		node[1].depth = 1;
		search(1);
		
		StringBuilder sb = new StringBuilder();
		for (int i=2; i<=N; i++) {
			sb.append(node[i].parent).append('\n');
		}
		System.out.println(sb);
	}
	
	static void search(int idx) {
		
		int nowDepth = node[idx].depth;
		
		for (int i=0; i<node[idx].connect.size(); i++) {
			Node next = node[idx].connect.get(i);
			if (next.depth == 0) {
				next.parent = idx;
				next.depth = nowDepth + 1;
				search(next.idx);
			}
		}
	}
}
