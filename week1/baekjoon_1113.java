package week1;

import java.io.*;
import java.util.*;

public class baekjoon_1113 {
	
	public static int N, M;
	public static int[][] map;
	public static int[][] waterIn;
	public static int[] num = new int[10];
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		waterIn = new int[N][M];
		
		char[] str;
		for (int i=0; i<N; i++) {
			str = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				map[i][j] = str[j] - '0';
				num[map[i][j]]++;
			}
		}
		
		///////////////////////////////////////////////////
		ans = 0;
		
		for (int k=9; k>=2; k--) {
			if (num[k] == 0)
				continue;
			for (int i=1; i<N-1; i++) {
				for (int j=1; j<M-1; j++) {
					if (map[i][j] < k && waterIn[i][j] == 0) {
						BFS(i, j, k);
						System.out.println(k);
						printArr(map);
					}
				}
			}
		}
		
		System.out.println(ans);
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void BFS(int i, int j, int limit) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] visit = new int[N][M];
		
		q.add(i); q.add(j);
		visit[i][j] = 1;
		
		int a, b;
		while(!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0 || na>=N || nb<0 || nb>=M) {
					q.clear();
					return;
				}
				
				if (visit[na][nb] != 0) {
					continue;
				}
				
				if (map[na][nb] >= limit) {
					continue;
				}
				
				q.add(na); q.add(nb);
				visit[na][nb] = 1;
			}
		}
		
		for (int y=1; y<N-1; y++) {
			for (int x=1; x<M-1; x++) {
				if (visit[y][x] != 0) {
					int diff = limit - map[y][x];
					map[y][x] = limit;
					ans += diff;
					
					waterIn[y][x] = 1;
				}
			}
		}
	
	}
	
	public static void printArr(int[][] tmp) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(tmp[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	public static void printAll() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(waterIn[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
