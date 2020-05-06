package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2186 {
	
	static int N, M, K;
	static char[][] map; // 좌표에 따른 문자 값
	static long[][][] visit; // 해당 좌표에서 해당 depth의 방문 여부
	static String goal; // 목표로 하는 영단어

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
		}
		goal = br.readLine();
		visit = new long[N][M][goal.length()];
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				for (int k=0; k<goal.length(); k++)
					visit[i][j][k] = -1; // -1로 초기화
			}
		}
		
		long ans = 0;
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				ans += DFS(i, j, 0); // 해당 좌표에서 DFS
			}
		}
		System.out.println(ans);
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
	
	static long DFS(int a, int b, int depth) {
		
		if (visit[a][b][depth] != -1) { // 이미 방문한 곳이면
			return visit[a][b][depth];
		}
		
		if (map[a][b] != goal.charAt(depth)) { // 문자가 일치하지 않으면
			return visit[a][b][depth] = 0;
		}
		
		if (depth == goal.length()-1) { // 모든 문자를 일치시켰으면
			return visit[a][b][depth] = 1;
		}
		
		long sum = 0;
		int na, nb;
		for (int i=0; i<4; i++) {
			na = a;
			nb = b;
			for (int j=0; j<K; j++) {
				na += da[i];
				nb += db[i];
				
				if (na<0||na>=N||nb<0||nb>=M) // 범위 벗어난 곳
					break;
				
				sum += DFS(na, nb, depth+1); // DP - 메모이제이션
			}
		}
		return visit[a][b][depth] = sum;
	}
}