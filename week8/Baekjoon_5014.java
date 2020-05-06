package week8;

import java.io.*;
import java.util.*;

public class Baekjoon_5014 {
	
	static int[] visit;
	
	static int MAX_FLOOR;
	static int now;
	static int goal;
	static int U, D;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		MAX_FLOOR = Integer.parseInt(st.nextToken());
		now = Integer.parseInt(st.nextToken());
		goal= Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		visit = new int[MAX_FLOOR+1];
		
		int ans = BFS();
		if (ans == -1) {
			System.out.println("use the stairs");
		} else {
			System.out.println(ans);
		}
	}
		
	static int BFS() {
		
		int result = -1;
		
		Queue<Integer> q = new LinkedList<>();
		int[] dn = {U, -D};
		
		q.add(now);
		visit[now] = 1;
		
		int n;
		while (!q.isEmpty()) {
			
			n = q.poll();
						
			if (n == goal) {
				result = visit[n]-1;
				q.clear();
				break;
			}
			
			int next;
			for (int i=0; i<2; i++) {
				next = n + dn[i];
				
				if (next<1 || next>MAX_FLOOR || visit[next]!=0)
					continue;
				
				q.add(next);
				visit[next] = visit[n]+1;
			}
			
		}
		return result;
	}

}
