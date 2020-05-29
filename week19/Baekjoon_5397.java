package week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_5397 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			char[] input = br.readLine().toCharArray();
			sb.append(getPwd(input)).append('\n');
		}
		System.out.println(sb);
	}
	
	static class Node {
		char ch;
		Node pre;
		Node next;
		
		public Node (char ch) {
			this.ch = ch;
			this.pre = null;
			this.next = null;
		}
		
		public void add(Node n) {
			Node tmp = this.next;
			
			this.next = n;
			n.pre = this;
			n.next = tmp;
			
			if (tmp != null)
				tmp.pre = n;
		}
		
		public Node remove() {
			this.pre.next = this.next;
			
			if (this.next != null)
				this.next.pre = this.pre;
			
			return this.pre;
		}
	}
	
	static String getPwd(char[] input) {	
		
		Node root = new Node('r');
		
		Node now = root;
		
		for (char ch : input) {
			if (ch == '<') {
				if (now != root) 
					now = now.pre;
			} else if (ch == '>') {
				if (now.next != null)
					now = now.next;
			} else if (ch == '-') {
				if (now != root)
					now = now.remove();
			} else {
				Node next = new Node(ch);
				now.add(next);
				now = next;
			}
		}
		
		StringBuilder result = new StringBuilder();
		
		now = root.next;
		while (now != null) {
			result.append(now.ch);
			now = now.next;
		}
		
		return result.toString();
	}

}
