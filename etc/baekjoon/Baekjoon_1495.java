package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1495 {
	
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		dp = new int[N][M+1];
		for (int i=0; i<N; i++)
			Arrays.fill(dp[i], -2);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(S);
		
		st = new StringTokenizer(br.readLine());
		int[] vol = new int[N];
		for (int i=0; i<N; i++)
			vol[i] = Integer.parseInt(st.nextToken());
		
		
		int ans = getAns(0, vol, S, M);
		
		System.out.println(ans);
	}
	
	static int getAns(int idx, int[] vol, int now, int limit) {
		
		if (now>limit || now<0)
			return -1;
		
		if (idx >= vol.length)
			return now;
		
		if (dp[idx][now] != -2)
			return dp[idx][now];
		
		return dp[idx][now] = Math.max(getAns(idx+1, vol, now-vol[idx], limit), getAns(idx+1, vol, now+vol[idx], limit));
	}
}
