package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_17626 {
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		ans = Integer.MAX_VALUE;
		DFS(n, 0);
		System.out.println(ans);
	}
	
	static void DFS(int n, int time) {
		
		if (time >= ans)
			return;
		
		if (n==0) {
			ans = Math.min(ans, time);
			return;
		}
		
		int next = (int)Math.sqrt(n);
		
		for (int i=next; i>0 && time+1<ans; i--) {
			DFS(n-i*i, time+1);
		}		
	}
}
