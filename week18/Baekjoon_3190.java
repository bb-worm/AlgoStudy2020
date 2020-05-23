package week18;

import java.io.*;
import java.util.*;

public class Baekjoon_3190 {
	
	static int N;
	static int[][] map;
	static Map<Integer, String> rotate = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		int K = Integer.parseInt(br.readLine());
		
		int a, b;
		for (int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken())-1;
			b = Integer.parseInt(st.nextToken())-1;
			
			map[a][b] = 1;
		}
		
		int L = Integer.parseInt(br.readLine());
		int t;
		String d;
		for (int i=0; i<L; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			d = st.nextToken();
			rotate.put(t, d);
		}
		
		int time = 0;
		Queue<Loca> q = new LinkedList<>();
		
		map[0][0] = 2; // start point
		int dir = 1; // right
		
		Loca now = new Loca(0, 0);
		q.add(now);
		
		while (true) {
			time++;
			Loca next = getNext(now, dir);
			
			if (next==null) break;
			
			now = next;
			
			// no apple
			if (map[now.a][now.b] != 1) {
				Loca tail = q.poll();
				map[tail.a][tail.b] = 0; 
			}
			
			map[now.a][now.b] = 2;
			q.add(now);
			dir = getDir(time, dir);
		}
		System.out.println(time);
	}
	
	static class Loca {
		int a, b;
		public Loca(int a, int b) {
			this.a = a;
			this.b = b;
		}
	}
	
	static int getDir(int time, int dir) {
		String r = rotate.getOrDefault(time, null);
		
		if (r == null)
			return dir;
		else {
			if (r.equals("L")) {
				return (dir+3)%4;
			} else {
				return (dir+1)%4;
			}
		}
	}
	
	static Loca getNext(Loca now, int dir) {
		int na=now.a, nb=now.b;
		
		if (dir == 0) { // up
			na--;
		} else if (dir == 1) { // right
			nb++;
		} else if (dir == 2) { // down
			na++;
		} else { // left
			nb--;
		}
		
		if (!check(na, nb)) {
			return null;
		} else {
			return new Loca(na, nb);
		}
	}
	
	static boolean check(int a, int b) {
		if (a<0||a>=N||b<0||b>=N||map[a][b]==2) {
			return false;
		}
		return true;
	}
	
	static void print() {
		for (int i=0; i<N; i++) {
			for (int j=0; j<N; j++) {
				System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}

}
