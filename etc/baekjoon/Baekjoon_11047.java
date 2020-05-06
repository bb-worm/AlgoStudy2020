package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11047 {
	
	static int N, K;
	static int[] coin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coin = new int[N];
		
		for (int i=0; i<N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(coin);
		
		int ans = 0;
		for (int i=N-1; i>=0 && K>0; i--) {
			
			if (K/coin[i] > 0) {
				ans += K/coin[i];
				K %= coin[i];
			}
		}
		System.out.println(ans);
	}
}
