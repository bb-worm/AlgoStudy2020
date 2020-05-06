package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11723 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		Set<Integer> hs = new HashSet<>();
		
		int M = Integer.parseInt(br.readLine());
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			String oper = st.nextToken();
			doOper(oper, hs, sb, st);
		}
		System.out.println(sb);
	}
	
	static void doOper(String oper, Set<Integer> hs, StringBuilder sb, StringTokenizer st) {
		Integer num;
		if (oper.equals("add")) {
			num = new Integer(st.nextToken());
			if (!hs.contains(num)) {
				hs.add(num);
			}
		} else if (oper.equals("check")) {
			num = new Integer(st.nextToken());
			if (hs.contains(num)) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
			
		} else if (oper.equals("remove")) {
			num = new Integer(st.nextToken());
			if (hs.contains(num)) {
				hs.remove(num);
			}
		} else if (oper.equals("toggle")) {
			num = new Integer(st.nextToken());
			if (hs.contains(num)) {
				hs.remove(num);
			} else {
				hs.add(num);
			}
		} else if (oper.equals("all")) {
			hs.clear();
			for (int i=1; i<=20; i++) {
				hs.add(i);
			}
		} else {
			hs.clear();
		}
	}

}
