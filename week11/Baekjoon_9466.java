package week11;

import java.io.*;
import java.util.*;

public class Baekjoon_9466 {
	
	static int n;
	static int[] select;
	static int[] visit;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			n = Integer.parseInt(br.readLine());
			select = new int[n+1];
			visit = new int[n+1];
			
			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=n; i++) {
				select[i] = Integer.parseInt(st.nextToken());
				if (select[i] == i)
					visit[i] = -1;
			}
			
			ans = 0;
			for (int i=1; i<=n; i++) {
				if (visit[i] == 0) {
					visit[i] = 1;
					ArrayList<Integer> al = new ArrayList<>();
					al.add(i);
					DFS(i, al);
				}
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static void DFS(int now, ArrayList<Integer> al) {
		
		int next = select[now];
		
		// find cycle
		if (visit[next] == 1) {
			int idx = al.indexOf(new Integer(next));
			
			for (int i=0; i<al.size(); i++) {
				if (i < idx)
					ans++;
				
				visit[al.get(i)] = -1;
			}
			return;
		}
		// not visit
		else if (visit[next] == 0){
			visit[next] = 1;
			al.add(next);
			DFS(next, al);
		} 
		// cannot go
		else if (visit[next] == -1) {
			for (int i : al) {
				ans++;
				visit[i] = -1;
			}
			return;
		}
	}
}
