package etc.baekjoon;

import java.io.*;

public class Baekjoon_5052 {

	static class Trie{
		boolean end;
		boolean pass;
		Trie[] next;
		
		public Trie() {
			this.end = false;
			this.pass = false;
			this.next = new Trie[10];
		}
		
		public boolean insert(String str, int idx) {
			if (end)
				return false;
			
			if (str.length() == idx) {
				end = true;
				return !pass;
			}
			
			int num = str.charAt(idx) - '0';
			if (next[num] == null) {
				next[num] = new Trie();
				pass = true;
			}
			
			return next[num].insert(str, idx+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			
			int N = Integer.parseInt(br.readLine());
			boolean check = true;
			Trie trie = new Trie();
			
			for (int i=0; i<N; i++) {
				String str = br.readLine();
				if (check && !trie.insert(str, 0)) {
					check = false;
				}
			}
			
			if (check)
				sb.append("YES").append('\n');
			else
				sb.append("NO").append('\n');
		}
		System.out.println(sb);
	}
}
