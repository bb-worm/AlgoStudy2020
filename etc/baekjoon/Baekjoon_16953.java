package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_16953 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<Long, Integer> hm = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<>();
		q.add(A);
		hm.put((long)A, 1);
		
		int ans = -1;
		while (!q.isEmpty()) {
			int now = q.poll();
			int val = hm.get((long)now);
			
			if (now==B) {
				ans = val;
				q.clear();
				break;
			}
			
			long next;
			
			// *2
			next = (long)now*2;
			if (hm.getOrDefault(next, 0)==0 && next <= B) {
				q.add((int)next);
				hm.put(next, val+1);
			}
			
			// *10 + 1
			next = (long)now*10 + 1;
			if (hm.getOrDefault(next, 0)==0 && next <= B) {
				q.add((int)next);
				hm.put(next, val+1);
			}
		}
		System.out.println(ans);
	}

}
