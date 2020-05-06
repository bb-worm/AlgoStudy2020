package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1654 {
	
	static int K, N;
	static int[] line;
	
	static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		line = new int[K];
		
		int max = 0;
		for (int i=0; i<K; i++) {
			line[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, line[i]);
		}
		
		ans = 1;
		binarySearch(1, max);
		System.out.println(ans);
	}
	
	static void binarySearch(long start, long end) {
		if (start > end)
			return;
		
		long mid = (start+end)/2;
		if (mid==0)
			return;
		
		long sum = 0;
		for (int i=0; i<K; i++) {
			sum += line[i] / mid;
		}
		
		if (sum >= N) {
			ans = Math.max(ans, mid);
			binarySearch(mid+1, end);
		} else{
			binarySearch(start, mid-1);
		}
	}
}
