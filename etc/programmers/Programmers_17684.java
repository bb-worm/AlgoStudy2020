package etc.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Programmers_17684 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		String msg = "KAKAO";
		String msg = "TOBEORNOTTOBEORTOBEORNOT";
		int[] ans = s.solution(msg);
		for (int i : ans)
			System.out.print(i + " ");
	}
	
	static class Solution {
		public int[] solution(String msg) {
			
			ArrayList<Integer> al = new ArrayList<>();
			Map<String, Integer> hm = new HashMap<>();
			
			for (int i=1; i<=26; i++) {
				hm.put(Character.toString((char)('A'+i-1)), i);
			}
			
			StringBuilder sb = new StringBuilder();
			sb.append(msg.charAt(0));
			int pre = hm.get(sb.toString());
			
			for (int i=1; i<msg.length(); i++) {
				sb.append(msg.charAt(i));
				if (hm.getOrDefault(sb.toString(), 0) == 0) {
					al.add(pre);
					hm.put(sb.toString(), hm.size()+1);
					sb = new StringBuilder();
					i--;
				} else {
					pre = hm.get(sb.toString());
				}
			} al.add(hm.get(sb.toString()));
			
			
			int[] ans = new int[al.size()];
			for (int i=0; i<al.size(); i++)
				ans[i] = al.get(i);

			return ans;
		}
	}

}
