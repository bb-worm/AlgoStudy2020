package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_1644 {
	
	static boolean[] isPrime;
	static ArrayList<Integer> prime = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		isPrime = new boolean[N+1];
		Arrays.fill(isPrime, true);
		
		setPrime(N);
		int ans = getPrime(N);
		
		System.out.println(ans);
	}
	
	static int getPrime(int N) {
		int result = 0;
		
		int sum = 0;
		int startIdx = 0;
		
		for (int i=0; i<prime.size(); i++) {
			sum += prime.get(i);
			
			while (sum > N) {
				sum -= prime.get(startIdx);
				startIdx++;
			}
			
			if (sum == N)
				result++;
		}
		return result;
	}
	
	static void setPrime(int N) {
		int sqrt = (int)Math.sqrt(N);
		for (int i=2; i<=sqrt; i++) {
			if (isPrime[i]) {
				for (int j=i*i; j<=N; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		
		for (int i=2; i<=N; i++)
			if (isPrime[i])
				prime.add(i);
	}
}
