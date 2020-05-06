package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1620 {
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String, Integer> name = new HashMap<>();
		HashMap<Integer, String> number = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String input = br.readLine();
			name.put(input, i+1);
			number.put(i+1, input);
		}
		
		for (int j=0; j<M; j++) {
			String input = br.readLine();
			
			int first = input.charAt(0);
			
			if (first >= 'A' && first <= 'Z') {
				sb.append(name.get(input)).append('\n');
			} else {
				sb.append(number.get(Integer.parseInt(input))).append('\n');
			}
		}
		System.out.println(sb);
	}
}
