package week9;

import java.io.*;
import java.util.*;

public class Baekjoon_2551 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
				
		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];
		
		long sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			int n = Integer.parseInt(st.nextToken());
			sum += n;
			num[i] = n;
		}
		Arrays.sort(num);
		
		int ans1 = num[(N-1)/2];
		int ans2 = (int)(sum / N);
		if ((double)sum/N - ans2 > 0.5)
			ans2++;
		System.out.println(ans1 + " " + ans2);
	}

}
