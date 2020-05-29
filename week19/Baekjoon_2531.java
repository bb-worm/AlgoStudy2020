package week19;

import java.io.*;
import java.util.*;

public class Baekjoon_2531 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[] plate = new int[N];
		for (int i=0; i<N; i++)
			plate[i] = Integer.parseInt(br.readLine());
		
		int[] eat = new int[d+1];
		eat[c]++; // coupon
		
		int ans;
		int total = 1;
		
		for (int i=0; i<k; i++) {
			eat[plate[i]]++;
			if (eat[plate[i]] == 1)
				total++;
		}
		ans = total;
		
		int left=0, right=k-1;
		for (int i=1; i<N; i++) {
			eat[plate[left]]--;
			if (eat[plate[left]] == 0)
				total--;
			left++;
			
			right = (right+1)%N;
			eat[plate[right]]++;
			if (eat[plate[right]] == 1)
				total++;
			
			ans = Math.max(ans, total);
		}
		
		System.out.println(ans);
	}
}
