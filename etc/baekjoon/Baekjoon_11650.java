package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11650 {
	
	static class Posi implements Comparable<Posi> {
		int x, y;
		
		public Posi(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int compareTo(Posi p) {
			if (this.x == p.x) {
				return this.y - p.y;
			} else {
				return this.x - p.x;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		Posi[] posi = new Posi[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			posi[i] = new Posi(x, y);
		}
		
		Arrays.sort(posi);
		
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<N; i++) {
			sb.append(posi[i].x);
			sb.append(' ');
			sb.append(posi[i].y);
			sb.append('\n');
		}
		System.out.println(sb);
	}

}
