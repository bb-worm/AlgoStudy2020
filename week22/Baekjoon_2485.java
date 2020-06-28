package week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon_2485 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];
		
		for (int i=0; i<N; i++) {
			nums[i] = Integer.parseInt(br.readLine());
		}
		
		int gcd = nums[1] - nums[0];
		for (int i=2; i<N; i++) {
			gcd = getGcd(gcd, nums[i]-nums[i-1]);
		}
		
		// 정답 도출 
		int ans = 0;
		for (int i=1; i<N; i++) {
			ans += (nums[i]-nums[i-1])/gcd - 1;
		}
		
		System.out.println(ans);
	}
	
	// 유클리드 호제법으로 최대공약수 구하기 
	static int getGcd(int n1, int n2) {
		
		while (n1>0 && n2>0) {
			if (n1 > n2) {
				n1 %= n2;
			}
			else {
				n2 %= n1;
			}
		}
		
		if (n1==0)
			return n2;
		else
			return n1;
	}
}
