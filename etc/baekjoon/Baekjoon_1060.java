package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1060 {
	
	static class LuckySet {
		int num;
		int start;
		int end;
		int isFinish;
		
		public LuckySet(int num) {
			this.num = num;
			this.isFinish = 0;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int L = Integer.parseInt(br.readLine());
		LuckySet[] ls = new LuckySet[L+1];
		ls[0] = new LuckySet(0);
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=L; i++) {
			ls[i] = new LuckySet(Integer.parseInt(st.nextToken()));
		}
		int N = Integer.parseInt(br.readLine());
		
		Arrays.sort(ls, new Comparator<LuckySet>() {
			public int compare(LuckySet l1, LuckySet l2) {
				return l1.num - l2.num;
			}
		});
		
		//////////////////////////
		
		// 1
		ArrayList<Integer> al = new ArrayList<>();
		for (int i=1; i<=L; i++) {
			al.add(ls[i].num);
		}
		for (int i=0; i<L; i++) {
			int diff = ls[i+1].num - ls[i].num;
			
			if (diff == 1) {
				ls[i].isFinish = 1;
			} else if (diff == 2) {
				al.add(ls[i].num + 1);
				ls[i].isFinish = 1;
			} else {
				ls[i].start = ls[i].num + 1;
				ls[i].end = ls[i+1].num - 1;
			}
		}
		al.sort(null);
		
		// 2
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Queue<Integer> q = new LinkedList<>();
		boolean isChange = true;
		while (isChange && al.size()<N) {
			isChange = false;
			
			long min = Long.MAX_VALUE;
			for (int i=0; i<L; i++) {
				if (ls[i].isFinish == 1)
					continue;
				
				int pre = ls[i].start - ls[i].num - 1;
				int next = ls[i+1].num - ls[i].start;
				long val = (long)pre*next + next-1;
				
				if (val < min) {
					q.clear();
					q.add(i);
					
					min = val;
					isChange = true;
				} else if (val == min) {
					q.add(i);
				}
			}
			
			if (isChange) {
				while (!q.isEmpty()) {
					int idx = q.poll();
					
					pq.add(ls[idx].start);
					if (ls[idx].start != ls[idx].end)
						pq.add(ls[idx].end);
					
					ls[idx].start++;
					ls[idx].end--;
					
					if (ls[idx].start > ls[idx].end)
						ls[idx].isFinish = 1;
				}
				
				while (!pq.isEmpty()) {
					al.add(pq.poll());
				}
			}
		}
		
		// 3
		for (int i=ls[L].num+1; al.size()<N; i++) {
			al.add(i);
		}
		
		// print
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(al.get(i)).append(' ');
		}
		System.out.println(sb);
	}
}
