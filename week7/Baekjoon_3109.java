package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_3109 {
	
	static int R, C;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		
		
		for (int i=0; i<R; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j=0; j<C; j++) {
				map[i][j] = str[j];
			}
		}
		
		int ans = 0;
		for (int i=0; i<R; i++) {
			if (possible(i, 1)) {
				ans++;
			}
		}
//		printAll();
		System.out.println(ans);
	}
	
	static int[] da = {-1, 0, 1};
	
	static boolean possible(int a, int b) {
		
		if (b >= C) {
			return true;
		}
		
		int na;
		for (int i=0; i<3; i++) {
			na = a + da[i];
			
			if (na<0 || na>=R || map[na][b] != '.')
				continue;
			
			map[na][b] = 'x';
			
			if (possible(na, b+1)) {
				return true;
			}
		}
		
		return false;
	}
	
	static void printAll() {
		for (int i=0; i<R; i++) {
			for (int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
