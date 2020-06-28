package week22;

import java.io.*;
import java.util.*;

public class Baekjoon_1182 {
	
	static int N, S;
	static int[] nums;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		ans = 0;
		findAns(0, 0);
		System.out.println(ans);
	}
	
	static int cnt;
	static void findAns(int idx, int sum) {
		if (idx >= N)
			return;
		
		findAns(idx+1, sum+nums[idx]);
		
		if (sum + nums[idx] == S) {
			ans++;
		}
		
		findAns(idx+1, sum);
	}
}
