package etc.programmers;

public class Programmers_12911 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		int n = 78;
		int n = 15;
		System.out.println(s.solution(n));
	}
	
	static class Solution {
		public int solution(int n) {
			
			int origin = oneNum(n);
			
			for (int i=n+1; ; i++) {
				if (oneNum(i) == origin)
					return i;
			}
		}
		
		int oneNum(int n) {
			
			int total = 0;
			String bi = Integer.toBinaryString(n);
			for (int i=0; i<bi.length(); i++)
				total += bi.charAt(i) - '0';
			return total;
		}
	}

}
