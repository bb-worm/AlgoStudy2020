package week16;

import java.io.*;
import java.util.*;

public class Baekjoon_9518 {
	
	static int R, S;
	static char[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		map = new char[R][S];
		
		for (int i=0; i<R; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		int before = 0;
		
		for (int i=0; i<R; i++) {
			for (int j=0; j<S; j++) {
				
				if (map[i][j] == '.')
					continue;
				
				before += checkAround(i, j, 4);
			}
		}
		
		int ans = before;
		for (int i=0; i<R; i++) {
			for (int j=0; j<S; j++) {
				if (map[i][j] == '.') {
					int sum = checkAround(i, j, 8);
					
					ans = Math.max(ans, before+sum);
				}
			}
		}
		System.out.println(ans);
	}
	
	static int[] da = {-1, 0, 1, 1, 1, 0, -1, -1};
	static int[] db = {1, 1, 1, 0, -1, -1, -1, 0};
	
	static int checkAround(int a, int b, int limit) {
		int sum = 0;
		
		int na, nb;
		for (int k=0; k<limit; k++) {
			na = a + da[k];
			nb = b + db[k];
			
			if (!rangeCheck(na, nb))
				continue;
			
			if (map[na][nb] == 'o')
				sum++;
		}
		return sum;
	}
	
	static boolean rangeCheck(int a, int b) {
		if (a<0||a>=R||b<0||b>=S)
			return false;
		else
			return true;
	}
}