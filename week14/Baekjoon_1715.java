package week14;

import java.io.*;
import java.util.*;

public class Baekjoon_1715 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=0; i<N; i++) {
			pq.add(Integer.parseInt(br.readLine()));
		}
		
		int ans = 0;
		
		int a, b;
		while (pq.size() > 1) {
			a = pq.poll();
			b = pq.poll();
			ans += a+b;
			pq.add(a+b);
		}
		pq.clear();
		
		System.out.println(ans);
	}

}
