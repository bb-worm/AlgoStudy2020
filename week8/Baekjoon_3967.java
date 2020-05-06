package week8;

import java.io.*;

public class Baekjoon_3967 {
	
	static int[][] position = {{1, 1},
							   {1, 1},
							   {3, 1},
							   {3, 1},
							   {1, 7},
							   {3, 7}};
	
	static int[] da = {0, 1, -1, 0, 1, -1};
	static int[] db = {2, 1, 1, 2, -1, -1};
	
	static int[][] map;
	static int r=5, c=9;
	
	static int[] isUse;
	static int findAns;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				
		map = new int[r][c];
		isUse = new int[13];
		
		for (int i=0; i<r; i++) {
			char[] input = br.readLine().toCharArray();
			for (int j=0; j<c; j++) {
				if (input[j] == '.') {
					map[i][j] = -1;
				}
				else if (input[j] == 'x') {
					map[i][j] = 0;
				} else {
					map[i][j] = input[j] - 'A' + 1;
					isUse[map[i][j]]++;
				}
			}
		}
		
		permutation(0);
	}
	
	static int[] na = {0, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4};
	static int[] nb = {4, 1, 3, 5, 7, 2, 6, 1, 3, 5, 7, 4};
	
	static void permutation(int idx) {
		if (findAns == 1)
			return;
//		printAll();
		if (idx >= 12) {
			if (checkAns()) {
				printAll();
				findAns = 1;
			}
			
			return;
		}
		
		int a, b;
		a = na[idx];
		b = nb[idx];
		
		if (map[a][b] > 0) {
			permutation(idx+1);
		} else {
			for (int i=1; i<=12; i++) {
				if (isUse[i] == 0){
					isUse[i] = 1;
					map[a][b] = i;
					permutation(idx+1);
					isUse[i] = 0;
					map[a][b] = 0;
				}
			}
		}
	}
	
	static boolean checkAns() {
		int a, b, sum;
		for (int i=0; i<6; i++) {
			sum = 0;
			a = position[i][0];
			b = position[i][1];
			
			int k = 0;
			do {
				
				sum += map[a][b];
				a += da[i];
				b += db[i];
				
				k++;
			} while (k<4);
			
			if (sum != 26)
				return false;
		}
		return true;
	}
	
	static void printAll() {
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (map[i][j] == -1 || map[i][j] == 0)
					System.out.print('.');
				else
					System.out.print((char)(map[i][j]+'A'-1));
			}System.out.println();
		}System.out.println();
	}
	
	static void printInt() {
		for (int i=0; i<r; i++) {
			for (int j=0; j<c; j++) {
				if (map[i][j] == -1)
					System.out.printf("%2d ",0);
				else
					System.out.printf("%2d ",map[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
