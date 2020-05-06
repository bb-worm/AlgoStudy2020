package etc.programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_62049 {

	public static void main(String[] args) {
		Solution s = new Solution();
		int n = 1;
		int[] ans = s.solution(n);
		for (int i : ans)
			System.out.print(i+ " ");
	}
	
	static class Solution {
		
		class Node {
			int val;
			
			Node left;
			Node right;
			
			public Node (int val) {
				this.val = val;
				this.left = null;
				this.right = null;
			}
		}
		
	    public int[] solution(int n) {
	    	Node root = new Node(0);
	    	
	    	Queue<Node> q = new LinkedList<>();
	    	q.add(root);
	    	for (int i=0; i<n-1; i++) {
	    		int size = q.size();
	    		
	    		for (int j=0; j<size; j++) {
	    			Node now = q.poll();
	    			
	    			now.left = new Node(0);
	    			now.right = new Node(1);
	    			
	    			q.add(now.left);
	    			q.add(now.right);
	    		}
	    	}
	    	q.clear();
	    	
	    	ArrayList<Integer> al = new ArrayList<>();
	    	traversal(root, al);
	    	
	    	int[] ans = new int[al.size()];
	    	
	    	for (int i=0; i<al.size(); i++)
	    		ans[i] = al.get(i);
	    	
	    	return ans;
	    }
	    
	    void traversal(Node node, ArrayList<Integer> al) {
	    	if (node == null) {
	    		return;
	    	}
	    	traversal(node.left, al);
	    	al.add(node.val);
	    	traversal(node.right, al);
	    }
	}
}
