package week24;

import java.io.*;

public class Baekjoon_1100 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = 8;
		int ans = 0;
		for (int i=0; i<n; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<n; j++) {
				if (i%2==0 && j%2==0 && input[j]=='F') ans++;
				else if (i%2!=0 && j%2!=0 && input[j]=='F') ans++;
			}
		}
		System.out.println(ans);
	}

}
