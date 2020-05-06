package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_17779 {
	
	static int N;
	static int[][] map;
	static int[][] visit;
	
	static int[] up = new int[2];
	static int[] down = new int[2];
	static int[] left = new int[2];
	static int[] right = new int[2];
	
	static int total;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new int[N][N];
		
		for (int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				total += map[i][j];
			}
		}
		
		ans = Integer.MAX_VALUE;
		for (int i=1; i<N-1; i++) {
			for (int j=1; j<N-2; j++) {
				up[0] = i; up[1] = j;
				visit[i+1][j+1] = 1;
				DFS(i+1, j+1, i, j, 0);
				visit[i+1][j+1] = 0;
			}
		}
		System.out.println(ans);
	}
	
	static void getAns(int a, int b) {
		
		int exceptFive = 0;
		
		int[][] number = new int[N][N];
		int sum = 0;
		int max = 0;
		int min = Integer.MAX_VALUE;
		
		// 1
		for (int i=0; i<left[0]; i++) {
			for (int j=0; j<=up[1]; j++) {
				if (visit[i][j] == 1)
					break;
				
				sum += map[i][j];
				number[i][j] = 1;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		exceptFive += sum;
		sum = 0;
		
		// 2
		for (int i=0; i<=right[0]; i++) {
			for (int j=N-1; j>up[1]; j--) {
				if (visit[i][j] == 1)
					break;
				
				sum += map[i][j];
				number[i][j] = 2;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		exceptFive += sum;
		sum = 0;
		
		// 3
		for (int i=left[0]; i<N; i++) {
			for (int j=0; j<down[1]; j++) {
				if (visit[i][j] == 1)
					break;
				
				sum += map[i][j];
				number[i][j] = 3;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		exceptFive += sum;
		sum = 0;
		
		// 4
		for (int i=right[0]+1; i<N; i++) {
			for (int j=N-1; j>=down[1]; j--) {
				if (visit[i][j] == 1)
					break;
				
				sum += map[i][j];
				number[i][j] = 4;
			}
		}
		max = Math.max(max, sum);
		min = Math.min(min, sum);
		exceptFive += sum;
		
		max = Math.max(max, total-exceptFive);
		min = Math.min(min, total-exceptFive);
		
		ans = Math.min(ans, max-min);
	}
	
	static int[] da = {1, 1, -1, -1};
	static int[] db = {1, -1, -1, 1};
	
	static void DFS(int a, int b, int ga, int gb, int dir) {
		
		if (a==ga && b==gb) {
//			System.out.println(ga + " " + gb);
//			printVisit();
			getAns(ga, gb);
			return;
		}
		
		int na, nb;
		
		// 기존 방향 
		na = a + da[dir];
		nb = b + db[dir];
		
		if (na>=ga && na<N && nb>=0 && nb<N && visit[na][nb]==0) {
			visit[na][nb] = 1;
			DFS(na, nb, ga, gb, dir);
			visit[na][nb] = 0;
		}
		
		if (dir <= 2) {
			// 새로운 방향 
			dir = dir+1;
			
			na = a + da[dir];
			nb = b + db[dir];
			
			if (na>=ga && na<N && nb>=0 && nb<N && visit[na][nb]==0) {
				
				if (dir == 1) {
					right[0] = a;
					right[1] = b;
				} else if (dir == 2) {
					down[0] = a;
					down[1] = b;
				} else if (dir == 3) {
					left[0] = a;
					left[1] = b;
				}
				
				visit[na][nb] = 1;
				DFS(na, nb, ga, gb, dir);
				visit[na][nb] = 0;
			}
		}
	}
	
	static void printVisit() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(visit[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

}
