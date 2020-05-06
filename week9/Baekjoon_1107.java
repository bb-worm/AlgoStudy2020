package week9;

import java.io.*;
import java.util.*;

public class Baekjoon_1107 {
	
	static int N, M;
	static int[] malfunc;
	static int digit;
	
	static int now;
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		now = 100;
		
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		malfunc = new int[10];
		
		digit = Integer.toString(N).length();
		
		if (M > 0) {
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<M; i++) {
				malfunc[Integer.parseInt(st.nextToken())] = 1;
			}
		}
		
		ans = Math.abs(N - 100);
		for (int i=0; i<=9; i++) {
			if (malfunc[i] == 0)
				DFS(i, 1);
		}
		System.out.println(ans);
	}
	
	static void DFS(int num, int push) {
		
		ans = Math.min(ans, push + Math.abs((N-num)));
		
		if (Integer.toString(num).length() > digit)
			return;
		if (num==0 && push>1)
			return;
		
		for (int i=0; i<=9; i++) {
			if (malfunc[i] == 0) {
				DFS(num*10 + i, push+1);
			}
		}
	}
}
