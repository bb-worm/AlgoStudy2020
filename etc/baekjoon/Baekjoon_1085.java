package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_1085 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x, y;
		int w, h;
		
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		
		int min = Math.min(x, y);
		
		min = Math.min(min, w-x);
		min = Math.min(min, h-y);
		
		System.out.println(min);
	}

}
