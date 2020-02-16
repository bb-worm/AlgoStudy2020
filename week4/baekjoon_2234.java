package week4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class baekjoon_2234 {
	
	public static int m, n;
	public static int[][] map;
	public static int[][][] cantGo;
	
	public static int ans1, ans2, ans3;
	
	public static ArrayList<Integer> width = new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		System.out.println(11 & 1);
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[m][n];
		cantGo = new int[m][n][4];
		
		int val;
		for (int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<n; j++) {
				val = Integer.parseInt(st.nextToken());
				setInput(i, j, val);
				map[i][j] = -1;
			}
		}
		
		ans2 = -1;
		// labeling + width 구하기
		int num = 0;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				if (map[i][j] == -1) {
					labeling(i, j, num);
					num++;
				}
			}
		}
		// 라벨링한 사이즈가 답1이 됨 
		ans1 = width.size();
		
		ans3 = -1;
		// 벽 부술 수 있으면 부수기 
		int sum;
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				for (int k=0; k<4; k++) {
					if (cantGo[i][j][k] == 1)
						breakWall(i, j, k);
				}
			}
		}
		
		System.out.println(ans1);
		System.out.println(ans2);
		System.out.println(ans3);
		
	}
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void breakWall(int a, int b, int k) {
		int na = a + da[k];
		int nb = b + db[k];
		
		if (na<0||na>=m||nb<0||nb>=n)
			return;
		
		int nowIdx = map[a][b];
		int nextIdx = map[na][nb];
		
		// 같은 라벨이면 return
		if (nowIdx == nextIdx)
			return;
		
		int sum = width.get(nowIdx) + width.get(nextIdx);
		
		ans3 = Math.max(ans3, sum);
	}
	
	public static void labeling(int i, int j, int num) {
		Queue<Integer> q = new LinkedList<Integer>();
		int[][] visit = new int[m][n];
		
		q.add(i); q.add(j);
		visit[i][j] = 1;
		map[i][j] = num;
		int sum = 1;
		
		int a, b;
		while (!q.isEmpty()) {
			a = q.poll();
			b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=m||nb<0||nb>=n)
					continue;
				if (visit[na][nb] == 1)
					continue;
				if (cantGo[a][b][k] == 1)
					continue;
				
				q.add(na); q.add(nb);
				visit[na][nb] = 1;
				map[na][nb] = num;
				sum++;
			}
		}
		
		ans2 = Math.max(ans2, sum);
		width.add(sum);
	}
	public static void setInput(int i, int j, int val) {
		
		// west
		if (val % 2 != 0) {
			cantGo[i][j][2] = 1;
			val -= 1;
		}
		
		// south
		if (checkPow(val-8)) {
			val -= 8;
			cantGo[i][j][1] = 1;
		}
		
		// east
		if (checkPow(val-4)) {
			val -= 4;
			cantGo[i][j][3] = 1;
		}
		
		// north
		if (checkPow(val-2)) {
			val -= 2;
			cantGo[i][j][0] = 1;
		}
	}
	public static boolean checkPow(int val) {
		if (val==0 || val==2 || val==4 || val==8 || val==6)
			return true;
		return false;
	}
	public static void printAll() {
		for (int i=0; i<m; i++) {
			for (int j=0; j<n; j++) {
				System.out.printf("%2d ",map[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
