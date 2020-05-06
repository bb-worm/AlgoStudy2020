package week13;

import java.io.*;
import java.util.*;

public class Baekjoon_13913 {
	
	static int N, K;
	static int[] visit = new int[100001];
	static int[] pre = new int[100001];
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		BFS();
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append('\n');
		
		Stack<Integer> s = new Stack<>();
		
		int now = K;
		while (now >= 0) {
			s.push(now);
			now = pre[now];
		}
		while (!s.isEmpty()) {
			sb.append(s.pop()).append(' ');
		}
		System.out.println(sb);
	}
	
	static void BFS() {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(N);
		visit[N] = 1;
		pre[N] = -1;
		
		while (!q.isEmpty()) {
			int now = q.poll();
			
			if (now == K) {
				ans = visit[now] - 1;
				q.clear();
				break;
			}
			
			for (int i=0; i<3; i++) {
				int next = getNext(now, i);
				
				if (next<0 || next>100000 || visit[next]!=0)
					continue;
				
				q.add(next);
				visit[next] = visit[now] + 1;
				pre[next] = now;
			}
		}
	}
	
	static int getNext(int now, int i) {
		if (i == 0)
			return now-1;
		else if (i==1)
			return now+1;
		else
			return now*2;
	}

}
