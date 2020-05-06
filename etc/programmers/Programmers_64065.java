package etc.programmers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Programmers_64065 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		String str = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
//		String str = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
//		String str = "{{20,111},{111}}";
//		String str = "{{123}}";
		String str = "{{4,2,3},{3},{2,3,4,1},{2,3}}";
		int[] ans = s.solution(str);
		for (int i : ans) {
			System.out.print(i + " ");
		}
	}
	
	static class Solution {
		
		static class Row {
			ArrayList<Integer> al = new ArrayList<>();
		}
		
	    public int[] solution(String s) {
	    	
	    	ArrayList<Row> Col = new ArrayList<>();
	    	String[] input = s.substring(2,s.length()-2).replace("},{", "/").split("/");
	    	
	    	for (int i=0; i<input.length; i++) {
	    		String[] num = input[i].split(",");
	    		Row r = new Row();
	    		for (int j=0; j<num.length; j++) {
	    			r.al.add(Integer.parseInt(num[j]));
	    		}
	    		Col.add(r);
	    	}
	    	
	    	Col.sort(new Comparator<Row>() {
	    		public int compare(Row r1, Row r2) {
	    			return r1.al.size() - r2.al.size();
	    		}
	    	});
	    	
//	    	for (int i=0; i<Col.size(); i++) {
//	    		for (int j=0; j<Col.get(i).al.size(); j++) {
//	    			System.out.print(Col.get(i).al.get(j) + " ");
//	    		}System.out.println();
//	    	}System.out.println();
	    	
	    	
	    	int[] ans = new int[Col.size()];
	    	
	    	Set<Integer> hs = new HashSet<>();
	    	for (int i=0; i<Col.size(); i++) {
	    		Row r = Col.get(i);
	    		for (int j=0; j<r.al.size(); j++) {
	    			int num = r.al.get(j);
	    			if (!hs.contains(num)) {
	    				ans[i] = num;
	    				hs.add(num);	
	    				break;
	    			}
	    		}
	    	}
	    	
	    	return ans;
	    }
	}

}
