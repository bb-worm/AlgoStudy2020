package week1;

import java.io.*;
import java.util.*;

public class baekjoon_17135 {

	public static int N, M;
	public static int D;

	public static int[][] map;
	public static int[][] archer;

	public static int ans;
	public static int enermyNum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		archer = new int[3][2];

		ans = 0;
		enermyNum = 0;

		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					enermyNum++;
			}
		}
		/////////////////////////////////
//
//		archer[0][0] = archer[1][0] = archer[2][0] = 5;
//		archer[0][1] = 0;
//		archer[1][1] = 2;
//		archer[2][1] = 4;
//		System.out.println(start());

		// 배치 -> 실행
		if (enermyNum != 0) {
			setArcher(0, 0);
		}

		System.out.println(ans);
	}

	public static void setArcher(int now, int w) {

		if (now >= 3) {
//			printArcher();
//			return;
			int newNum = start();
			if (ans < newNum) {
				ans = newNum;
//				System.out.println(newNum);
//				printArcher();
			}
			return;
		}

		if (w >= M)
			return;

		archer[now][0] = N;
		archer[now][1] = w;
		setArcher(now+1, w+1);

		setArcher(now, w+1);
	}

	public static int start() {
		int killNum = 0;
		int tmpEnermyNum = enermyNum;

		int[][] tmpMap = new int[N][M];
		copyMap(tmpMap);

//		System.out.println(tmpEnermyNum);
//		printAll(tmpMap);

		while (tmpEnermyNum > 0) {
			int shootNum = shoot(tmpMap);
//			System.out.println("shoot:" + shootNum);
//			printAll(tmpMap);

			int downNum = down(tmpMap);
//			System.out.println("down: " + downNum);
//			printAll(tmpMap);

			killNum += shootNum;

			tmpEnermyNum -= (shootNum + downNum);

//			System.out.println(tmpEnermyNum);
		}
		return killNum;
	}

	public static Queue<Integer> q = new LinkedList<Integer>();

	public static int shoot(int[][] tmpMap){
		int sum = 0;
		int[][] del = new int[3][2];
		del[0] = BFS(tmpMap, 0);
		del[1] = BFS(tmpMap, 1);
		del[2] = BFS(tmpMap, 2);

		for (int k=0; k<3; k++) {
			int a = del[k][0];
			int b = del[k][1];

			if (a == -1)
				continue;

			if (tmpMap[a][b] == 1) {
				sum++;
				tmpMap[a][b] = 0;
			}
		}
		return sum;
	}

	public static int[] da = {0, -1, 0};
	public static int[] db = {-1, 0, 1};

	public static int[] BFS(int[][] tmpMap, int idx) {
		int[] enermy = {-1, -1};

		int[][] visit = new int[N+1][M];

		q.add(archer[idx][0]);
		q.add(archer[idx][1]);
		visit[archer[idx][0]][archer[idx][1]] = 1;

		int a, b;

		while (!q.isEmpty()) {
			a = q.poll();
			b = q.poll();

			int na, nb;
			for (int i=0; i<3; i++) {
				na = a + da[i];
				nb = b + db[i];

				if (na < 0 || na >= N || nb < 0 || nb >= M)
					continue;

				if (visit[na][nb] != 0)
					continue;

				if (distance(archer[idx][0], archer[idx][1], na, nb) > D)
					continue;

				if (tmpMap[na][nb] == 1) {
					enermy[0] = na;
					enermy[1] = nb;
					q.clear();
					return enermy;
				}

				visit[na][nb] = 1;
				q.add(na); q.add(nb);
			}
		}
		return enermy;
	}

	public static int down(int[][] tmpMap) {
		int sum = 0;

		for (int i=N-1; i>=0; i--) {
			for (int j=0; j<M; j++) {
				// first line
				if (i==0) {
					tmpMap[i][j] = 0;
					continue;
				}

				// last line
				if (i==N-1 && tmpMap[i][j] == 1) {
					sum++;
				}

				tmpMap[i][j] = tmpMap[i-1][j];
			}
		}
		return sum;
	}

	public static void copyMap(int[][] tmp) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				tmp[i][j] = map[i][j];
			}
		}
	}

	public static int distance(int r1, int b1, int r2, int b2) {
		return Math.abs(r1-r2) + Math.abs(b1-b2);
	}

	public static void printAll(int[][] tmp) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				System.out.print(tmp[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void printArcher() {
		for (int i=0; i<3; i++) {
			System.out.println(archer[i][0] + " " + archer[i][1]);
		}System.out.println();
	}
}
