package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_4153 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int[] num = new int[3];
		while (true) {
			st = new StringTokenizer(br.readLine());
			num[0] = Integer.parseInt(st.nextToken());
			num[1] = Integer.parseInt(st.nextToken());
			num[2] = Integer.parseInt(st.nextToken());
			
			if (num[0]+num[1]+num[2] == 0)
				break;
			
			Arrays.sort(num);
			
			if (Math.pow(num[0], 2) + Math.pow(num[1], 2) == Math.pow(num[2], 2))
				sb.append("right");
			else
				sb.append("wrong");
			sb.append('\n');
			
		}
		System.out.println(sb);

	}

}
