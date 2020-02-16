package week1;

import java.io.*;
import java.util.*;

public class baekjoon_1062 {

	public static int N, K;
	public static char[][] words;

	// 사용된 글자
	public static int[] usedAlpha = new int[26];
	// 배운 글자
	public static int[] learnAlpha = new int[26];

	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		ans = 0;

		words = new char[N][15];

		for (int i=0; i<N; i++) {
			words[i] = br.readLine().toCharArray();
			for (int j=4; j<words[i].length-4; j++) {
				usedAlpha[words[i][j] - 'a'] =  1;
			}
		}

		if (K < 5) {
			System.out.println(ans);
		}
		else {
			learnAlpha['a'-'a'] = 1;
			learnAlpha['c'-'a'] = 1;
			learnAlpha['i'-'a'] = 1;
			learnAlpha['n'-'a'] = 1;
			learnAlpha['t'-'a'] = 1;

			K -= 5;

			setUse(0, 0);

			System.out.println(ans);
		}
	}

	public static void setUse(int idx, int totalUse) {
		if (totalUse >= K) {
			ans = Math.max(ans, getAns());
			return;
		}

		if (idx >= 26)
			return;

		// 사용되었는데 아직 배우지 않았으면
		if (learnAlpha[idx] == 0) {
			learnAlpha[idx] = 1;
			setUse(idx+1, totalUse+1);
			learnAlpha[idx] = 0;
		}
		setUse(idx+1, totalUse);
	}

	public static int getAns() {
		int sum = 0;

		for (int i=0; i<N; i++) {
			int canLearn = 1;
			for (int j=4; j<words[i].length-4; j++) {
				if (learnAlpha[words[i][j] - 'a'] == 0) {
					canLearn = 0;
					break;
				}
			}
			if (canLearn == 1)
				sum++;
		}

		return sum;
	}
}
