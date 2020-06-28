package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_10942 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int[] input = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] isPalindrom = new int[N][N];
		setPalindrom(isPalindrom, input);
		
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()) - 1;
			int e = Integer.parseInt(st.nextToken()) - 1;
			
			sb.append(isPalindrom[s][e]).append('\n');
		}
		System.out.println(sb);
	}
	
	static void setPalindrom(int[][] isPalindrom, int[] input) {
		
		for (int i=0; i<input.length; i++) {
			int left = i;
			int right = i;
			
			while (left>=0 && right<input.length) {
				if (input[left] == input[right]) {
					isPalindrom[left][right] = 1;
					left--; right++;
				} else {
					break;
				}
			}
			
			left = i;
			right = i+1;
			
			while (left>=0 && right<input.length) {
				if (input[left] == input[right]) {
					isPalindrom[left][right] = 1;
					left--; right++;
				} else {
					break;
				}
			}
		}
	}
}
