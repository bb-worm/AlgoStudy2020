package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_15650 {
	
	static int N, M;
	
	static int[] num;
	static int[] use;

	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		num = new int[N+1];
		use = new int[M];
		
		sb = new StringBuilder();
		
		set(1, 0);
		System.out.println(sb);
	}
	
	static void set(int idx, int now) {
		if (now>M)
			return;
		
		if (now==M) {
			for (int i : use)
				sb.append(i).append(' ');
			sb.append('\n');
			return;
		}
		
		for (int i=idx; i<=N; i++) {
			if (num[i] == 0) {
				num[i] = 1;
				use[now] = i;
				set(i+1, now+1);
				num[i] = 0;
			}
		}
	}

}
