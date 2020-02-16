package week4;

import java.io.*;
import java.util.*;

public class baekjoon_2309 {
	
	public static int[] height;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		height = new int[9];
		int sum = 0;
		for (int i=0; i<9; i++) {
			height[i] = Integer.parseInt(br.readLine());
			sum += height[i];
		}
		
		Arrays.sort(height);
		
		int target = sum - 100;
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				if (i==j)
					continue;
				if (height[i]+height[j] == target) {
					for (int k=0; k<9; k++) {
						if (k==i || k==j)
							continue;
						System.out.println(height[k]);
					}
					return;
				}
			}
		}

	}
}
