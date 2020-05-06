package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_5525 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		String S = br.readLine();
		
		int length = 2*N + 1;
		
		int ans = 0;
		
		int count = 0;
		for (int i=0; i<M-2; i++) {
			if (S.substring(i, i+3).equals("IOI")) {
				count++;
				i++;
				
				if (count == N) {
					ans++;
					count--;
				}
			} else {
				count = 0;
			}
		}
		
		System.out.println(ans);
	}
}
