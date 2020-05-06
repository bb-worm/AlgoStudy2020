package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_12851 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] visit = new int[100001];
		Arrays.fill(visit, Integer.MAX_VALUE);
		
		Queue<Integer> q = new LinkedList<>();
		q.add(N);
		visit[N] = 1;
		
		int ans = 0;
		int total = 0;
		boolean findAns = false;
		
		if (N==K) {
			findAns = true;
			total++;
		}
		
		while (!q.isEmpty() && !findAns) {
			
			int size = q.size();
			
			for (int i=0; i<size; i++) {
				int now = q.poll();
				
				if (now-1>=0 && visit[now-1]>=visit[now]+1) {
					if (now-1 == K) {
						findAns = true;
						ans = visit[now];
						total++;
					} else {
						q.add(now-1);
						visit[now-1] = visit[now]+1;
					}
				}
				
				if (now+1<=100000 && visit[now+1]>=visit[now]+1) {
					if (now+1 == K) {
						findAns = true;
						ans = visit[now];
						total++;
					} else {
						q.add(now+1);
						visit[now+1] = visit[now]+1;
					}
				}
				
				if (now*2<=100000 && visit[now*2]>=visit[now]+1) {
					if (now*2 == K) {
						findAns = true;
						ans = visit[now];
						total++;
					} else {
						q.add(now*2);
						visit[now*2] = visit[now]+1;
					}
				}
			}
			
			if (findAns) {
				q.clear();
				break;
			}
		}
		System.out.println(ans);
		System.out.println(total);
	}
}
