package week21;

import java.io.*;
import java.util.*;

public class Baekjoon_17780 {
	
	static class Horse{
		int idx; // 말 번호 
		int a, b; // 좌표 
		int dir; // 방향 
		Horse up; // 위에 있는 말 
		
		public Horse(int idx, int a, int b, int dir) {
			this.idx = idx;
			this.a = a;
			this.b = b;
			this.dir = dir;
		}
		
		// 본인 및 위에 있는 말 좌표 설정 
		public void move(int na, int nb) {
			this.a = na;
			this.b = nb;
			
			if (this.up != null)
				this.up.move(na, nb);
		}
		
		// 위아래 뒤집기 
		public Horse reverse(Horse tmp) {
			Horse next = this.up;
			this.up = tmp;
			
			if (next == null)
				return this;
			else
				return next.reverse(this);
		}
		
		// 본인 포함 위에 있는 말의 개수 return  
		public int upNum() {
			if (this.up == null)
				return 1;
			else
				return 1 + this.up.upNum();
		}
		
		// 가장 위에 있는 말 return 
		public Horse top() {
			if (this.up == null)
				return this;
			else
				return this.up.top();
		}
	}
	
	static int N, K;
	static int[][] map;
	static int[][] horseMap;
	static Horse[] horse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		horseMap = new int[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		horse = new Horse[K+1];
		for (int i=1; i<=K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			int dir = Integer.parseInt(st.nextToken())-1;
			horse[i] = new Horse(i, a, b, dir);
			horseMap[a][b] = i;
		}
		
		int t = 0;
		while (t <= 1000) {
			t++;
			for (int i=1; i<=K; i++) {
				if (move(horse[i], 1)) {
					System.out.println(t);
					return;
				}
			}
		}
		System.out.println(-1);
	}
	
	static int[] da = {0, 0, -1, 1};
	static int[] db = {1, -1, 0, 0};
	
	// 특정 말을 움직
	static boolean move(Horse h, int chance) {
		
		// 만약 가장 아래에 있는 말이 아니면 return 
		if (horseMap[h.a][h.b] != h.idx)
			return false;
		
		int na = h.a + da[h.dir];
		int nb = h.b + db[h.dir];
		
		// 범위를 벗어났거나, 파란색 칸을 만났거나 
		if (na<0||na>=N||nb<0||nb>=N||map[na][nb]==2) {
			if (chance == 0) // 두번째 기회 종료 
				return false;
			
			h.dir = changeDir(h.dir);
			return move(h, 0);
		}
		
		// 전에 있던 곳을 0으로 초기화 
		horseMap[h.a][h.b] = 0; 
		
		if (map[na][nb] == 1) { // red
			h = h.reverse(null); // 뒤집기 
		}
		
		// 새로 간 곳이 비었는지 안 비었는지 체크 
		if (horseMap[na][nb] == 0)
			horseMap[na][nb] = h.idx;
		else {
			horse[horseMap[na][nb]].top().up = h;
		}
		
		// 말 이동 
		h.move(na, nb);
		
		// 종료 조건 체크 
		return check(na, nb);
	}
	
	// 종료 조건 체크 
	static boolean check(int a, int b) {
		Horse floor = horse[horseMap[a][b]];
		
		if (floor.upNum() >= 4)
			return true;
		else
			return false;
	}
	
	// 반대 방향으로 전환 
	static int changeDir(int dir) {
		if (dir == 0) // right to left
			return 1;
		else if (dir == 1) // left to right
			return 0;
		else if (dir == 2) // up to down
			return 3;
		else // down to up
			return 2;
	}
	
	// 디버깅용 
	static void printAll() {
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				if (horseMap[i][j] != 0) {
					Horse now = horse[horseMap[i][j]];
					while (now != null) {
						System.out.print(now.idx + " ");
						now = now.up;
					}System.out.println();
				}
			}
		}System.out.println();
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(horseMap[i][j]+ " ");
			}System.out.println();
		}System.out.println();
	}
}
