package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_18870 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> hm = new HashMap<>();
		ArrayList<Integer> al = new ArrayList<>();
		ArrayList<Integer> input = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int x = Integer.parseInt(st.nextToken());
			if (hm.getOrDefault(x, 0) == 0) {
				hm.put(x, 1);
				al.add(x);
			}
			input.add(x);
		}
		
		al.sort(null);
		for (int i=0; i<al.size(); i++) {
			hm.put(al.get(i), i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<input.size(); i++) {
			int ans = hm.get(input.get(i));
			sb.append(ans).append(' ');
		}
		System.out.println(sb);
	}

}
