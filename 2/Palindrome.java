package ipr.a03;

import ipr.util.Terminal;

/**
 * Program for determining whether a string is a palindrome.
 */
public class Palindrome {
	public static void main(String[] ARGV) {

		
		Terminal.print("Bitte geb ein Wort :");
		String input = Terminal.readString();
		int l = input.length();
		boolean succ = true;

		for (int i = 0; i < l / 2; i++) {
			if (input.charAt(i) != input.charAt(l - i - 1)) {
				succ = false;
				break;
			}
		}

		Terminal.println("Das wort '" + input);
		if (succ)
			Terminal.println("'ist Palindrome");
		else
			Terminal.println("'ist nicht Palindrome");

	}
}
