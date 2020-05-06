package etc.baekjoon;

import java.io.*;

public class Baekjoon_1259 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String num;
		while (!(num = br.readLine()).equals("0")) {
			
			int front = 0;
			int end = num.length() - 1;
			
			boolean isTrue = true;
			while (front < end) {
				
				if (num.charAt(front) != num.charAt(end)) {
					isTrue = false;
					break;
				}
				
				front++;
				end--;
			}
			
			if (isTrue) {
				sb.append("yes").append('\n');
			} else {
				sb.append("no").append('\n');
			}
		}
		System.out.println(sb);
	}
}
