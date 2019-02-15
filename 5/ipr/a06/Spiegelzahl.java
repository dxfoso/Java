package ipr.a06;

import ipr.util.Terminal;

public class Spiegelzahl {
	
	
	public static int countDigits(int zahl) {
		return (int)(Math.log10(zahl)+1);
	}
	
	public static int countDigitsR(int zahl) {
		return zahl>=1  ?countDigitsR(zahl/10)+1 :0  ;
	}
	
	
	public static int reverse(int zahl) {
		
		int l = countDigits(zahl);
		int res = l%2==1 ? 1 : 0;
		for (int i = 0; i < l / 2; i++) {
			if (getDigit (zahl , i) !=  getDigit(zahl ,l - i - 1)) return res;
			res+=2;
		}
		return res;
	}
	private static int getDigit(int zahl , int index ) {		 
		return (int)  (zahl/ Math.pow(10, index) ) %10;
	}
	public static int reverseR(int zahl) {
		int l = countDigits(zahl);
		if(l==1 || l==0)return l;
		boolean ifEdgePalindrom	=getDigit (zahl , 0) ==  getDigit(zahl ,l - 1);
		if(!ifEdgePalindrom || zahl ==0)return 0;
		//Rekursion <<<<<<<
		return reverseR((int )(zahl % Math.pow(10,  l-1 ) /10 )) +2;
	}

	
	
	public static boolean isPalindrome(int zahl) {
		return reverseR (zahl) == countDigitsR(zahl);
		
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int z = Terminal.readInt("Bitte Zahl eingeben");
		System.out.println(" Zahl z = "+z+" die Anzahl der Ziffern ist "+countDigits(z));
		System.out.println(" Zahl z = "+z+" die Anzahl der Ziffern ist rekursiv bestimmt "+countDigitsR(z));
		System.out.println(" Zahl z = "+z+" Spiegelzahl = "+reverse(z)+ " , "+reverseR(z)+" die Zahl ist Palindrom :"+isPalindrome(z));

		z= 1348431;
		System.out.println(" Zahl z = "+z+" Spiegelzahl = "+reverse(z)+ " , "+reverseR(z)+" die Zahl ist Palindrom :"+isPalindrome(z));

	}

}
