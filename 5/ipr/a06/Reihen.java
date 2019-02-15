package ipr.a06;

public class Reihen {

	public static double func1(double eps) {

		double res = 0, x;
		double n = 2;

		do {
			x = (2 * n + 1) / ((n * n) * (n + 1) * (n + 1));
			res += x >= eps ? x : 0;
			n++;
		} while (x >= eps);

		return res;
	}

	public static double ln(double x) {
		// if( x <0 ) throw new IllegalArgumentException ("x soll nicht Negative sein// !");
		double res = 0, y;
		double n = 1;
		do {
			y = Math.pow(-1, n + 1) * Math.pow(x - 1, n) / n;
			res += y >= 0.0001 ? y : 0;
			n++;
		} while (y >= 0.0001);

		return res;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (double e = 0.1; e >= 0.000001; e /= 10) {
			System.out.print(" eps = " + e + " : ");
			System.out.print(func1(e) + " ");
		}
		// Tests fuer Teilaufgabe b)
		System.out.println("\nTeil B");
		for (double i = -1; i <= 3; i = i + 0.2)
			System.out.println("ln(" + i + ") = " + ln(i));
		// Hinweise *********************
		// fur Log ( Negative ) gibt es keine werte , die Richtige Losung ist beim Implementieren die folgende Code in die Funktion
		// if( x <0 ) throw new IllegalArgumentException ("x soll nicht Negative sein// !");
	}
}
