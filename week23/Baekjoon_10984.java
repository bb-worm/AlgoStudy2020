package week23;

import java.io.*;
import java.util.*;

public class Baekjoon_10984 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			int N = Integer.parseInt(br.readLine());
			
			int totalCredit = 0;
			float totalGrade = 0.0f;
			for (int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				int credit = Integer.parseInt(st.nextToken());
				totalCredit += credit;
				totalGrade += credit * Float.parseFloat(st.nextToken());
			}
			sb.append(totalCredit).append(' ').append(totalGrade/totalCredit).append('\n');
		}
		
		System.out.println(sb);
	}
}
