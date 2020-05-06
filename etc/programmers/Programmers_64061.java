package etc.programmers;

import java.util.Arrays;
import java.util.Stack;

public class Programmers_64061 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] board = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
		int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};
		int ans = s.solution(board, moves);
		System.out.println(ans);
	}
	
	static class Solution {
	    public int solution(int[][] board, int[] moves) {
	    	int ans = 0;
	    	
	    	int[] idx = new int[board[0].length];
	    	Arrays.fill(idx, -1);
	    
	    	for (int i=0; i<board.length; i++) {
	    		for (int j=0; j<board[0].length; j++) {
	    			if (idx[j] == -1 && board[i][j] != 0) {
	    				idx[j] = i;
	    			}
	    		}
	    	}
	    	
	    	Stack<Integer> s = new Stack<>();
	    	
	    	int a, b;
	    	for (int j : moves) {
	    		if (idx[j-1] < board.length) {
	    			a = idx[j-1];
	    			b = j-1;
	    			idx[j-1]++;
	    			
	    			if (s.isEmpty() || s.peek()!=board[a][b]) {
	    				s.add(board[a][b]);
	    			} else {
	    				s.pop();
	    				ans += 2;
	    			}
	    		}
	    	}
	    	
	    	return ans;
	    }
	}

}
