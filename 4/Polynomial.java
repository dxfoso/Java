package ipr.a05;

import ipr.util.Terminal;

/**
 * Der Vorgefertigter Programmrahmen zu Aufgabe 3 der Hausaufgabenserie 5
 * 
 * @author you
 * 
 */

public class Polynomial {
	
     /**
	 * Aufgabe a) Implementieren Sie in dieser Methode die formschöne Ausgabe
	 * eines Polynoms nach dem Format:
	 * <p>
	 * <code>a_n * x^n + a_(n-1) * x^(n-1) + ... + a_1 * x + a_0</code>
	 * </p>
	 * 
	 * <p>
	 * Z.B. <code>3 * x^2 + 4 * x - 3</code>
	 * </p>
	 * 
	 * @param polynomial
	 *            Koeffizienten eines Polynomes
	 */
	public static void printPolynomial(int[] polynomial) {
		String res = "f(x) =";
		int l = polynomial.length;
		boolean isFirst = true ;
		for (int i = 0; i < l; i++) {
			if (polynomial[i] == 0)
				continue;
			
			
			int p = l-i-1;//Polynomgrad
			res += polynomial[i] >0 && !isFirst ? " +" : "";
			res += polynomial[i] ==-1 && p >0 ? " -" : "";
			res += Math.abs(polynomial[i]) != 1 || p ==0 ? polynomial[i] : "";
			res += Math.abs(polynomial[i]) != 1 && p > 0 ? "*" : "";
			res += p > 0 ? "x" : "";
			res += p > 1 ? "^" + (p) : "";
			isFirst = false;
		}
		Terminal.println(res);
	}
	
	
	/**
	 * Aufgabe b) Implementieren Sie in dieser Methode die Berechnung eines
	 * Polynoms an der Stelle x<code>x</code>.
	 * 
	 * @param polynomial
	 *            Koeffizienten des Polynomes
	 * @param x
	 *            Stelle, an der das Polynom ausgewertet werden soll
	 * @return Funktionswert des Polynoms
	 */
	public static double evaluate(int[] polynomial, double x) {
		double erg=0.0;
		int l = polynomial.length;
			 for (int i = 0; i < l; i++)
				erg += 	polynomial[i] * Math.pow(x, l-i) ; 
		return erg;	// Ergebnis zurückgeben
	}
	
	
	
	public static void main(String[] args) {
		int n;
		int[] p;
		int[] p1 = {3, 4, -3}; // Beispiel vom Aufgabenblatt 3*x^2 + 4x -3
		double unten, oben, schrittweite, x;
		
		printPolynomial(p1);
	
		unten = -2.0;
		oben = 2.0;
		schrittweite = 0.25;
		for(x=unten; x <=oben; x=x + schrittweite)
			System.out.println("  x= "+x+" f(x) ="+evaluate(p1,x));
	
		// variable Eingabe von Polynomen
		n= Terminal.readInt("Bitte den Polynomgrad eingeben");
		while(n > 0) {
			p= new int[n+1];
			for(int i=0; i<=n; i++){
				p[i]=Terminal.readInt("Bitte Koeffizienten fuer x hoch "+(n-i)+" eingeben");
			}
		printPolynomial(p);
		}
	}

}




