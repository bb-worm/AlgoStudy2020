package etc.programmers;

public class Programmers_12913 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		int ans = s.solution(land);
		System.out.println(ans);
	}
	
	static class Solution {
	    int solution(int[][] land) {
	    	
	    	for (int i=1; i<land.length; i++) {
	    		for (int j=0; j<4; j++){
	    			int max = 0;
	    			for (int k=0; k<4; k++) {
	    				if (j==k)
	    					continue;
	    				max = Math.max(max, land[i-1][k]);
	    			}
	    			land[i][j] += max;
    			}
    		}
	    	
	    	int maxVal = 0;
	    	for (int i=0; i<4; i++) {
	    		maxVal = Math.max(maxVal, land[land.length-1][i]);
	    	}
	    	return maxVal;
	    }
	}

}
