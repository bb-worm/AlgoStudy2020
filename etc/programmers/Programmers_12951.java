package etc.programmers;

public class Programmers_12951 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		String str = "3people unFollowed me";
		String str = " 1a b c d e f g h";
		String ans = s.solution(str);
		System.out.println(ans);
	}
	
	static class Solution {
		public String solution(String s) {
			char[] str = s.toCharArray();
			
			int offset = 'a' - 'A';
			
			boolean isFirst = true;
			for (int i=0; i<str.length; i++) {
				if (str[i] == ' ') {
					isFirst = true;
					continue;
				}
				
				if (isFirst && str[i]>='a' && str[i]<='z') {
					str[i] -= offset;
				} else if (!isFirst && str[i]>='A' && str[i]<='Z') {
					str[i] += offset;
				}
				
				isFirst = false;
			}
			
			StringBuilder sb = new StringBuilder();
			for (char ch : str)
				sb.append(ch);
			return sb.toString();
		}
	}
}
