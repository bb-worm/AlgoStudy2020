package etc.programmers;

public class Programmers_12924 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 15;
		int ans = s.solution(n);
		System.out.println(ans);
	}
	
	static class Solution {
		public int solution(int n) {
			int ans = 0;
			
			int start = 1;
			int sum = 0;
			
			for (int i=1; i<=n; i++) {
				sum += i;
				
				while (sum > n) {
					sum -= start;
					start++;
				}
				
				if (sum == n) {
					ans++;
					sum -= start;
					start++;
				}
			}
			
			return ans;
		}
	}

}
