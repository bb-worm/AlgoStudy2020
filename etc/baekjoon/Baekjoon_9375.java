package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_9375 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			int n = Integer.parseInt(br.readLine());
			
			HashMap<String, Integer> hm = new HashMap<>();
			
			for (int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String sort = st.nextToken();
				hm.put(sort, hm.getOrDefault(sort, 0) + 1);
			}
			
			Set<String> keys = hm.keySet();
			
			int sum = 1;
			for (String key : keys) {
				// 입거나 안 입거나 
				sum *= (hm.get(key)+1);
			}
			
			// 벌거벗은 상태 빼기 
			sum--;
			
			sb.append(sum).append('\n');
		}
		System.out.println(sb);
		
	}

}
