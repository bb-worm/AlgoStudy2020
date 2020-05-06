package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11053 {
	
	static int N;
	static int[] arr;
	static int[] DP;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		DP = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.fill(DP, 1);
		for (int i=N-1; i>=0; i--) {
			ans = Math.max(ans, getAns(i));
		}
		System.out.println(ans);
	}
	
	static int getAns(int now) {
		
		int length = 1;
		
		for (int i=now+1; i<N; i++) {
			if (arr[now] < arr[i]) {
				length = Math.max(length, DP[i]+1);
			}
		}
		DP[now] = length;
		return length;
	}
}
