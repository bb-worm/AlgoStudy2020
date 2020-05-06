package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_12865 {
	
	static class Product {
		int weight, value;
		
		public Product (int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
	
	static int N, K;
	static Product[] product;
	
	static int[][] DP;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		product = new Product[N];
		DP = new int[N][K+1];
		
		int w, v;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			
			product[i] = new Product(w, v);
		}
		
		for (int i=1; i<=K; i++) {
			if (product[0].weight > i) {
				DP[0][i] = 0;
			} else {
				DP[0][i] = product[0].value;
			}
		}
		
		for (int i=1; i<N; i++) {
			for (int j=1; j<=K; j++) {
				int restWeight = j - product[i].weight;
				if (restWeight >= 0) {
					DP[i][j] = Math.max(DP[i-1][restWeight]+product[i].value, DP[i-1][j]);
				} else {
					DP[i][j] = DP[i-1][j];
				}
			}
		}
		
		System.out.println(DP[N-1][K]);
		
	}
	
	static void printDP() {
		for (int i=0; i<N; i++) {
			for (int j=1; j<=K; j++) {
				System.out.printf("%2d ",DP[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
}
