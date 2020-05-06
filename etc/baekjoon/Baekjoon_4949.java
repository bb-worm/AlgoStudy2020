package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_4949 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while (true) {
			char[] input = br.readLine().toCharArray();
			if (input[0] == '.')
				break;
			
			int small = 0;
			int big = 0;
			Stack<Integer> turn = new Stack<>();
			
			int isBalance = 1;
			
			for (int i=0; i<input.length; i++) {
				if (input[i] == '(') {
					turn.add(1);
					small++;
				} else if (input[i] == ')') {
					if (turn.isEmpty() || turn.peek() == 2 || small <= 0) {
						sb.append("no").append('\n');
						isBalance = 0;
						break;
					}
					turn.pop();
					small--;
				} else if (input[i] == '[') {
					turn.add(2);
					big++;
				} else if (input[i] == ']') {
					if (turn.isEmpty() || turn.peek() == 1 || big <= 0) {
						sb.append("no").append('\n');
						isBalance = 0;
						break;
					}
					turn.pop();
					big--;
				}
			}
			
			if (isBalance == 1) {
				if (small + big == 0)
					sb.append("yes").append('\n');	
				else
					sb.append("no").append('\n');
			}
		}
		System.out.println(sb);
	}
}
