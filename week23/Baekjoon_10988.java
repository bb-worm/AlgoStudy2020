package week23;

import java.io.*;
import java.util.*;

public class Baekjoon_10988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		
		int n = input.length();
		int left, right;
		
		if (n%2 == 0) {
			left = n/2 - 1;
			right = n/2;
		} else {
			left = right = n/2;
		}
		
		while (left >= 0) {
			if (input.charAt(left) != input.charAt(right))
				break;
			
			left--;
			right++;
		}
		
		int ans;
		if (left < 0) {
			ans = 1;
		} else {
			ans = 0;
		}
		
		System.out.println(ans);
	}

}
