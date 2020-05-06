package week10;

import java.io.*;
import java.util.*;

public class Baekjoon_1092 {
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] crane = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			crane[i] = Integer.parseInt(st.nextToken());
		}
		
		int M = Integer.parseInt(br.readLine());
		ArrayList<Integer> box = new ArrayList<>(M);
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<M; i++){
			box.add(Integer.parseInt(st.nextToken()));
		}
		
		for (int i : box) {
			int canMove = 0;
			for (int j : crane) {
				if (i <= j) {
					canMove = 1;
					break;
				}
			}
			if (canMove == 0) {
				System.out.println(-1);
				return;
			}
		}
		Arrays.sort(crane);
		box.sort(null);
		
		int time = 0;
		int move = 0;
		while (move < M) {
			
			for (int i=N-1; i>=0; i--) {
				int now = crane[i];
				
				int find = BS(0, box.size(), now, box);
				if (find >= 0) {
					box.remove(find);
					move++;
				}
			}
			time++;
		}
		System.out.println(time);
	}
	
	static int BS(int start, int end, int goal, ArrayList<Integer> box) {
		
		if (start >= end)
			return -1;
		
		int mid = (start + end) / 2;
		
		if (box.get(mid) <= goal) {
			int next = BS(mid+1, end, goal, box);
			
			if (next >= 0)
				return next;
			else
				return mid;
		} else {
			return BS(start, mid, goal, box);
		}
	}
}
