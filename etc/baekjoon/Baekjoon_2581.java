package etc.baekjoon;

import java.io.*;

public class Baekjoon_2581 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int[] ans = findPrime(M, N);
		if (ans[0] == 0)
			System.out.println(-1);
		else {
			System.out.println(ans[0]);
			System.out.println(ans[1]);
		}
	}
	
	static int[] findPrime(int M, int N) {
		int[] isPrime = new int[N+1];
		
		for (int i=2; i<=N; i++) {
			if (isPrime[i] == 0) {
				isPrime[i] = 1;
				
				for (int j=i*2; j<=N; j+=i) {
					isPrime[j] = -1;
				}
			}
		}
		
		int[] result = new int[2];
		for (int i=M; i<=N; i++) {
			if (isPrime[i] == 1) {
				if (result[0] == 0)
					result[1] = i;
				result[0] += i;
			}
		}
		
		return result;
	}
}
