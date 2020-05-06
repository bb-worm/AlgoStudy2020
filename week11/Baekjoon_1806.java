package week11;

import java.io.*;
import java.util.*;

public class Baekjoon_1806 {
	
	static int N, S;
	static long[] num;
	static int ans;

 	public static void main(String[] args) throws IOException {
 		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 		StringTokenizer st;
 		
 		st = new StringTokenizer(br.readLine());
 		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		num = new long[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
			if (i!=0)
				num[i] += num[i-1];
		}
		ans = Integer.MAX_VALUE;
		if (num[N-1] < S) {
			ans = 0;
		} else {
			for (int i=0; i<N; i++) {
				if (ans == Integer.MAX_VALUE) {
					findAns(i, 0);
				} else {
					findAns(i, i-ans+1);
				}
			}
		}
		System.out.println(ans);
	}
 	
 	static void findAns(int idx, int start) {
 		if (idx < start)
 			return;
 		
 		if (start == 0) {
 			if (num[idx] >= S) {
 				ans = Math.min(ans, idx+1);
 				findAns(idx, 1);
 			}
 		} else if (num[idx] - num[start-1] >= S){
			ans = Math.min(ans, idx-start+1);
			findAns(idx, start+1);
 		}
 	}
}
