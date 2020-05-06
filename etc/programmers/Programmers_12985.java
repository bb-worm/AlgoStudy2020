package etc.programmers;

public class Programmers_12985 {

	public static void main(String[] args) {

		Solution s = new Solution();
//		int n = 8;
//		int a = 4;
//		int b = 7;
		int n = 8;
		int a = 2;
		int b = 3;
		int ans = s.solution(n, a, b);
		System.out.println(ans);
	}
	
	static class Solution {
	    public int solution(int n, int a, int b) {
	    	
	    	int ans = 0;
	    	while (true) {
	    		ans++;
	    		
	    		for (int i=1; i<=n; i+=2) {
	    			if ((i==a && i+1==b) || (i==b && i+1==a)) {
	    				return ans;
	    			}
	    			
	    			if (i==a || i+1==a)
	    				a = (i+1)/2;
	    			else if (i==b || i+1==b)
	    				b = (i+1)/2;
	    		}
	    		
	    		n /= 2;
	    	}
	    }
	}

}
