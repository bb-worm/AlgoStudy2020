package week1;

import java.io.*;
import java.util.*;

public class baekjoon_17136 {

	public static int[] leftNum = {0, 5, 5, 5, 5, 5};
	public static int[][] map = new int[10][10];

	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		ans = Integer.MAX_VALUE;

		for (int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(0, 0, 0);

		if (ans == Integer.MAX_VALUE) {
			ans = -1;
		}

		System.out.println(ans);
	}

	public static void go(int a, int b, int usedNum) {
		if (usedNum >= ans)
			return;

		int na, nb;

		if (b >= 10) {
			na = a+1;
			nb = 0;

			// finish
			if (na >= 10) {
				ans = Math.min(ans, usedNum);
				return;
			}
		}
		else {
			na = a;
			nb = b;
		}


		if (map[na][nb] == 0) {
			go(na, nb+1, usedNum);
		}

		// 1*1
		if (check(na, nb, 1)) {

			if (leftNum[1] > 0) {
				leftNum[1]--;
				makeZero(na, nb, 1);
				go(na, nb+1, usedNum+1);
				makeOne(na, nb, 1);
				leftNum[1]++;
			}

			// 2*2
			if (check(na, nb, 2)) {

				if (leftNum[2] > 0) {
					leftNum[2]--;
					makeZero(na, nb, 2);
					go(na, nb+2, usedNum+1);
					makeOne(na, nb, 2);
					leftNum[2]++;
				}

				// 3*3
				if (check(na, nb, 3)) {

					if (leftNum[3] > 0) {
						leftNum[3]--;
						makeZero(na, nb, 3);
						go(na, nb+3, usedNum+1);
						makeOne(na, nb, 3);
						leftNum[3]++;
					}

					// 4*4
					if (check(na, nb, 4)) {

						if (leftNum[4] > 0) {
							leftNum[4]--;
							makeZero(na, nb, 4);
							go(na, nb+4, usedNum+1);
							makeOne(na, nb, 4);
							leftNum[4]++;
						}

						// 5*5
						if (check(na, nb, 5) && leftNum[5] > 0) {
							leftNum[5]--;
							makeZero(na, nb, 5);
							go(na, nb+5, usedNum+1);
							makeOne(na, nb, 5);
							leftNum[5]++;
						}
					}
				}
			}
		}

	}

	public static boolean check(int a, int b, int size) {
		for (int i=a; i<a+size; i++) {
			for (int j=b; j<b+size; j++) {
				if (i>=10 || j>=10 || map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static void makeZero(int a, int b, int size) {
		for (int i=a; i<a+size; i++) {
			for (int j=b; j<b+size; j++) {
				map[i][j] = 0;
			}
		}
	}

	public static void makeOne(int a, int b, int size) {
		for (int i=a; i<a+size; i++) {
			for (int j=b; j<b+size; j++) {
				map[i][j] = 1;
			}
		}
	}

}
