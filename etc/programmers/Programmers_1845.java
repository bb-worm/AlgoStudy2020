package etc.programmers;

import java.util.HashSet;
import java.util.Set;

public class Programmers_1845 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] nums = {3,1,2,3};
//		int[] nums = {3,3,3,2,2,4};
		int[] nums = {3,3,3,2,2,1};
		int ans = s.solution(nums);
		System.out.println(ans);
	}
	
	static class Solution {
	    public int solution(int[] nums) {
	    	
	    	Set<Integer> hs = new HashSet<>();
	    	
	    	int select = 0;
	    	for (int i=0; i<nums.length && select<nums.length/2; i++) {
	    		if (!hs.contains(nums[i])) {
	    			hs.add(nums[i]);
	    			select++;
	    		}
	    	}
	    	
	    	return hs.size();
	    }
	}

}
