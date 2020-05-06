package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_13549 {
	
	static int N, K;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS();
		System.out.println(ans);
	}
	
	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		int[] visit = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE);
		
		q.add(N);
		visit[N] = 1;
		
		int now;
		while (!q.isEmpty()) {
			now = q.poll();

			if (now==K) {
				ans = visit[now] - 1;
				q.clear();
				return;
			}
			
			int nextPosi;
			int nextVisit;
			for (int i=0; i<3; i++) {
				nextPosi = nextPosi(now, i);
				nextVisit = nextVisit(visit[now], i);
				
				if (nextPosi<0 || nextPosi>100000)
					continue;
				if (visit[nextPosi] <= nextVisit)
					continue;
				
				q.add(nextPosi);
				visit[nextPosi] = nextVisit;
			}
		}
	}
	
	static int nextVisit(int now, int method) {
		if (method == 0 || method == 1) {
			return now+1;
		} else {
			return now;
		}
	}
	
	static int nextPosi(int i, int method) {
		if (method == 0)
			return i-1;
		else if (method == 1)
			return i+1;
		else
			return i*2;
	}
}
