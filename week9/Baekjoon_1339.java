package week9;

import java.io.*;
import java.util.*;

public class Baekjoon_1339 {
	
	static int N;
	static String[] input;
	static int[] alpha = new int[26];
	static int[] totalDigit = new int[26];
	
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		input = new String[N];
		
		int alphaNum = 0;
		
		for (int i=0; i<N; i++) {
			input[i] = br.readLine();
			for (int j=0; j<input[i].length(); j++) {
				int idx = input[i].charAt(j) - 'A';
				
				if (alpha[idx] == 0)
					alphaNum++;
				
				alpha[idx] = 1;
				totalDigit[idx] += Math.pow(10, input[i].length() - j - 1);
			}
		}
		
		Arrays.sort(totalDigit);
		
		ans = 0;
		int val = 9;
		for (int i=0; i<alphaNum; i++) {
			ans += totalDigit[25-i] * val;
			val--;
		}
		
		System.out.println(ans);
	}
}
