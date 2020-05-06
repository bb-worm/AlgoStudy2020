package etc.programmers;

import java.util.Queue;
import java.util.LinkedList;

public class Programmers_12980 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 5000;
		int ans = s.solution(n);
		System.out.println(ans);
	}
	
	static public class Solution {
	    public int solution(int n) {
	    	
	    	int ans = 0;
	    	while (n>0) {
	    		if (n%2 == 0)
	    			n = n/2;
	    		else {
	    			ans++;
	    			n = (n-1)/2;
	    		}
	    	}
	    	return ans;
	    }
	}

}
