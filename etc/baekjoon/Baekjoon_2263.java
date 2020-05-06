package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2263 {
	
	static class Node {
		int idx;
		Node parent;
		
		public Node (int idx) {
			this.idx = idx;
			this.parent = null;
		}
	}
	
	static int[] inorder, postorder;
	static int[] inorderlocation;
	static int[] visit;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		Node[] node = new Node[n+1];
		for (int i=1; i<=n; i++)
			node[i] = new Node(i);
		
		
		inorder = new int[n];
		inorderlocation = new int[n+1];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
			inorderlocation[inorder[i]] = i;
		}
		
		postorder = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}
	
		visit = new int[n+1];
		findAns(0, n-1, 0, n-1);
		System.out.println(sb);
	}
	
	static void findAns(int inleft, int inright, int postleft, int postright) {
		
		
		if (inright < 0 || postright < 0 || inleft > inright || postleft > postright)
			return;
//		System.out.println(inleft + " " + inright);
//		System.out.println(postleft + " " + postright);
//		System.out.println();
		
		int num = postorder[postright];
//		System.out.println(num);
		if (visit[num] == 1)
			return;
	
		sb.append(num).append(' ');
		visit[num] = 1;
		
		int offset = Math.abs(inleft - postleft);
		int j = inorderlocation[num];
			findAns(inleft, j-1, postleft, j-1-offset);
			findAns(j+1, inright, j-1-offset+1, postright-1);
	}
}
