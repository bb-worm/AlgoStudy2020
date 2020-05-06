package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_10250 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=0; t<T; t++) {
			
			int H, W, N;
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			
			int pre = N%H;
			int post = 1 + (N/H);
			if (pre==0) {
				pre = H;
				post--;
			}
			
			String ans;
			
			if (post < 10) {
				ans = pre + "0" + post;
			} else {
				ans = pre + "" + post;
			}
			System.out.println(ans);
			
		}
	}

}
