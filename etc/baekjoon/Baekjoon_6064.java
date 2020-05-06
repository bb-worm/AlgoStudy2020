package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_6064 {
	
	static int N, M;
	static int x, y;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			int a = x - y;
			int year = 0;
			int canFind = 1;
			while (a%M != 0) {
				a += N;
				year++;
				
				if (N*year + x > N*M) {
					canFind = 0;
					break;
				}
			}
			
			if (canFind == 1) {
				sb.append(N*year + x).append('\n');
			} else {
				sb.append(-1).append('\n');
			}
			
		}
		System.out.println(sb);
	}
}
