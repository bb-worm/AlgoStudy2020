package week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Baekjoon_3372 {
	
	static int N;
	static int[][] map;
	static BigInteger[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		DP = new BigInteger[N][N];
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++)
				DP[i][j] = new BigInteger("-1");
		}
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BigInteger ans = DFS(0, 0);
		System.out.println(ans);
	}
	
	static BigInteger DFS(int a, int b) {
		
		if (a<0||a>=N||b<0||b>=N)
			return BigInteger.ZERO;
		
		if (DP[a][b].compareTo(BigInteger.ZERO) >=0)
			return DP[a][b];
		
		if (a==N-1 && b==N-1)
			return BigInteger.ONE;
		
		int val = map[a][b];
		
		if (val == 0) {
			return DP[a][b] = BigInteger.ZERO;
		}
		else {
			return DP[a][b] = DFS(a+val, b).add(DFS(a, b+val));
		}
	}
	
	static void printDP() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(DP[i][j]+ " ");
			}System.out.println();
		}System.out.println();
	}
}
