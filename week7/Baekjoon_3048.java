package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_3048 {
	
	static int N, M;
	static char[] arr;
	static int T;
	
	static int[] goRightAlpha;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N+M];
		goRightAlpha = new int['Z' - 'A' + 1];
		
		char[] input = br.readLine().toCharArray();
		for (int i=0; i<N; i++) {
			arr[N-1-i] = input[i];
			goRightAlpha[input[i] - 'A']++;
		}
		input = br.readLine().toCharArray();
		for (int i=0; i<M; i++)
			arr[N+i] = input[i];
		
		T = Integer.parseInt(br.readLine());
		
		////////////////////////////////////////////
		
		for (int i=0; i<T; i++) {
			int now, next;
			for (int k=0; k<N+M-1; k++) {
				now = arr[k] - 'A';
				next = arr[k+1] - 'A';
				
				if (goRightAlpha[now]>0 && goRightAlpha[next]==0) {
					char tmp = arr[k];
					arr[k] = arr[k+1];
					arr[k+1] = tmp;
					k++;
				}
			}
		}
		
		for (char ch : arr)
			System.out.print(ch);
	}
}
