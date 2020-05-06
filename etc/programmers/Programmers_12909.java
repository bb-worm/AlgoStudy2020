package etc.programmers;

public class Programmers_12909 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		String str = "()()";
//		String str = "(())()";
//		String str = ")()(";
		String str = "(()(";
		System.out.println(s.solution(str));
	}
	
	static class Solution {
	    boolean solution(String s) {

	    	int open = 0;
	    	
	    	for (int i=0; i<s.length(); i++) {
	    		char ch = s.charAt(i);
	    		
	    		if (ch == '(')
	    			open++;
	    		else if (ch == ')') {
	    			if (open <= 0)
	    				return false;
	    			else
	    				open--;
	    		}
	    	}
	    	
	    	if (open == 0)
	    		return true;
	    	else
	    		return false;
	    }
	}
}
