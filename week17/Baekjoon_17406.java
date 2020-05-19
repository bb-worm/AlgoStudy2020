package week17;

import java.io.*;
import java.util.*;

public class Baekjoon_17406 {
	
	static int N, M, K;
	static int[][] map;
	static int[][] rotateInfo;
	static int[] order;
	static boolean[] isUse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		rotateInfo = new int[K][3];
		order = new int[K];
		isUse = new boolean[K];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			rotateInfo[i][0] = Integer.parseInt(st.nextToken())-1;
			rotateInfo[i][1] = Integer.parseInt(st.nextToken())-1;
			rotateInfo[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int ans = setOrder(0);
		System.out.println(ans);
	}
	
	static int setOrder(int idx) {

		if (idx >= K) {
			return rotateAll();
		}
		
		int min = Integer.MAX_VALUE;
		
		for (int i=0; i<K; i++) {
			if (!isUse[i]) {
				isUse[i] = true;
				order[idx] = i;
				min = Math.min(min, setOrder(idx+1));
				isUse[i] = false;
			}
		}
		
		return min;
	}
	
	static int rotateAll() {
		int[][] tmp = new int[N][M];
		copy(tmp, map);
		
		for (int i=0; i<K; i++) {
			rotate(i);
		}
		
		int result = getMin();
		copy(map, tmp);
		
		return result;
	}
	
	static void rotate(int idx) {
		int infoIdx = order[idx];
		int r = rotateInfo[infoIdx][0];
		int c = rotateInfo[infoIdx][1];
		int s = rotateInfo[infoIdx][2];
		
		int[][] tmp = new int[N][M];
		for (int i=0; i<=s*2; i++) {
			for (int j=0; j<=s*2; j++) {
				tmp[i][j] = map[r-s+i][c-s+j];
			}
		}
		
		int a = s;
		int b = s;
		
		for (int i=s; i>=1; i--) {
			for (int j=1; j<=i*2; j++) {
				map[r-i][c-i+j] = tmp[a-i][b-i+j-1];
				map[r-i+j][c+i] = tmp[a-i+j-1][b+i];
				map[r+i][c+i-j] = tmp[a+i][b+i-j+1];
				map[r+i-j][c-i] = tmp[a+i-j+1][b-i];
			}
		}
	}
	
	static int getMin() {
		int result = Integer.MAX_VALUE;
		
		for (int i=0; i<N; i++) {
			int sum = 0;
			for (int j=0; j<M; j++) {
				sum += map[i][j];
			}
			result = Math.min(result, sum);
		}
		
		return result;
	}
	
	static void copy(int[][] arr1, int[][] arr2) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				arr1[i][j] = arr2[i][j];
			}
		}
	}
}
