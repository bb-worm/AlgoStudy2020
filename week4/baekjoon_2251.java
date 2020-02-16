package week4;

import java.io.*;
import java.util.*;

public class baekjoon_2251 {
	
	public static int[] limit = new int[3];
	public static int[] num = new int[201];
	public static HashMap<String, Integer> hm = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<3; i++) {
			limit[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] start = {0, 0, limit[2]};
		findAns(start);
		
		int ans = 0;
		for (int i=0; i<=200; i++) {
			if (num[i] != 0)
				System.out.print(i + " ");
		}
	}
	
	public static void findAns(int[] water) {
		
		// 이미 체크한 조합인지 확인
		String str = "" + water[0] + water[1] + water[2];
		if (hm.containsKey(str)) {
			return;
		} else {
			hm.put(str, 1);
		}
		
		// a가 비었을 때 
		if (water[0] == 0) {
			num[water[2]]++;
		}
		
		for (int i=0; i<3; i++) {
			for (int j=0; j<3; j++) {
				if (i==j)
					continue;
				
				// water[i]를 water[j]에 붓기 
				// 부을 수 있을지와 담을 수 있을지 체크 
				if (water[i]>0 && water[j]<limit[j]) {
					int tmpi = water[i];
					int tmpj = water[j];
					
					int canPour = limit[j] - water[j];
					
					if (canPour >= water[i]) {
						water[j] += water[i];
						water[i] = 0;
						findAns(water);
					} else {
						water[i] -= canPour;
						water[j] = limit[j];
						findAns(water);
					}
					
					water[i] = tmpi;
					water[j] = tmpj;
				}
			}
		}
	}
}
