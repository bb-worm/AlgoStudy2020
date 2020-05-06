package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_7662 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Long> maxHeap = new PriorityQueue<>();
		HashMap<Long, Integer> maxHm = new HashMap<>();
		PriorityQueue<Long> minHeap = new PriorityQueue<>();
		HashMap<Long, Integer> minHm = new HashMap<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			int size = 0;
			
			int k = Integer.parseInt(br.readLine());
			
			for (int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				char oper = st.nextToken().charAt(0);
				long num = Long.parseLong(st.nextToken());
				
				if (oper == 'I') {
					maxHeap.add(-num);
					minHeap.add(num);
					size++;
				} else {
					
					if (size == 0)
						continue;
					
					if (num == 1) {
						long del = -maxHeap.poll();
						
						while (minHm.getOrDefault(del, 0) != 0) {
							minHm.put(del, minHm.get(del) - 1);
							del = -maxHeap.poll();
						}
						
						maxHm.put(del, maxHm.getOrDefault(del, 0)+1);
					} else {
						long del = minHeap.poll();
						
						while (maxHm.getOrDefault(del, 0) != 0) {
							maxHm.put(del, maxHm.get(del) - 1);
							del = minHeap.poll();
						}
						
						minHm.put(del, minHm.getOrDefault(del, 0)+1);
					}
					size--;
				}
				
			}
			
			if (size == 0)
				sb.append("EMPTY").append('\n');
			else {
				
				long max = -maxHeap.poll();
				while (minHm.getOrDefault(max, 0) != 0) {
					minHm.put(max, minHm.get(max)-1);
					max = -maxHeap.poll();
				}
				
				long min = minHeap.poll();
				while (maxHm.getOrDefault(min, 0) != 0) {
					maxHm.put(min, maxHm.get(min)-1);
					min = minHeap.poll();
				}
				
				sb.append(max).append(" ").append(min).append('\n');
			}
			
			maxHeap.clear();
			minHeap.clear();
			maxHm.clear();
			minHm.clear();
		}
		System.out.println(sb);
	}

}
