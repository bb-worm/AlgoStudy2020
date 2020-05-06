package etc.programmers;

import java.util.Stack;

public class Programmers_12973 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
//		String str = "baabaa";
//		String str = "cdcd";
		String str = "aa";
		int ans = s.solution(str);
		System.out.println(ans);
	}
	
	static class Solution {
	    public int solution(String s) {
	    	
	    	Stack<Character> stack = new Stack<>();
	    	
	    	for (int i=0; i<s.length(); i++) {
	    		char ch = s.charAt(i);
	    		
	    		if (stack.isEmpty()) {
	    			stack.push(ch);
	    		} else {
	    			if (stack.peek() == ch)
	    				stack.pop();
	    			else
	    				stack.push(ch);
	    		}
	    	}
	    	
	    	if (stack.size() == 0)
	    		return 1;
	    	else
	    		return 0;
	    }
	}
}
