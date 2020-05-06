package week11;

import java.io.*;
import java.util.*;

public class Baekjoon_2580 {
	
	static int[][] map;
	static boolean findAns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[9][9];
		
		for (int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// DFS
		findAns = false;
		dfs(0, 0);
	}
	
	static void dfs(int a, int b) {
//		System.out.println(a + " " + b);
//		printAll();
		if (findAns)
			return;
		
		// answer
		if (a >= 9) {
			printAns();
			findAns = true;
			return;
		}
		
		// go next
		if (map[a][b] != 0) {
			if (b+1 < 9)
				dfs(a, b+1);
			else
				dfs(a+1, 0);
			
			return;
		}
		
		// insert something to the blank
		int[] num = new int[10];
		int boundRow = bound(a);
		int boundCol = bound(b);
		for (int i=boundRow; i<boundRow+3; i++) {
			for (int j=boundCol; j<boundCol+3; j++) {
				num[map[i][j]]++;
			}
		}
		for (int i=1; i<=9 && !findAns; i++) {
			if (num[i] == 0) {
				map[a][b] = i;
				
				if (!checkRowCol(a, b)) {
					map[a][b] = 0;
					continue;
				}
				
				if (b+1 < 9)
					dfs(a, b+1);
				else
					dfs(a+1, 0);
				
				map[a][b] = 0;
			}
		}
	}
	
	static boolean checkRowCol(int a, int b) {
		int[] rowNum = new int[10];
		int[] colNum = new int[10];
		
		for (int k=0; k<9; k++) {
			rowNum[map[k][b]]++;
			colNum[map[a][k]]++;
			
			if (map[k][b]!=0 && rowNum[map[k][b]]==2) {
				return false;
			}
			if (map[a][k]!=0 &&colNum[map[a][k]]==2) {
				return false;
			}
		}
		return true;
	}
	
	static void printAns() {
		// print
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				sb.append(map[i][j]).append(' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static int bound(int a) {
		if (a < 3)
			return 0;
		else if (a < 6)
			return 3;
		else
			return 6;
	}
	
	static void printAll() {
		for (int i=0; i<9; i++) {
			for (int j=0; j<9; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

}
