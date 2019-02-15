package ipr.a04;

import java.util.Arrays;

import ipr.util.Terminal;

/**
 * Class to check whether two strings are anagrams.
 */
public class Anagrams {
	// Please implement me!
	public static void main(String[] ARGV) {

		Terminal.println(letterNumber('a'));

		Terminal.println(Arrays.toString(charHistogram("aaaAoreghrg,?y345")));

		String s1 = "Ampel";
		String s2 = "Lampe";
		String s3 = "Lamped";
		Terminal.println(s1 + " " + s2 + " : " + isAnagram(s1, s2));
		Terminal.println(s3 + " " + s2 + " : " + isAnagram(s3, s2));

	}

	public static int letterNumber(char c) {
		int res = c;
		if (res >= 65 && res <= 90)
			return res - 65;
		if (res >= 97 && res <= 122)
			return res - 97;
		return -1;
	}

	public static int[] charHistogram(String s) {
		int res[] = new int[26];

		for (int i = 0; i < s.length(); i++)
			res[i] = 0;

		for (int i = 0; i < s.length(); i++) {
			int n = letterNumber(s.charAt(i));
			if (n == -1)
				continue;
			res[n]++;
		}

		return res;
	}

	public static Boolean isAnagram(String s1, String s2) {

		int h1[] = charHistogram(s1);
		int h2[] = charHistogram(s2);

		for (int i = 0; i < h1.length; i++)
			if (h1[i] != h2[i])
				return false;
		return true;
	}
}
