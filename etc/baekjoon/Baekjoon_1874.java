package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1874 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> s = new Stack<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		StringBuilder sb = new StringBuilder();
		
		s.push(1);
		sb.append('+').append('\n');
		
		int now = 0;
		int num = 2;
		while (!s.isEmpty()) {
			
			while (!s.isEmpty() && now<N && s.peek() == arr[now]) {
				s.pop();
				sb.append('-').append('\n');
				now++;
			}
			
			if (num <= N) {
				s.push(num);
				sb.append('+').append('\n');
				num++;			
			} else {
				break;
			}
		}
		
		if (!s.isEmpty()) {
			System.out.println("NO");
		} else {
			System.out.println(sb);			
		}
	}
}
