package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Set<Integer> hs = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<M; i++) {
			if (hs.contains(Integer.parseInt(st.nextToken()))) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
