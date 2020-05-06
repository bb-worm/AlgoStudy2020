package etc.programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programmers_12286 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[][] relation = {{"100", "ryan", "music", "2"}, {"200", "apeach", "math", "2"}, {"300", "tube", "computer", "3"}, {"400", "con", "computer", "4"}, {"500", "muzi", "music", "3"}, {"600", "apeach", "music", "2"}};
//		String[][] relation = {{"100", "a", "a", "a"},
//								{"200", "b", "a", "b"},
//								{"300", "c", "c", "c"}, 
//								{"400", "d", "d", "d"}, 
//								{"500", "e", "e", "e"}, 
//								{"600", "f", "f", "f"}};
//		String[][] relation = {{"b", "2", "a", "a", "b"},
//								{"b", "2", "7", "1", "b"},
//								{"1", "0", "a", "a", "8"}, 
//								{"7", "5", "a", "a", "9"}, 
//								{"3", "0", "a", "f", "9"}};
//		String[][] relation = {{"a", "b", "c"},
//								{"1", "b", "c"},
//								{"a", "b", "4"},
//								{"a", "5", "c"}};
//		String[][] relation = {{"a", "1", "4"},
//								{"2", "1", "5"},
//								{"a","2","4"}};
//		String[][] relation = {{"ab", "c"},
//								{"a", "bc"},
//								{"x", "yz"},
//								{"x","c"}};
		int ans = s.solution(relation);
		System.out.println(ans);
	}
	
	static class Solution {
		
		class Combi implements Comparable<Combi>{
			ArrayList<Integer> al;
			
			public Combi() {
				this.al = new ArrayList<>();
			}
			
			public int compareTo(Combi c) {
				return this.al.size() - c.al.size();
			}
		}
		
		ArrayList<Combi> all = new ArrayList<>();
		Set<ArrayList<Integer>> ansSet = new HashSet<>();
		int[] tuple;
		int R, C;
		int ans;
		
	    public int solution(String[][] relation) {
	    	
	    	R = relation.length;
	    	C = relation[0].length;
			tuple = new int[C];
	    	
	    	ans = 0;
	    	
	    	perm(0, 0, C);
	    	all.sort(null);
	    	
	    	for (Combi c : all) {
	    		if (check(c, relation)) {
	    			ans++;
//	    			for (int i : c.al)
//	    				System.out.print(i+ " ");
//	    			System.out.println();
	    		}
	    	}
	    	
	    	return ans;
	    }
	    
	    void perm(int idx, int now, int limit) {
	    	
	    	Combi c = new Combi();
	    	for (int i=0; i<now; i++) {
	    		c.al.add(tuple[i]);
	    	}
	    	all.add(c);
	    	
	    	if (now >= limit)
	    		return;
	    	
	    	if (idx >= C)
	    		return;
	    	
	    	for (int i=idx; i<C; i++) {
	    		tuple[now] = i;
	    		perm(i+1, now+1, limit);
	    	}
	    }
	    
	    boolean check(Combi c, String[][] relation) {
	    	Set<String> hs = new HashSet<>();
	    	StringBuilder sb;
	    	
	    	boolean isContain;
	    	for (ArrayList<Integer> tmp : ansSet) {
	    		isContain = true;
	    		for (int i : tmp) {
	    			if (!c.al.contains(i)) {
	    				isContain = false;
	    			}
	    		}
	    		if (isContain)
	    			return false;
	    	}
	    	
	    	for (int i=0; i<R; i++) {
	    		sb = new StringBuilder();
	    		for (int j : c.al) {
	    			sb.append(relation[i][j]).append(' ');
	    		}
	    		if (hs.contains(sb.toString())) {
	    			return false;
	    		}
	    		hs.add(sb.toString());
	    	}
	    	
	    	ansSet.add(c.al);
	    	
	    	return true;
	    }
	}

}
