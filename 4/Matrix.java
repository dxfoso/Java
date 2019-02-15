package ipr.a05;

import ipr.util.Terminal;

/**
 * Der Vorgefertigter Programmrahmen zu Aufgabe 2 der Hausaufgabenserie 5
 * 
 * @author you
 * 
 */
public class Matrix {



	public static boolean isRectangular(double[][] array) {
		if (array == null)
			return false;
		if (array.length == 0)
			return false;
		if (array[0].length == 0)
			return false;

		for (int i = 0; i < array.length; i++) {
			if (array[i] == null)
				return false;
			if (array[0].length != array[i].length)
				return false;
		}

		return true;
	}


	public static double[][] transpose(double[][] matrix) {
		if (!isRectangular(matrix))
			return null;

		double[][] res = new double[matrix[0].length][matrix.length];

		for (int y = 0; y < matrix.length; y++)
			for (int x = 0; x < matrix[0].length; x++)
				res[x][y] = matrix[y][x];

		return res;
	}



	public static int maxRowSum(double[][] matrix) {
		if (!isRectangular(matrix))
			return -1;

		double max = 0;
		int rowIndex = 0;
		for (int y = 0; y < matrix.length; y++) {
			int t = 0;

			for (int x = 0; x < matrix[0].length; x++)
				t += matrix[y][x];
			if (max < t || y == 0) {
				max = t;
				rowIndex = y;
			}
		}
		return rowIndex + 1;
	}

	
	public static void printMatrix(double[][] matrix) {
		if (matrix != null) {
			System.out.print("[");
			for (int i = 0; i < matrix.length; i++) {
				System.out.print("[ ");
				for (int j = 0; j < matrix[i].length; j++) {
					System.out.print(matrix[i][j]);
					if (j < (matrix[i].length - 1))
						System.out.print(", ");
					else
						System.out.print(" ");
				}
				if (i < matrix.length - 1)
					System.out.print("], \n ");
				else
					System.out.println("]]");
			}
		} else {
			System.out.println("null");
		}
	}

	// ---- Hauptmethode des Programms ----------------------------------------

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Testdaten fuer Matrixoperationen

		double[][] matrix1 = { { 1, -3, 2 }, { 1, 2, 7 } }; // 2x3 Matrix mit 2 Zeilen und 3 Spalten
		double[][] matrix2; // 3x2 Matrix fuer transponierte Matrix zu matrix1
		double[][] matrix3 = { { -8, -32.65 }, { -1, -7 }, { 1.0, -2.07 } }; // 3x2 Matrix
		double[][] matrix4 = { { 6, -1, 3 }, { 3, 2 }, { 0, -3 } }; // nicht rechteckig
		double[][] matrix5 = null; // null-Referenz

		// Test der Methode transpose
		matrix2 = transpose(matrix1);

		if (matrix2 != null)
			System.out.println(
					"Die Matrix matrix2 hat " + matrix2.length + " Zeilen und " + matrix2[0].length + " Spalten");
		// gebenenfalls Matrix zur Kontrolle hier ausgeben
		System.out.println("Die Ausgangsmatrix:");
		printMatrix(matrix1);
		System.out.println("Die transponierte Matrix:");
		printMatrix(matrix2);

		// maxRowSum(matrix1) = {{1, -3, 2}, {1, 2, 7}} Zeile 0, Zeilensumme 0; Zeile 1
		// (max), Zeilensumme 10
		System.out.println(
				"In Matrix matrix1 + ist " + maxRowSum(matrix1) + ". te Zeile die mit der maximalen Zeilensumme");

		// maxRowSum(matrix3) = {{ -8, -32.65 }, { -1, -7 }, { 1.0, -2.07 }}
		// Zeile 0, Zeilensumme -40.65; Zeile 1, Zeilensumme -8; Zeile 2 (max),
		// Zeilensumme -1.07
		System.out.println(
				"In Matrix matrix3 + ist " + maxRowSum(matrix3) + ". te Zeile die mit der maximalen Zeilensumme");

		// isRectangular(matrix3) - true
		System.out.println("Matrix matrix3 + ist rechteckig: " + isRectangular(matrix3) + ".");

		// isRectangular(matrix4) - false
		System.out.println("Matrix matrix4 + ist rechteckig: " + isRectangular(matrix4) + ".");

		// isRectangular(matrix5) - false
		System.out.println("Matrix matrix5 + ist rechteckig: " + isRectangular(matrix5) + ".");

		// Matrix existiert nicht, Zeilennummer ist damit - 1
		System.out.println(
				"In Matrix matrix5 + ist " + maxRowSum(matrix5) + ". te Zeile die mit der maximalen Zeilensumme");

	}

}
