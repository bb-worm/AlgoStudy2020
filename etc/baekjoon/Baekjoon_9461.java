package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Long> al = new ArrayList<>();
		
		al.add((long) 0);
		al.add((long) 1);
		al.add((long) 1);
		al.add((long) 1);
		al.add((long) 2);
		al.add((long) 2);
		al.add((long) 3);
		al.add((long) 4);
		al.add((long) 5);
		al.add((long) 7);
		al.add((long) 9);
		
		int T = Integer.parseInt(br.readLine());
		int[] input = new int[T];
		int max = 0;
		for (int t=0; t<T; t++) {
			input[t] = Integer.parseInt(br.readLine());
			max = Math.max(max, input[t]);
		}
		
		for (int i=11; i<=max; i++) {
			al.add(al.get(i-5) + al.get(i-1));
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<T; i++) {
			sb.append(al.get(input[i])).append('\n');
		}
		System.out.println(sb);
	}

}
