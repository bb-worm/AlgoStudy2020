package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1966 {
	
	static class Paper{
		int p;
		int curious;
		
		public Paper (int p, int curious) {
			this.p = p;
			this.curious = curious;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		ArrayList<Paper> al = new ArrayList<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
						
			st = new StringTokenizer(br.readLine());
			for (int i=0; i<N; i++) {
				int p = Integer.parseInt(st.nextToken());
				if (i==M) {
					al.add(new Paper(p, 1));
				} else {
					al.add(new Paper(p, 0));
				}
			}
			
			
			int time = 1;
			while (true) {
				
				int now = 0;
				
				for (int i=0; i<al.size(); i++) {
					if (al.get(now).p < al.get(i).p)
						now = i;
				}
				
				if (now != 0) {
					al.add(new Paper(al.get(0).p, al.get(0).curious));
					al.remove(0);
				} else if (al.get(0).curious == 1) {
					sb.append(time).append('\n');
					al.clear();
					break;
				} else {
					al.remove(0);
					time++;
				}
			}
		}
		System.out.println(sb);
	}
}
