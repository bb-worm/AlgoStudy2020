package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_11004 {
	
	static int N, K;
	static ArrayList<Integer> al;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()) - 1;
		al = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			al.add(Integer.parseInt(st.nextToken()));
		}
		
		al.sort(null);
		System.out.println(al.get(K));
	}
}
