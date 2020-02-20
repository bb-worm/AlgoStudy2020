package week5_6;

import java.io.*;
import java.util.*;

public class baekjoon_5427 {
	
	public static char[][] map;
	public static int[][] fire;
	
	public static int h, w;
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		Queue<Integer> fireQ = new LinkedList<>();
		Queue<Integer> humanQ = new LinkedList<>();
		
		int T = Integer.parseInt(br.readLine());
		for (int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new char[h][w];
			fire = new int[h][w];
			
			for (int i=0; i<h; i++) {
				map[i] = br.readLine().toCharArray();
				for (int j=0; j<w; j++) {
					if (map[i][j] == '@') {
						humanQ.add(i); humanQ.add(j);
						fire[i][j] = 1;
					} else if (map[i][j] == '*') {
						fireQ.add(i); fireQ.add(j);
						fire[i][j] = 1;
					} else {
						fire[i][j] = Integer.MAX_VALUE;
					}
				}
			}
			
			int canExit = 0;
			int a, b;
			
			while (!fireQ.isEmpty() || !humanQ.isEmpty()) {
				
				// fire
				int size = fireQ.size()/2;
				for (int i=0; i<size; i++) {
					a = fireQ.poll(); b = fireQ.poll();
					
					int na, nb;
					for (int k=0; k<4; k++) {
						na = a + da[k];
						nb = b + db[k];
						
						if (na<0||na>=h||nb<0||nb>=w)
							continue;
						if (map[na][nb] == '#')
							continue;
						
						if (fire[na][nb] > fire[a][b]+1) {
							fireQ.add(na); fireQ.add(nb);
							fire[na][nb] = fire[a][b] + 1;
						}
					}
				}
				
				int canGo = 0;
				
				// human
				size = humanQ.size()/2;
				for (int i=0; i<size; i++) {
					a = humanQ.poll(); b = humanQ.poll();
					
					int na, nb;
					for (int k=0; k<4; k++) {
						na = a + da[k];
						nb = b + db[k];
						
						// exit
						if (na<0||na>=h||nb<0||nb>=w) {
							canExit = fire[a][b];
							fireQ.clear();
							humanQ.clear();
							break;
						}
						
						if (map[na][nb] == '#')
							continue;
						
						if (fire[na][nb] > fire[a][b]+1) {
							humanQ.add(na); humanQ.add(nb);
							fire[na][nb] = fire[a][b] + 1;
							canGo = 1;
						}
					}
					if (canExit != 0);
				}
				// don't exit
				if (canGo == 0) {
					fireQ.clear();
					humanQ.clear();
					break;
				}
			}
			if (canExit == 0) {
				System.out.println("IMPOSSIBLE");
			} else {
				System.out.println(canExit);
			}
			
		}
	}
	
	public static void printFire() {
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				if (fire[i][j] == Integer.MAX_VALUE) {
					System.out.print(0 + " ");
				} else {
					System.out.print(fire[i][j] + " ");
				}
			}System.out.println();
		}System.out.println();
	}

}
