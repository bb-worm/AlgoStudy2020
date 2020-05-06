package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_14938 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		
		int[] item = new int[n+1];
		int[][] path = new int[n+1][n+1];
		for (int i=1; i<=n; i++)
			Arrays.fill(path[i], 10000);
		
		// item
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=n; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		
		// weight
		for (int i=0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			path[a][b] = weight;
			path[b][a] = weight;
		}
		
		////////////////
		
		for (int k=1; k<=n; k++) {
			
			for (int i=1; i<=n; i++) {
				for (int j=1; j<=n; j++) {
					if (i==j)
						continue;
					
					if (path[i][j] > path[i][k]+path[k][j]) {
						path[i][j] = path[i][k]+path[k][j];
					}
					
				}
			}
		}
		
		int ans = 0;
		for (int i=1; i<=n; i++) {
			int sum = item[i];
			for (int j=1; j<=n; j++) {
				if (i==j)
					continue;
				
				if (path[i][j] <= m)
					sum += item[j];
			}
			ans = Math.max(ans, sum);
		}
		System.out.println(ans);
	}
}
