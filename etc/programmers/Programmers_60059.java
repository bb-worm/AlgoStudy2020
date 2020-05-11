package etc.programmers;

public class Programmers_60059 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[][] key = {{1, 1}, {0, 0}};
//		int[][] key = {{1, 1, 1, 1}, {0, 0, 0, 0}, {1, 1, 1, 1}, {0, 0, 0, 0}};
		int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		boolean ans = s.solution(key, lock);
		System.out.println(ans);
	}
	
	static class Solution {
	    public boolean solution(int[][] key, int[][] lock) {
	        int m = key.length;
	        int n = lock.length;
	        int offset = m-1;
	        
	        int[][] map = new int[offset*2+n][offset*2+n];
	        for (int i=0; i<map.length; i++){
	            for (int j=0; j<map.length; j++)
	                map[i][j] = -1;
	        }
	        
	        fillMapWithLock(map, lock, offset, n);
	        
	        for (int k=0; k<4; k++) {
	        	
	        	for (int i=0; i<map.length-offset; i++){
	        		for (int j=0; j<map[0].length-offset; j++){
	        			
	        			boolean canDo = true;
	        			for (int a=0; a<m && canDo; a++){
	        				for (int b=0; b<m; b++){
	        					int na = i+a;
	        					int nb = j+b;
	        					
	        					if (map[na][nb] == -1)
	        						continue;
	        					
	        					map[na][nb] += key[a][b];
	        					
	        					if (map[na][nb] != 1){
	        						canDo = false;
	        						break;
	        					}
	        				}
	        			}
	        			
//	                printMap(map, offset, n);
	        			
	        			if (canDo && check(map, offset, n)){
	        				return true;
	        			}
	        			fillMapWithLock(map, lock, offset, n);
	        		}
	        	}
	        	
	        	rotate(key);
	        }
	        return false;
	    }
	    
	    void rotate(int[][] key) {
	    	
	    	int[][] tmp = new int[key.length][key.length];
	    	for (int i=0; i<key.length; i++) {
	    		for (int j=0; j<key.length; j++)
	    			tmp[i][j] = key[i][j];
	    	}
	    	
	    	int a = 0, b = 0;
	    	int len = key.length;
	    	
	    	while (len > 1) {
	    		int limit = a+len-1;
	    		for (int i=0; i<len; i++) {
	    			key[a+i][limit] = tmp[a][a+i];
	    			key[a][a+i] = tmp[limit-i][b];
	    			key[limit-i][b] = tmp[limit][limit-i];
	    			key[limit][limit-i] = tmp[a+i][limit];
	    		}
	    		
	    		a++;
	    		b++;
	    		len -= 2;
	    	}
	    	
	    }
	    
	    void printArr(int[][] arr) {
	    	for (int i=0; i<arr.length; i++) {
	    		for (int j=0; j<arr[0].length; j++)
	    			System.out.printf("%2d ",arr[i][j]);
	    		System.out.println();
	    	}System.out.println();
	    }
	    
	    void printMap(int[][] map, int offset, int n) {
	    	for (int i=0; i<n; i++){
	            for (int j=0; j<n; j++){
	                System.out.print(map[i+offset][j+offset] + " ");
	            }System.out.println();
	        }System.out.println();
	    }
	    
	    private boolean check(int[][] map, int offset, int n){
	        for (int i=0; i<n; i++){
	            for (int j=0; j<n; j++){
	                if (map[i+offset][j+offset] != 1)
	                    return false;
	            }
	        }
	        return true;
	    }
	    
	    private void fillMapWithLock(int[][] map, int[][] lock, int offset, int n){
	        for (int i=0; i<n; i++){
	            for (int j=0; j<n; j++){
	                map[i+offset][j+offset] = lock[i][j];
	            }
	        }
	    }
	}

}
