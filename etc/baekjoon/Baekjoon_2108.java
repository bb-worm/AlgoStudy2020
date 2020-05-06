package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2108 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		
		int[] range = new int[8001];
		
		int sum = 0;
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		ArrayList<Integer> al = new ArrayList<>();
		for (int i=0; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			al.add(num);
			range[num+4000]++;
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		al.sort(null);
		
		System.out.println(Math.round((float)sum/N));
		System.out.println(al.get(N/2));
		
		int isSecond = 0;
		int mostIdx = 0;
		int mostVal = 0;
		for (int i=0; i<=8000; i++) {
			if (range[i] > mostVal) {
				mostIdx = i;
				mostVal = range[i];
				isSecond = 0;
			} else if (range[i] == mostVal && isSecond == 0) {
				isSecond = 1;
				mostIdx = i;
			}
		}
		System.out.println(mostIdx - 4000);
		System.out.println(max - min);
	}

}
