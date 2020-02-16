package week3;

import java.io.*;
import java.util.*;

public class baekjoon_1697 {
	
	public static int N, K;
	public static int[] visit;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		visit = new int[100001];
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		ans = 0;
		BFS();
		System.out.println(ans);
	}
	public static Queue<Integer> q = new LinkedList<Integer>();
	
	public static void BFS() {
		q.add(N);
		visit[N] = 1;
		
		int n;
		while (!q.isEmpty()) {
			n = q.poll();
			
			if (n==K) {
				ans = visit[n]-1;
				q.clear();
				return;
			}
			
			if (n-1>=0 && visit[n-1]==0) {
				q.add(n-1);
				visit[n-1]=visit[n]+1;
			}
			if (n+1<=100000 && visit[n+1]==0) {
				q.add(n+1);
				visit[n+1] = visit[n]+1;
			}
			if (2*n<=100000 && visit[2*n]==0) {
				q.add(2*n);
				visit[2*n] = visit[n]+1;
			}
		}
	}
}
