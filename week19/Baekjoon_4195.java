package week19;

import java.io.*;
import java.util.*;

public class Baekjoon_4195 {
	
	static class Node {
		int num;
		Node parent;
		
		public Node () {
			this.num = 1;
			this.parent = this;
		}
		
		public Node find() {
			if (this.parent == this)
				return this;
			else
				return this.parent = this.parent.find();
		}
		
		public void union(Node n) {
			if (this.find() == n.find())
				return;
			
			n.find().num += this.find().num;
			this.find().parent = n.find();
		}
		
		public int getNum() {
			return this.find().num;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			int F = Integer.parseInt(br.readLine());
			Map<String, Node> hm = new HashMap<String, Node>();
			
			String f1, f2;
			Node n1, n2;
			for (int i=0; i<F; i++) {
				st = new StringTokenizer(br.readLine());
				f1 = st.nextToken();
				f2 = st.nextToken();
				
				n1 = hm.getOrDefault(f1, null);
				if (n1 == null) {
					n1 = new Node();
					hm.put(f1, n1);
				}
				n2 = hm.getOrDefault(f2, null);
				if (n2 == null) {
					n2 = new Node();
					hm.put(f2, n2);
				}
				
				n1.union(n2);
				sb.append(n1.getNum()).append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
