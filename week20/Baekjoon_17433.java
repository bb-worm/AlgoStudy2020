package week20;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Baekjoon_17433 {
	
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			N = Integer.parseInt(br.readLine());
			int[] num = new int[N];
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				num[i] = Integer.parseInt(st.nextToken());
				min = Math.min(min, num[i]);
				max = Math.max(max, num[i]);
			}
			
			if (min == max)
				sb.append("INFINITY\n");
			else {
				int[] diff = new int[N-1];
				for (int i=1; i<N; i++) {
					diff[i-1] = Math.abs(num[i] - num[i-1]);
				}
				
				int result = getGCD(0, diff).intValue();
				sb.append(result).append('\n');
			}
		}
		System.out.println(sb);
	}
	
	static BigInteger getGCD(int idx, int[] diff) {
		
		if (idx == N-2) {
			return BigInteger.valueOf(diff[idx]);
		}
		
		BigInteger num = BigInteger.valueOf(diff[idx]);
		
		return num.gcd(getGCD(idx+1, diff));
	}
}