package etc.programmers;

import java.util.Map;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Programmers_42888 {

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo", "Change uid4567 Ryan"};
		String[] ans = s.solution(record);
		for (String str : ans)
			System.out.println(str);
	}
	
	static class Solution {
		
	    public String[] solution(String[] record) {
	    	
	    	Map<String, String> hm = new HashMap<>();
	    	int ansSize = 0;
	    	
	    	StringTokenizer st;
	    	for (int i=0; i<record.length; i++) {
	    		st = new StringTokenizer(record[i]);
	    		String oper = st.nextToken();
	    		String uid = st.nextToken();
	    		
	    		if (oper.equals("Enter")) {
	    			String name = st.nextToken();
	    			hm.put(uid, name);
	    			ansSize++;
	    		} else if (oper.equals("Change")){ // change
	    			String name = st.nextToken();
	    			hm.put(uid, name);
	    		} else {
	    			ansSize++;
	    		}
	    	}
	    	
	    	String[] ans = new String[ansSize];
	    	int idx = 0;
	    	
	    	StringBuilder sb;
	    	
	    	for (int i=0; i<record.length; i++) {
	    		st = new StringTokenizer(record[i]);
	    		String oper = st.nextToken();
	    		String uid = st.nextToken();
	    		
	    		if (oper.equals("Change")) {
	    			continue;
	    		}
	    		
	    		sb = new StringBuilder();
	    		sb.append(hm.get(uid));
	    		
	    		if (oper.equals("Enter")) {
	    			sb.append("님이 들어왔습니다.");
	    			ans[idx] = sb.toString();
	    		} else {
	    			sb.append("님이 나갔습니다.");
	    			ans[idx] = sb.toString();
	    		}
	    		idx++;
	    	}
	    	return ans;
	    }
	}
}
