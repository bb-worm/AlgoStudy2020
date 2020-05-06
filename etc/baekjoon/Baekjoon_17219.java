package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_17219 {
	
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> hm = new HashMap<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String pwd = st.nextToken();
			
			hm.put(site, pwd);
		}
		StringBuilder sb = new StringBuilder();
		for (int j=0; j<M; j++) {
			sb.append(hm.get(br.readLine())).append('\n');
		}
		System.out.println(sb);
	}

}
