package week22;

import java.io.*;
import java.util.*;

public class Baekjoon_1406 {
	
	static class Node {
		char ch;
		Node pre;
		Node next; 
		
		public Node(char ch) {
			this.ch = ch;
			this.pre = null;
			this.next = null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Node root = new Node('r');
		
		Node pre = root;
		Node now = root;
		char[] input = br.readLine().toCharArray();
		for (int i=0; i<input.length; i++) {
			now = new Node(input[i]);
			now.pre = pre;
			pre.next = now;
			
			pre = now;
		}
		
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			char oper = st.nextToken().charAt(0);
			if (oper == 'L' && now.pre != null) {
				now = now.pre;
			} else if (oper == 'D' && now.next != null) {
				now = now.next;
			} else if (oper == 'B' && now.pre != null) {
				if (now.next != null)
					now.next.pre = now.pre;
				now.pre.next = now.next;
				now = now.pre;
			} else if (oper == 'P') {
				char addChar = st.nextToken().charAt(0);
				Node addNode = new Node(addChar);
				addNode.pre = now;
				addNode.next = now.next;
				
				if (now.next != null)
					now.next.pre = addNode;
				now.next = addNode;
				now = addNode;
			}
		}
		print(root);
	}
	
	static void print(Node root) {
		StringBuilder sb = new StringBuilder();
		
		Node now = root.next;
		while (now != null) {
			sb.append(now.ch);
			now = now.next;
		}
		System.out.println(sb);
	}

}
