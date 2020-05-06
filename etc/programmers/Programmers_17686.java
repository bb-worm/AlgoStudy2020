package etc.programmers;

import java.util.Arrays;

public class Programmers_17686 {

	public static void main(String[] args) {
		
		Solution s = new Solution();
		String[] files = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] ans = s.solution(files);
		for (String str : ans)
			System.out.println(str);

	}
	
	static class Solution {
		
		class File implements Comparable<File>{
			int idx;
			String head;
			int number;
			
			public File(int idx, String head, int number) {
				this.idx = idx;
				this.head = head.toLowerCase();
				this.number = number;
			}
			
			public int compareTo(File f) {
				if (this.head.equals(f.head)) {
					return this.number - f.number;
				} else {
					return this.head.compareTo(f.head);
				}
			}
		}
		
		public String[] solution(String[] files) {
			
			File[] file = new File[files.length];
			
			String head;
			int number;
			for (int i=0; i<file.length; i++) {
				head = null;
				number = -1;
				for (int j=0; j<files[i].length(); j++) {
					char ch = files[i].charAt(j);
					
					if (Character.isDigit(ch)) {
						head = files[i].substring(0, j);
						
						int k = j+1;
						for (; k<files[i].length(); k++) {
							ch = files[i].charAt(k);
							
							if (!Character.isDigit(ch) || k-j >= 5) {
								break;
							}
						}
						number = Integer.parseInt(files[i].substring(j,k));
						
						break;
					}
				}
				
				file[i] = new File(i, head, number);
			}
			
			Arrays.sort(file);
			
			String[] ans = new String[file.length];
			for (int i=0; i<ans.length; i++) {
				ans[i] = files[file[i].idx];
			}
			return ans;
		}
	}
}
