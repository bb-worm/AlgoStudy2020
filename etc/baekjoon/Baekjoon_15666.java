package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_15666 {
	
	static int N, M;
	static int[] arr;
	static int[] use;
	
	static StringBuilder ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		use = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		ans = new StringBuilder();
		set(0, 0);
		System.out.println(ans);
	}
	
	static void set(int idx, int now) {
		if (now > M)
			return;
		
		if (now == M) {
			for (int i : use)
				ans.append(i).append(' ');
			ans.append('\n');
			return;
		}
		
		for (int i=idx; i<N; i++) {
			use[now] = arr[i];
			set(i, now+1);
			while (i+1 < N && arr[i] == arr[i+1]) {
				i++;
			}
		}
	}
}
