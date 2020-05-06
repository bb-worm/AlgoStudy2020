package etc.programmers;

public class Programmers_12953 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] arr = {2, 6, 8, 14};
		int ans = s.solution(arr);
		System.out.println(ans);
	}
	
	static class Solution {
		public int solution(int[] arr) {
			
			int num = 0;
			
			for (int i : arr) {
				num = Math.max(num, i);
			}
			
			int ans = num;
			boolean canOut = false;
			while (!canOut) {
				canOut = true;
				
				for (int i : arr) {
					if (ans%i != 0) {
						canOut = false;
						ans += num;
						break;
					}
				}
			}
			
			return ans;
		}
	}
}
