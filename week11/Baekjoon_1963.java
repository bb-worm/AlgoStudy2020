package week11;

import java.io.*;
import java.util.*;

public class Baekjoon_1963 {
	
	static int[] isPrime;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		isPrime = new int[10000];
		checkPrime();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int goal = Integer.parseInt(st.nextToken());
			BFS(start, goal);
		}
		
		System.out.println(sb);
	}
	
	static void BFS(int start, int goal) {
		Queue<Integer> q = new LinkedList<>();
		int[] visit = new int[10000];
		
		q.add(start);
		visit[start] = 1;
		
		int now;
		while(!q.isEmpty()) {
			now = q.poll();
			
//			System.out.println(now + " " + visit[now]);
			
			if (now == goal) {
				sb.append(visit[now]-1).append('\n');
				q.clear();
				return;
			}
			
			int[] digit = new int[4];
			for (int i=1; i<=4; i++) {
				digit[i-1] = (int) ((now % Math.pow(10, i)) - (now % Math.pow(10, i-1)));
			}
			
			int next;
			for (int i=0; i<4; i++) {
				int offset = (int)Math.pow(10, i);
				for (int j=0; j<10; j++) {
					
					next = (now - digit[i]) + offset*j;
					
					if (next<1000 || visit[next]!=0 || isPrime[next]!=1)
						continue;
					
					q.add(next);
					visit[next] = visit[now] + 1;
				}
			}
		}
	}
	
	static void checkPrime() {
		
		for (int i=2; i<10000; i++) {
			
			if (isPrime[i] == 0) {
				isPrime[i] = 1;
				
				for (int j=i*2; j<10000; j+=i) {
					isPrime[j] = -1;
				}
			}
		}
	}
}
