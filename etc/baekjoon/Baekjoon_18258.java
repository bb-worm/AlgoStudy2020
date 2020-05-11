package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_18258 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		Deque<Integer> dq = new LinkedList<>();
		
		int N = Integer.parseInt(br.readLine());
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String oper = st.nextToken();
			
			if (oper.equals("push")) {
				int num = Integer.parseInt(st.nextToken());
				dq.add(num);
			} else if (oper.equals("pop")) {
				if (dq.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(dq.pollFirst()).append('\n');
			} else if (oper.equals("size")) {
				sb.append(dq.size()).append('\n');
			} else if (oper.equals("empty")) {
				if (dq.isEmpty())
					sb.append(1).append('\n');
				else
					sb.append(0).append('\n');
			} else if (oper.equals("front")) {
				if (dq.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(dq.peekFirst()).append('\n');
			} else { // back
				if (dq.isEmpty())
					sb.append(-1).append('\n');
				else
					sb.append(dq.peekLast()).append('\n');
			}
		}
		System.out.println(sb);
	}
}
