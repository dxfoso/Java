import java.util.ArrayList;
import java.util.List;



/**
 * Program for "doing math" on sequences.
 * @author you
 */
public class Sequences {

	
	public static void main(String[] ARGV) {
		
		int input = 1;
		while(input >=1 && input <=3) {
		    
	     	Terminal.println("hello ...");
	    	Terminal.println("[1]calcMinimum");
	    	Terminal.println("[2]calcMaximum");
	    	Terminal.println("[3]calcAverage");
	    	Terminal.println("Andere exit");
	    	input = Terminal.readInt();
	    	if(input ==1 )
	        	calcMinimum();
	    	else if(input ==2 )
	    	    calcMaximum();
	    	else if(input ==3)
	        	calcAverage();
	    	else break;
		}
	}
		
	private static void  calcMinimum() {

		Terminal.println("gib nummer fur calcMinimum ...");
		Integer temp =1,res=Integer.MAX_VALUE;
		int count =0;
		do {
		    temp = Terminal.readInt();
	         if(temp >=0) {
	        	 res = Math.min(res ,  temp);
	        	 count ++; 
	         }
		}while(temp>=0);
		
		if(count ==0 ) Terminal.println("keine nummer abgegeben zu rechnen ...");
		else Terminal.print("Minimum : " + res + "\n");
	}
	
	
	private static void  calcMaximum() {
		Terminal.println("gib nummer fur calcMaximum ...\n");
		Integer temp =1,res=0;
		int count =0;
		
		while(temp>=0) {
		    temp = Terminal.readInt();
	         if(temp >=0) {
	        	 res = Math.max(res ,  temp);
	        	 count ++; 
	         }
		}
		
		if(count ==0 ) Terminal.println("keine nummer abgegeben zu rechnen ...");
		else Terminal.print("Maximum : " + res+"\n");
	}
		 
	private static void  calcAverage() {
		Terminal.println("gib nummer fur calcAverage ...\n");
		Integer temp =1,res=1;

		int count ;
		for(count =0;temp>=0;count ++) {
		    temp = Terminal.readInt();
	        if(temp >=0) 
	         res += temp;      
		}
				
		if(count ==0 ) Terminal.println("keine nummer abgegeben zu rechnen ...\n");
		else Terminal.print("Average : " + (res/count)+ "\n");
	}
}
