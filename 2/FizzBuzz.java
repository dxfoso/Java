package ipr.a03;

import ipr.util.Terminal;

/**
 * Program for printing the FizzBuzz sequence.
 */
public class FizzBuzz {
	public static void main(String[] ARGV) {
		
		for(int i=1;i<=100;i++) {
			
			if(i%3==0 && i%5 == 0)
				Terminal.println("FizzBuzz");
			else if(i%3==0)
				Terminal.println("Fizz");
			else if(i%5 == 0)
				Terminal.println("Buzz");
			else Terminal.println(i);
			
		}
	
	}
}

