package etc.programmers;

public class Programmers_12977 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
//		int[] nums = {1, 2, 3, 4}; 
		int[] nums = {1,2,7,6,4};
		int ans = s.solution(nums);
		System.out.println(ans);
	}
	
	static class Solution {
		
		int[] isPrime;
		int[] select = new int[3];
		
	    public int solution(int[] nums) {
	    	
	    	setPrime();
	    	int ans = selectNum(nums, 0, 0);
	    	return ans;
	    }
	    
	    int selectNum(int[] nums, int idx, int total){
	    	
//	    	System.out.println(idx + " " + total);
	    	
	    	
	    	if (total == 3) {
	    		
//	    		for (int i : select)
//	    			System.out.print(i + " ");
//	    		System.out.println();
	    		
	    		int num = 0;
	    		for (int i=0; i<3; i++)
	    			num += select[i];
	    		
	    		if (isPrime[num] == 1)
	    			return 1;
	    		else
	    			return 0;
	    	}
	    	
	    	if (idx >= nums.length)
	    		return 0;
	    	
	    	int sum = 0;
	    	for (int i=idx; i<nums.length; i++) {
	    		select[total] = nums[i];
	    		sum += selectNum(nums, i+1, total+1);
	    	}
	    	return sum;
	    }
	    void setPrime() {
	    	isPrime = new int[3001];
	    	
	    	for (int i=2; i<=3000; i++) {
	    		if (isPrime[i] == 0) {
	    			isPrime[i] = 1;
	    			for (int j=i*2; j<=3000; j+=i) {
	    				isPrime[j] = -1;
	    			}
	    		}
	    	}
	    }
	}
}
