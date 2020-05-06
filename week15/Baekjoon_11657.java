package week15;

import java.io.*;
import java.util.*;

public class Baekjoon_11657 {
	
	static final long MAX = Long.MAX_VALUE;
	
	static int N, M;
	static long[] node;
	static int[][] edge;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		node = new long[N+1];
		edge = new int[M][3];
		
		Arrays.fill(node, MAX);
		node[1] = 0;
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			edge[i][0] = Integer.parseInt(st.nextToken());
			edge[i][1] = Integer.parseInt(st.nextToken());
			edge[i][2] = Integer.parseInt(st.nextToken());
		}
		
		// 벨만포드 
		for (int i=0; i<N-1; i++) {
			relaxation();
		}
		
		if (relaxation()) {
			System.out.println(-1);
		} else {
			StringBuilder sb = new StringBuilder();
			for (int i=2; i<=N; i++) {
				if (node[i] == MAX)
					sb.append(-1).append('\n');
				else
					sb.append(node[i]).append('\n');
			}
			System.out.println(sb);
		}
	}
	
	static boolean relaxation() {
		boolean isChange = false;
		
		int a, b, c;
		
		for (int j=0; j<M; j++) {
			a = edge[j][0];
			b = edge[j][1];
			c = edge[j][2];
			
			if (node[a] == MAX)
				continue;
			
			// relaxation
			if (node[a] + c < node[b]) {
				node[b] = node[a] + c;
				isChange = true;
			}
		}
		return isChange;
	}
	
	static void printNode() {
		for (int i=1; i<node.length; i++)
			System.out.print(node[i] + " ");
		System.out.println();
	}
}
