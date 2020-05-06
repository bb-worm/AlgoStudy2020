package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_10814 {
	
	static class Node implements Comparable<Node> {
		int age;
		String name;
		
		public Node (int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		public int compareTo(Node n) {
			return this.age - n.age;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Node[] node = new Node[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int age = Integer.parseInt(st.nextToken());
			String name = st.nextToken();
			node[i] = new Node(age, name);
		}
		
		Arrays.sort(node);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(node[i].age);
			sb.append(' ');
			sb.append(node[i].name);
			sb.append('\n');
		}
		System.out.println(sb);
		
	}

}
