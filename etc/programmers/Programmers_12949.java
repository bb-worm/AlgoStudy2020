package etc.programmers;

public class Programmers_12949 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] arr1 = {{1,4}, {3,2}, {4,1}};
		int[][] arr2 = {{3,3},{3,3}};
		int[][] ans = s.solution(arr1, arr2);
		for (int i=0; i<ans.length; i++) {
			for (int j=0; j<ans[0].length; j++) {
				System.out.print(ans[i][j] + " " );
			}System.out.println();
		}System.out.println();
	}
	
	static class Solution {
		public int[][] solution(int[][] arr1, int[][] arr2) {
			
			int r1 = arr1.length;
			int c1 = arr1[0].length;
			
			int r2 = arr2.length;
			int c2 = arr2[0].length;
			
			int[][] ans = new int[r1][c2];
			for (int i=0; i<r1; i++) {
				for (int j=0; j<c2; j++) {
					
					for (int k=0; k<c1; k++) {
						ans[i][j] += arr1[i][k]*arr2[k][j];
					}
					
				}
			}
			
			return ans;
	    }
	}

}
