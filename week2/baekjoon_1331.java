package week2;

import java.io.*;
import java.util.*;

public class baekjoon_1331 {
	
	public static int[][] map = new int[6][6];
	public static int[][] visit = new int[6][6];
	
	public static boolean isValid;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		isValid = true;
		
		char[][] str = new char[37][2];
		for (int i=0; i<36; i++) {
			str[i] = br.readLine().toCharArray();
		}
		str[36][0] = str[0][0];
		str[36][1] = str[0][1];
		
		int a, b;
		int na, nb;
		for (int i=0; i<36; i++) {
			if (!isValid) {
				break;
			}
			a = row(str[i][1]);
			b = col(str[i][0]);
			na = row(str[i+1][1]);
			nb = col(str[i+1][0]);
			check(a, b, na, nb);
//			printVisit();
		}
		
		for (int i=0; i<6 && isValid; i++) {
			for (int j=0; j<6 && isValid; j++) {
				if (visit[i][j] == 0) {
					isValid = false;
				}
			}
		}
		
		if (isValid) {
			System.out.println("Valid");
		}
		else {
			System.out.println("Invalid");
		}
	}
	
	public static void check(int a, int b, int na, int nb) {
//		System.out.println(a+ " " + b + " " + na + " " +nb);
		if (visit[na][nb] != 0) {
			isValid = false;
			return;
		}
		
		int absA = Math.abs(na-a);
		int absB = Math.abs(nb-b);
		
		if ((absA==2 && absB==1) || (absA==1 && absB==2)) {
			visit[na][nb] = 1;
		}
		else {
			isValid = false;
			return;
		}
		
	}
	
	public static int row(char i) {
		return 6 - (i - '0');
	}
	public static int col(char ch) {
		return ch-'A';
	}
	
	public static void printVisit() {
		for (int i=0; i<6; i++) {
			for (int j=0; j<6; j++) {
				System.out.print(visit[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

}
