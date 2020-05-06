package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_7568 {
	
	static class Person {
		int idx;
		int weight;
		int height;
		
		public Person(int idx, int weight, int height) {
			this.idx = idx;
			this.weight = weight;
			this.height = height;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Person[] person = new Person[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			person[i] = new Person(i, w, h);
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int i=0; i<N; i++) {
			int rank = 1;
			for (int j=0; j<N; j++) {
				if (i==j)
					continue;
				
				if (person[i].weight < person[j].weight && person[i].height < person[j].height)
					rank++;
			}
			sb.append(rank).append(' ');
		}
		
		System.out.println(sb);
	}
}
