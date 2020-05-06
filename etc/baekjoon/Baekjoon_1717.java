package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1717 {
	
	static class Node {
		Node parent;
		
		public Node () {
			this.parent = this;
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
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		Node[] node = new Node[n+1];
		for (int i=0; i<=n; i++) {
			node[i] = new Node();
		}
		
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int oper = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
						
			if (oper == 0) {
				node[a].union(node[b]);
			} else {
				if (node[a].find() == node[b].find())
					sb.append("YES").append('\n');
				else
					sb.append("NO").append('\n');
			}
		}
		System.out.println(sb);
	}

}
