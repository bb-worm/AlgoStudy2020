package week5_6;

import java.io.*;
import java.util.*;

public class Baekjoon_2536 {
	
	static class Bus {
		int idx;
		int x1, y1;
		int x2, y2;
		int type; // 0: 수직, 1: 수평 
		
		public Bus(int idx, int x1, int y1, int x2, int y2, int type) {
			this.idx = idx;
			this.x1 = Math.min(x1, x2);
			this.y1 = Math.min(y1, y2);
			this.x2 = Math.max(x1, x2);
			this.y2 = Math.max(y1, y2);
			this.type = type;
		}
		
		public boolean isContain(int x, int y) {
			if (this.type == 0) { // 수직 
				if (this.x1==x && y>=this.y1 && y<=this.y2)
					return true;
				else
					return false;
			} else { // 수평 
				if (this.y1==y && x>=this.x1 && x<=this.x2)
					return true;
				else
					return false;
			}
		}
		
		public boolean isContain(Bus b) {
			if (this.type==0 && b.type==0) { // 수직 수직 
				if (this.x1 != b.x1 || this.y1 > b.y2 || this.y2 < b.y1)
					return false;
				else
					return true;
			} else if (this.type==1 && b.type==1) { // 수평 수평
				if (this.y1 != b.y1 || this.x1 > b.x2 || this.x2 < b.x1)
					return false;
				else
					return true;
			} else if (this.type==0 && b.type==1) { // 수직 수평 
				if (this.x1>=b.x1 && this.x1<=b.x2 && b.y1>=this.y1 && b.y1<=this.y2)
					return true;
				else
					return false;
			} else { // 수평 수직 
				if (this.y1>=b.y1 && this.y1<=b.y2 && b.x1>=this.x1 && b.x1<=this.x2)
					return true;
				else
					return false;
			}
		}
	}
	
	static int m, n;
	static int k;
	static Bus[] bus;
	
	static int sx, sy, gx, gy;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		k = Integer.parseInt(br.readLine());
		bus = new Bus[k+1];
		for (int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			if (x1==x2) { // 수직 
				bus[b] = new Bus(b, x1, y1, x2, y2, 0);
			} else { // 수평 
				bus[b] = new Bus(b, x1, y2, x2, y2, 1);
			}
		}
		
		st = new StringTokenizer(br.readLine());
		sx = Integer.parseInt(st.nextToken());
		sy = Integer.parseInt(st.nextToken());
		gx = Integer.parseInt(st.nextToken());
		gy = Integer.parseInt(st.nextToken());
		
		int ans = BFS();
		System.out.println(ans);
	}
	
	static int BFS() {
		int result = 0;
		
		Queue<Bus> q = new LinkedList<>();
		int[] visit = new int[k+1];
		
		for (int i=1; i<=k; i++) {
			if (bus[i].isContain(sx, sy)) {
				q.add(bus[i]);
				visit[i] = 1;
			}
		}
		
		while (!q.isEmpty()) {
			Bus now = q.poll();
			
			if (now.isContain(gx, gy)) {
				result = visit[now.idx];
				q.clear();
				break;
			}
			
			for (int i=1; i<=k; i++) {
				if (visit[i] != 0 || !now.isContain(bus[i]))
					continue;
				
				q.add(bus[i]);
				visit[i] = visit[now.idx] + 1;
			}
		}
		return result;
	}
}
