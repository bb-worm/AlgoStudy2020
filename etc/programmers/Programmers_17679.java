package etc.programmers;

public class Programmers_17679 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		int m = 4;
//		int n = 5;
//		String[] board = {"CCBDE", "AAADE", "AAABF", "CCBBF"};
		int m = 6;
		int n = 6;
		String[] board = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
		int ans = s.solution(m, n, board);
		System.out.println(ans);
	}
	
	static class Solution {
		
		char[][] map;
		int ans;
		
		public int solution(int m, int n, String[] board) {
			
			map = new char[m][n];
			for (int i=0; i<m; i++)
				map[i] = board[i].toCharArray();
			
			ans = 0;
			while (check(m, n)) {
//				printMap(m, n);
				down(m, n);
			}
			return ans;
		}
		
		int[] da = {0, 1, 1};
		int[] db = {1, 0, 1};
		
		boolean check(int m, int n) {
			
			int[][] delete = new int[m][n];
			boolean isChange = false;
			
			for (int i=0; i<m-1; i++) {
				for (int j=0; j<n-1; j++) {
					
					if (map[i][j] == '0')
						continue;
					
					boolean isSame = true;
					int na, nb;
					for (int k=0; k<3; k++) {
						na = i + da[k];
						nb = j + db[k];
						if (map[i][j] != map[na][nb]) {
							isSame = false;
							break;
						}
					}

					if (isSame) {
						if (delete[i][j] == 0)
							ans++;
						
						delete[i][j] = 1;
						for (int k=0; k<3; k++) {
							if (delete[i+da[k]][j+db[k]] == 0)
								ans++;
							
							delete[i+da[k]][j+db[k]] = 1;
						}
						isChange = true;
					}
				}
			}
			
			if (isChange) {
				for (int i=0; i<m; i++) {
					for (int j=0; j<n; j++) {
						if (delete[i][j] == 1)
							map[i][j] = '0';
					}
				}
			} 
			
			return isChange;
		}
		
		void down(int m, int n) {
			
			for (int j=0; j<n; j++) {
				for (int i=m-1; i>=0; i--) {
					if (map[i][j] == '0') {
						
						int k = i-1;
						while (k>=0 && map[k][j] == '0')
							k--;
						
						if (k<0)
							break;
						map[i][j] = map[k][j];
						map[k][j] = '0';
						
					}
				}
			}
		}
		
		void printMap(int m, int n) {
			for (int i=0; i<m; i++) {
				for (int j=0; j<n; j++) {
					System.out.print(map[i][j] + " ");
				}System.out.println();
			}System.out.println();
		}
	}

}
