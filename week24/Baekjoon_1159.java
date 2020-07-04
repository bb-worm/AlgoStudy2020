package week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baekjoon_1159 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		Map<Character, Integer> player = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			String name = br.readLine();
			
			char ch = name.charAt(0);
			player.put(ch, player.getOrDefault(ch, 0) + 1);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i='a'; i<='z'; i++) {
			char ch = (char)i;
			if (player.getOrDefault(ch, 0) >= 5)
				sb.append(ch);
		}
		
		if (sb.length() == 0)
			sb.append("PREDAJA");
		
		System.out.println(sb);
	}
}
