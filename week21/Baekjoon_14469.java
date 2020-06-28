package week21;

import java.io.*;
import java.util.*;

public class Baekjoon_14469 {
	
	static class Cow implements Comparable<Cow>{
		int arriveTime;
		int censorTime;
		
		public Cow(int arriveTime, int censorTime) {
			this.arriveTime = arriveTime;
			this.censorTime = censorTime;
		}
		public int compareTo(Cow cow) {
			return this.arriveTime - cow.arriveTime;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		Cow[] cow = new Cow[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int arrive = Integer.parseInt(st.nextToken());
			int censor = Integer.parseInt(st.nextToken());
			cow[i] = new Cow(arrive, censor);
		}
		
		Arrays.sort(cow);
		
		int ans = 0;
		
		for (int i=0; i<N; i++) {
			ans = Math.max(ans, cow[i].arriveTime) + cow[i].censorTime;
		}
		
		System.out.println(ans);
	}
}
