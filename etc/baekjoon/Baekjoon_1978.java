package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1978 {
	
	static int[] prime;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		prime = new int[1001];
		makePrime();
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			if (prime[Integer.parseInt(st.nextToken())] == 1)
				ans++;
		}
		System.out.println(ans);
	}
	
	static void makePrime() {
		
		for (int i=2; i<=1000; i++) {
			if (prime[i] == 0) {
				prime[i] = 1;
				
				for (int j=i*2; j<=1000; j+=i) {
					prime[j] = -1;
				}
			}
		}
	}
}
