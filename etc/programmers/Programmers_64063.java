package etc.programmers;

import java.util.HashMap;
import java.util.Map;

public class Programmers_64063 {

	public static void main(String[] args) {
		Solution s = new Solution();
		long k = 10;
		long[] room_number = {1, 3, 4, 1, 3, 1};
		long[] ans = s.solution(k, room_number);
		for (long i : ans)
			System.out.print(i + " ");
		System.out.println();
	}
	
	static class Solution {
	    
	    class Node {
	        long num;
	        Node parent;
	        
	        public Node (long num){
	            this.num = num;
	            this.parent = this;
	        }
	        
	        public Node find(){
	            if (this.parent == this)
	                return this;
	            else
	                return this.parent = this.parent.find();
	        }
	        
	        public void union(Node n){
	            this.find().parent = n.find();
	        }
	    }
	    
	    public long[] solution(long k, long[] room_number) {
	        long[] ans = new long[room_number.length];
	        
	        Map<Long, Node> hm = new HashMap<>();
	        
	        for (int i=0; i<room_number.length; i++){
	            
	            long want = room_number[i];
	            
	            Node now = hm.getOrDefault(want, null);
	            if (now == null){
	            	now = new Node(want);
	                ans[i] = want;
	                hm.put(want, now);
	                
	                Node pre = hm.getOrDefault(want-1, null);
	                Node next = hm.getOrDefault(want+1, null);
	                if (pre != null)
	                    pre.union(now);
	                if (next != null)
	                	now.union(next);
	            } else {
	                Node next = new Node(now.find().num + 1);
	                ans[i] = next.num;
	                
	                hm.put(next.num, next);
	                now.union(next);
	                
	                Node nnext = hm.getOrDefault(next.num+1, null);
	                if (nnext != null)
	                	next.union(nnext);
	            }
	        }
	        return ans;
	    }
	}

}
