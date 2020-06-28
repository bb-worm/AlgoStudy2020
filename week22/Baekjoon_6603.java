package week22;

import java.io.*;
import java.util.*;

public class Baekjoon_6603 {
	
	static int K;
	static int[] nums;
	static int[] order = new int[6];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while (true) {
			st = new StringTokenizer(br.readLine());
			K = Integer.parseInt(st.nextToken());
			if (K==0)
				break;
			
			nums = new int[K];
			for (int i=0; i<K; i++)
				nums[i] = Integer.parseInt(st.nextToken());
			
			combination(0, 0);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void combination(int orderNum, int idx) {
		if (orderNum >= 6) {
			
			for (int i=0; i<6; i++) {
				sb.append(order[i]).append(' ');
			}sb.append('\n');
			
			return;
		}
		
		if (idx >= K)
			return;
		
		if (6-orderNum > K-idx)
			return;
		
		order[orderNum] = nums[idx];
		combination(orderNum+1, idx+1);
		order[orderNum] = 0;
		
		combination(orderNum, idx+1);
	}
}
