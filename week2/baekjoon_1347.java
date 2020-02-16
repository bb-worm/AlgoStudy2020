package week2;

import java.io.*;
import java.util.*;

public class baekjoon_1347 {

	public static char[][] map;
	public static int r, c;
	public static int dir; // 0:up, 1:right, 2:down, 3:left
	
	public static int maxR, minR;
	public static int maxC, minC;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new char[102][102];
		
		int N = Integer.parseInt(br.readLine());
		
		r = 50;
		c = 50;
		dir = 2;
		map[r][c] = '.';
		
		maxR = minR = maxC = minC = 50;
		
		char[] str = br.readLine().toCharArray();
		for (int i=0; i<N; i++) {
			move(str[i]);
			changeRange();
			map[r][c] = '.';
		}
		
		for (int i=minR; i<=maxR; i++) {
			for (int j=minC; j<=maxC; j++) {
				if (map[i][j] != '.')
					System.out.print('#');
				else
					System.out.print('.');
			}System.out.println();
		}
	}
	
	public static void changeRange() {
		if (r>maxR) {
			maxR = r;
		}
		if (r<minR) {
			minR =r;
		}
		if (c>maxC) {
			maxC = c;
		}
		if (c<minC) {
			minC = c;
		}
	}
	
	public static int[] dr = {-1, 0, 1, 0};
	public static int[] dc = {0, 1, 0, -1};
	
	public static void move(char ch) {
		if (ch == 'F') {
			r += dr[dir];
			c += dc[dir];
		}
		else if (ch == 'R') {
			dir = (dir+1) % 4;
		}
		else { // L
			dir = (dir + 3) % 4;
		}
	}

}
