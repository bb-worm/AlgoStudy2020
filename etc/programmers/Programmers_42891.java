package etc.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Programmers_42891 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		int[] food_times = {5,5,5};
		long k = 15;
		int ans = s.solution(food_times, k);
		System.out.println(ans);
	}
	
	static class Solution {
	    
	    class Food {
	        int num;
	        int time;
	        
	        public Food(int num, int time){
	            this.num = num;
	            this.time = time;
	        }
	    }
	    
	    public int solution(int[] food_times, long k) {
	        PriorityQueue<Food> pq = new PriorityQueue<>(new Comparator<Food>(){
	            public int compare(Food f1, Food f2){
	                return f1.time - f2.time;
	            }
	        });
	        
	        long total = 0;
	        
	        for (int i=0; i<food_times.length; i++) {
	        	pq.add(new Food(i+1, food_times[i]));
	        	total += food_times[i];
	        }
	        
	        if (total <= k)
	        	return -1;
	        
	        int pre = 0;
	        int now;
	        while (true){
	            
	            now = pq.peek().time;
	            
	            if (k - (long)pq.size()*(now-pre) > 0){
	                
	                k -= (long)pq.size()*(now-pre);
	                
	                while (!pq.isEmpty() && pq.peek().time==now){
	                    pq.poll();
	                }
	                
	                if (pq.isEmpty()){
	                    return -1;
	                }
	                
	                pre = now;
	                
	            } else {
	                
	                ArrayList<Food> al = new ArrayList<>();
	                while (!pq.isEmpty())
	                    al.add(pq.poll());
	                al.sort(new Comparator<Food>(){
	                    public int compare(Food f1, Food f2){
	                        return f1.num - f2.num;
	                    }
	                });
	                  
	                
	                k %= al.size();
	                
	                return al.get((int)k).num;
	            }
	        }
	    }
	}
	
}
