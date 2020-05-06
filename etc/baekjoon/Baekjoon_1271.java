package etc.baekjoon;

import java.io.*;
import java.util.*;
import java.math.BigDecimal;

public class Baekjoon_1271 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());;
		
		BigDecimal n1 = new BigDecimal(st.nextToken());
		BigDecimal n2 = new BigDecimal(st.nextToken());
		
		System.out.println((n1.divide(n2, 1)));
		System.out.println(n1.remainder(n2));
	}
}
