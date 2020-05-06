package week10;

import java.io.*;
import java.util.*;

public class Baekjoon_1091 {
	
	static int N;
	static int[] P;
	static int[] S;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		N = Integer.parseInt(br.readLine());
		P = new int[N];
		S = new int[N];
		
		boolean alreadyGood = true;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			P[i] = Integer.parseInt(st.nextToken());
			if (P[i] != i%3)
				alreadyGood = false;
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			S[i] = Integer.parseInt(st.nextToken());
		}
		
		//////////////////////
		
		int ans = 0;
		
		if (!alreadyGood) {
			int time = 0;
			do {
				ans++;
				time++;
				if (time >= Math.pow(10, 6)) {
					System.out.println(-1);
					return;
				}
			} while (!mix());	
		}
		
		System.out.println(ans);
	}
	
	static boolean mix() {
		
		boolean result = true;
		
		int[] tmp = new int[N];
		for (int i=0; i<N; i++) {
			tmp[i] = P[i];
		}
		for (int i=0; i<N; i++){		
			P[S[i]] = tmp[i];
			if (P[S[i]] != S[i]%3)
				result = false;
		}
		return result;
	}
}
