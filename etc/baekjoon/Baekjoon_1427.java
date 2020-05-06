package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1427 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String N = br.readLine();
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i=0; i<N.length(); i++)
			pq.add(-(N.charAt(i) - '0'));
		
		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			sb.append(-pq.poll());
		}
		System.out.println(sb);
	}

}
