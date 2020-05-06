package etc.programmers;

public class Programmers_12945 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 3;
		int ans = s.solution(n);
		
		System.out.println(ans);
	}
	
	static class Solution {
		
		int[] dp = new int[100001];
		
		public int solution(int n) {
			dp[1] = 1;
			return fibbo(n);
		}
		
		int fibbo(int n) {
			if (n==0)
				return 0;
			
			if (dp[n] != 0)
				return dp[n];
			
			return dp[n] = (fibbo(n-2) + fibbo(n-1))%1234567;
		}
	}

}
