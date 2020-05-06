package etc.baekjoon;

import java.io.*;

public class Baekjoon_10951 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input;
		while ((input = br.readLine()) != null && input.length() != 0) {
			int a = input.charAt(0) - '0';
			int b = input.charAt(2) - '0';
			
			System.out.println(a+b);
		}
		
	}

}
