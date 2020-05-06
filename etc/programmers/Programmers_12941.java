package etc.programmers;

import java.util.Arrays;

public class Programmers_12941 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[] A = {1, 4, 2};
		int[] B = {5, 4, 4};
		int ans = s.solution(A, B);
		System.out.println(ans);
	}
	
	static class Solution {
	    public int solution(int []A, int []B) {
	    	
	    	Arrays.sort(A);
	    	Arrays.sort(B);
	    	
	    	int ans = 0;
	    	
	    	for (int i=0; i<A.length; i++) {
	    		ans += (A[i]*B[B.length-1-i]);
	    	}
	    	
	    	return ans;
	    }
	}

}
