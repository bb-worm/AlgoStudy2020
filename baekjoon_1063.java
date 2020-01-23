import java.io.*;
import java.util.*;

public class baekjoon_1063 {

	public static int[] king = new int[2];
	public static int[] stone = new int[2];

	public static int N;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		char[] Kings = st.nextToken().toCharArray();
		king[0] = 8 - (Kings[1] - '0');
		king[1] = Kings[0] - 'A';

		char[] Stones = st.nextToken().toCharArray();
		stone[0] = 8 - (Stones[1] - '0');
		stone[1] = Stones[0] - 'A';

		N = Integer.parseInt(st.nextToken());


//		printAll();
		for (int i=0; i<N; i++) {
			move(br.readLine());
//			printAll();
		}

		Kings[1] = (char)((8 - king[0]) + '0');
		Kings[0] = (char)(king[1] + 'A');
		Stones[1] = (char)((8 - stone[0]) + '0');
		Stones[0] = (char)(stone[1] + 'A');

		System.out.println(Kings);
		System.out.println(Stones);
	}

	public static void move(String dir) {
		// top
		if (dir.equals("T")) {
			check(0);
		}
		// Bottom
		else if (dir.equals("B")) {
			check(1);
		}
		// Right
		else if (dir.equals("L")) {
			check(2);
		}
		// Left
		else if (dir.equals("R")) {
			check(3);
		}
		// Left Top
		else if (dir.equals("LT")) {
			check(4);
		}
		// Right Top
		else if (dir.equals("RT")) {
			check(5);
		}
		// Left Bottom
		else if (dir.equals("LB")) {
			check(6);
		}
		// Right Bottom
		else if (dir.equals("RB")) {
			check(7);
		}
	}

	// T, B, L, R, LT, RT, LB, RB
	public static int[] da = {-1, 1, 0, 0, -1, -1, 1, 1};
	public static int[] db = {0, 0, -1, 1, -1, 1, -1, 1};

	public static void check(int dir) {
		int ka, kb;
		int sa, sb;
		ka = king[0];
		kb = king[1];
		sa = stone[0];
		sb = stone[1];

		ka += da[dir];
		kb += db[dir];

		if (ka == sa && kb == sb) {
			sa += da[dir];
			sb += db[dir];
		}

		if (ka<0 || ka>=8 || kb<0 || kb>=8 || sa<0 || sa>=8 || sb<0 || sb>=8) {
			return;
		}

		king[0] = ka;
		king[1] = kb;
		stone[0] = sa;
		stone[1] = sb;
	}

	public static void printAll() {
		int ka, kb;
		int sa, sb;
		ka = king[0];
		kb = king[1];
		sa = stone[0];
		sb = stone[1];

		for (int i=0; i<8; i++) {
			for (int j=0; j<8; j++) {
				if (i==ka && j==kb)
					System.out.print('1');
				else if (i==sa && j==sb)
					System.out.print('2');
				else
					System.out.print('0');
			}
			System.out.println();
		}System.out.println();
	}
}
