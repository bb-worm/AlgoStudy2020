package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9095 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			
			sb.append(DFS(N, 0)).append('\n');
			
		}
		System.out.println(sb);
	}
	
	static int DFS(int n, int time) {
		if (n < 0) {
			return 0;
		}
		else if (n == 0) {
			return 1;
		}
		else {
			return DFS(n-1, time+1) + DFS(n-2, time+1) + DFS(n-3, time+1);
		}
	}

}
