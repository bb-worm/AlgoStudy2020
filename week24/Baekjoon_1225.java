package week24;

import java.io.*;
import java.util.*;

public class Baekjoon_1225 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		char[] A = st.nextToken().toCharArray();
		char[] B = st.nextToken().toCharArray();
		
		long total = 0;
		
		for (int i=0; i<A.length; i++) {
			for (int j=0; j<B.length; j++) {
				total += (A[i] - '0') * (B[j] - '0');
			}
		}
		System.out.println(total);		
	}
}
