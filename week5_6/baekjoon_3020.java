package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_3020 {
	
	public static int N, H;
	public static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H];
		
		int val;
		for (int i=0; i<N; i++) {
			val = Integer.parseInt(br.readLine()) - 1;
			
			// 아래에서 
			if (i%2 == 0) {
				map[0]++;
				map[val+1]--;
			} 
			// 위에서 
			else {
				map[H-val-1]++;
			}
		}
		
		// 누적 
		for (int i=1; i<H; i++) {
			map[i] += map[i-1];
		}
		
		int min = map[0];
		int cnt = 1;
		
		for (int i=1; i<H; i++) {
			if (min > map[i]) {
				min = map[i];
				cnt = 1;
			} else if (min == map[i]) {
				cnt++;
			}
		}
//		printMap();
		System.out.println(min + " " + cnt);
	}
	
	public static void printMap() {
		for (int i=0; i<H; i++) {
			System.out.print(map[i]+ " ");
		}System.out.println();
	}
}