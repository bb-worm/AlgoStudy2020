package week16;

import java.io.*;
import java.util.*;

public class Baekjoon_1527 {
	
	static int A, B;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		ans = 0;
		DFS(0);
		System.out.println(ans);
	}
	
	static void DFS(long now) {
		if (now > B)
			return;
		
		if (now >= A)
			ans++;
		
		DFS((now*10) + 4);
		DFS((now*10) + 7);
	}
}
