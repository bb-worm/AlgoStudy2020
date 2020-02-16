package week1;

import java.io.*;
import java.util.*;

public class baekjoon_1026 {

	public static int N;

	public static int[] A;
	public static int[] B;
	public static int[] useIdx;
	public static int[] isUsed;

	public static int[] countA;
	public static int[] countB;

	public static int ans;

	public static void main(String[] args) throws IOException {
//		for (int i=1; i<=50; i++) {
//			System.out.print(i + " ");
//		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		A = new int[N+1];
		B = new int[N+1];
		useIdx = new int[N+1];
		isUsed = new int[N+1];

		countA = new int[101];
		countB = new int[101];

		ans = Integer.MAX_VALUE;

		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
			countA[A[i]]++;
		}
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			B[i] = Integer.parseInt(st.nextToken());
			countB[B[i]]++;
		}

		findMin();

//		start(1, 0);
		System.out.println(ans);
	}

	public static void findMin() {
		int result = 0;
		for (int i=0; i<=100; i++) {

			if (countA[i] != 0) {
				countA[i]--;
				for (int j=100; j>=0; j--) {
					if (countB[j] != 0) {
						countB[j]--;

						result += i*j;

						i--;
						j++;

						break;
					}
				}
			}
		}

		ans = result;
	}

	public static void start(int idx, int sum) {
		if (sum >= ans)
			return;

		// finish
		if (idx > N) {
			for (int i=1; i<=N; i++) {
				System.out.print(useIdx[i] + " ");
			}System.out.println();

			ans = Math.min(ans, sum);
			System.out.println(ans);
			return;
		}

		for (int i=1; i<=N; i++) {
			if (isUsed[i] == 0) {
				isUsed[i] = 1;
				useIdx[idx] = i;
				start(idx+1, sum + A[i]*B[idx]);
				isUsed[i] = 0;
			}
		}
	}
}
