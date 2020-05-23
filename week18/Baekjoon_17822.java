package week18;

import java.io.*;
import java.util.*;

public class Baekjoon_17822 {

	static int N, M, T;
	static int[][] map;
	static boolean[][] delete;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[N+1][M];
		delete = new boolean[N+1][M];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int x, d, k;
		for (int i=0; i<T; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			k = Integer.parseInt(st.nextToken());
			
			// rotate
			for (int j=x; j<=N; j+=x) {
				rotate(j, d, k);
			}
			
			if (!remove()) {
				double average = getAverage();
				changeMap(average);
			}
		}
		
		int ans = getSum();
		System.out.println(ans);
	}
	
	static int getSum() {
		int sum = 0;
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j<M; j++) {
				if (!delete[i][j])
					sum += map[i][j];
			}
		}
		
		return sum;
	}
	
	static void changeMap(double average) {
		for (int i=1; i<=N; i++) {
			for (int j=0; j<M; j++) {
				if (!delete[i][j]) {
					if (map[i][j] < average)
						map[i][j]++;
					else if (map[i][j] > average)
						map[i][j]--;
				}
			}
		}
	}
	
	static double getAverage() {
		int sum = 0;
		int cnt = 0;
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j<M; j++) {
				if (!delete[i][j]) {
					sum += map[i][j];
					cnt++;
				}
			}
		}
		
		return (double)sum / cnt;
	}
	
	static boolean remove() {
		
		boolean isRemoved = false;
		
		int[][] visit = new int[N+1][M];
		
		int now, left, right, up, down;
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j<M; j++) {
				if (delete[i][j])
					continue;
				
				now = map[i][j];
				if (!delete[i][(j+M-1)%M]) {
					left = map[i][(j+M-1)%M];
					if (now==left) {
						visit[i][j] = 1;
						visit[i][(j+M-1)%M] = 1;
					}
				}
				
				if (!delete[i][(j+1)%M]) {
					right = map[i][(j+1)%M];
					if (now==right) {
						visit[i][j] = 1;
						visit[i][(j+1)%M] = 1;
					}
				}
				
				if (i<N && !delete[i+1][j]) {
					up = map[i+1][j];
					if (now==up) {
						visit[i][j] = 1;
						visit[i+1][j] = 1;
					}
				}
				
				if (i>1 && !delete[i-1][j]) {
					down = map[i-1][j];
					if (now==down) {
						visit[i][j] = 1;
						visit[i-1][j] = 1;
					}
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			for (int j=0; j<M; j++) {
				if (visit[i][j] == 1) {
					isRemoved = true;
					map[i][j] = 0;
					delete[i][j] = true;
				}
			}
		}
		
		return isRemoved;
	}
	
	static void rotate(int idx, int dir, int offset) {
		int[] tmp = new int[M+1];
		boolean[] tmpDel = new boolean[M+1];
		copy(tmp, map[idx]);
		copy(tmpDel, delete[idx]);
		
		
		if (dir == 0) { // 시계방향 
			for (int i=0; i<M; i++) {
				map[idx][i] = tmp[(i+M-offset)%M];
				delete[idx][i] = tmpDel[(i+M-offset)%M];
			}
		} else { // 반시계방향 
			for (int i=0; i<M; i++) {
				map[idx][i] = tmp[(i+offset)%M];
				delete[idx][i] = tmpDel[(i+offset)%M];
			}
		}
	}
	
	static void copy(int[] arr1, int[] arr2) {
		for (int i=0; i<M; i++) {
			arr1[i] = arr2[i];
		}
	}
	static void copy(boolean[] arr1, boolean[] arr2) {
		for (int i=0; i<M; i++) {
			arr1[i] = arr2[i];
		}
	}
	
	static void print() {
		for (int i=1; i<=N; i++) {
			for (int j=0; j<M; j++) {
				if (delete[i][j])
					System.out.print("x ");
				else
					System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
}
