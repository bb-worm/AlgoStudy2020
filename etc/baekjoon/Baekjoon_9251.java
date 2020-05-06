package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] str1 = br.readLine().toCharArray();
		char[] str2 = br.readLine().toCharArray();
		
		int[][] map = new int[str1.length+1][str2.length+1];
		
		for (int i=1; i<=str1.length; i++) {
			for (int j=1; j<=str2.length; j++) {
				if (str1[i-1] == str2[j-1]) {
					map[i][j] = map[i-1][j-1] + 1;
				} else {
					map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
				}
			}
		}
		
		System.out.println(map[str1.length][str2.length]);
		
	}

}
