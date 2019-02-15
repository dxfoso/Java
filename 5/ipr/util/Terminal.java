package ipr.util;

import java.io.*;

/**
 * This class contains static helper methods for input/output.
 * You may use provided public methods via <code>import static</code>.  
 * @author parzy
 *
 */
public class Terminal {

	// output -------------------------------------------------------------
	// --------------------------------------------------------------------
	
	/**
	 * Prints an arbitrary object on standard out.
	 * @param o object to print on standard out
	 */
	public static void print(Object o) {
		System.out.print(o);
	}
	
	/**
	 * Prints an arbitrary object on standard out followed by a line break.
	 * @param o object to print on standard out
	 */
	public static void println(Object o) {
		System.out.println(o);
	}
	
	/**
	 * Prints a line break on standard out.
	 */
	public static void println() {
		System.out.println();
	}

	
	// input --------------------------------------------------------------
	// --------------------------------------------------------------------
	
	/**
	 * Reads a line from standard input.
	 * @return the line read
	 */
	public static String readString() {
		return readString(null);
	}
	
	/**
	 * Asks the user for input printing the string prompt on standard 
	 * output.  Afterwards, reads a line from standard input.
	 * @param prompt prompt to print on standard output
	 * @return the line read
	 */
	public static String readString(String prompt) {
		prompt(prompt);
		return readLine();
	}
	
	/**
	 * Reads an integer value from standard input.  Repeats if provided 
	 * input cannot be converted to an integer value.
	 * @return the integer value entered by the user
	 */
	public static int readInt() {
		return readInt(null);
	}
	
	/**
	 * Asks the user for input printing the string prompt on standard 
	 * output.  Afterwards, reads an integer value from standard input.  
	 * Repeats if provided input cannot be converted to an integer value.
	 * @param prompt prompt to print on standard output
	 * @return the integer value entered by the user
	 */
	public static int readInt(String prompt) {
		for (;;) {
			try {
				prompt(prompt);		
				return Integer.parseInt(readLine().trim());
			} catch(Exception e) {
				System.err.println(e);
			}
		}
	}
	
	/**
	 * Reads a long value from standard input.  Repeats if provided 
	 * input cannot be converted to a long value.
	 * @return the long value entered by the user
	 */
	public static long readLong() {
		return readLong(null);
	}
	
	/**
	 * Asks the user for input printing the string prompt on standard 
	 * output.  Afterwards, reads a long value from standard input.  
	 * Repeats if provided input cannot be converted to a long value.
	 * @param prompt prompt to print on standard output
	 * @return the long value entered by the user
	 */
	public static long readLong(String prompt) {
		for (;;) {
			try {
				prompt(prompt);		
				return Long.parseLong(readLine().trim());
			} catch(Exception e) {
				System.err.println(e);
			}
		}
	}
	
	/**
	 * Reads a float value from standard input.  Repeats if provided 
	 * input cannot be converted to a float value.
	 * @return the float value entered by the user
	 */
	public static float readFloat() {
		return readFloat(null);
	}
	
	/**
	 * Asks the user for input printing the string prompt on standard 
	 * output.  Afterwards, reads a float value from standard input.  
	 * Repeats if provided input cannot be converted to a float value.
	 * @param prompt prompt to print on standard output
	 * @return the float value entered by the user
	 */
	public static float readFloat(String prompt) {
		for (;;) {
			try {
				prompt(prompt);		
				return Float.parseFloat(readLine().trim());
			} catch(Exception e) {
				System.err.println(e);
			}
		}
	}
	
	/**
	 * Reads a double value from standard input.  Repeats if provided 
	 * input cannot be converted to a double.
	 * @return the float value entered by the user
	 */
	public static double readDouble() {
		return readDouble(null);
	}
	
	/**
	 * Asks the user for input printing the string prompt on standard 
	 * output.  Afterwards, reads a double value from standard input.  
	 * Repeats if provided input cannot be converted to a double value.
	 * @param prompt prompt to print on standard output
	 * @return the double value entered by the user
	 */
	public static double readDouble(String prompt) {
		for (;;) {
			try {
				prompt(prompt);		
				return Double.parseDouble(readLine().trim());
			} catch(Exception e) {
				System.err.println(e);
			}
		}
	}

	/**
	 * Reads a boolean value from standard input.  Repeats if provided 
	 * input cannot be converted to a boolean.  Accepted input strings are
	 * true, t, wahr, w, yes, y, ja, j, on, an, 1 for <code>true</code> and
	 * false, f, falsch, no, n, nein, off, aus, 0 for <code>false</code> 
	 * regardless of case.
	 * @return the integer value entered by the user
	 */

	public static boolean readBoolean() {
		return readBoolean(null);
	}
	
	/**
	 * Asks the user for input printing the string prompt on standard 
	 * output.  Afterwards, reads a boolean value from standard input.  
	 * Repeats if provided input cannot be converted to a boolean value.
	 * Accepted input strings are true, t, wahr, w, yes, y, ja, j, on, an, 
	 * 1 for <code>true</code> and false, f, falsch, no, n, nein, off, aus,
	 * 0 for <code>false</code> regardless of case.
	 * @param prompt prompt to print on standard output
	 * @return the integer value entered by the user
	 */
	public static boolean readBoolean(String prompt) {
		for (;;) {
			try {
				prompt(prompt);		
				return parseBoolean(readLine().trim());
			} catch(Exception e) {
				System.err.println(e);
			}
		}
	}
	
	/**
	 * Strings encoding a <code>true</code> value.
	 */
	private static String positive[] = {"true", "t", "wahr", "w",
		                                "yes", "y", "ja", "j",
		                                "on", "an", "1"};
	/**
	 * Strings encoding a <code>false</code> value.
	 */
	private static String negative[] = {"false", "f", "falsch",
		                                "no", "n", "nein",
		                                "off", "aus", "0"};
	private static boolean parseBoolean(String s) {
		for (String t: positive) {
			if (t.equalsIgnoreCase(s)) return true;
		}
		for (String t: negative) {
			if (t.equalsIgnoreCase(s)) return false;
		}
		throw new NumberFormatException("For input string: \""+s+'"');
	}
	
	/**
	 * Singleton reader for input on standard in.
	 */
	private static BufferedReader in = null;
	/**
	 * Reads a line from standard in. Exits to system if reader on standard 
	 * in cannot be initialized or throws unexpexted exceptions.
	 * @return the line read
	 */
	private static String readLine() {
		try {
			if (in==null) {
				in = new BufferedReader(new InputStreamReader(System.in));
			}
			String line = null;
			while ( (line=in.readLine()) == null );
			return line;
		} catch (IOException e) {
			System.err.println("ipr.util.Terminal: system exit caused by fatal exception");
			e.printStackTrace();
			System.exit(-1);
			return null;
		}
	}
	
	/**
	 * Prints a prompt on standard out if the given string is not null.
	 * @param prompt the prompt to print
	 */
	private static void prompt(String prompt) {
		if (prompt != null) {
			System.out.print(prompt);
		}
	}
}