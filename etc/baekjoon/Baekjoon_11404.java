package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11404 {
	
	static int n;
	static int m;
	static long[][] cost;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		cost = new long[n][n];
		
		int a, b, c;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			c = Integer.parseInt(st.nextToken());
			
			if (cost[a][b] == 0)
				cost[a][b] = c;
			else
				cost[a][b] = Math.min(cost[a][b], c);
		}
		
		for (int k=0; k<n; k++) {
			
			for (int i=0; i<n; i++) {
				for (int j=0; j<n; j++) {
					
					if (cost[i][k]==0 || cost[k][j]==0)
						continue;
					
					long val = cost[i][k] + cost[k][j];
					
					if (cost[i][j] == 0)
						cost[i][j] = cost[i][k] + cost[k][j];
					else
						cost[i][j] = Math.min(cost[i][j], val);
				}
			}
		}
		
		print();
	}
	
	static void print() {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			for (int j=0; j<n; j++) {
				if (i==j)
					sb.append("0 ");
				else
					sb.append(cost[i][j]).append(' ');
			}sb.append('\n');
		}
		System.out.println(sb);
	}

}
