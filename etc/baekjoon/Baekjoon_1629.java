package etc.baekjoon;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Baekjoon_1629 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		BigInteger A = new BigInteger(st.nextToken());
		BigInteger B = new BigInteger(st.nextToken());
		BigInteger C = new BigInteger(st.nextToken());
//		A = A.modPow(B, C);
		System.out.println(A.modPow(B, C));
	}
}
