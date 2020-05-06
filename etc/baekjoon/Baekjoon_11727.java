package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11727 {
	
	static int[] num = new int[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		DFS(1000);
		System.out.println(num[n]);
	}
	
	static int DFS(int now) {
		
		if (now < 0)
			return 0;
		
		if (now == 0) {
			return 1;
		}
		
		if (num[now] != 0)
			return num[now];
		
		return num[now] = (DFS(now-1) + DFS(now-2)*2) % 10007;
	}

}
