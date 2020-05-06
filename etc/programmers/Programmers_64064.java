package etc.programmers;

import java.util.ArrayList;
import java.util.List;

public class Programmers_64064 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//		String[] banned_id = {"fr*d*", "abc1**"};
//		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
//		String[] banned_id = {"*rodo", "*rodo", "******"};
		String[] user_id = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] banned_id = {"fr*d*", "*rodo", "******", "******"};
		int ans = s.solution(user_id, banned_id);
		System.out.println(ans);
	}
	
	static class Solution {
		
		int[] isUse;
		String[] str;
		int ans;
		
		List<String[]> al = new ArrayList<>();
		
		public int solution(String[] user_id, String[] banned_id) {
			
			isUse = new int[banned_id.length];
			str = new String[banned_id.length];
			ans = 0;
			DFS(0, 0, user_id, banned_id);
			printAll();
			return ans;
			
	    }
		
		void printAll() {
			for (String[] list : al) {
				for (String str : list) {
					System.out.print(str + " ");
				}System.out.println();
			}
		}
		
		void DFS(int idx, int total, String[] user_id, String[] banned_id) {
			
			if (total >= banned_id.length) {
				
				if (!containCheck()) {
					String[] tmp = copy(str);
					al.add(tmp);
					ans++;
				}
				
				return;
			}
			
			if (idx >= user_id.length)
				return;
			
			for (int i=idx; i<user_id.length; i++) {
				for (int j=0; j<banned_id.length; j++) {
					if (isUse[j]==0 && check(user_id[i], banned_id[j])) {
						isUse[j] = 1;
						str[j] = user_id[i];
						DFS(i+1, total+1, user_id, banned_id);
						isUse[j] = 0;
					}
				}
			}
		}
		
		String[] copy(String[] arr) {
			String[] tmp = new String[arr.length];
			for (int i=0; i<arr.length; i++)
				tmp[i] = arr[i];
			return tmp;
		}
		
		boolean containCheck() {
			
			for (String[] list : al) {
				boolean isContain = true;
				
				for (int i=0; i<str.length; i++) {
					boolean isSame = false;
					for (int j=0; j<list.length; j++) {
						if (str[i].equals(list[j])) {
							isSame = true;
							break;
						}
					}
					if (!isSame) {
						isContain = false;
						break;
					}
				}
				
				if (isContain)
					return true;
				
			}
			return false;
		}
		
		boolean check(String user, String bann) {
			if (user.length() != bann.length())
				return false;
			
			for (int i=0; i<user.length(); i++) {
				if (bann.charAt(i)!='*' && bann.charAt(i)!=user.charAt(i))
					return false;
			}
			
			return true;
		}
	}

}
