package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_17837 {
	
	static class Map {
		int color;
		int a, b;
		ArrayList<Integer> al;
		
		public Map(int color, int a, int b) {
			this.color = color;
			this.a = a;
			this.b = b;
			this.al = new ArrayList<>();
		}
	}
	
	static class Horse {
		int a, b;
		int dir;
		
		public Horse (int a, int b, int dir) {
			this.a = a;
			this.b = b;
			this.dir = dir;
		}
	}
	
	static int N, K;
	static Map[][] map;
	static Horse[] horse;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new Map[N][N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				int color = Integer.parseInt(st.nextToken());
				map[i][j] = new Map(color, i, j);
			}
		}
		
		horse = new Horse[K];
		int a, b, dir;
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken()) - 1;
			b = Integer.parseInt(st.nextToken()) - 1;
			dir = Integer.parseInt(st.nextToken()) - 1;
			horse[i] = new Horse(a, b, dir);
			map[a][b].al.add(i);
		}
		int turn = 0;
		boolean isFinish = false;
		while (!isFinish) {
			turn++;
			
			if (turn > 1000) {
				turn = -1;
				break;
			}
			
			int na, nb;
			for (int i=0; i<K; i++) {
				
//				System.out.println(i);
//				System.out.println(horse[i].a + " " +horse[i].b + " " + horse[i].dir);
				move(i);
//				System.out.println(horse[i].a + " " +horse[i].b + " " + horse[i].dir);
//				printMap();
				
				na = horse[i].a;
				nb = horse[i].b;
				if (map[na][nb].al.size() >= 4) {
//					printMap();
//					System.out.println(i + ": " + na + " " + nb);
					isFinish = true;
					break;
				}
			}
		}
		System.out.println(turn);
	}
	
	static int[] da = {0, 0, -1, 1};
	static int[] db = {1, -1, 0, 0};
	
	static void move(int idx) {
		int a = horse[idx].a;
		int b = horse[idx].b;
		int dir = horse[idx].dir;
		
		int na = a + da[dir];
		int nb = b + db[dir];
		
		// blue
		if (!rangeCheck(na, nb) || map[na][nb].color == 2) {
			horse[idx].dir = changeDir(dir);
			dir = horse[idx].dir;
			
			na = a + da[dir];
			nb = b + db[dir];
			
			// cannot go again
			if (!rangeCheck(na, nb) || map[na][nb].color == 2)
				return;
			
			move(idx);
		}
		// white || red
		else {
			int start = map[a][b].al.indexOf(new Integer(idx));
			
			// red
			if (map[na][nb].color == 1) {
				for (int i=map[a][b].al.size()-1; i>=start; i--) {
					int now = map[a][b].al.get(i);
					map[na][nb].al.add(now);
					horse[now].a = na;
					horse[now].b = nb;
				}
			}
			// white
			else {
				for (int i=start; i<map[a][b].al.size(); i++) {
					int now = map[a][b].al.get(i);
					map[na][nb].al.add(now);
					horse[now].a = na;
					horse[now].b = nb;
				}
			}
			
			// remove old
			for (int i=map[a][b].al.size()-1; i>=start; i--)
				map[a][b].al.remove(i);
		}
	}
	
	static void printMap() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(map[i][j].al.size());
			}
			System.out.print("    ");
			for (int j=0; j<N; j++) {
				System.out.print(map[i][j].color);
			}
			System.out.println();
		}System.out.println();
		
//		for (int i=0; i<K; i++) {
//			System.out.print(i + ": " + horse[i].a + " " + horse[i].b + " ");
//			if (horse[i].dir == 2)
//				System.out.println("상");
//			else if (horse[i].dir == 3)
//				System.out.println("하");
//			else if (horse[i].dir == 1)
//				System.out.println("좌");
//			else
//				System.out.println("우");
//		}System.out.println();
	}
	
	static boolean rangeCheck(int a, int b) {
		if (a<0||a>=N||b<0||b>=N)
			return false;
		else
			return true;
	}
	
	static int changeDir(int dir) {
		if (dir == 0)
			return 1;
		else if (dir == 1)
			return 0;
		else if (dir == 2)
			return 3;
		else
			return 2;
	}
}
