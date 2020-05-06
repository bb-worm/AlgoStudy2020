package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_15649 {
	
	static int N, M;
	
	static int[] num;
	static int[] use;
	
	static StringBuilder sb;
	
	public static void main(String[] agrs) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		sb = new StringBuilder();
		
		num = new int[N+1];
		use = new int[M];
		
		set(0);
		System.out.println(sb);
	}
	
	static void set(int now) {
		if (now>M)
			return;
		
		if (now==M) {
			for (int i : use) {
				sb.append(i);
				sb.append(' ');
			}
			sb.append('\n');
			return;
		}
		
		for (int i=1; i<=N; i++) {
			if (num[i] == 0) {
				num[i] = 1;
				use[now] = i;
				set(now+1);
				num[i] = 0;
			}
		}
	}
}
