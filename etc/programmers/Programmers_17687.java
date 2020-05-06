package etc.programmers;

public class Programmers_17687 {

	public static void main(String[] args) {	
		Solution s = new Solution();
		int n = 2;
		int t = 4;
		int m = 2;
		int p = 1;
		String ans = s.solution(n, t, m, p);
		System.out.println(ans);
	}
	
	static class Solution {
		public String solution(int n, int t, int m, int p) {
			
			StringBuilder sb = new StringBuilder();

			int num = 0;

			int turn = 1;
			while (sb.length() < t) {
				
				String next = change(num, n);
				num++;
				
				for (int i=0; i<next.length(); i++) {
					if (turn == p) {
						sb.append(next.charAt(i));
						if (sb.length() == t) {
							break;
						}
					}
					
					turn++;
					if (turn > m)
						turn = 1;
				}
			}
			
			return sb.toString();
			
		}
		
		char[] number = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
		
		String change(int num, int n) {
			
			StringBuilder sb = new StringBuilder();
			
			while (num >= n) {
				sb.append(number[num%n]);
				num /= n;
			}
			sb.append(number[num]);
			
			return sb.reverse().toString();
		}
	}

}
