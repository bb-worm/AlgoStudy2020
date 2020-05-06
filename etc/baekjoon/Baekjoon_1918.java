package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1918 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Character> s = new Stack<>();
		
		char[] input = br.readLine().toCharArray();
		
		for (int i=0; i<input.length; i++) {
			char ch = input[i];
			
			if (ch == '(') {
				s.push(ch);
			} else if (ch == '-' || ch == '+') {
				while (!s.isEmpty() && s.peek()!='(') {
					sb.append(s.pop());
				}
				s.push(ch);
			} else if (ch == '/' || ch == '*') {
				while (!s.isEmpty() && s.peek()!='(' && s.peek()!='-' && s.peek()!='+') {
					sb.append(s.pop());
				}
				s.push(ch);
			} else if (ch == ')') {
				while (!s.isEmpty() && s.peek()!='(') {
					sb.append(s.pop());
				}
				if (!s.isEmpty() && s.peek()=='(') {
					s.pop();
				}
			} else {
				sb.append(ch);
			}
		}
		
		while (!s.isEmpty() && s.peek()!='(') {
			sb.append(s.pop());
		}
		s.clear();
		sb.append('\n');
		System.out.println(sb);
	}

}
