package ipr.a03;

import ipr.util.Terminal;

/**
 * Program for finding prime numbers and factorizing the others.
 */
public class Primes {
	public static void main(String[] ARGV) {

		 
		Terminal.print("Bitte geb eine nummer :");
		int input = Terminal.readInt();
		
		if(isPrime(input))
			Terminal.println(input + " is eine Prime Zahl");
		else 
			Terminal.println
			(input + " is keine Prime Zahl\nPrimfaktorzerlegung : " + primeFactorization(input));
		
	}

	public static boolean isPrime(int input) {

		boolean isPrime = true;
		for (int div = 2; div <= input / 2; div++) {
			if (input % div == 0) {
				isPrime = false;
				break;
			}
		}

		return isPrime;
	}

	public static String primeFactorization(int input) {
		String res =input + " = 1";
		
	while(input>1 ) {
		int t = ErstePrime(input);
		res+= " * " +  t;
		input /=t;
	}

		return res;		
	}

	private static int ErstePrime(int input) {
		for (int i = 2; i <= input; i++) {
			if (input % i == 0)
				if (isPrime(i))
					return i;
		}
		return 1;
	}

}
