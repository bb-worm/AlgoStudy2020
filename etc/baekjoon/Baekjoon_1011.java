package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1011 {
	
	public static int x, y;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			if (y-x == 1)
				ans = 1;
			else if (y-x == 2)
				ans = 2;
			else {
				
				int diff = y - x;
				int val = (int)Math.sqrt(diff-1)+1;
				if (diff > val*val - val) {
					ans = val + val-1;
				} else {
					ans = val + val -2;
				}
				
//				int now = 2;
//				int num = 2;
//				ans = 3;
//				
//				while (true) {
//					now += num;
//					if (now >= y-x) {
//						break;
//					}
//					ans++;
//					
//					now += num;
//					if (now >= y-x) {
//						break;
//					}
//					ans++;
//					num++;
//				}
			}
			
			System.out.println(ans);
		}
	}
}
