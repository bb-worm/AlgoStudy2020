package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9020 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean[] isPrime = new boolean[10001];
		Arrays.fill(isPrime, true);
		
		for (int i=2; i<=10000; i++) {
			if (isPrime[i]) {
				for (int j=i*2; j<=10000; j+=i)
					isPrime[j] = false;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());
			
			for (int i=n/2; ; i--) {
				int j = n-i;
				
				if (isPrime[i] && isPrime[j]) {
					sb.append(i).append(' ').append(j).append('\n');
					break;
				}
			}
		}
		System.out.println(sb);
	}

}
