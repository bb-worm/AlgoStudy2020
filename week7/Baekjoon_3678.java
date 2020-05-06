package week7;

import java.io.*;
import java.util.*;

public class Baekjoon_3678{
	
	static int[] inputArr;
	static int maxN;
	///////////////////////
	
	static int[][] map;
	static int sa, sb;
	static int dir;
	
	static int[] useNum = new int[6];
	static int[] ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		maxN = 0;
		int T = Integer.parseInt(br.readLine());
		inputArr = new int[T];
		for (int t=0; t<T; t++) {
			inputArr[t] = Integer.parseInt(br.readLine());	// 일단 저장 
			maxN = Math.max(maxN, inputArr[t]);
		}
		/////////////////////////////////////
		
		map = new int[300][300];
		sa = sb = 150;
		dir = 0;
		
		ans = new int[maxN+1];
		
		map[sa][sb] = 1;
		ans[1] = 1;
		useNum[1]++;
		for (int i=2; i<=maxN; i++) {
			findAns(sa, sb, i);
		}
		for (int i=0; i<inputArr.length; i++) {
			System.out.println(ans[inputArr[i]]);
		}
//		print();
//		printMap();
	}
	
	static int[][] da = {{-1, -1, 1, 1}, 
						{1, -2, -1, 2}, 
						{1, -1, -1, 1}};
	static int[][] db = {{1, -1, -1, 1}, 
						{1, 0, -1, 0}, 
						{1, 1, -1, -1}};
	
	static int[] ra = {-2, -1, 1, 2, 1, -1};
	static int[] rb = {0, -1, -1, 0, 1, 1};
	
	static void findAns(int a, int b, int idx) {
		int na, nb;
		
		// 어디로 갈지 선택 
		int t=0;
		do {
			na = a + da[t][dir];
			nb = b + db[t][dir];
			t++;
		} while (map[na][nb] != 0);
		
		if (t==1) {
			dir = (dir+1)%4;
		}
		
		// 값 선택 
		ArrayList<Integer> al = new ArrayList<>();
		for (int i=1; i<=5; i++)
			al.add(i);
		
		for (int i=0; i<6; i++) {
			al.remove(new Integer(map[na+ra[i]][nb+rb[i]]));
		}
		
		al.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return useNum[o1] - useNum[o2];
			}
		});
		
		int n = al.get(0);
		useNum[n]++;
		ans[idx] = n;
		map[na][nb] = n;
		sa = na; sb = nb;
	}
	
	static void print() {
		for (int i=1; i<=14; i++) {
			System.out.print(ans[i]+ " ");
		}System.out.println();
	}
	
	static void printMap() {
		for (int i=140; i<160; i++) {
			for (int j=140; j<160; j++) {
				if (i==150 && j==150)
					System.out.print('*' + " ");
				else
					System.out.print(map[i][j] + " ");
			}System.out.println();
		}System.out.println();
	}
}
