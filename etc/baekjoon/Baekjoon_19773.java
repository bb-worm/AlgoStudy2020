package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_19773 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Integer> s = new Stack<>();
		
		int K = Integer.parseInt(br.readLine());
		
		for (int i=0; i<K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num==0) {
				s.pop();
			} else{
				s.push(num);
			}
		}
		
		long sum = 0;
		while (!s.isEmpty()) {
			sum += s.pop();
		}
		System.out.println(sum);
	}

}
