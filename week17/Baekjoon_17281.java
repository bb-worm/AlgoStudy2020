package week17;

import java.io.*;
import java.util.*;

public class Baekjoon_17281 {
	
	static int N;
	static int[][] point;
	static int[] perm = new int[10];
	static boolean[] isUse = new boolean[10];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		point = new int[N][10];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=1; j<=9; j++) {
				point[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isUse[1] = true;
		perm[4] = 1;
		int ans = setPlayer(1);
		System.out.println(ans);
	}

	static int setPlayer(int now) {
		if (now >= 10) {
			return play();
		}
		
		if (now == 4) {
			return setPlayer(now+1);
		}
		
		int max = 0;
		for (int i=1; i<=9; i++) {
			if (!isUse[i]) {
				isUse[i] = true;
				perm[now] = i;
				max = Math.max(max, setPlayer(now+1));
				isUse[i] = false;
			}
		}
		
		return max;
	}

	static int play() {
		
		int result = 0;
		int idx = 1;
		
		int out;
		int[] base = new int[3];
		
		for (int i=0; i<N; i++) {
			
			out = 0;
			base[0] = base[1] = base[2] = 0;
			
			while (out < 3) {
				
				int hit = point[i][perm[idx]];
				
				if (hit == 0) { // out
					out++;
				} else if (hit == 1) { // 안타 
					if (base[2] == 1) {
						result++;
					}
					
					base[2] = base[1];
					base[1] = base[0];
					base[0] = 1;
					
				} else if (hit == 2) { // 2루타 
					for (int k=1; k<=2; k++) {
						if (base[k] == 1)
							result++;
					}
					
					base[2] = base[0];
					base[1] = 1;
					base[0] = 0;
					
				} else if (hit == 3) { // 3루타 
					for (int k=0; k<=2; k++) {
						if (base[k] == 1)
							result++;
					}
					
					base[2] = 1;
					base[1] = base[0] = 0;
					
				} else { // 홈런 
					for (int k=0; k<=2; k++) {
						if (base[k] == 1)
							result++;
					}
					result++;
					
					base[2] = base[1] = base[0] = 0;
				}
				
				idx = (idx==9) ? 1 : idx+1;
			}
		}
		
		return result;
	}
}
