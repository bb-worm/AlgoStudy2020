package week18;

import java.io.*;
import java.util.*;

public class Baekjoon_14888 {
	
	static int N;
	static int[] num;
	static int[] oper = new int[4];
	static int[] perm;
	
	static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		num = new int[N];
		perm = new int[N-1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());
		}
		
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		permutation(0);
		System.out.println(max);
		System.out.println(min);
	}
	
	static void permutation(int now) {
		
		if (now >= N-1) {
			
			calAns();
			
			return;
		}
		
		for (int i=0; i<4; i++) {
			if (oper[i] > 0) {
				oper[i]--;
				perm[now] = i;
				permutation(now+1);
				oper[i]++;
			}
		}
	}
	
	static void calAns() {
		
		int result = num[0];
		
		for (int i=0; i<N-1; i++) {
			result = cal(result, num[i+1], perm[i]);
		}
		
		min = Math.min(min, result);
		max = Math.max(max, result);
	}
	
	static int cal(int now, int next, int i) {
		if (i==0) {  // +
			return now + next; 
		}
		else if (i==1) { // -
			return now - next;
		}
		else if (i==2) { // *
			return now * next;
		}
		else { // /
			return now / next;
		}
	}

}
