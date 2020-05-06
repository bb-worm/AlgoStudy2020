package etc.baekjoon;

import java.io.*;

public class Baekjoon_9012 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<N; i++) {
			char[] input = br.readLine().toCharArray();
			
			int open = 0;
			int close = 0;
			
			int pass = 0;
			
			for (int j=0; j<input.length; j++) {
				if (input[j] == '(')
					open++;
				else {
					if (open <= close) {
						sb.append("NO");
						sb.append('\n');
						pass = 1;
						break;
					}
					close++;
				}
			}
			
			if (pass == 0) {
				if (open != close) {
					sb.append("NO");
				} else {
					sb.append("YES");
				}
				sb.append('\n');
			}
		}
		System.out.println(sb);
	}
}
