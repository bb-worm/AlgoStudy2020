package week3;

import java.io.*;
import java.util.*;

public class beakjoon_1941 {
	
	public static char[][] map;
	public static int[][] visit;
	public static int[][] isUsed;
	public static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		map = new char[5][5];
		visit = new int[5][5];
		isUsed = new int[5][5];
		
		for (int i=0; i<5; i++) {
			char[] arr = br.readLine().toCharArray();
			for (int j=0; j<5; j++) {
				map[i][j] = arr[j];
			}
		}
		
		ans = 0;
		isUsed[0][0] = 1;
		pick(0, 0, 1);
		isUsed[0][0] = 0;
		pick(0, 0, 0);
		System.out.println(ans);
	}
	
	public static void pick(int a, int b, int now) {
		if (now >= 7) {
			if (checkRange()) {
//				printUse();
				ans++;
			}
			return;
		}
		
		int na = a, nb = b+1;
		if (nb >= 5) {
			na++;
			nb = 0;
			
			if (na >= 5) {
				return;
			}
		}
		
		isUsed[na][nb] = 1;
		pick(na, nb, now+1);
		isUsed[na][nb] = 0;
		pick(na, nb, now);
	}
	
	public static int[] da = {-1, 1, 0, 0};
	public static int[] db = {0, 0, -1, 1};
	
	public static boolean checkRange() {
		int sSum = 0;
		
		int a=0, b=0;
		for (int i=0; i<5; i++) {
			for (int j=0 ;j<5; j++) {
				if (isUsed[i][j] == 1) {
					if (map[i][j] == 'S')
						sSum++;
					a=i; b=j;
				}
			}
		}
		if (sSum < 4) {
			return false;
		}
		
		if (!BFS(a, b)) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean BFS(int i, int j) {
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(i); q.add(j);
		visit[i][j] = 1;
		
		int a, b;
		while (!q.isEmpty()) {
			a = q.poll(); b = q.poll();
			
			int na, nb;
			for (int k=0; k<4; k++) {
				na = a + da[k];
				nb = b + db[k];
				
				if (na<0||na>=5||nb<0||nb>=5)
					continue;
				if (visit[na][nb]!=0)
					continue;
				if (isUsed[na][nb]!=1)
					continue;
				
				q.add(na); q.add(nb);
				visit[na][nb] = 1;
			}
		}
		
		int sum = 0;
		for (int y=0; y<5; y++) {
			for (int x=0; x<5; x++) {
				if (visit[y][x] == 1) {
					sum++;
					visit[y][x] = 0;
				}
			}
		}
		if (sum >= 7) {
			return true;
		} else {
			return false;
		}
	}
	
	public static void printUse() {
		for (int i=0; i<5; i++) {
			for (int j=0; j<5;j++) {
				System.out.print(isUsed[i][j]);
			} System.out.println();
		}System.out.println();
	}
	
}
