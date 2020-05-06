package etc.programmers;

public class Programmers_12905 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[][] board = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
//		int[][] board = {{0,0,1,1},{1,1,1,1}};
//		int[][] board = {{1,1,0,0},{1,1,0,0},{0,0,0,0},{0,0,0,0}};
		int[][] board = {{0},{1}};
		int ans = s.solution(board);
		System.out.println(ans);
	}
	
	static class Solution {
		
	    public int solution(int[][] board) {

	    	int R = board.length;
	    	int C = board[0].length;
	    	
	    	int[][] col = new int[R][C];
	    	int[][] row = new int[R][C];
	    	
	    	for (int i=0; i<R; i++) {
	    		for (int j=0; j<C; j++) {
	    			if (j!=0) 
	    				row[i][j] += row[i][j-1];

    				row[i][j] += board[i][j];
	    		}
	    	}
	    	
	    	for (int j=0; j<C; j++) {
	    		for (int i=0; i<R; i++) {
	    			if (i!=0) 
	    				col[i][j] += col[i-1][j];
	    			
	    			col[i][j] += board[i][j];
	    		}
	    	}
	    	
//	    	printArr(row);
//	    	printArr(col);
	    	
	    	int length = 0;
	    	
	    	for (int i=0; i<R; i++) {
	    		for (int j=0; j<C; j++) {
	    			if (board[i][j] == 0)
	    				continue;
	    			
	    			while (check(R, C, i, j, length+1, col, row))
	    				length++;
	    		}
	    	}
	    	
	    	return length*length;
	    }
	    
	    private boolean check(int R, int C, int a, int b, int len, int[][] col, int[][] row) {
	    	if (a+len-1 >= R || b+len-1 >= C)
	    		return false;
	    	
	    	for (int i=a; i<a+len; i++) {
	    		int rowVal = row[i][b+len-1];
	    		if (b!=0)
	    			rowVal -= row[i][b-1];
	    		
	    		if (rowVal != len)
	    			return false;
	    	}
	    	
	    	for (int j=b; j<b+len; j++) {
	    		int colVal = col[a+len-1][j];
	    		if (a!=0)
	    			colVal -= col[a-1][j];
	    		
	    		if (colVal != len)
	    			return false;
	    	}
	    	
	    	return true;
	    }
	    
	    void printArr(int[][] arr) {
	    	for (int i=0; i<arr.length; i++) {
	    		for (int j=0; j<arr[0].length; j++) {
	    			System.out.print(arr[i][j] + " ");
	    		}System.out.println();
	    	}System.out.println();
	    }
	}
	

}
