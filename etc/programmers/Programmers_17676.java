package etc.programmers;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Programmers_17676 {

	public static void main(String[] args) {
		Solution s = new Solution();
//		String[] lines = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
//		String[] lines = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
		String[] lines = {"2016-09-15 23:59:59.999 0.001s"};
		int ans = s.solution(lines);
		System.out.println(ans);
	}
	
	static class Solution {
	    
	    class Time {
	        int start;
	        int end;
	        
	        public Time(int start, int end){
	            this.start = start;
	            this.end = end;
	        }
	        
	        public boolean overlap(int t){
	        	if (this.start > t)
	        		return false;
	        	else
	        		return true;
	        }
	    }
	    
	  public int solution(String[] lines) {
	      ArrayList<Time> al = new ArrayList<>();
	      
	      StringTokenizer st;
	      for (int i=0; i<lines.length; i++){
	          st = new StringTokenizer(lines[i]);
	          st.nextToken();
	          String[] S = st.nextToken().split(":");
	          int hour = Integer.parseInt(S[0])*3600*1000;
	          int minute = Integer.parseInt(S[1])*60*1000;
	          int ms = (int)(Double.parseDouble(S[2]) * 1000);
	          
	          int T = (int)(Double.parseDouble(st.nextToken().replace("s", "")) * 1000);
	          
	          int start = hour+minute+ms - T + 1;
	          int end = hour+minute+ms;
	          al.add(new Time(start, end));
	        }
	      
//	      for (Time t : al)
//	    	  System.out.println(t.start + " " + t.end);
//	      System.out.println();
	      
	      int ans = 1;
	      for (int i=0; i<al.size()-1; i++){
	          int end = al.get(i).end;
	          
	          int sum = 1;
	          for (int j=i+1; j<al.size(); j++){
	              if (al.get(j).overlap(end+999))
	                  sum++;
	              else
	                  break;
	          }
	          ans = Math.max(ans, sum);
	      }
	      
	      return ans;
	}
  }
}
