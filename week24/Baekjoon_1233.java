package week24;

import java.io.*;
import java.util.*;

public class Baekjoon_1233 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Map<Integer, Integer> hm = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		int S1 = Integer.parseInt(st.nextToken());
		int S2 = Integer.parseInt(st.nextToken());
		int S3 = Integer.parseInt(st.nextToken());
		
		for (int i=1; i<=S1; i++) {
			for (int j=1; j<=S2; j++) {
				for (int k=1; k<=S3; k++) {
					int sum = i+j+k;
					hm.put(sum, hm.getOrDefault(sum, 0) + 1);
				}
			}
		}
		
		Set<Integer> keys = hm.keySet();
		
		int maxSum = 0;
		int maxNum = 0;
		for (int key : keys) {
			if (maxSum < hm.get(key) || (maxSum == hm.get(key) && maxNum > key)) {
				maxSum = hm.get(key);
				maxNum = key;
			}
		}
		
		System.out.println(maxNum);
	}

}
