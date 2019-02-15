package ipr.a05;

import java.util.Random;

import ipr.util.Terminal;

public class Temperature {
	
	// 3 dimensionales Array fuer die Temperaturdaten hier anlegen, kann später in den Methoden benutzt werden.
	
	
	/**
	 * Berechnet und liefert die maximale gemessene Temperatur in der Kalenderwoche
	 * 
	 * @param kalenderwoche
	 *            Die Kalenderwoche
	 * @return <code>maximale Temperatur</code> wenn die Daten existieren, 
	 *         <code>Fehlerwert</code> sonst ( unmögliche Temperatur)
	 */
	public static double maxWeekTemperature(int kalenderwoche){
		if(k2017[kalenderwoche] ==null)return -274;
		double res= k2017[kalenderwoche][0][0];
		for(int y=0;y<7;y++)
			for(int x=0;x<24;x++) 
				res = Math.max(res ,k2017[kalenderwoche][y][x]);
		return res; 
	}
	
 
	
	/**
	 * Berechnet die maximale und minimale gemessenen Temperaturen in der Kalenderwoche
	 * und gibt diese aus mit Zeitpunkt der Messung ( Tag und Stunde) aus.
	 * (sonderpunkte für Berücksichtigung Minimum und Maximum kann mehrfach in der Woche auftreten.)
	 * 
	 * @param kalenderwoche
	 *            Die Kalenderwoche
	 * @return <code>true</code> wenn die Daten existieren, 
	 *         <code>false</code> sonst ( keine korrekte Kalenderwoche)
	 */
	public static boolean weekStatistics(int kalenderwoche){
		if(k2017[kalenderwoche] ==null)return false ;
		double max =k2017[kalenderwoche][0][0];
		double min =k2017[kalenderwoche][0][0];
		int dmax =0,  hmax=0;
		int dmin =0,  hmin=0;
	
		
		double res= k2017[kalenderwoche][0][0];
		for(int y=0;y<7;y++)
			for(int x=0;x<24;x++) {
				 if( k2017[kalenderwoche][y][x] > max ) {
					 max  = Math.max(res ,k2017[kalenderwoche][y][x]);
					 dmax = y;
					 hmax = x;
				 }
				 if( k2017[kalenderwoche][y][x] < min ) {
					 min  = Math.min(res ,k2017[kalenderwoche][y][x]);
					 dmin = y;
					 hmin = x;
				 }
			}
				
		
		
		Terminal.println("woche:" +  kalenderwoche + " tag:" + dmax +  " Uhr:" + hmax +  " temp :" +  max); 
		Terminal.println("woche:" +  kalenderwoche + " tag:" + dmin +  " Uhr:" + hmin +  " temp :" +  min); 
		return false;
	}


	public static double [][][] k2017 ;
	public static void main(String[] args) {
		// Historische Daten Kalenderwoche 45 6.11-12.11.2017 der Station Rostock-Warnemuende
		double[][] kw452017= { 
				   {9.6,9.4,9.3,9.1,7.9,7.7,7.3,7.2,8.8,9.3,9.7,9.4,10.2,9.7,9.9,9.5,9.2,9.3,9.2,7.1,6.1,5.9,5.6,5.2},
				   {4.9,4.6,4.6,4.1,3.5,3.1,2.6,2.6,3.5,5.1,6.2,8.3,9.0,9.3,9.1,8.0,6.8,6.4,5.4,5.2,4.8,4.5,5.0,5.5},
				   {6.3,6.8,7.0,7.2,7.1,7.2,7.1,7.4,7.7,8.2,8.7,9.1,8.8,8.7,8.6,8.4,8.0,7.9,7.7,7.6,7.5,7.3,7.3,7.2},
				   {7.1,7.0,6.9,6.8,6.7,6.7,6.7,6.6,6.7,6.8,6.9,7.2,7.5,7.7,8.1,8.3,8.0,7.7,8.1,8.2,7.7,7.5,7.7,7.9},
				   {8.1,8.0,7.9,7.8,7.5,7.2,6.9,7.2,8.0,8.4,8.7,9.0,8.7,8.9,9.0,7.8,8.5,8.1,7.7,7.7,6.7,7.0,6.5,7.1},
				   {6.4,6.6,6.3,5.8,5.0,4.9,4.7,4.6,4.9,5.3,6.1,5.5,5.3,5.7,5.8,6.5,6.6,5.8,5.8,7.1,7.0,7.0,6.3,5.8},
				   {4.4,4.0,3.8,3.8,4.2,4.2,4.3,3.8,4.4,5.2,5.7,5.9,6.1,6.7,6.3,5.9,5.5,5.1,5.0,5.0,5.2,5.7,7.2,7.7}};

	    k2017  = new double[52][7][24];
		for(int z=0;z<52;z++)
			k2017[z]= z!= 45 ? null : kw452017;
		
		
		// Beispielwoche 45 6.11-12.11.2017 in Gesamtdatensatz einlesen 
	
		

		
		 double w = maxWeekTemperature(45);
		 System.out.println("Wochenhöchsttemperatur :" +w);
		 
		 weekStatistics(45);
		
	}
	
}
