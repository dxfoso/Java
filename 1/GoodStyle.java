//package ipr.a02;

public class GoodStyle {
	public static double Calc(double Zahl) {
		double RESULT = 1;
		double _N = Zahl;
		while (_N >= 1) {
			RESULT = RESULT * _N;
			_N -= 1;
		}
		return RESULT;
	}
	public static void main(String[] ARGV) {
		int Number   ;

		if (ARGV.length == 1) {
			try {
				Number = Integer.parseInt(ARGV[0]);
				System.out.println("Result is " + Calc(Number));
			} catch (NumberFormatException e) {
				System.err.println("Number " + ARGV[0] + " invalid (" + e.getMessage() + ").");
			}
		} else {
			System.err.println("usage: GoodStyle number");
		}
	}
}
