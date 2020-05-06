package week13;

import java.util.*;
import java.math.BigInteger;

public class Baekjoon_9659 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		BigInteger N = new BigInteger(sc.next());
		BigInteger two = new BigInteger("2");
		
		if (N.mod(two).equals(BigInteger.ZERO)) {
			System.out.println("CY");
		} else {
			System.out.println("SK");
		}
	}
}
