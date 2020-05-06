package etc.programmers;

import java.util.StringTokenizer;

public class Programmers_12939 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		String str = "1 2 3 4";
		s.solution(str);

	}
	
	static class Solution {
		public String solution(String s) {
			
			StringTokenizer st = new StringTokenizer(s);
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			while (st.hasMoreTokens()) {
				int num = Integer.parseInt(st.nextToken());
				min = Math.min(min, num);
				max = Math.max(max, num);
			}
			
			return min + " " + max;
			
		}
	}

}
