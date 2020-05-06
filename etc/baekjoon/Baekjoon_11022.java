package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11022 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			sb.append("Case #").append(t).append(": ");
			sb.append(A).append(" + ");
			sb.append(B).append(" = ");
			sb.append(A+B).append('\n');
		}
		System.out.println(sb);
	}

}
