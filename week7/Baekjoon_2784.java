package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_2784 {
	
	static char[][] map;
	static String[] inStr;
	static int[] setIdx;
	static int[] use;
	
	static int findAns;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[3][3];
		inStr = new String[7];
		setIdx = new int[6];
		use = new int[7];
		
		for (int i=0; i<6; i++) {
			inStr[i+1] = br.readLine();
		}
		
		findAns = 0;
		set(0);
		if (findAns == 1) {
			for (int i=0; i<3; i++) {
				for (int j=0; j<3; j++) {
					System.out.print(map[i][j]);
				}System.out.println();
			}
		} else {
			System.out.println(0);
		}
		
	}
	
	static void set(int select) {
		if (findAns == 1)
			return;
		
		if (select >= 6) {
//			for (int i=0; i<6; i++) {
//				System.out.print(setIdx[i]);
//			}System.out.println();
			
			if (check()) {
				findAns = 1;
			}
			
			return;
		}
		
		for (int i=1; i<=6; i++) {
			if (use[i] == 0) {
				use[i] = 1;
				setIdx[select] = i;
				set(select + 1);
				use[i] = 0;
			}
		}
	}
	
	static boolean check() {
		
		for (int i=0; i<3; i++) {
			String now = inStr[setIdx[i]];
			map[i] = now.toCharArray();
		}
		
		for (int i=0; i<3; i++) {
			String now = "";
			for (int j=0; j<3; j++) {
				now += map[j][i];
			}
			
			String cmpStr = inStr[setIdx[i+3]];
			if (!now.equals(cmpStr))
				return false;
		}
		
		return true;	
	}
}
