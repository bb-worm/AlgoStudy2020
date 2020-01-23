import java.io.*;
import java.util.*;

public class baekjoon_1074 {
	
	
	public static int N;
	public static int r, c;
	public static int[][] map = {{0,1}
								,{2,3}};
	
	public static int ans;

 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		findOrigin(r, c, 0);	
		System.out.println(ans);
	}
 	
 	public static void findOrigin(int a, int b, int sum) {
 		if (a<2 && b<2) {
 			ans = sum + map[a][b];
 			return;
 		}
 		
 		int minA, minB;
 		minA = findMin(a);
 		minB = findMin(b);
 		
 		if (minA == minB) {
 			findOrigin(a-minA, b-minB, sum+minA*minA*3);
 		}
 		else if (minA > minB) {
 			findOrigin(a-minA, b, sum+minA*minA*2);
 		}
 		else {
 			findOrigin(a, b-minB, sum+minB*minB);
 		}
 	}
 	
 	public static int findMin(int idx) {
 		int n = (int)Math.pow(2, N);
 		
 		while (n > idx) {
 			n /= 2;
 		}
 		
 		return n;
 	}
 	
 	public static void printAll() {
 		for (int i=0; i<Math.pow(2, N); i++) {
 			for (int j=0; j<Math.pow(2, N); j++) {
 				System.out.printf("%3d ",map[i][j]);
 			}
 			System.out.println();
 		}
 		System.out.println();
 	}

}
