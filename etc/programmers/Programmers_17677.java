package etc.programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_17677 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String str1 = "FRANCE";
		String str2 = "french"; 
		int ans = s.solution(str1, str2);
		System.out.println(ans);
	}
	
	static class Solution {
		public int solution(String str1, String str2) {
			
			char[] s1 = str1.toLowerCase().toCharArray();
			char[] s2 = str2.toLowerCase().toCharArray();
			
			Map<String, Integer> hm = new HashMap<>();
			
			int total = 0;
			int same = 0;
			
			for (int i=0; i<s1.length-1; i++) {
				
				if (Character.isLetter(s1[i]) && Character.isLetter(s1[i+1])) {
					String str = s1[i] + "" + s1[i+1];
					hm.put(str, hm.getOrDefault(str, 0) + 1);
					total++;
				}
			}
			
			for (int i=0; i<s2.length-1; i++) {
				if (Character.isLetter(s2[i]) && Character.isLetter(s2[i+1])) {
					String str = s2[i] + "" +s2[i+1];

					if (hm.getOrDefault(str, 0) == 0) {
						total++;
					} else {
						hm.put(str, hm.get(str)-1);
						same++;
					}
				}
			}
			
			if (total == 0)
				return 65536;

			return same*65536/total;
		}
	}

}
