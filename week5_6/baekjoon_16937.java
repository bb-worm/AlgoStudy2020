package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_16937 {
	
	public static int H, W;
	public static int N;
	
	public static int[][] map;
	public static int[][] sticker;
	
	public static int[] use;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		map = new int[H][W];
		
		N = Integer.parseInt(br.readLine());
		sticker = new int[N][2];
		use = new int[2];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			sticker[i][0] = Integer.parseInt(st.nextToken());
			sticker[i][1] = Integer.parseInt(st.nextToken());
		}
		
		ans = Integer.MIN_VALUE;
		choose(0, 0);
		if (ans == Integer.MIN_VALUE)
			ans = 0;
		System.out.println(ans);
	}
	
	public static void choose(int idx, int select) {
		if (select >= 2) {
			
			int h1 = sticker[use[0]][0];
			int w1 = sticker[use[0]][1];
			int h2 = sticker[use[1]][0];
			int w2 = sticker[use[1]][1];
			
			if ((h1*w1)+(h2*w2) <= ans)
				return;
//			System.out.println((h1*w1)+(h2*w2));
			
			check(h1, w1, h2, w2);
			check(h1, w1, w2, h2);
			check(w1, h1, h2, w2);
			check(w1, h1, w2, h2);
			
			return;
		}
		
		for (int i=idx; i<N; i++) {
			use[select] = i;
			choose(i+1, select+1);
		}
	}
	
	public static void check(int h1, int  w1, int  h2, int  w2) {
//		System.out.println(h1 + " " + w1 + " " +h2 + " " + w2);
//		System.out.println((h1-1) + " " + (H-h2) + " " + (w1-1) + " " + (W-w2));
//		System.out.println();
		
		if (h1>H || h2>H || w1>W || w2>W)
			return;
		
		
		if (h1-1 >= H-h2 && w1-1 >= W-w2) {
			return;
		}

		ans = (h1*w1) + (h2*w2);
	}
}
