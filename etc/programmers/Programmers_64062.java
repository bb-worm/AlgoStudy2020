package etc.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_64062 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
//		int k = 3;
		int[] stones = {4, 3, 3, 3, 3, 3, 3, 4};
		int k = 8;
		int ans = s.solution(stones, k);
		System.out.println(ans);
		
	}
	
	static class Solution {
		
		class Point implements Comparable<Point>{
			int idx;
			int num;
			
			public Point (int idx, int num) {
				this.idx = idx;
				this.num = num;
			}
			
			public int compareTo(Point p) {
				return this.num - p.num;
			}
		}
		
	    public int solution(int[] stones, int k) {
	    	
	    	Point[] point = new Point[stones.length];
	    	int[] zero = new int[stones.length];
	    	
	    	for (int i=0; i<point.length; i++)
	    		point[i] = new Point(i, stones[i]);
	    	
	    	Arrays.sort(point);
	    	
	    	int ans = 0;
	    	
	    	Queue<Integer> q = new LinkedList<>();
	    	for (int i=0; i<point.length; i++) {
	    		int n = point[i].num;
	    		stones[point[i].idx] = 0;
	    		q.add(point[i].idx);
	    		zero[point[i].idx] = 1;
	    		
	    		while (i+1<point.length && point[i+1].num==n) {
	    			i++;
	    			stones[point[i].idx] = 0;
	    			q.add(point[i].idx);
	    			zero[point[i].idx] = 1;
	    		}
//	    		printArr(zero);
	    		while (!q.isEmpty()) {
	    			
	    			int idx = q.poll();
	    			
	    			// right
	    			int right = idx;
	    			while (right+1 < stones.length && zero[right+1]!=0) {
	    				right++;
	    			}
	    			
	    			// left
	    			int left = idx;
	    			while (left-1 >= 0 && zero[left-1]!=0) {
	    				left--;
	    			}
	    			
	    			int val = 1 + (right-idx) + (idx-left);
	    			
	    			if (val >= k) {
	    				q.clear();
	    				return n;
	    			}
	    		}
//	    		printArr(zero);
	    		ans = n;
	    	}
	    	
	    	return ans;
	    }
	    
	    void printArr(int[] arr) {
	    	for (int i=0; i<arr.length; i++)
	    		System.out.print(arr[i] + " ");
	    	System.out.println();
	    }
	}
}
