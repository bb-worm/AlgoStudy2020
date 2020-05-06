package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_15655 {
	
	static int N, M;
	
	static int[] arr;
	static int[] use;
	
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		use = new int[M];
		
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		set(0, 0);
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
		
		for (int i=idx; i<N; i++) {
			if (arr[i] != -1) {
				int tmp = arr[i];
				arr[i] = -1;
				use[now] = tmp;
				set(i+1, now+1);
				arr[i] = tmp;
			}
		}
	}

}
