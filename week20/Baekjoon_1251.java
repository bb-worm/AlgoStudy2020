package week20;

import java.io.*;
import java.util.*;

public class Baekjoon_1251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String ans = null;
		
		String input = br.readLine();
		
		for (int i=1; i<input.length()-1; i++) {
			for (int j=i+1; j<input.length(); j++) {
				ans = getAns(ans, getStr(input, i, j));
			}
		}
		
		System.out.println(ans);
	}
	
	static String getStr(String input, int i, int j) {
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		StringBuilder sb3 = new StringBuilder();
		
		sb1.append(input.substring(0, i)).reverse();
		sb2.append(input.substring(i, j)).reverse();
		sb3.append(input.substring(j)).reverse();
		
		return sb1.append(sb2.append(sb3)).toString();
	}
	
	static String getAns(String str1, String str2) {
		if (str1 == null)
			return str2;
		else if (str2 == null)
			return str1;
		else {
			int result = str1.compareTo(str2);
			
			if (result <= 0)
				return str1;
			else
				return str2;
		}
	}
}
