package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_3009 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] ans = new int[2];
		
		int[][] input = new int[3][2];
		for (int i=0; i<3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<2; j++) {
				input[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<2; i++) {
			if (input[0][i] == input[1][i])
				ans[i] = input[2][i];
			else if (input[0][i] == input[2][i])
				ans[i] = input[1][i];
			else
				ans[i] = input[0][i];
		}
		
		System.out.println(ans[0] + " " + ans[1]);
		
	}

}
