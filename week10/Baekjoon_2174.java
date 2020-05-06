package week10;

import java.io.*;
import java.util.*;

public class Baekjoon_2174 {
	
	static class Robot {
		int a, b;
		int dir;
		
		public Robot(int a, int b, int dir) {
			this.a = a;
			this.b = b;
			this.dir = dir;
		}
	}
	
	static int R, C;
	static int N, M;
	static int[][] map;
	static Robot[] robot;
	
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		robot = new Robot[N+1];
		
		// robot location
		int x, y, dir;
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken())-1;
			y = R - Integer.parseInt(st.nextToken());
			dir = getDir(st.nextToken().charAt(0));
			
			robot[i] = new Robot(y, x, dir);
			map[y][x] = i;
		}
		
		// operation
		int idx;
		char oper;
		int iter;
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			idx = Integer.parseInt(st.nextToken());
			oper = st.nextToken().charAt(0);
			iter = Integer.parseInt(st.nextToken());
			
			if (!doOper(idx, oper, iter))
				break;
		}
		
		if (sb.length() == 0)
			sb.append("OK");
		System.out.println(sb);
	}
	
	static int[] dir = {'N', 'E', 'S', 'W'};
	
	static int[] da = {-1, 0, 1, 0};
	static int[] db = {0, 1, 0, -1};
	
	static boolean doOper(int idx, char oper, int iter) {
		
		if (oper == 'F') {
			
			int a, b, dir;
			a = robot[idx].a;
			b = robot[idx].b;
			dir = robot[idx].dir;
			
			int na = a, nb = b;
			for (int i=0; i<iter; i++) {
				na += da[dir];
				nb += db[dir];
				
				if (na<0||na>=R||nb<0||nb>=C) {
					sb.append("Robot ").append(idx).append(" crashes into the wall").append('\n');
					return false; 
				}
				
				if (map[na][nb] != 0) {
					sb.append("Robot ").append(idx).append(" crashes into robot ").append(map[na][nb]).append('\n');
					return false;
				}
			}
			
			map[a][b] = 0;
			map[na][nb] = idx;
			robot[idx].a = na;
			robot[idx].b = nb;
			
		} else if (oper == 'R') {
			iter %= 4;
			for (int i=0; i<iter; i++) {
				robot[idx].dir = (robot[idx].dir + 1) % 4;
			}
		} else {
			iter %= 4;
			for (int i=0; i<iter; i++) {
				robot[idx].dir = (robot[idx].dir + 3) % 4;
			}
		}
		
		return true;
		
	}
	
	static int getDir(char dir) {
		if (dir == 'N')
			return 0;
		else if (dir == 'E')
			return 1;
		else if (dir == 'S')
			return 2;
		else
			return 3;
	}

}
