package ipr.a04;

import java.util.Arrays;

import ipr.util.Terminal;

/**
 * Class to manage sorted arrays.
 */
public class SortedArrays {
	public static void main(String[] ARGV) {

		int t1[] = new int[] { 1, 2, 4, 5, 6, 7 };

		printArray(t1);
		Terminal.println(isSorted(t1));
		Terminal.println(Arrays.toString(insertSorted(t1, 3)));
	}

	public static void printArray(int[] a) {
		Terminal.print("Array:{");
		for (int i = 0; i < a.length; i++) {
			Terminal.print(a[i]);
			if (i < a.length - 1)
				Terminal.print(",");
		}
		Terminal.print("}\n");
	}

	public static Boolean isSorted(int[] a) {
		for (int i = 0; i < a.length - 1; i++)
			if (a[i] > a[i + 1])
				return false;
		return true;
	}

	public static int[] insertSorted(int[] a, int x) {
		int res[] = new int[a.length + 1];
		int pos = find(a, x);
		
		for (int i = 0; i < pos; i++)
			res[i] = a[i];

		res[pos] = x;

		for (int i = pos; i < a.length; i++)
			res[i + 1] = a[i];

		return res;
	}

	private static int find(int[] a, int x) {
		if (x < a[0])
			return 0;
		for (int i = 0; i < a.length - 1; i++)
			if (x >= a[i] && x <= a[i + 1])
				return i + 1;
		return a.length;
	}

}
