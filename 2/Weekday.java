package ipr.a03;

import ipr.util.PerpetualCalendar;
import ipr.util.Terminal;

/**
 * Program to determine the day of the week for a given date.
 */
public class Weekday {
	public static void main(String[] ARGV) {

		Terminal.print("Bitte geb Jahr [1582 4000] :");
		int y = Terminal.readInt();
		Terminal.print("Bitte geb Monat [1 12]:");
		int m = Terminal.readInt();
		Terminal.print("Bitte geb Tag [1 31]:");
		int d = Terminal.readInt();

		boolean c = check(y , m ,d );
	    Terminal.println( "Datum ist" + (c ? " gichtig" : " nicht gichtig"));
		
	    if(!c)return ;
		
		Terminal.println("Weekday:" + PerpetualCalendar.getWeekday( d ,m, y));
		Terminal.println( y + (isLeapYear(y) ? " : ist ein Schaltjahre" : " : ist kein Schaltjahre"));
		
		Terminal.println(get_month_length (y,m )) ;
		
	}
	

	private static boolean check(int y, int m, int d) {
		if (y < 1582 || y > 4000)
			return false;
		if (m < 1 || m > 12)
			return false;
		if (d < 1 || d > get_month_length(y, m))
			return false;
		return true;

	}

	public static boolean isLeapYear(int year) {
		return ((year % 4) == 0) && (!(((year % 100) == 0) && ((year % 400) != 0)));
	}

	public static int get_month_length(int GregorianYear, int GregorianMonth) {
		int M, Y;
		double jd = GregorianToJulian(GregorianYear, GregorianMonth, 1); // jd of first day of the month
		if (GregorianMonth > 12) {
			M = 1;
			Y = GregorianYear + 1;
		} else {
			M = GregorianMonth + 1;
			Y = GregorianYear;
		}
		double jdNextMonth = GregorianToJulian(Y, M, 1); // jd of first day of next the month
		return (int) (jdNextMonth - jd);
	}

	private static double GREGORIAN_EPOCH = 1721425.5;

	private static double GregorianToJulian(int Year, int Month, int Day) {
		// start check the value
		return (GREGORIAN_EPOCH - 1) + (365 * (Year - 1)) + Math.floor((Year - 1) / 4) + (-Math.floor((Year - 1) / 100))
				+ Math.floor((Year - 1) / 400)
				+ Math.floor((((367 * Month) - 362) / 12) + ((Month <= 2) ? 0 : (isLeapYear(Year) ? -1 : -2)) + Day);
	}
}
