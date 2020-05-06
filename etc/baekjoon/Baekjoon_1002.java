package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1002 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());
			
			int ans;
			double dist = distance(x1, y1, x2, y2);
			
			if (x1==x2 && y1==y2 && r1==r2)
				ans = -1;
			else if (x1==x2 && y1==y2 && r1!=r2)
				ans = 0;
			else if (dist >= Math.max(r1, r2)) { // 외부 
				if (dist < r1+r2)
					ans = 2;
				else if (dist == r1+r2)
					ans = 1;
				else
					ans = 0;
			} else {
				if (dist > Math.abs(r1-r2))
					ans = 2;
				else if (dist == Math.abs(r1-r2))
					ans = 1;
				else
					ans = 0;
			}
			
			sb.append(ans).append('\n');
		}
		System.out.println(sb);
	}
	
	static double distance(int x1, int y1, int x2, int y2) {
		return Math.sqrt(Math.pow(x1-x2, 2) + Math.pow(y1-y2, 2));
	}

}
