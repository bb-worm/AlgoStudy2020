package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_10818 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num > max) {
				max = num;
			}
			if (num < min) {
				min = num;
			}
		}
		System.out.println(min + " " + max);
	}

}
