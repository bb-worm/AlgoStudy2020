package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_17244 {
	
	public static int N, M;
	public static char[][] map;
	public static int[][] key;
	public static int[] isUse;
	
	public static int a, b;
	public static int goalA, goalB;
	
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
//		System.out.println(0 | (1 << 'A'));
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[M][N];
		key = new int[5][2];
		isUse = new int[5];
		
		int keyNum = 0;
		for (int i=0; i<M; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j=0; j<N; j++) {
				if (map[i][j] == 'S') {
					a = i; b = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'X') {
					key[keyNum][0] = i;
					key[keyNum++][1] = j;
				} else if (map[i][j] == 'E') {
					goalA = i;
					goalB = j;
				}
			}
		}
		ans = Integer.MAX_VALUE;
		setKey(1, keyNum);
		System.out.println(ans);
	}
	
	public static void setKey(int now, int limit) {
//		System.out.println(now + " " + limit);
		if (now > limit) {
			int result = 0;
			
			int startA=a, startB=b;
			int endA, endB;
			for (int i=0; i<limit; i++) {
				endA = key[isUse[i]-1][0];
				endB = key[isUse[i]-1][1];
				
				result += BFS(startA, startB, endA, endB);
				if (result >= ans)
					return;
				
				startA = endA;
				startB = endB;
			}
			result += BFS(startA, startB, goalA, goalB);
			ans = Math.min(ans, result);
			return;
		}
		
		for (int i=0; i<limit; i++) {
			if (isUse[i] == 0) {
				isUse[i] = now;
				setKey(now+1, limit);
				isUse[i] = 0;
			}
		}
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static int BFS(int startA, int startB, int endA, int endB) {
		Queue<Integer> q = new LinkedList<>();
		int[][] visit = new int[M][N];
		
		q.add(startA); q.add(startB);
		visit[startA][startB] = 1;
		
		int a, b;
		while(!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			if (a==endA && b==endB) {
				q.clear();
				return visit[a][b] - 1;
			}
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=M||nb<0||nb>=N||visit[na][nb]!=0||map[na][nb]=='#')
					continue;
				
				q.add(na); q.add(nb);
				visit[na][nb] = visit[a][b] + 1;
			}
		}
		return 0;
	}
}
