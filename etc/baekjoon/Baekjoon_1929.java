package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1929 {

	static int M, N;
	static int[] isPrime;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		isPrime = new int[N+1];
		
		checkPrime();
		
		StringBuilder sb = new StringBuilder();
		for (int i=M; i<=N; i++) {
			if (isPrime[i]==1)
				sb.append(i).append('\n');
		}
		System.out.println(sb);
	}

	static void checkPrime() {
		
		isPrime[0] = -1;
		isPrime[1] = -1;
		
		for (int i=2; i<=N; i++) {
			if (isPrime[i] == 0) {
				isPrime[i] = 1;
			}
			for (int j=i*2; j<=N; j+=i) {
				isPrime[j] = -1;
			}
		}
		
	}
}
