package week23;

import java.io.*;
import java.util.*;

public class Baekjoon_17173 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<Integer> check = new HashSet<>();
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++) {
			int k = Integer.parseInt(st.nextToken());
			for (int j=k; j<=N; j+=k) {
				check.add(j);
			}
		}
		
		int sum = 0;
		for (int i : check) {
			sum += i;
		}
		System.out.println(sum);
	}
}
