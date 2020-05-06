package week14;

import java.io.*;
import java.util.*;

public class Baekjoon_2166 {
	
	static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		double ans = 0;
		
		st = new StringTokenizer(br.readLine());
		int sa = Integer.parseInt(st.nextToken());
		int sb = Integer.parseInt(st.nextToken());
		
		int preA = sa;
		int preB = sb;
		int nowA, nowB;
		for (int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			nowA = Integer.parseInt(st.nextToken());
			nowB = Integer.parseInt(st.nextToken());
			
			ans += (double)preA*nowB;
			ans -= (double)nowA*preB;
			preA = nowA;
			preB = nowB;
		}
		ans += (double)preA*sb;
		ans -= (double)sa*preB;
		
		ans = Math.abs(ans)/2;
		
		System.out.printf("%.1f", ans);
	}
}
