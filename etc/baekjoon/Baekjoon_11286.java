package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11286 {
	
	static class Number implements Comparable<Number> {
		int num;
		
		public Number(int num) {
			this.num = num;
		}
		
		public int compareTo(Number n) {
			if (Math.abs(this.num) == Math.abs(n.num))
				return this.num - n.num;
			else
				return Math.abs(num) - Math.abs(n.num);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Number> pq = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		int num;
		for (int i=0; i<N; i++){
			num = Integer.parseInt(br.readLine());
			
			if (num == 0) {
				if (pq.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					int pop = pq.poll().num;
					sb.append(pop).append('\n');
				}
			} else {
				pq.add(new Number(num));
			}
		}
		System.out.println(sb);
	}

}
