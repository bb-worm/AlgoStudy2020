package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9935 {
	
	static class Str {
		char ch;
		int matchIdx;
		
		public Str (char ch, int matchIdx) {
			this.ch = ch;
			this.matchIdx = matchIdx;
		}
	}
	
	static int[] isUsed = new int['z'+1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		char[] str = br.readLine().toCharArray();
		char[] bomb = br.readLine().toCharArray();
		for (int i=0; i<bomb.length; i++) {
			isUsed[bomb[i]] = i+1;
		}
		
		Stack<Str> s = new Stack<>();
		Stack<Str> s2 = new Stack<>();
//		Queue<Str> q = new LinkedList<>();
		
		int idx;
		for (char ch : str) {
			
			s.push(new Str(ch, isUsed[ch]));
			
			idx = bomb.length;
			while (idx > 0) {
				if (s.isEmpty() || s.peek().matchIdx != idx) {
					while (!s2.isEmpty()) {
						s.push(s2.pop());
					}
					break;
				}
				
				s2.push(s.pop());
				idx--;
			}
			s2.clear();
		}
		
		for (Str left : s) {
			sb.append(left.ch);
		}
		
		if (sb.length() == 0)
			sb.append("FRULA");
		
		System.out.println(sb);
	}
}
