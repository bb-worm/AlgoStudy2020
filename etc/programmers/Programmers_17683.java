package etc.programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Programmers_17683 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		String m = "ABCDEFG";
		String[] musicinfos = {"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//		String m = "ABC";
//		String[] musicinfos = {"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"};
//		String m = "ABC";
//		String[] musicinfos = {"12:00,12:04,test,ABC#"};
		String ans = s.solution(m, musicinfos);
		System.out.println(ans);
	}
	
	static class Solution {
		
		class Note {
			String note;
			int time;
			int idx;
			
			public Note(String note, int time, int idx) {
				this.note = note;
				this.time = time;
				this.idx = idx;
			}
		}
		
		public String solution(String m, String[] musicinfos) {
			
			Map<String, Note> hm = new HashMap<>();
			
			String newM = makeNote(m);
			
			StringTokenizer st;
			StringBuilder sb;
			for (int k=0; k<musicinfos.length; k++) {
				String input = musicinfos[k];
				
				st = new StringTokenizer(input, ",");
				
				int time = getTime(st.nextToken(), st.nextToken());
				String title = st.nextToken();
				String note = makeNote(st.nextToken());
				
				sb = new StringBuilder();
				sb.append(note);
				
				while (time > sb.length()) {
					sb.append(note);
				}

				if (newM.length() <= time) {
					hm.put(title, new Note(sb.substring(0, time), time, k));
				}
			}
			
			String ans = null;
			int ansTime = 0;
			int ansIdx = -1;
			
			Set<String> keys = hm.keySet();
			for (String key : keys) {
				Note n = hm.get(key);
				
				String note = n.note;
				int time = n.time;
				int idx = n.idx;
				
				if (note.contains(newM)) {
					if (time > ansTime || (time==ansTime && idx < ansIdx)) {
						ans = key;
						ansTime = time;
						ansIdx = idx;
					}
				}
			}
			
			if (ans==null)
				ans = "(None)";
			
			return ans;
		}
		
		String makeNote(String note) {
			
			note = note.replaceAll("C#", "c");
			note = note.replaceAll("D#", "d");
			note = note.replaceAll("F#", "f");
			note = note.replaceAll("G#", "g");
			note = note.replaceAll("A#", "a");
			
			return note;
		}
		
		int getTime(String start, String end) {
			String[] s = start.split(":");
			String[] e = end.split(":");
			
			int h1 = Integer.parseInt(s[0]);
			int m1 = Integer.parseInt(s[1]);
			int h2 = Integer.parseInt(e[0]);
			int m2 = Integer.parseInt(e[1]);
			
			return m2 - m1 + (h2-h1) * 60;
		}
	}
}
