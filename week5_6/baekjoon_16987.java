package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_16987 {
	
	static class Egg{
		int idx;
		int durability;
		int weight;
		
		public Egg(int idx, int durability, int weight) {
			this.idx = idx;
			this.durability = durability;
			this.weight = weight;
		}
	}
	
	public static int N;
	public static Egg[] egg;
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		egg = new Egg[N];
		
		int durability;
		int weight;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			durability = Integer.parseInt(st.nextToken());
			weight = Integer.parseInt(st.nextToken());
			egg[i] = new Egg(i, durability, weight);
		}
		
		ans = 0;
		DFS(0);
		System.out.println(ans);
	}
	
	public static void DFS(int now) {
		if (now >= N) {
			int sum = 0;
			for (int i=0; i<N; i++) {
				if (egg[i].durability <= 0) {
					sum++;
				}
			}
			ans = Math.max(ans, sum);
			return;
		}
		
		if (egg[now].durability <= 0) {
			DFS(now+1);
			return;
		}
		
		for (int i=0; i<N; i++) {
			if (i==now || egg[i].durability <= 0)
				continue;
			
			egg[i].durability -= egg[now].weight;
			egg[now].durability -= egg[i].weight;
			
			DFS(now+1);
			
			egg[i].durability += egg[now].weight;
			egg[now].durability += egg[i].weight;
		}
		
		if (now == N-1) {
			DFS(now+1);
		}
	}
}
