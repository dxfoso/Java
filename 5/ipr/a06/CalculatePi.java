package ipr.a06;

public class CalculatePi {

	public static double piUsingLeibniz(int anz) {

		double res = 0;
		double i = 0;
		do {
			res += Math.pow(-1, i) / (2 * i + 1);
			i++;
		} while (i <= anz);
		return res*4;
	}

	public static double piUsingWallis(int anz) {
		double res = 1;

		for(int i=1;i<=anz;i++) 
			res *= Math.pow(2 * i, 2) / ((2 * i - 1) * (2 * i + 1));
		
		return res*2;
	}

	public static double piUsingMonteCarlo(int anz) {

		double insideCount = 0;
		for (int i = 0; i < anz; i++) {
			double x = random(-1, 1);
			double y = random(-1, 1);
			double dist = x * x + y * y;
			insideCount += dist <= 1 ? 1 : 0;
		}
		return insideCount* 4/ anz;
	}

	private static double random(int min, int max) {
		int range = (max - min)  ;
		return (Math.random() * range) + min;
	}

	public static void main(String[] args) {
		// testen der Methoden
		for (int i = 100; i < 1000000000; i *= 10) {
			System.out.print(i + " ");
			System.out.print(piUsingLeibniz(i) + " ");
			System.out.print(piUsingWallis(i) + " ");
			System.out.println(piUsingMonteCarlo(i) + " ");
		}
		
		//Hineweise
		//      Schneller --->>   Mitte             -->  Langsame                          
		//   piUsingWallis      piUsingMonteCarlo  --   piUsingLeibniz 
	}

}
