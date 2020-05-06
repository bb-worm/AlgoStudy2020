package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_4902 {
	
	public static int N;
	public static int[] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int t=1; ; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			if (N==0)
				break;
			
			int ans = Integer.MIN_VALUE;
			
			map = new int[N*N];
			for (int i=0; i<N*N; i++) {
				map[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<N*N; i++) {
				int layer = (int)Math.sqrt(i) + 1;
				
				// 삼각형 탐색 
				if ((layer%2==1 && i%2==0) || (layer%2==0 && i%2==1))
					ans = Math.max(ans, check(i));
				// 뒤집힌 삼각형 거꾸로 탐색 
				else
					ans = Math.max(ans, reverseCheck(i));
			}
			
			System.out.printf("%d. %d\n", t, ans);
		}
	}
	
	public static int check(int idx) {
		int max = Integer.MIN_VALUE;
		int layer = (int)Math.sqrt(idx) + 1; // 현재 층 
		int offset = 2*layer; // 다음 값을 지정하기 위한 값 
		int size = 1;
//		System.out.println("idx: " +idx);
		int sum = 0;
		while (true) {
			
			for (int i=idx; i<idx+size; i++) {
				if (i >= N*N) {
//					System.out.println("max: " + max +  ", sum: " + sum);
					return max;
				}
//				System.out.print(i + " ");
				sum += map[i];
			}
//			System.out.println();
			max = Math.max(max, sum);
			idx += offset-1;
			size += 2;
			offset += 2;
		}
	}
	
	public static int reverseCheck(int idx) {
		int max = Integer.MIN_VALUE;
		int layer = (int)Math.sqrt(idx) + 1;
		int offset = 2*layer-2;
		layer++;
		int size = 1;
//		System.out.println("idx: " +idx);
		int sum = 0;
		while (true) {
			
			int leftLayer = (int)Math.sqrt(idx) + 1;
			int rightLayer = (int)Math.sqrt(idx+size-1) + 1;
			if (leftLayer != rightLayer) {
//				System.out.println("max: " + max +  ", sum: " + sum);
				return max;
			}
			
			for (int i=idx; i<idx+size; i++) {
				if (i<0) {
//					System.out.println("max: " + max +  ", sum: " + sum);
					return max;
				}
//				System.out.print(i + " ");
				sum += map[i];
			}
//			System.out.println();
			max = Math.max(max, sum);
			idx -= (offset + 1);
			size += 2;
			offset -= 2;
		}
	}
}
