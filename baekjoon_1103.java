import java.io.*;
import java.util.*;

public class baekjoon_1103 {
	
	public static int N, M;
	public static int[][] map;
	public static int[][] visit;
	public static int[][] maxVal;
	
	public static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		visit = new int[N][M];
		maxVal = new int[N][M];
		
		ans = 0;
		
		for (int i=0; i<N; i++) {
			char[] str = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				if (str[j] == 'H') {
					map[i][j] = 0;
				}
				else {
					map[i][j] = str[j] - '0';
				}
			}
		}
		
		//////////////////////////////////////////////////
		
		start(0, 0, 1);
		if (ans != -1) {
			for (int i=0; i<N; i++) {
				for (int j=0; j<M; j++) {
					ans = Math.max(ans, maxVal[i][j]);
				}
			}
		}
		System.out.println(ans);
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void start(int a, int b, int totalMove) {
		int na, nb;
		int jump = map[a][b];
		
		for (int i=0; i<4; i++) {
//			System.out.println(a + " " + b +  " " + i);
//			printMax();
			
			if (ans == -1)
				return;
			
			na = a + da[i]*jump;
			nb = b + db[i]*jump;
			
			// 범위 밖 
			if (na<0 || na>=N || nb<0 || nb>=M) {
				maxVal[a][b] = Math.max(maxVal[a][b], totalMove);
				continue;
			}
			// 구멍 
			if (map[na][nb] == 0) {
				maxVal[a][b] = Math.max(maxVal[a][b], totalMove);
				continue;
			}
			
			// loop check
			if (visit[na][nb] != 0) {
				ans = -1;
				return;
			}
			
			// 가려는 곳이 이미 계산된 곳이면서 값도 크면 
			if (maxVal[na][nb] >= totalMove+1) {
				continue;
			}
			
			visit[na][nb] = 1;
			start(na, nb, totalMove+1);
			maxVal[a][b] = Math.max(maxVal[a][b], maxVal[na][nb]-1);
			visit[na][nb] = 0;
		}
	}
	
	public static void printMax() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(maxVal[i][j]);
			}System.out.println();
		}System.out.println();
	}
	
	public static void printAll(int a, int b) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (i==a && j==b)
					System.out.printf("%2d ", -1);
				else {
					System.out.printf("%2d ", map[i][j]);
				}
			}System.out.println();
		}System.out.println();
	}
}
