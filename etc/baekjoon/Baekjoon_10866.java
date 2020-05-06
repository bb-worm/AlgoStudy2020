package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_10866 {
	
	static String[] oper = {"push_front", "push_back", "pop_front", "pop_back", "size", "empty", "front", "back"};
	
	static ArrayList<Integer> al = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int num = 0;
			if (st.hasMoreTokens())
				num = Integer.parseInt(st.nextToken());
			
			for (int j=0; j<oper.length; j++) {
				if (str.equals(oper[j])) {
					play(j, num);
					break;
				}
			}
		}
		System.out.println(sb);
	}
	
	static void play(int idx, int num) {
		if (idx == 0) {
			al.add(0, num);
		} else if (idx == 1) {
			al.add(num);
		} else if (idx == 2) {
			if (!al.isEmpty()) {
				sb.append(al.get(0));
				al.remove(0);
			} else {
				sb.append(-1);
			}
			sb.append('\n');
		} else if (idx == 3) {
			if (!al.isEmpty()) {
				sb.append(al.get(al.size()-1));
				al.remove(al.size()-1);
			} else {
				sb.append(-1);
			}
			sb.append('\n');
		} else if (idx == 4) {
			sb.append(al.size());
			sb.append('\n');
		} else if (idx == 5) {
			if (al.isEmpty()) {
				sb.append(1);
			} else {
				sb.append(0);
			}
			sb.append('\n');
		} else if (idx == 6) {
			if (!al.isEmpty()) {
				sb.append(al.get(0));
			} else {
				sb.append(-1);
			}
			sb.append('\n');
		} else {
			if (!al.isEmpty()) {
				sb.append(al.get(al.size()-1));
			} else {
				sb.append(-1);
			}
			sb.append('\n');
		}
	}

}
