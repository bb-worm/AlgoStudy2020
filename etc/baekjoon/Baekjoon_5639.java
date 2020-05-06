package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_5639 {
	
	static class Node {
		int val;
		
		Node parent;
		Node left;
		Node right;
		
		public Node (int val) {
			this.val = val;
		}
	}
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Node root = new Node(Integer.parseInt(br.readLine()));
//		Node parent = root;
		
		String input;
		while ((input = br.readLine())!=null && input.length()!=0) {
			Node node = new Node(Integer.parseInt(input));
			
			Node parent = root;
			while (true) {
				
				if (parent.val > node.val) {
					if (parent.left == null) {
						parent.left = node;
						break;
					} else {
						parent = parent.left;
					}
				} else {
					if (parent.right == null) {
						parent.right = node;
						break;
					} else {
						parent = parent.right;
					}
				}
			}
		}
		print(root);
		System.out.println(sb);
	}
	
	static void print(Node node) {
		if (node == null)
			return;
		
		print(node.left);
		print(node.right);
		sb.append(node.val).append('\n');
	}
}
