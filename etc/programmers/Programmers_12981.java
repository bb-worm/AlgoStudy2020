package etc.programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers_12981 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		int n = 3;
		String[] words = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		int[] ans = s.solution(n, words);
		for (int i : ans)
			System.out.println(i);
	}
	
	static class Solution {
	    public int[] solution(int n, String[] words) {
	    	
	    	int[] ans = new int[2];
	    	ans[1] = 1;
	    	
	    	Set<String> hs = new HashSet<>();
	    	
	    	int last = words[0].charAt(0);
	    	
	    	int j = 1;
	    	for (int i=0; i<words.length; i++) {
	    		if (words[i].charAt(0) != last || hs.contains(words[i])) {
	    			ans[0] = j;
	    			break;
	    		}
	    		
	    		last = words[i].charAt(words[i].length()-1);
	    		hs.add(words[i]);
	    		
	    		j++;
	    		if (j == n+1) {
	    			ans[1]++;
	    			j = 1;
	    		}
	    	}
	    	
	    	if (ans[0] == 0)
	    		ans[1] = 0;
	    	
	    	return ans;
	    }
	}

}
