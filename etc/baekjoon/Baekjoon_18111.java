package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_18111 {
	
	static int N, M;
	static int B;
	
	static int[][] map;
	
	static int ansTime;
	static int ansHeight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		int min = Integer.MAX_VALUE;
		int max = 0;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				max = Math.max(max, map[i][j]);
				min = Math.min(min, map[i][j]);
			}
		}
		
		ansTime = Integer.MAX_VALUE;
		ansHeight = 0;
		
		findAns(min, max);
		
		System.out.println(ansTime + " " + ansHeight);
	}
	
	static void findAns(int min, int max) {
		
		for (int h=min; h<=max; h++) {
			
			int time = 0;
			int block = B;
			
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					
					int diff = map[i][j] - h;
					
					if (diff == 0)
						continue;
					
					block += diff;
					
					if (diff > 0) {
						time += diff*2;
					} else {
						time += -diff;
					}
				}
			}
		
			if (block >= 0) {
				
				if (ansTime == time) {
					ansHeight = Math.max(ansHeight, h);
				} else if (ansTime > time) {
					ansTime = time;
					ansHeight = h;
				}
			}
		}
	}
}
