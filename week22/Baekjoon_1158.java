package week22;

import java.io.*;
import java.util.*;

public class Baekjoon_1158 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		List<Integer> al = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		for (int i=0; i<N; i++)
			al.add(i+1);
		
		int idx = 0;
		while (al.size() >= 1) {
			idx = (idx+K-1) % al.size();
			sb.append(al.get(idx));
			al.remove(idx);
			
			if (al.size() >= 1)
				sb.append(", ");
			else
				sb.append('>');
			
		}
		System.out.println(sb);
	}
}
