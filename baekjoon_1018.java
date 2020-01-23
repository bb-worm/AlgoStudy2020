import java.io.*;
import java.util.*;

public class baekjoon_1018 {

	public static int N, M;
	public static int[][] map;

	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		ans = Integer.MAX_VALUE;

		char[] str;
		for (int i=0; i<N; i++) {
			str = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				if (str[j] == 'W')
					map[i][j] = 0; // white
				else
					map[i][j] = 1; // black
			}
		}
//		printMap(0, 0);
		start();
		System.out.println(ans);
	}

	public static void start() {
		for (int i=0; i<=N-8; i++) {
			for (int j=0; j<=M-8; j++) {
				go(i, j);
			}
		}
	}

	public static void go(int a, int b) {
		int[][] tmp = new int[8][8];

		// white
		copy(a, b, tmp);
		BFS(0, tmp);

		//black
		copy(a, b, tmp);
		BFS(1, tmp);
	}

	public static Queue<Integer> q = new LinkedList<Integer>();
	public static int[] da = {0, 1};
	public static int[] db = {1, 0};

	public static void BFS(int start, int[][] tmp) {
		int[][] visit = new int[8][8];

		int sum = 0;

		if (tmp[0][0] != start) {
			sum++;
			tmp[0][0] = start;
		}

		q.add(0); q.add(0);
		visit[0][0] = 1;

		int a, b;
		while (!q.isEmpty()) {
			a = q.poll();
			b = q.poll();

			int na, nb;
			for (int i=0; i<2; i++) {
				na = a + da[i];
				nb = b + db[i];

				if (na >= 8 || nb >= 8)
					continue;

				if (visit[na][nb] != 0)
					continue;

				q.add(na); q.add(nb);
				visit[na][nb] = 1;

				if (tmp[a][b] == tmp[na][nb]) {
					sum++;

					// finish
					if (sum >= ans) {
						q.clear();
						return;
					}

					tmp[na][nb] = (tmp[a][b] + 1) % 2;
				}
			}
		}

		ans = Math.min(ans, sum);
	}

	public static void copy(int a, int b, int[][] tmp) {
		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				tmp[i][j] = map[i+a][j+b];
			}
		}
	}

	public static void printMap(int a, int b) {
		for (int i=a; i<a+8; i++) {
			for (int j=b; j<b+8; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}

}
