package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1541 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] input = br.readLine().toCharArray();
		
		int ans = 0;
		
		int num = 0;
		int isMinus = 0;
		for (int i=0; i<input.length; i++) {
			num += input[i] - '0';
			
			if (i == input.length - 1) {
				if (isMinus == 1) {
					ans -= num;
				} else {
					ans += num;
				}
			} else if (input[i+1] == '+') {
				if (isMinus == 1)
					ans -= num;
				else
					ans += num;
				
				num=0;
				i++;
			} else if (input[i+1] == '-') {
				if (isMinus == 1)
					ans -= num;
				else
					ans += num;
				
				isMinus = 1;
				
				num=0;
				i++;
			} else {
				num *= 10;
			}
		}
		System.out.println(ans);
	}
}
