package etc.baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon_14681 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int y = Integer.parseInt(br.readLine());
		
		int ans;
		if (x>0) {
			if (y>0)
				ans = 1;
			else
				ans = 4;
		} else {
			if (y>0)
				ans = 2;
			else
				ans = 3;
		}
		System.out.println(ans);
	}

}
