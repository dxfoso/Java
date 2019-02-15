package ipr.a04;

import java.util.Arrays;

import ipr.util.Terminal;

/**
 * Class to find multiples of a number in an array.
 */
public class Multiples {
	public static void main(String[] ARGV) {

		int t1[] = new int[] { 1, 2, 3, 4, 5, 6, 7 };
		int n1 = 2;
		int t2[] = new int[] { 6, 99, 4, 4, 5, 6, 9 };
		int n2 = 3;
		int t3[] = new int[] { 44, 99, 4, 4, 4444, 6, 9 };
		int n3 = 4;

		Terminal.println("countMultiples " + n1 + " " + Arrays.toString(t1) + " : " + countMultiples(t1, n1));
		Terminal.println("countMultiples " + n2 + " " + Arrays.toString(t2) + " : " + countMultiples(t2, n2));
		Terminal.println("countMultiples " + n3 + " " + Arrays.toString(t3) + " : " + countMultiples(t3, n3));

		Terminal.println(
				"getMultiples " + n1 + " " + Arrays.toString(t1) + " : " + Arrays.toString(getMultiples(t1, n1)));
		Terminal.println(
				"getMultiples " + n2 + " " + Arrays.toString(t2) + " : " + Arrays.toString(getMultiples(t2, n2)));
		Terminal.println(
				"getMultiples " + n3 + " " + Arrays.toString(t3) + " : " + Arrays.toString(getMultiples(t3, n3)));

		Terminal.println("successiveMultiples " + n1 + " " + Arrays.toString(t1) + " : " + successiveMultiples(t1, n1));
		Terminal.println("successiveMultiples " + n2 + " " + Arrays.toString(t2) + " : " + successiveMultiples(t2, n2));
		Terminal.println("successiveMultiples " + n3 + " " + Arrays.toString(t3) + " : " + successiveMultiples(t3, n3));

	}

	public static int countMultiples(int[] a, int n) {
		int res = 0;
		for (int i = 0; i < a.length; i++)
			res += a[i] % n == 0 ? 1 : 0;
		return res;
	}

	public static int[] getMultiples(int[] a, int n) {
		int res[] = new int[countMultiples(a, n)];
		int j = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] % n == 0) {
				res[j] = a[i];
				j++;
			}
		}
		return res;
	}

	public static int successiveMultiples(int[] a, int n) {
		int res = 0;
		int cur = 0;
		for (int i = 0; i < a.length; i++) {

			if (a[i] % n == 0) {
				cur++;
				res = Math.max(res, cur);
			} else
				cur = 0;

		}
		return res;
	}
}
