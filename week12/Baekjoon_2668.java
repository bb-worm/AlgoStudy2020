package week12;

import java.io.*;
import java.util.*;

public class Baekjoon_2668 {
	
	static int n;
	static int[] num;
	static int[] visit;
	static int[] check;
	
	static int sameNum;
	
	static int ans;
	static ArrayList<Integer> al = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		num = new int[n+1];
		visit = new int[n+1];
		check = new int[n+1];
		ans = 0;
		
		for (int i=1; i<=n; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if (num[i] == i) {
				sameNum++;
				al.add(i);
			}
		}
		ans += sameNum;
		
		for (int i=1; i<=n; i++) {
			if (num[i] == i)
				continue;
			
			if (visit[i] == 0) {
				visit[i] = 1;
				DFS(num[i], 2);
				check[i] = 1;
			}
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(ans).append('\n');
		
		al.sort(null);
		for (int i=0; i<al.size(); i++){
			sb.append(al.get(i)).append('\n');
		}
		System.out.println(sb);
	}
	
	static void DFS(int idx, int length) {
		
		if (check[idx] == 1 || num[idx] == idx)
			return;
		
		if (visit[idx] == 0) {
			visit[idx] = length;
			DFS(num[idx], length+1);
			check[idx] = 1;
		} else {
			int result = length - visit[idx];
			
			ans += result;
			
			for (int i=1; i<=n; i++) {
				if ((check[i]==0 && visit[i]>=visit[idx])) {
					al.add(i);
				}
			}
		}
	}
}
