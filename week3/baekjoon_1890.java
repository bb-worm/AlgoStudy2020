package week3;

import java.io.*;
import java.util.*;

public class baekjoon_1890 {
	
	public static int N;
	public static int[][] map;
	public static long[][] canGo;
	
	public static long ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		canGo = new long[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				canGo[i][j] = -1;
			}
		}
		
		ans = DFS(0, 0);
//		printAll();
		System.out.printf("%d\n",ans);
//		System.out.println(total);
	}
	
	public static int[] da = {0, 1};
	public static int[] db = {1, 0};
//	public static long total = 0;
	public static long DFS(int a, int b) {
//		total++;
		if (a == N-1 && b == N-1) {
			return 1;
		}
		if (map[a][b] == 0) {
			return 0;
		}
		
		long sum = 0;
		int jump = map[a][b];
		
		int na, nb;
		for (int i=0; i<2; i++) {
			na = a + da[i]*jump;
			nb = b + db[i]*jump;
			
			if (na<0||na>=N||nb<0||nb>=N)
				continue;
			
			if (canGo[na][nb] != -1) {
				sum += canGo[na][nb];
			} else {
				sum += DFS(na, nb);
			}
		}
		
		canGo[a][b] = sum;
		return sum;
	}
	
	public static void printAll() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(canGo[i][j]);
			}System.out.println();
		}System.out.println();
	}

}
