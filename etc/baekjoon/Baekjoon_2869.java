package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A, B, V;
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		int ans = (V-A) / (A-B);
		if ((V-A) % (A-B) != 0)
			ans++;
		ans++;
		
		System.out.println(ans);

	}

}
