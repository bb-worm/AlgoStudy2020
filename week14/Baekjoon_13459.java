package week14;

import java.io.*;
import java.util.*;

public class Baekjoon_13459 {
	
	static class Status {
		int[] red;
		int[] blue;
		int move;
		
		public Status(int[] red, int[] blue, int move) {
			this.red = new int[2];
			this.blue = new int[2];
			
			for (int i=0; i<2; i++) {
				this.red[i] = red[i];
				this.blue[i] = blue[i];
			}
			this.move = move;
		}
	}
	
	static int N, M;
	static char[][] map;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		int[] red = new int[2]; //red
		int[] blue = new int[2]; //blue
		
		for (int i=0; i<N; i++) {
			map[i] = br.readLine().toCharArray();
			for (int j=0; j<M; j++) {
				if (map[i][j] == 'R') {
					red[0] = i; red[1] = j;
					map[i][j] = '.';
				} else if (map[i][j] == 'B') {
					blue[0] = i; blue[1] = j;
					map[i][j] = '.';
				}
			}
		}
		
		int ans = BFS(red, blue);
		System.out.println(ans);
	}
	
	static int BFS(int[] red, int[] blue) {
		int result = 0;
		
		Queue<Status> q = new LinkedList<>();
		Set<String> visit = new HashSet<>();
		
		q.add(new Status(red, blue, 0));
		visit.add(makeStr(red, blue));
		
		while (!q.isEmpty()) {
			Status s = q.poll();
			
			if (s.move >= 10) {
				q.clear();
				break;
			}
			
			int[] nred = new int[2];
			int[] nblue = new int[2];
			for (int i=0; i<4; i++) {
				
				int[] next = check(s, i);
				
				// hole in blue
				if (next[4] == -1)
					continue;
				// hole in red only
				else if (next[4] == 1) {
					result = 1;
					q.clear();
					break;
				} else {
					
					for (int j=0; j<2; j++) {
						nred[j] = next[j];
						nblue[j] = next[j+2];
					}
					
					String str = makeStr(nred, nblue);
					
					// already visit
					if (visit.contains(str))
						continue;
					
					q.add(new Status(nred, nblue, s.move+1));
					visit.add(str);
				}
			}
		}
		
		return result;
	}
	
	static int[] da = {-1, 1, 0, 0};
	static int[] db = {0, 0, -1, 1};
		
	static int[] check(Status s, int i) {
		
		int[] red = {s.red[0], s.red[1]};
		int[] blue = {s.blue[0], s.blue[1]};
		
		boolean stopRed = false;
		boolean stopBlue = false;
		
		boolean holeRed = false;
		boolean holeBlue = false;
		
		while (!stopRed || !stopBlue) {
			
			// move
			if (!stopRed) {
				red[0] += da[i];
				red[1] += db[i];
				if (stopBlue && red[0]==blue[0] && red[1]==blue[1]) {
					red[0] -= da[i];
					red[1] -= db[i];
					stopRed = true;
				}
			}
			if (!stopBlue) {
				blue[0] += da[i];
				blue[1] += db[i];
				if (stopRed && !holeRed && red[0]==blue[0] && red[1]==blue[1]) {
					blue[0] -= da[i];
					blue[1] -= db[i];
					stopBlue = true;
				}
			}
			
			// move check
			if (!stopRed && map[red[0]][red[1]] == '#') {
				red[0] -= da[i];
				red[1] -= db[i];
				stopRed = true;
				
				if (red[0]==blue[0] && red[1]==blue[1]) {
					blue[0] -= da[i];
					blue[1] -= db[i];
					stopBlue = true;
				}
			}
			if (!stopBlue && map[blue[0]][blue[1]] == '#') {
				blue[0] -= da[i];
				blue[1] -= db[i];
				stopBlue = true;
				
				if (red[0]==blue[0] && red[1]==blue[1]) {
					red[0] -= da[i];
					red[1] -= db[i];
					stopRed = true;
				}
			}
			
			// hole check
			if (!holeRed && map[red[0]][red[1]] == 'O') {
				stopRed = true;
				holeRed = true;
				red[0] = red[1] = -1;
			}
			if (!holeBlue && map[blue[0]][blue[1]] == 'O') {
				stopBlue = true;
				holeBlue = true;
				blue[0] = blue[1] = -1;
			}
			
//			printMap(red, blue);
		}
		
		int[] result = new int[5];
		
		result[0] = red[0];
		result[1] = red[1];
		result[2] = blue[0];
		result[3] = blue[1];
		
		if (holeBlue) {
			result[4] = -1;
		} else if (holeRed) {
			result[4] = 1;
		}
		
		return result;
	}
	
	static String makeStr(int[] red, int[] blue) {
		StringBuilder sb = new StringBuilder();
		sb.append(red[0]).append(red[1]).append(blue[0]).append(blue[1]);
		return sb.toString();
	}
	
	static void printMap(int[] red, int[] blue) {
		for (int i=0; i<N; i++) {
			for (int j=0; j<M; j++) {
				if (i==red[0]&&j==red[1])
					System.out.print('R');
				else if (i==blue[0]&&j==blue[1])
					System.out.print('B');
				else
					System.out.print(map[i][j]);
			}System.out.println();
		}System.out.println();
	}
}
